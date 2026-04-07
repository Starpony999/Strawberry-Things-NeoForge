package net.starpony.strawberry.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.starpony.strawberry.Strawberry;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EventBusSubscriber(modid = Strawberry.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModWeathering {
    private static final Map<Block, Block> NEXT_BLOCK_BY_BLOCK = new HashMap<>();
    private static final float AGE_CHANCE = 0.04F;

    private ModWeathering() {
    }

    public static void registerChain(Block... blocks) {
        for (int i = 0; i < blocks.length - 1; i++) {
            NEXT_BLOCK_BY_BLOCK.put(blocks[i], blocks[i + 1]);
        }
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
}