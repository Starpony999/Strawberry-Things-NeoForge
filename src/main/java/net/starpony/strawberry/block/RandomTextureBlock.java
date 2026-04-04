package net.starpony.strawberry.block;

import net.minecraft.core.BlockPos;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class RandomTextureBlock extends Block {
    public static final IntegerProperty VARIANT = IntegerProperty.create("variant", 0, 3);

    public RandomTextureBlock(Properties props) {
        super(props);
        this.registerDefaultState(this.stateDefinition.any().setValue(VARIANT, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(VARIANT);
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        int rand = context.getLevel().getRandom().nextInt(4);
        return this.defaultBlockState().setValue(VARIANT, rand);
    }
    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!level.isClientSide) {
            int rand = level.getRandom().nextInt(4);
            level.setBlock(pos, state.setValue(VARIANT, rand), 2);
        }
    }
}
