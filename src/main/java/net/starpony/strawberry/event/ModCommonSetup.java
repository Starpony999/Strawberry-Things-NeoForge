package net.starpony.strawberry.event;

import net.minecraft.world.level.block.Blocks;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.starpony.strawberry.block.ModBlocks;
import net.starpony.strawberry.block.ModWeathering;

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
    }
}
