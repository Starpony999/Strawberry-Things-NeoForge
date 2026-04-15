package net.starpony.strawberry.datagen;

import net.starpony.strawberry.block.ModBlocks;
import net.starpony.strawberry.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;


public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModBlocks.PLUM.sapling.getId(), new FurnaceFuel(100), false)
                .add(ModBlocks.SYCAMORE.sapling.getId(), new FurnaceFuel(100), false)
        ;

        this.builder(NeoForgeDataMaps.COMPOSTABLES)
// Seeds, grass, saplings, and berries - 30%
                .add(ModItems.CAULIFLOWER_SEEDS.getId(), new Compostable (0.3f), false)
                .add(ModItems.GRAPE_SEEDS.getId(), new Compostable (0.3f), false)
                .add(ModItems.CORN_SEEDS.getId(), new Compostable (0.3f), false)
                .add(ModBlocks.SYCAMORE.sapling.getId(), new Compostable (0.3f), false)
                .add(ModBlocks.PLUM.sapling.getId(), new Compostable (0.3f), false)
                .add(ModBlocks.BLOODWOOD.sapling.getId(), new Compostable (0.3f), false)
                .add(ModBlocks.VOID.sapling.getId(), new Compostable (0.3f), false)
                .add(ModBlocks.SYCAMORE.leaves.getId(), new Compostable (0.3f), false)
                .add(ModBlocks.PLUM.leaves.getId(), new Compostable (0.3f), false)
                .add(ModBlocks.VOID.leaves.getId(), new Compostable (0.3f), false)

// Vines, melons, cactus, dried kelp block - 50%
// Most things - 65%
                .add(ModItems.CAULIFLOWER.getId(), new Compostable (0.65f), false)
                .add(ModItems.CORN.getId(), new Compostable (0.65f), false)
                .add(ModItems.GRAPES.getId(), new Compostable (0.65f), false)
                .add(ModItems.STRAWBERRY.getId(), new Compostable (0.65f), false)
                .add(ModItems.BLUEBERRY.getId(), new Compostable (0.65f), false)
                .add(ModItems.LEMON.getId(), new Compostable (0.65f), false)
                .add(ModItems.LIME.getId(), new Compostable (0.65f), false)
                .add(ModItems.ORANGE.getId(), new Compostable (0.65f), false)
                .add(ModItems.PLUM_FRUIT.getId(), new Compostable (0.65f), false)
        ;
// Baked Potato, Bread, Cookie, Flowering Azalea, Full Blocks - 85%
// Cake & Pumpkin Pie - 100%


        ;
    }
}
