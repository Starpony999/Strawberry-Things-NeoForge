package net.starpony.strawberry.worldgen;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.starpony.strawberry.Strawberry;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.starpony.strawberry.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> RUBY_ORE_PLACED_KEY = registerKey("ruby_ore_placed");
    public static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_STONE_PLACED_KEY = registerKey("sapphire_ore_stone_placed");
    public static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_DEEPSLATE_PLACED_KEY = registerKey("sapphire_ore_deepslate_placed");
    public static final ResourceKey<PlacedFeature> ALUMINUM_ORE_PLACED_KEY = registerKey("aluminum_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHERTHYST_ORE_PLACED_KEY = registerKey("netherthyst_ore_placed");
    public static final ResourceKey<PlacedFeature> ENDERTHYST_ORE_PLACED_KEY = registerKey("enderthyst_ore_placed");
    public static final ResourceKey<PlacedFeature> END_ROSE_QUARTZ_ORE_PLACED_KEY = registerKey("end_rose_quartz_ore_placed");

    public static final ResourceKey<PlacedFeature> SYCAMORE_PLACED_KEY = registerKey("sycamore_placed");
    public static final ResourceKey<PlacedFeature> PLUM_PLACED_KEY = registerKey("plum_placed");

    public static final ResourceKey<PlacedFeature> STRAWBERRY_BUSH_PLACED_KEY = registerKey("strawberry_bush_placed");
    public static final ResourceKey<PlacedFeature> BLUEBERRY_BUSH_PLACED_KEY = registerKey("blueberry_bush_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, RUBY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RUBY_ORE_KEY),
                ModOrePlacement.modifiersWithCount(7, //veins per chunk
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-144), VerticalAnchor.absolute(16))));
         register(context, SAPPHIRE_ORE_STONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SAPPHIRE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(10,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
        register(context, ALUMINUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ALUMINUM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(16,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
        register(context, NETHERTHYST_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHERTHYST_ORE_KEY),
                ModOrePlacement.modifiersWithCount(1,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(8), VerticalAnchor.absolute(24))));
        register(context, ENDERTHYST_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ENDERTHYST_ORE_KEY),
                ModOrePlacement.modifiersWithCount(1,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(45), VerticalAnchor.absolute(55))));
        register(context, END_ROSE_QUARTZ_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_ROSE_QUARTZ_ORE_KEY),
                ModOrePlacement.modifiersWithCount(5,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(120))));

        register(context, SYCAMORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SYCAMORE_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(2, 0.1f, 2), ModBlocks.SYCAMORE.sapling.get()));
        register(context, PLUM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PLUM_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(2, 0.1f, 2), ModBlocks.PLUM.sapling.get()));


        register(context, STRAWBERRY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STRAWBERRY_BUSH_KEY),
                List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, BLUEBERRY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLUEBERRY_BUSH_KEY),
                List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));


    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
