package net.starpony.strawberry.event;

import net.minecraft.world.level.block.Block;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.starpony.strawberry.block.ModBlocks;
import net.starpony.strawberry.block.ModWeathering;
import net.starpony.strawberry.util.sets.SimpleStoneBaseSet;
import net.starpony.strawberry.util.sets.VanillaSets;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public final class ModCommonSetup {
    private ModCommonSetup() {
    }

    public static void onCommonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> registerSetChain(
                VanillaSets.COBBLESTONE,
                ModBlocks.WASHED_COBBLESTONE,
                ModBlocks.EXPOSED_COBBLESTONE,
                ModBlocks.WEATHERED_COBBLESTONE,
                ModBlocks.AGED_COBBLESTONE
        ));
        event.enqueueWork(() -> registerSetChain(
                ModBlocks.WASHED_COBBLESTONE_BRICKS,
                ModBlocks.EXPOSED_COBBLESTONE_BRICKS,
                ModBlocks.WEATHERED_COBBLESTONE_BRICKS,
                ModBlocks.AGED_COBBLESTONE_BRICKS
        ));
        event.enqueueWork(() -> {
            registerClaySealSet(VanillaSets.COBBLESTONE, ModBlocks.SEALED_COBBLESTONE);
            registerClaySealSet(ModBlocks.WASHED_COBBLESTONE, ModBlocks.SEALED_WASHED_COBBLESTONE);
            registerClaySealSet(ModBlocks.EXPOSED_COBBLESTONE, ModBlocks.SEALED_EXPOSED_COBBLESTONE);
            registerClaySealSet(ModBlocks.WEATHERED_COBBLESTONE, ModBlocks.SEALED_WEATHERED_COBBLESTONE);
            registerClaySealSet(ModBlocks.AGED_COBBLESTONE, ModBlocks.SEALED_AGED_COBBLESTONE);
        });
    }
    private static void registerSetChain(SimpleStoneBaseSet... sets) {
        List<Function<SimpleStoneBaseSet, ? extends Block>> variants = List.of(
                SimpleStoneBaseSet::getStoneBlock,
                SimpleStoneBaseSet::getSlabBlock,
                SimpleStoneBaseSet::getStairsBlock,
                SimpleStoneBaseSet::getWallBlock,
                SimpleStoneBaseSet::getButtonBlock,
                SimpleStoneBaseSet::getPressurePlateBlock
        );

        for (var getter : variants) {
            Block[] chain = Arrays.stream(sets)
                    .map(getter)
                    .toArray(Block[]::new);
            if (Arrays.stream(chain).allMatch(Objects::nonNull)) {
                ModWeathering.registerChain(chain);
            }
        }
    }

    private static void registerClaySealSet(SimpleStoneBaseSet source, SimpleStoneBaseSet sealed) {
        List<Function<SimpleStoneBaseSet, ? extends Block>> variants = List.of(
                SimpleStoneBaseSet::getStoneBlock,
                SimpleStoneBaseSet::getSlabBlock,
                SimpleStoneBaseSet::getStairsBlock,
                SimpleStoneBaseSet::getWallBlock,
                SimpleStoneBaseSet::getButtonBlock,
                SimpleStoneBaseSet::getPressurePlateBlock
        );

        for (var getter : variants) {
            Block sourceBlock = getter.apply(source);
            Block sealedBlock = getter.apply(sealed);
            if (sourceBlock != null && sealedBlock != null) {
                ModWeathering.registerClaySeal(sourceBlock, sealedBlock);
            }
        }
    }
}
