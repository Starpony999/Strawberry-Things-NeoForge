package net.starpony.strawberry.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.starpony.strawberry.Strawberry;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EventBusSubscriber(modid = Strawberry.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModWeathering {
    private static final Map<Block, Block> NEXT_BLOCK_BY_BLOCK = new HashMap<>();
    private static final Map<Block, Block> CLAY_SEALED_BLOCK_BY_BLOCK = new HashMap<>();
    private static final Map<Block, Block> ORIGINAL_BLOCK_BY_SEALED_BLOCK = new HashMap<>();
    private static final float AGE_CHANCE = 0.04F;

    private ModWeathering() {
    }

    public static void registerChain(Block... blocks) {
        for (int i = 0; i < blocks.length - 1; i++) {
            NEXT_BLOCK_BY_BLOCK.put(blocks[i], blocks[i + 1]);
        }
    }

    public static void registerClaySeal(Block source, Block sealed) {
        CLAY_SEALED_BLOCK_BY_BLOCK.put(source, sealed);
        ORIGINAL_BLOCK_BY_SEALED_BLOCK.putIfAbsent(sealed, source);
    }

    @SubscribeEvent
    public static void onLevelTick(LevelTickEvent.Post event) {
        Level level = event.getLevel();
        if (level.isClientSide || NEXT_BLOCK_BY_BLOCK.isEmpty()) {
            return;
        }

        List<? extends net.minecraft.world.entity.player.Player> players = level.players();
        if (players.isEmpty()) {
            return;
        }

        RandomSource random = level.random;
        int attempts = Math.max(4, players.size() * 2);

        for (int i = 0; i < attempts; i++) {
            net.minecraft.world.entity.player.Player player = players.get(random.nextInt(players.size()));
            BlockPos anchor = player.blockPosition();
            int x = anchor.getX() + random.nextInt(33) - 16;
            int y = anchor.getY() + random.nextInt(17) - 8;
            int z = anchor.getZ() + random.nextInt(33) - 16;

            if (y < level.getMinBuildHeight() || y >= level.getMaxBuildHeight()) {
                continue;
            }

            tryAge(level, new BlockPos(x, y, z), random);
        }
    }

    private static void tryAge(Level level, BlockPos pos, RandomSource random) {
        BlockState state = level.getBlockState(pos);
        Block nextBlock = NEXT_BLOCK_BY_BLOCK.get(state.getBlock());
        if (nextBlock == null || random.nextFloat() >= AGE_CHANCE || !isExposedToWater(level, pos)) {
            return;
        }

        level.setBlock(pos, copySharedProperties(state, nextBlock.defaultBlockState()), Block.UPDATE_CLIENTS);
    }

    private static BlockState copySharedProperties(BlockState source, BlockState target) {
        BlockState result = target;
        for (Property<?> property : source.getProperties()) {
            if (target.hasProperty(property)) {
                result = copyProperty(source, result, property);
            }
        }

        return result;
    }

    private static <T extends Comparable<T>> BlockState copyProperty(BlockState source, BlockState target, Property<T> property) {
        return target.setValue(property, source.getValue(property));
    }

    private static boolean isExposedToWater(Level level, BlockPos pos) {
        if (level.getFluidState(pos).is(FluidTags.WATER)) {
            return true;
        }

        for (Direction direction : Direction.values()) {
            if (level.getFluidState(pos.relative(direction)).is(FluidTags.WATER)) {
                return true;
            }
        }

        return false;
    }

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        var level = event.getLevel();
        if (level.isClientSide) {
            return;
        }

        var player = event.getEntity();
        var heldItem = event.getItemStack();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);

        if (heldItem.is(Items.CLAY_BALL)) {
            sealWithClay(event, level, player, heldItem, pos, state);
            return;
        }

        if (heldItem.is(ItemTags.AXES)) {
            scrapeSealed(event, level, player, heldItem, pos, state);
        }
    }

    private static void sealWithClay(PlayerInteractEvent.RightClickBlock event, Level level,
                                     net.minecraft.world.entity.player.Player player, ItemStack heldItem,
                                     BlockPos pos, BlockState state) {
        Block sealedBlock = CLAY_SEALED_BLOCK_BY_BLOCK.get(state.getBlock());
        if (sealedBlock == null || state.is(sealedBlock)) {
            return;
        }

        BlockState sealedState = copySharedProperties(state, sealedBlock.defaultBlockState());
        level.setBlock(pos, sealedState, Block.UPDATE_ALL);
        SoundType sound = sealedState.getSoundType();
        level.playSound(null, pos, sound.getPlaceSound(), SoundSource.BLOCKS, 1.0F, 1.0F);
        level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);

        if (!player.getAbilities().instabuild) {
            heldItem.shrink(1);
        }

        event.setCancellationResult(InteractionResult.SUCCESS);
        event.setCanceled(true);
    }

    private static void scrapeSealed(PlayerInteractEvent.RightClickBlock event, Level level,
                                     net.minecraft.world.entity.player.Player player, ItemStack heldItem,
                                     BlockPos pos, BlockState state) {
        Block originalBlock = ORIGINAL_BLOCK_BY_SEALED_BLOCK.get(state.getBlock());
        if (originalBlock == null) {
            return;
        }

        BlockState originalState = copySharedProperties(state, originalBlock.defaultBlockState());
        level.setBlock(pos, originalState, Block.UPDATE_ALL);
        level.playSound(null, pos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
        level.levelEvent(player, LevelEvent.PARTICLES_SCRAPE, pos, 0);
        level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);

        heldItem.hurtAndBreak(1, ((ServerLevel) level), player,
                item -> player.onEquippedItemBroken(item, net.minecraft.world.entity.LivingEntity.getSlotForHand(event.getHand())));

        event.setCancellationResult(InteractionResult.SUCCESS);
        event.setCanceled(true);
    }
}
