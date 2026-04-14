package net.starpony.strawberry.block;


import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.starpony.strawberry.item.ModItems;

public class CornCropBlock extends CropBlock {
    public static final int MAX_AGE = 6;
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 6);
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(4, 0, 4, 12, 3, 12),
            Block.box(4, 0, 4, 12, 5, 12),
            Block.box(4, 0, 4, 12, 8, 12),
            Block.box(1, 0, 1, 15, 10, 15),
            Block.box(0, 0, 0, 16, 11, 16),
            Block.box(0, 0, 0, 16, 13, 16),
            Block.box(0, 0, 0, 16, 14, 16)
    };
    public CornCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.CORN_SEEDS;
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}