package net.starpony.strawberry.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

public class RedstoneLanternBlock extends ColoredLanternBlock {

    public RedstoneLanternBlock(Properties properties) {
        super(properties);
    }

    // Tell Minecraft this block can emit a redstone signal
    @Override
    public boolean isSignalSource(BlockState state) {
        return true;
    }

    // How strong the redstone signal is
    @Override
    public int getSignal(BlockState state, BlockGetter world, BlockPos pos, Direction side) {
        return 15; // Max signal
    }
}
