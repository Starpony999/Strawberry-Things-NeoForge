package net.starpony.strawberry.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.data.JsonCodecProvider;
/*
public class ModBiomeDataProvider extends JsonCodecProvider<Biome> {
    public ModBiomeDataProvider(PackOutput output) {
        super(
                output,
                "Nightmare Biomes",
                DataProviderRegistry.BIOME,
                "strawberry",
                Biome.DIRECT_CODEC
        );
    }

    @Override
    protected void addJsons() {

        // Nightmare Barrens (cold nether barrens)
        add("nightmare_barrens", coldNetherBiome()
                .generationSettings(
                        new BiomeGenerationSettings.Builder()
                                .addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, StrawberryFeatures.NIGHTSTONE_PATCH)
                                .build()
                )
        );

        // Grimdark
        add("grimdark", coldNetherBiome()
                .generationSettings(
                        new BiomeGenerationSettings.Builder()
                                .addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, StrawberryFeatures.GRIMSTONE_PATCH)
                                .build()
                )
        );

        // Dreamless Depths (ice spikes + fossils)
        add("dreamless_depths", frozenBiome()
                .generationSettings(
                        new BiomeGenerationSettings.Builder()
                                .addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, StrawberryFeatures.ICE_SPIKES)
                                .addFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, StrawberryFeatures.FOSSILS)
                                .build()
                )
        );

        // Bloodwood Thicket (cold crimson forest)
        add("bloodwood_thicket", coldNetherBiome()
                .generationSettings(
                        new BiomeGenerationSettings.Builder()
                                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, StrawberryFeatures.BLOODWOOD_TREES)
                                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, StrawberryFeatures.BLOODWOOD_ROOTS)
                                .build()
                )
        );
    }

    private static Biome coldNetherBiome() {
        return new Biome.BiomeBuilder()
                .temperature(-0.5F)
                .downfall(0.0F)
                .precipitation(Biome.Precipitation.NONE)
                .biomeCategory(Biome.BiomeCategory.NETHER)
                .mobSpawnSettings(MobSpawnSettings.EMPTY)
                .specialEffects(defaultNightmareFX())
                .build();
    }

    private static Biome frozenBiome() {
        return new Biome.BiomeBuilder()
                .temperature(-1.0F)
                .downfall(0.0F)
                .precipitation(Biome.Precipitation.NONE)
                .biomeCategory(Biome.BiomeCategory.ICY)
                .mobSpawnSettings(MobSpawnSettings.EMPTY)
                .specialEffects(defaultFrozenFX())
                .build();
    }

    private static BiomeSpecialEffects defaultNightmareFX() {
        return new BiomeSpecialEffects.Builder()
                .fogColor(0x1E1E25)      // cold dark fog
                .skyColor(0x2A2A3A)
                .waterColor(0x3A3A55)
                .waterFogColor(0x101018)
                .build();
    }

    private static BiomeSpecialEffects defaultFrozenFX() {
        return new BiomeSpecialEffects.Builder()
                .fogColor(0xcdeaff)
                .skyColor(0x9bd2ff)
                .waterColor(0x4ca4ff)
                .waterFogColor(0x588fb2)
                .build();
    }
} */