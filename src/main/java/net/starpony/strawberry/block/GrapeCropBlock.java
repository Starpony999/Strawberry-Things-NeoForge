package net.starpony.strawberry.block;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.starpony.strawberry.item.ModItems;

public class GrapeCropBlock extends CropBlock {
    public static final int MAX_AGE = 5;
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 5);

    public GrapeCropBlock(BlockBehaviour.Properties properties) {super(properties);}

    @Override
    protected ItemLike getBaseSeedId() {return ModItems.GRAPE_SEEDS;}
    @Override
    public IntegerProperty getAgeProperty() {return AGE;}
    @Override
    public int getMaxAge() {return MAX_AGE;}
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(AGE);}
}