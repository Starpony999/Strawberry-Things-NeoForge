package net.starpony.strawberry.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.registries.DeferredBlock;

public class BuddingThuliteBlock extends BuddingAmethystBlock {//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

        public static final int GROWTH_CHANCE = 5;
        private static final Direction[] DIRECTIONS = Direction.values();

    public BuddingThuliteBlock(Properties properties) {
        super(properties);
    }


    @Override
        protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
            if (random.nextInt(5) == 0) {
                Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
                BlockPos blockpos = pos.relative(direction);
                BlockState blockstate = level.getBlockState(blockpos);
                DeferredBlock<? extends Block> block = null;

                if (canClusterGrowAtState(blockstate)) {
                    block = ModBlocks.SMALL_THULITE_BUD;
                } else if (blockstate.is(ModBlocks.SMALL_THULITE_BUD) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                    block = ModBlocks.MEDIUM_THULITE_BUD;
                } else if (blockstate.is(ModBlocks.MEDIUM_THULITE_BUD) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                    block = ModBlocks.LARGE_THULITE_BUD;
                } else if (blockstate.is(ModBlocks.LARGE_THULITE_BUD) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                    block = ModBlocks.THULITE_CLUSTER;
                }

                if (block != null) {
                    BlockState blockstate1 = block.get()
                            .defaultBlockState()
                            .setValue(AmethystClusterBlock.FACING, direction)
                            .setValue(AmethystClusterBlock.WATERLOGGED, blockstate.getFluidState().getType() == Fluids.WATER);

                    level.setBlockAndUpdate(blockpos, blockstate1);
                }
            }

        }

        public static boolean canClusterGrowAtState(BlockState state) {
            return state.isAir() || state.is(Blocks.WATER) && state.getFluidState().getAmount() == 8;
        }
    }


