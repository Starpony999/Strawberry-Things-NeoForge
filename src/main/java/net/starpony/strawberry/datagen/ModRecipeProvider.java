package net.starpony.strawberry.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.starpony.strawberry.block.ModBlocks;
import net.starpony.strawberry.util.sets.*;
import net.starpony.strawberry.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.starpony.strawberry.datagen.RecipeMethodProvider.*;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput exporter) {

        List<ItemLike> ROSE_QUARTZ_SMELTABLES = List.of(ModItems.RAW_ROSE_QUARTZ, ModBlocks.ROSE_QUARTZ_ORE, ModBlocks.END_ROSE_QUARTZ_ORE);
        List<ItemLike> ALUMINUM_SMELTABLES = List.of(ModBlocks.ALUMINUM_ORE, ModBlocks.DEEPSLATE_ALUMINUM_ORE);
        List<ItemLike> RAW_ALUMINUM_SMELTABLES = List.of(ModItems.RAW_ALUMINUM);
        List<ItemLike> RUBY_SMELTABLES = List.of(ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE);
        List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ModBlocks.SAPPHIRE_ORE, ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        List<ItemLike> ALUMINUM_BLOCK_SMELTABLES = List.of(ModBlocks.RAW_ALUMINUM_BLOCK);
        List<ItemLike> ROSE_QUARTZ_BLOCK_SMELTABLES = List.of(ModBlocks.RAW_ROSE_QUARTZ_BLOCK);
        List<ItemLike> IRON_BLOCK_SMELTABLES = List.of(Blocks.RAW_IRON_BLOCK);
        List<ItemLike> GOLD_BLOCK_SMELTABLES = List.of(Blocks.RAW_GOLD_BLOCK);
        List<ItemLike> COPPER_BLOCK_SMELTABLES = List.of(Blocks.RAW_COPPER_BLOCK);
        List<ItemLike> ENDERTHYST_SMELTABLES = List.of(ModBlocks.ENDERTHYST_ORE);
        List<ItemLike> NETHERTHYST_SMELTABLES = List.of(ModBlocks.NETHERTHYST_ORE);
        List<ItemLike> DIAMOND_SHARD_SMELTABLES = List.of(Items.DIAMOND_AXE, Items.DIAMOND_PICKAXE, Items.DIAMOND_HOE, Items.DIAMOND_SHOVEL, Items.DIAMOND_SWORD, Items.DIAMOND_HELMET, Items.DIAMOND_CHESTPLATE, Items.DIAMOND_LEGGINGS, Items.DIAMOND_BOOTS, Items.DIAMOND_HORSE_ARMOR);
        List<ItemLike> RUBY_SHARD_SMELTABLES = List.of(ModItems.RUBY.getAxe(), ModItems.RUBY.getPickaxe(), ModItems.RUBY.getHoe(), ModItems.RUBY.getShovel(), ModItems.RUBY.getSword(), ModItems.RUBY.getHelmet(), ModItems.RUBY.getChestplate(), ModItems.RUBY.getLeggings(), ModItems.RUBY.getBoots(), ModItems.RUBY.getHorseArmor());
        List<ItemLike> SAPPHIRE_SHARD_SMELTABLES = List.of(ModItems.SAPPHIRE.getAxe(), ModItems.SAPPHIRE.getPickaxe(), ModItems.SAPPHIRE.getHoe(), ModItems.SAPPHIRE.getShovel(), ModItems.SAPPHIRE.getSword(), ModItems.SAPPHIRE.getHelmet(), ModItems.SAPPHIRE.getChestplate(), ModItems.SAPPHIRE.getLeggings(), ModItems.SAPPHIRE.getBoots(), ModItems.SAPPHIRE.getHorseArmor());
        List<ItemLike> OTHERWORLDLY_AMETHYST_SHARD_SMELTABLES = List.of(ModItems.OTHERWORLDLY_AMETHYST.getAxe(), ModItems.OTHERWORLDLY_AMETHYST.getPickaxe(), ModItems.OTHERWORLDLY_AMETHYST.getHoe(), ModItems.OTHERWORLDLY_AMETHYST.getShovel(), ModItems.OTHERWORLDLY_AMETHYST.getSword(), ModItems.OTHERWORLDLY_AMETHYST.getHelmet(), ModItems.OTHERWORLDLY_AMETHYST.getChestplate(), ModItems.OTHERWORLDLY_AMETHYST.getLeggings(), ModItems.OTHERWORLDLY_AMETHYST.getBoots(), ModItems.OTHERWORLDLY_AMETHYST.getHorseArmor());
        List<ItemLike> ROSE_QUARTZ_SHARD_SMELTABLES = List.of(ModItems.ROSE_QUARTZ.getAxe(), ModItems.ROSE_QUARTZ.getPickaxe(), ModItems.ROSE_QUARTZ.getHoe(), ModItems.ROSE_QUARTZ.getShovel(), ModItems.ROSE_QUARTZ.getSword(), ModItems.ROSE_QUARTZ.getHelmet(), ModItems.ROSE_QUARTZ.getChestplate(), ModItems.ROSE_QUARTZ.getLeggings(), ModItems.ROSE_QUARTZ.getBoots(), ModItems.ROSE_QUARTZ.getHorseArmor());


        oreSmelting(exporter, ROSE_QUARTZ_SMELTABLES, RecipeCategory.MISC, ModItems.ROSE_QUARTZ.getGem(), 0.25f, 200, "rose_quartz_smeltables_1");
        oreSmelting(exporter, ALUMINUM_SMELTABLES, RecipeCategory.MISC, ModItems.ALUMINUM_SCRAP, 0.25f, 200, "aluminum_scrap_1");
        oreSmelting(exporter, RAW_ALUMINUM_SMELTABLES, RecipeCategory.MISC, ModItems.ALUMINUM_INGOT, 0.25f, 200, "aluminum_smeltables_1");
        oreSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.getGem(), 0.25f, 200, "ruby_smeltables_1");
        oreSmelting(exporter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.getGem(), 0.25f, 200, "sapphire_smeltables_1");
        oreSmelting(exporter, ENDERTHYST_SMELTABLES, RecipeCategory.MISC, ModItems.ENDERTHYST, 0.25f, 200, "enderthyst_smeltables_1");
        oreSmelting(exporter, NETHERTHYST_SMELTABLES, RecipeCategory.MISC, ModItems.NETHERTHYST, 0.25f, 200, "netherthyst_smeltables_1");
        oreSmelting(exporter, RUBY_SHARD_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.getShard(), 0.25f, 200, "ruby_shard_smeltables_1");
        oreSmelting(exporter, SAPPHIRE_SHARD_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.getShard(), 0.25f, 200, "sapphire_shard_smeltables_1");
        oreSmelting(exporter, DIAMOND_SHARD_SMELTABLES, RecipeCategory.MISC, ModItems.DIAMOND_SHARD, 0.25f, 200, "diamond_shard_smeltables_1");
        oreSmelting(exporter, OTHERWORLDLY_AMETHYST_SHARD_SMELTABLES, RecipeCategory.MISC, Items.AMETHYST_SHARD, 0.25f, 200, "amethyst_shard_smeltables_1");
        oreSmelting(exporter, ROSE_QUARTZ_SHARD_SMELTABLES, RecipeCategory.MISC, ModItems.ROSE_QUARTZ.getShard(), 0.25f, 200, "rose_quartz_shard_smeltables_1");

        oreSmelting(exporter, ALUMINUM_BLOCK_SMELTABLES, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALUMINUM_BLOCK, .9f, 400, "aluminum_smeltables_3");
        oreSmelting(exporter, ROSE_QUARTZ_BLOCK_SMELTABLES, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROSE_QUARTZ_BLOCK, .9f, 400, "rose_quartz_smeltables_3");
        oreSmelting(exporter, IRON_BLOCK_SMELTABLES, RecipeCategory.BUILDING_BLOCKS, Blocks.IRON_BLOCK, .9f, 400, "iron_smeltables_3");
        oreSmelting(exporter, GOLD_BLOCK_SMELTABLES, RecipeCategory.BUILDING_BLOCKS, Blocks.GOLD_BLOCK, .9f, 400, "gold_smeltables_3");
        oreSmelting(exporter, COPPER_BLOCK_SMELTABLES, RecipeCategory.BUILDING_BLOCKS, Blocks.COPPER_BLOCK, .9f, 400, "copper_smeltables_3");

        oreBlasting(exporter, ROSE_QUARTZ_SMELTABLES, RecipeCategory.MISC, ModItems.ROSE_QUARTZ.getGem(), 0.25f, 100, "rose_quartz_smeltables_2");
        oreBlasting(exporter, ALUMINUM_SMELTABLES, RecipeCategory.MISC, ModItems.ALUMINUM_SCRAP, 0.25f, 100, "aluminum_scrap_2");
        oreBlasting(exporter, RAW_ALUMINUM_SMELTABLES, RecipeCategory.MISC, ModItems.ALUMINUM_INGOT, 0.25f, 100, "aluminum_smeltables_2");
        oreBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.getGem(), 0.25f, 100, "ruby_smeltables_2");
        oreBlasting(exporter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.getGem(), 0.25f, 100, "sapphire_smeltables_2");
        oreBlasting(exporter, ENDERTHYST_SMELTABLES, RecipeCategory.MISC, ModItems.ENDERTHYST, 0.25f, 100, "enderthyst_smeltables_2");
        oreBlasting(exporter, NETHERTHYST_SMELTABLES, RecipeCategory.MISC, ModItems.NETHERTHYST, 0.25f, 100, "netherthyst_smeltables_2");
        oreBlasting(exporter, RUBY_SHARD_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.getShard(), 0.25f, 100, "ruby_shard_smeltables_2");
        oreBlasting(exporter, SAPPHIRE_SHARD_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.getShard(), 0.25f, 100, "sapphire_shard_smeltables_2");
        oreBlasting(exporter, DIAMOND_SHARD_SMELTABLES, RecipeCategory.MISC, ModItems.DIAMOND_SHARD, 0.25f, 100, "diamond_shard_smeltables_2");
        oreBlasting(exporter, OTHERWORLDLY_AMETHYST_SHARD_SMELTABLES, RecipeCategory.MISC, Items.AMETHYST_SHARD, 0.25f, 100, "amethyst_shard_smeltables_2");
        oreBlasting(exporter, ROSE_QUARTZ_SHARD_SMELTABLES, RecipeCategory.MISC, ModItems.ROSE_QUARTZ.getShard(), 0.25f, 100, "rose_quartz_shard_smeltables_2");

        oreBlasting(exporter, ALUMINUM_BLOCK_SMELTABLES, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALUMINUM_BLOCK, .9f, 200, "aluminum_smeltables_4");
        oreBlasting(exporter, ROSE_QUARTZ_BLOCK_SMELTABLES, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROSE_QUARTZ_BLOCK, .9f, 200, "rose_quartz_smeltables_4");
        oreBlasting(exporter, IRON_BLOCK_SMELTABLES, RecipeCategory.BUILDING_BLOCKS, Blocks.IRON_BLOCK, .9f, 200, "iron_smeltables_4");
        oreBlasting(exporter, GOLD_BLOCK_SMELTABLES, RecipeCategory.BUILDING_BLOCKS, Blocks.GOLD_BLOCK, .9f, 200, "gold_smeltables_4");
        oreBlasting(exporter, COPPER_BLOCK_SMELTABLES, RecipeCategory.BUILDING_BLOCKS, Blocks.COPPER_BLOCK, .9f, 200, "copper_smeltables_4");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY.getGem().get(), RecipeCategory.MISC, ModBlocks.RUBY_BLOCK.get().asItem());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SAPPHIRE.getGem().get(), RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get().asItem());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ALUMINUM_INGOT.get(), RecipeCategory.MISC, ModBlocks.ALUMINUM_BLOCK.get().asItem());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.ALUMINUM_SCRAP.get(), RecipeCategory.MISC, ModItems.RAW_ALUMINUM.get());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_ALUMINUM.get(), RecipeCategory.MISC, ModBlocks.RAW_ALUMINUM_BLOCK.asItem());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_ROSE_QUARTZ.get(), RecipeCategory.MISC, ModBlocks.RAW_ROSE_QUARTZ_BLOCK.get().asItem());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ROSE_QUARTZ.getGem().get(), RecipeCategory.MISC, ModBlocks.ROSE_QUARTZ_BLOCK.get().asItem());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.OTHERWORLDLY_AMETHYST.getGem().get(), RecipeCategory.MISC, ModBlocks.OTHERWORLDLY_AMETHYST_BLOCK.get().asItem());

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.CRYSTAL_LANTERN_BLOCK)
                .pattern("III")
                .pattern("IAI")
                .pattern("III")
                .define('A', Blocks.AMETHYST_CLUSTER)
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_" + (Blocks.AMETHYST_CLUSTER), has(Blocks.AMETHYST_CLUSTER))
                .save(exporter, "crystal_lantern_block");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TOILET_PAPER)
                .pattern("SS")
                .pattern("SS")
                .define('S', Items.SUGAR_CANE)
                .unlockedBy("has_" + (Items.SUGAR_CANE), has(Items.SUGAR_CANE))
                .save(exporter, "toilet_paper");
        registerSmallSquareRecipe(exporter, ModItems.THULITE_SHARD.get(), ModBlocks.THULITE_CRYSTAL_BLOCK.get().asItem(), 1);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHISEL)
                .pattern("A")
                .pattern("S")
                .define('A', ModItems.ALUMINUM_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_" + (ModItems.ALUMINUM_INGOT), has(ModItems.ALUMINUM_INGOT))
                .save(exporter, "chisel");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BLUE_DYE, 1)
                .requires(ModItems.BLUEBERRY, 1)
                .unlockedBy("has_" + (ModItems.BLUEBERRY), has(ModItems.BLUEBERRY))
                .save(exporter, "dye_from_blueberry");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PURPLE_DYE, 1)
                .requires(ModItems.GRAPES, 1)
                .unlockedBy("has_" + (ModItems.GRAPES), has(ModItems.GRAPES))
                .save(exporter, "dye_from_grapes");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CERISE_DYE, 1)
                .requires(ModItems.STRAWBERRY, 1)
                .unlockedBy("has_" + (ModItems.STRAWBERRY), has(ModItems.STRAWBERRY))
                .save(exporter, "dye_from_strawberry");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CERISE_DYE, 2)
                .requires(Items.RED_DYE, 1)
                .requires(Items.PINK_DYE, 1)
                .unlockedBy("has_" + (Items.RED_DYE), has(Items.RED_DYE))
                .unlockedBy("has_" + (Items.PINK_DYE), has(Items.PINK_DYE))
                .save(exporter, "cerise_from_dyes");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TURQUOISE_DYE, 2)
                .requires(Items.BLUE_DYE, 1)
                .requires(Items.CYAN_DYE, 1)
                .unlockedBy("has_" + (Items.BLUE_DYE), has(Items.BLUE_DYE))
                .unlockedBy("has_" + (Items.CYAN_DYE), has(Items.CYAN_DYE))
                .save(exporter, "turquoise_from_dyes");

        //Soda Recipes
        offerSodaRecipeDirt(exporter, ModItems.DIRT_SODA.get(), Items.DIRT);
        offerSodaRecipe(exporter, ModItems.STRAWBERRY_SODA.get(), ModItems.STRAWBERRY.get());
        offerSodaRecipe(exporter, ModItems.ORANGE_SODA.get(), ModItems.ORANGE.get());
        offerSodaRecipe(exporter, ModItems.BLUEBERRY_SODA.get(), ModItems.BLUEBERRY.get());
        offerSodaRecipe(exporter, ModItems.GRAPE_SODA.get(), ModItems.GRAPES.get());
        offerTwoIngredientSodaRecipe(exporter, ModItems.LEMON_LIME_SODA.get(), ModItems.LEMON.get(), ModItems.LIME.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SODA_CAN)
                .pattern("A A")
                .pattern("A A")
                .pattern("AAA")
                .define('A', ModItems.ALUMINUM_INGOT)
                .unlockedBy("has_" + (ModItems.ALUMINUM_INGOT), has(ModItems.ALUMINUM_INGOT))
                .save(exporter, "soda_can");
//CrystalLanterns
        registerCrystalLanternRecipe(exporter, Items.AMETHYST_CLUSTER, ModBlocks.CRYSTAL_LANTERN.get().asItem());
        registerCrystalLanternRecipe(exporter, Items.REDSTONE_TORCH, ModBlocks.REDSTONE_LANTERN.get().asItem());
        registerCrystalLanternRecipe(exporter, ModBlocks.THULITE_CLUSTER.get().asItem(), ModBlocks.THULITE_LANTERN.get().asItem());


        //Gems

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OTHERWORLDLY_AMETHYST.getGem())
                .pattern("E ")
                .pattern("NA")
                .define('A', Items.AMETHYST_SHARD)
                .define('E', ModItems.ENDERTHYST)
                .define('N', ModItems.NETHERTHYST)
                .unlockedBy("has_" + (Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .unlockedBy("has_" + (ModItems.ENDERTHYST), has(ModItems.ENDERTHYST))
                .unlockedBy("has_" + (ModItems.NETHERTHYST), has(ModItems.NETHERTHYST))
                .save(exporter, "otherworldly_amethyst_from_left_enderthyst");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OTHERWORLDLY_AMETHYST.getGem())
                .pattern(" E")
                .pattern("NA")
                .define('A', Items.AMETHYST_SHARD)
                .define('E', ModItems.ENDERTHYST)
                .define('N', ModItems.NETHERTHYST)
                .unlockedBy("has_" + (Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .unlockedBy("has_" + (ModItems.ENDERTHYST), has(ModItems.ENDERTHYST))
                .unlockedBy("has_" + (ModItems.NETHERTHYST), has(ModItems.NETHERTHYST))
                .save(exporter, "otherworldly_amethyst_from_right_enderthyst");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.DIAMOND, 1)
                .requires(ModItems.DIAMOND_SHARD, 9)
                .unlockedBy("has_" + (ModItems.DIAMOND_SHARD), has(ModItems.DIAMOND_SHARD))
                .save(exporter, "diamond_from_shards");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DIAMOND_SHARD, 9)
                .requires(Items.DIAMOND, 1)
                .unlockedBy("has_" + (Items.DIAMOND), has(ModItems.DIAMOND_SHARD))
                .save(exporter, "diamond_shards_from_diamond");

        trimSmithing(exporter, ModItems.COVER_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath("strawberry", "cover_smithing_trim"));
        trimSmithing(exporter, ModItems.STARS_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath("strawberry", "stars_smithing_trim")); registerTemplateRecipe(exporter, ModItems.SHINING_UPGRADE_SMITHING_TEMPLATE.get(), (ModBlocks.ALUMINUM_BLOCK).get().asItem());
        registerTemplateRecipe(exporter, ModItems.SIMPLE_UPGRADE_SMITHING_TEMPLATE.get(), (Blocks.COBBLESTONE).asItem());
        registerTemplateRecipe(exporter, ModItems.COVER_SMITHING_TEMPLATE.get(), (Blocks.COBBLESTONE).asItem());
        registerTemplateRecipe(exporter, ModItems.STARS_SMITHING_TEMPLATE.get(), (Blocks.BLUE_GLAZED_TERRACOTTA).asItem());
        registerTemplateRecipe(exporter, ModItems.STARS_SMITHING_TEMPLATE.get(), (Blocks.PURPLE_GLAZED_TERRACOTTA).asItem());


        registerToolAndArmorRecipes(exporter, ModItems.ROSE_QUARTZ, ModItems.ROSE_QUARTZ.getGem().get(), "rose_quartz");
        //registerToolAndArmorRecipes(exporter, ModItems.OTHERWORLDLY_AMETHYST, ModItems.OTHERWORLDLY_AMETHYST.getGem(), "otherworldly_amethyst");
        registerToolAndArmorRecipes(exporter, ModItems.RUBY, ModItems.RUBY.getGem().get(), "ruby");
        registerToolAndArmorRecipes(exporter, ModItems.SAPPHIRE, ModItems.SAPPHIRE.getGem().get(), "sapphire");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OTHERWORLDLY_AMETHYST_HAMMER)
                .pattern("AAA")
                .pattern("ASA")
                .pattern(" S ")
                .define('A', ModItems.OTHERWORLDLY_AMETHYST.getGem())
                .define('S', Items.STICK)
                .unlockedBy("has_" + (ModItems.OTHERWORLDLY_AMETHYST.getGem()), has(ModItems.OTHERWORLDLY_AMETHYST.getGem()))
                .save(exporter, "otherworldly_amethyst_hammer");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ROSE_QUARTZ_HAMMER)
                .pattern("AAA")
                .pattern("ASA")
                .pattern(" S ")
                .define('A', ModItems.ROSE_QUARTZ.getGem())
                .define('S', Items.STICK)
                .unlockedBy("has_" + (ModItems.ROSE_QUARTZ.getGem()), has(ModItems.ROSE_QUARTZ.getGem()))
                .save(exporter, "rose_quartz_hammer");
        registerToolAndArmorSmithingRecipe(exporter, ModItems.SHINING_UPGRADE_SMITHING_TEMPLATE.get(),
                ModItems.ROSE_QUARTZ, ModBlocks.OTHERWORLDLY_AMETHYST_BLOCK.asItem(),
                ModItems.OTHERWORLDLY_AMETHYST);
        registerToolAndArmorSmithingRecipe(exporter, ModItems.SHINING_UPGRADE_SMITHING_TEMPLATE.get(),
                VanillaSets.NETHERITE, ModItems.ROSE_QUARTZ.getGem().get(),
                ModItems.ROSE_QUARTZ);

        registerFullWoodSet(exporter, ModBlocks.PLUM);
        registerFullWoodSet(exporter, ModBlocks.SYCAMORE);
        registerFullWoodSet(exporter, ModBlocks.BLOODWOOD);

        registerFullStoneSet(exporter, ModBlocks.NIGHTSTONE);
        registerFullStoneSet(exporter, ModBlocks.GRIMSTONE);

        registerFullSimpleStoneSet(exporter, ModBlocks.GRANITE_BRICKS, "granite_bricks");
        registerFullSimpleStoneSet(exporter, ModBlocks.WASHED_GRANITE_BRICKS, "washed_granite_bricks");
        registerFullSimpleStoneSet(exporter, ModBlocks.ANDESITE_BRICKS, "andesite_bricks");
        registerFullSimpleStoneSet(exporter, ModBlocks.WASHED_ANDESITE_BRICKS, "washed_andesite_bricks");
        registerFullSimpleStoneSet(exporter, ModBlocks.DIORITE_BRICKS, "diorite_bricks");
        registerFullSimpleStoneSet(exporter, ModBlocks.WASHED_DIORITE_BRICKS, "washed_diorite_bricks");
        offerWashedRecipe(exporter, ModBlocks.WASHED_GRANITE_BRICKS.block.asItem(), ModBlocks.GRANITE_BRICKS.block.asItem());
        offerWashedRecipe(exporter, ModBlocks.WASHED_ANDESITE_BRICKS.block.asItem(), ModBlocks.ANDESITE_BRICKS.block.asItem());
        offerWashedRecipe(exporter, ModBlocks.WASHED_DIORITE_BRICKS.block.asItem(), ModBlocks.DIORITE_BRICKS.block.asItem());
        offerWashedRecipe(exporter, ModBlocks.WASHED_COBBLESTONE.block.asItem(), Blocks.COBBLESTONE.asItem());


        registerFullSimpleStoneSet(exporter, ModBlocks.AGED_COBBLESTONE, "aged_cobblestone");
        registerFullSimpleStoneSet(exporter, ModBlocks.AGED_COBBLESTONE_BRICKS, "aged_cobblestone_bricks");
        registerFullSimpleStoneSet(exporter, ModBlocks.EXPOSED_COBBLESTONE, "exposed_cobblestone");
        registerFullSimpleStoneSet(exporter, ModBlocks.EXPOSED_COBBLESTONE_BRICKS, "exposed_cobblestone_bricks");
        registerFullSimpleStoneSet(exporter, ModBlocks.WASHED_COBBLESTONE, "washed_cobblestone");
        registerFullSimpleStoneSet(exporter, ModBlocks.WASHED_COBBLESTONE_BRICKS, "washed_cobblestone_bricks");
        registerFullSimpleStoneSet(exporter, ModBlocks.WEATHERED_COBBLESTONE, "weathered_cobblestone");
        registerFullSimpleStoneSet(exporter, ModBlocks.WEATHERED_COBBLESTONE_BRICKS, "weathered_cobblestone_bricks");
        registerFullSimpleStoneSet(exporter, ModBlocks.SEALED_AGED_COBBLESTONE, "sealed_aged_cobblestone");
        registerFullSimpleStoneSet(exporter, ModBlocks.SEALED_AGED_COBBLESTONE_BRICKS, "sealed_aged_cobblestone_bricks");
        registerFullSimpleStoneSet(exporter, ModBlocks.SEALED_EXPOSED_COBBLESTONE, "sealed_exposed_cobblestone");
        registerFullSimpleStoneSet(exporter, ModBlocks.SEALED_EXPOSED_COBBLESTONE_BRICKS, "sealed_exposed_cobblestone_bricks");
        registerFullSimpleStoneSet(exporter, ModBlocks.SEALED_WASHED_COBBLESTONE, "sealed_washed_cobblestone");
        registerFullSimpleStoneSet(exporter, ModBlocks.SEALED_WASHED_COBBLESTONE_BRICKS, "sealed_washed_cobblestone_bricks");
        registerFullSimpleStoneSet(exporter, ModBlocks.SEALED_WEATHERED_COBBLESTONE, "sealed_weathered_cobblestone");
        registerFullSimpleStoneSet(exporter, ModBlocks.SEALED_WEATHERED_COBBLESTONE_BRICKS, "sealed_weathered_cobblestone_bricks");


        registerColorSetRecipes(exporter, ModItems.CERISE_DYE.get(), ModBlocks.CERISE, "cerise");
        registerColorSetRecipes(exporter, ModItems.TURQUOISE_DYE.get(), ModBlocks.TURQUOISE, "turquoise");

        registerSmallSquareBlockRecipe(exporter, ModBlocks.WASHED_COBBLESTONE.getStone().get(), ModBlocks.WASHED_COBBLESTONE_BRICKS.getStone().get());
        registerSmallSquareBlockRecipe(exporter, ModBlocks.WEATHERED_COBBLESTONE.getStone().get(), ModBlocks.WEATHERED_COBBLESTONE_BRICKS.getStone().get());
        registerSmallSquareBlockRecipe(exporter, ModBlocks.AGED_COBBLESTONE.getStone().get(), ModBlocks.AGED_COBBLESTONE_BRICKS.getStone().get());
        registerSmallSquareBlockRecipe(exporter, ModBlocks.EXPOSED_COBBLESTONE.getStone().get(), ModBlocks.EXPOSED_COBBLESTONE_BRICKS.getStone().get());

        registerSmallSquareBlockRecipe(exporter, ModBlocks.SEALED_WASHED_COBBLESTONE.getStone().get(), ModBlocks.SEALED_WASHED_COBBLESTONE_BRICKS.getStone().get());
        registerSmallSquareBlockRecipe(exporter, ModBlocks.SEALED_WEATHERED_COBBLESTONE.getStone().get(), ModBlocks.SEALED_WEATHERED_COBBLESTONE_BRICKS.getStone().get());
        registerSmallSquareBlockRecipe(exporter, ModBlocks.SEALED_AGED_COBBLESTONE.getStone().get(), ModBlocks.SEALED_AGED_COBBLESTONE_BRICKS.getStone().get());
        registerSmallSquareBlockRecipe(exporter, ModBlocks.SEALED_EXPOSED_COBBLESTONE.getStone().get(), ModBlocks.SEALED_EXPOSED_COBBLESTONE_BRICKS.getStone().get());

        registerClaySealSetRecipes(exporter, VanillaSets.COBBLESTONE, ModBlocks.SEALED_COBBLESTONE);
        registerClaySealSetRecipes(exporter, ModBlocks.WASHED_COBBLESTONE, ModBlocks.SEALED_WASHED_COBBLESTONE);
        registerClaySealSetRecipes(exporter, ModBlocks.EXPOSED_COBBLESTONE, ModBlocks.SEALED_EXPOSED_COBBLESTONE);
        registerClaySealSetRecipes(exporter, ModBlocks.WEATHERED_COBBLESTONE, ModBlocks.SEALED_WEATHERED_COBBLESTONE);
        registerClaySealSetRecipes(exporter, ModBlocks.AGED_COBBLESTONE, ModBlocks.SEALED_AGED_COBBLESTONE);
        registerClaySealSetRecipes(exporter, ModBlocks.WASHED_COBBLESTONE_BRICKS, ModBlocks.SEALED_WASHED_COBBLESTONE_BRICKS);
        registerClaySealSetRecipes(exporter, ModBlocks.EXPOSED_COBBLESTONE_BRICKS, ModBlocks.SEALED_EXPOSED_COBBLESTONE_BRICKS);
        registerClaySealSetRecipes(exporter, ModBlocks.WEATHERED_COBBLESTONE_BRICKS, ModBlocks.SEALED_WEATHERED_COBBLESTONE_BRICKS);
        registerClaySealSetRecipes(exporter, ModBlocks.AGED_COBBLESTONE_BRICKS, ModBlocks.SEALED_AGED_COBBLESTONE_BRICKS);
    }
}
