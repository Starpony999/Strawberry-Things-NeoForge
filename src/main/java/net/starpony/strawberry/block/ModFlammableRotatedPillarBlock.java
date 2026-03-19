package net.starpony.strawberry.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;

public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {


    private static final Map<Block, Block> STRIPPED_MAP = new HashMap<>();

    public ModFlammableRotatedPillarBlock(Properties properties) {
        super(properties);
    }

    public static void registerStrippable(Block original, Block stripped) {
        STRIPPED_MAP.put(original, stripped);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context,
                                                     ItemAbility itemAbility, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            Block stripped = STRIPPED_MAP.get(state.getBlock());
            if (stripped != null) {
                return stripped.defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}