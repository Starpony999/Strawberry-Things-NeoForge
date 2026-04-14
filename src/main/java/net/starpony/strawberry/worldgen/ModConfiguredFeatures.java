package net.starpony.strawberry.worldgen;

import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.neoforged.fml.common.Mod;
import net.starpony.strawberry.Strawberry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.starpony.strawberry.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_KEY = registerKey("ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_KEY = registerKey("sapphire_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALUMINUM_ORE_KEY = registerKey("aluminum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHERTHYST_ORE_KEY = registerKey("netherthyst_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ENDERTHYST_ORE_KEY = registerKey("enderthyst_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_ROSE_QUARTZ_ORE_KEY = registerKey("end_rose_quartz_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SYCAMORE_KEY = registerKey("sycamore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PLUM_KEY = registerKey("plum");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLOODWOOD_KEY = registerKey("bloodwood");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VOID_KEY = registerKey("void");

    public static final ResourceKey<ConfiguredFeature<?, ?>> THULITE_GEODE_KEY = registerKey("thulite_geode");

    public static final ResourceKey<ConfiguredFeature<?, ?>> STRAWBERRY_BUSH_KEY = registerKey("strawberry_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUEBERRY_BUSH_KEY = registerKey("blueberry_bush");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldRubyOres =
                List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.RUBY_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldSapphireOres =
                List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.SAPPHIRE_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldAluminumOres =
                List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.ALUMINUM_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_ALUMINUM_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> netherNetherthystOres =
                List.of(OreConfiguration.target(netherReplaceables, ModBlocks.NETHERTHYST_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> endEnderthystOres =
                List.of(OreConfiguration.target(endReplaceables, ModBlocks.ENDERTHYST_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> endRoseQuartzOres =
                List.of(OreConfiguration.target(endReplaceables, ModBlocks.END_ROSE_QUARTZ_ORE.get().defaultBlockState()));

        register(context, RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(overworldRubyOres, 4));
        register(context, SAPPHIRE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSapphireOres, 5));
        register(context, ALUMINUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAluminumOres, 10));
        register(context, NETHERTHYST_ORE_KEY, Feature.ORE, new OreConfiguration(netherNetherthystOres, 4));
        register(context, ENDERTHYST_ORE_KEY, Feature.ORE, new OreConfiguration(endEnderthystOres, 4));
        register(context, END_ROSE_QUARTZ_ORE_KEY, Feature.ORE, new OreConfiguration(endRoseQuartzOres, 5));

        register(context, SYCAMORE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.SYCAMORE.getLog().get()),
                new StraightTrunkPlacer(5, 2, 2),
                BlockStateProvider.simple(ModBlocks.SYCAMORE.getLeaves().get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),

                new TwoLayersFeatureSize(1, 0, 2))
                //.dirtProvider(BlockStateProvider.of(Blocks.DIRT))
                .build());

        register(context, PLUM_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.PLUM.getLog().get()),
                new StraightTrunkPlacer(7, 2, 0),
                BlockStateProvider.simple(ModBlocks.PLUM.getLeaves().get()),
                new BlobFoliagePlacer(
                        ConstantInt.of(2),  // radius
                        ConstantInt.of(0),  // offset
                        5                               // height
                ),
                new TwoLayersFeatureSize(1, 0, 2)   // trunk/foliage size shaping
        ).build());

        register(context, BLOODWOOD_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.BLOODWOOD.getLog().get()),
                new StraightTrunkPlacer(7, 2, 0),
                BlockStateProvider.simple(ModBlocks.BLOODWOOD.getWartBlock().get()),
                new BlobFoliagePlacer(
                        ConstantInt.of(2),  // radius
                        ConstantInt.of(0),  // offset
                        3                               // height
                ),
                new TwoLayersFeatureSize(1, 0, 2))   // trunk/foliage size shaping
                .dirt(BlockStateProvider.simple(ModBlocks.NIGHTSTONE.getBase().get()))
                .build());

        register(context, VOID_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.VOID.getLog().get()),
                new FancyTrunkPlacer(7, 2, 0),
                BlockStateProvider.simple(Blocks.AIR),
                new BlobFoliagePlacer(
                        ConstantInt.of(2),  // radius
                        ConstantInt.of(0),  // offset
                        3                               // height
                ),
                new TwoLayersFeatureSize(1, 0, 2))   // trunk/foliage size shaping
                .dirt(BlockStateProvider.simple(Blocks.END_STONE))
                .build());

        register(context, THULITE_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(ModBlocks.THULITE_CRYSTAL_BLOCK.get()),
                        BlockStateProvider.simple(ModBlocks.BUDDING_THULITE_CRYSTAL_BLOCK.get()),
                        BlockStateProvider.simple(ModBlocks.SCHIST.get()),
                        BlockStateProvider.simple(ModBlocks.GNEISS.get()),
                        List.of(
                                ModBlocks.SMALL_THULITE_BUD.get().defaultBlockState(),
                                ModBlocks.MEDIUM_THULITE_BUD.get().defaultBlockState(),
                                ModBlocks.LARGE_THULITE_BUD.get().defaultBlockState(),
                                ModBlocks.THULITE_CLUSTER.get().defaultBlockState()
                        ),
                        BlockTags.FEATURES_CANNOT_REPLACE,
                        BlockTags.GEODE_INVALID_BLOCKS
                ),
                        new GeodeLayerSettings(1.7, 2.2, 3.2, 4.2),
                        new GeodeCrackSettings(0.95, 2.0, 2),
                        0.35,
                        0.083,
                        true,
                        UniformInt.of(4, 6),
                        UniformInt.of(3, 4),
                        UniformInt.of(1, 2),
                        -16,
                        16,
                        0.05,
                        1
                )
        );


        register(context, STRAWBERRY_BUSH_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.STRAWBERRY_BUSH.get()
                                .defaultBlockState().setValue(SweetBerryBushBlock.AGE, 3))),
                        List.of(Blocks.GRASS_BLOCK)));
        register(context, BLUEBERRY_BUSH_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLUEBERRY_BUSH.get()
                                .defaultBlockState().setValue(SweetBerryBushBlock.AGE, 3))),
                        List.of(Blocks.GRASS_BLOCK)));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}