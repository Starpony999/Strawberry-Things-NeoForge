package net.starpony.strawberry.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.starpony.strawberry.Strawberry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EventBusSubscriber(modid = Strawberry.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModWeathering {
    private static final Map<Block, Block> NEXT_BLOCK_BY_BLOCK = new HashMap<>();
    private static final Map<Block, Block> CLAY_SEALED_BLOCK_BY_BLOCK = new HashMap<>();
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

        level.setBlock(pos, nextBlock.defaultBlockState(), Block.UPDATE_CLIENTS);
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
        var player = event.getEntity();
        var heldItem = event.getItemStack();

        if (!heldItem.is(Items.CLAY_BALL)) {
            return;
        }

        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        Block sealedBlock = CLAY_SEALED_BLOCK_BY_BLOCK.get(state.getBlock());
        if (sealedBlock == null || state.is(sealedBlock)) {
            return;
        }

        if (level.isClientSide) {
            event.setCancellationResult(InteractionResult.SUCCESS);
            event.setCanceled(true);
            return;
        }

        level.setBlock(pos, sealedBlock.defaultBlockState(), Block.UPDATE_ALL);
        SoundType sound = sealedBlock.defaultBlockState().getSoundType();
        level.playSound(null, pos, sound.getPlaceSound(), net.minecraft.sounds.SoundSource.BLOCKS, 1.0F, 1.0F);
        level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);

        if (!player.getAbilities().instabuild) {
            heldItem.shrink(1);
        }

        event.setCancellationResult(InteractionResult.SUCCESS);
        event.setCanceled(true);
    }
}
