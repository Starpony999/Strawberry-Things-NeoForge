package net.starpony.strawberry.block;

import net.minecraft.core.BlockPos;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class DoubleTextureBlock extends Block {

    public static final EnumProperty<Quadrant> QUADRANT =
            EnumProperty.create("quadrant", Quadrant.class);

    public DoubleTextureBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(QUADRANT, Quadrant.TOP_LEFT));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        return this.defaultBlockState().setValue(QUADRANT, getQuadrant(pos));
    }

    private Quadrant getQuadrant(BlockPos pos) {
        int x = pos.getX() & 1;
        int z = pos.getZ() & 1;

        if (x == 0 && z == 0) return Quadrant.TOP_LEFT;
        if (x == 1 && z == 0) return Quadrant.TOP_RIGHT;
        if (x == 0 && z == 1) return Quadrant.BOTTOM_LEFT;
        return Quadrant.BOTTOM_RIGHT;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(QUADRANT);
    }

    public enum Quadrant implements StringRepresentable {
        TOP_LEFT("top_left"),
        TOP_RIGHT("top_right"),
        BOTTOM_LEFT("bottom_left"),
        BOTTOM_RIGHT("bottom_right");

        private final String name;

        Quadrant(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }
}
