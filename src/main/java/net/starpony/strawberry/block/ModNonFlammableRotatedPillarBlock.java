package net.starpony.strawberry.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModNonFlammableRotatedPillarBlock extends RotatedPillarBlock {


    private static final Map<Supplier<? extends Block>, Supplier<? extends Block>> STRIPPED_MAP = new HashMap<>();

    public ModNonFlammableRotatedPillarBlock(Properties properties) {
        super(properties);
    }

    public static void registerStrippable(Supplier<? extends Block> original, Supplier<? extends Block> stripped) {
        STRIPPED_MAP.put(original, stripped);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context,
                                                     ItemAbility itemAbility, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            for (Map.Entry<Supplier<? extends Block>, Supplier<? extends Block>> entry : STRIPPED_MAP.entrySet()) {
                if (entry.getKey().get() == state.getBlock()) {
                    return entry.getValue().get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                }
            }
        }

        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}