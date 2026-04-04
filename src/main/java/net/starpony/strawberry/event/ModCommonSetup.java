package net.starpony.strawberry.event;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.starpony.strawberry.block.ModBlocks;
import net.starpony.strawberry.block.ModWeathering;
import net.starpony.strawberry.util.sets.SimpleStoneSet;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public final class ModCommonSetup {
    private ModCommonSetup() {
    }

    public static void onCommonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> ModWeathering.registerChain(
                Blocks.COBBLESTONE,
                ModBlocks.WASHED_COBBLESTONE.getStone().get(),
                ModBlocks.EXPOSED_COBBLESTONE.getStone().get(),
                ModBlocks.WEATHERED_COBBLESTONE.getStone().get(),
                ModBlocks.AGED_COBBLESTONE.getStone().get()
        ));
        event.enqueueWork(() -> ModWeathering.registerChain(
                ModBlocks.WASHED_COBBLESTONE_BRICKS.getStone().get(),
                ModBlocks.EXPOSED_COBBLESTONE_BRICKS.getStone().get(),
                ModBlocks.WEATHERED_COBBLESTONE_BRICKS.getStone().get(),
                ModBlocks.AGED_COBBLESTONE_BRICKS.getStone().get()
        ));
    }
    private static void registerSetChain(SimpleStoneSet... sets) {
        List<Function<SimpleStoneSet, ? extends Block>> variants = List.of(
                s -> s.getStone().get(),
                s -> s.getSlab().get(),
                s -> s.getStairs().get(),
                s -> s.getWall().get(),
                s -> s.getButton().get(),
                s -> s.getPressurePlate().get()
        );

        for (var getter : variants) {
            ModWeathering.registerChain(
                    Arrays.stream(sets)
                            .map(getter)
                            .toArray(Block[]::new)
            );
        }
    }
}

