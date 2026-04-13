package net.starpony.strawberry.datagen;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.starpony.strawberry.item.ModItems;
import net.starpony.strawberry.util.ModTags;
import net.starpony.strawberry.util.sets.*;
import net.minecraft.data.recipes.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RecipeMethodProvider extends RecipeProvider implements IConditionBuilder {
    public RecipeMethodProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    ///  Methods to simplify the recipe provider

    private static void registerWoodRecipe(RecipeOutput output, Block inputA, Block outputBlock, String name, String number) {
        ItemStack result = new ItemStack(outputBlock, 3);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result.getItem())
                .pattern("II")
                .pattern("II")
                .define('I', inputA)
                .unlockedBy("has_" + (inputA), has(inputA))
                .save(output, name + "_wood_recipe" + number);
    }
    private static void registerPlankRecipes(RecipeOutput output, Block[] inputs, Block result) {
        for (int i = 0; i < inputs.length; i++) {
            Block inputBlock = inputs[i];
            Item input = inputBlock.asItem();

            String inputName = BuiltInRegistries.BLOCK.getKey(inputBlock).getPath();
            String resultName = BuiltInRegistries.BLOCK.getKey(result).getPath();

            String recipeName = inputName + "_to_" + resultName + "_" + i;

            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, result, 4)
                    .requires(input)
                    .unlockedBy("has_" + inputName, has(input))
                    .save(output, recipeName);
        }
    }
    public static void registerFullWoodSet(RecipeOutput output, WoodSet woodSet) {
        registerWoodRecipe(output, woodSet.getLog().get(), woodSet.getWood().get(), woodSet.getName(), "1");
        registerWoodRecipe(output, woodSet.getStrippedLog().get(), woodSet.getStrippedWood().get(), woodSet.getName(), "2");
        registerPlankRecipes(output, new Block[]{woodSet.getLog().get(), woodSet.getWood().get(), woodSet.getStrippedLog().get(), woodSet.getStrippedWood().get()}, woodSet.getPlanks().get());
        buttonBuilder(woodSet.getButton().get(), Ingredient.of(woodSet.getPlanks().get()));
        slab(output, RecipeCategory.DECORATIONS, woodSet.getSlab(), woodSet.getPlanks().get());
        stairBuilder(woodSet.getStairs(), Ingredient.of(woodSet.getPlanks())).group(woodSet.getName())
                .unlockedBy("has_" + (woodSet.getPlanks()), has(woodSet.getPlanks()))
                .save(output, woodSet.getName() + "_stairs");
        doorBuilder(woodSet.getDoor(), Ingredient.of(woodSet.getPlanks()))
                .unlockedBy("has_" + (woodSet.getPlanks()), has(woodSet.getPlanks()))
                .save(output, woodSet.getName() + "_door");
        fenceGateBuilder(woodSet.getFenceGate(), Ingredient.of(woodSet.getPlanks()))
                .unlockedBy("has_" + (woodSet.getPlanks()), has(woodSet.getPlanks()))
                .save(output, woodSet.getName() + "_fence_gate");
        fenceBuilder(woodSet.getFence(), Ingredient.of(woodSet.getPlanks()))
                .unlockedBy("has_" + (woodSet.getPlanks()), has(woodSet.getPlanks()))
                .save(output, woodSet.getName() + "_fence");
        pressurePlate(output, woodSet.getPressurePlate(), woodSet.getPlanks().get());
        trapdoorBuilder(woodSet.getTrapdoor(), Ingredient.of(woodSet.getPlanks()))
                .unlockedBy("has_" + (woodSet.getPlanks()), has(woodSet.getPlanks()))
                .save(output, woodSet.getName() + "_trapdoor");
    }
    public static void registerStoneVariant(RecipeOutput output, StoneSet set, Block baseBlock, Block stairs, Block slab, Block wall, Block button, Block pressurePlate, String variantName) {
        stairBuilder(stairs, Ingredient.of(baseBlock))
                .unlockedBy("has_" + (baseBlock), has(baseBlock))
                .save(output,  variantName + "_stairs");
        slab(output, RecipeCategory.BUILDING_BLOCKS, slab, baseBlock);
        wall(output, RecipeCategory.BUILDING_BLOCKS, wall, baseBlock);
        buttonBuilder(button, Ingredient.of(baseBlock));
        pressurePlate(output, pressurePlate, baseBlock);

        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, stairs, baseBlock);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, slab, baseBlock, 2);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, wall, baseBlock);
    }
    public static void registerFullStoneSet(RecipeOutput output, StoneSet set) {

        // Base
        registerStoneVariant(output, set,
                set.base.get(), set.stairs.get(), set.slab.get(), set.wall.get(), set.button.get(), set.pressurePlate.get(),
                set.baseName + "_base");
        // Cobbled
        registerStoneVariant(output, set,
                set.cobbled.get(), set.cobbledStairs.get(), set.cobbledSlab.get(), set.cobbledWall.get(), set.cobbledButton.get(), set.cobbledPressurePlate.get(),
                set.baseName + "_cobbled");
        // Chiseled
        registerStoneVariant(output, set,
                set.chiseled.get(), set.chiseledStairs.get(), set.chiseledSlab.get(), set.chiseledWall.get(), set.chiseledButton.get(), set.chiseledPressurePlate.get(),
                set.baseName + "_chiseled");
        // Bricks
        registerStoneVariant(output, set,
                set.bricks.get(), set.bricksStairs.get(), set.bricksSlab.get(), set.bricksWall.get(), set.bricksButton.get(), set.bricksPressurePlate.get(),
                set.baseName + "_bricks");
        // Cracked Bricks
        registerStoneVariant(output, set,
                set.crackedBricks.get(), set.crackedBricksStairs.get(), set.crackedBricksSlab.get(), set.crackedBricksWall.get(), set.crackedBricksButton.get(), set.crackedBricksPressurePlate.get(),
                set.baseName + "_cracked_bricks");
        // Smooth
        registerStoneVariant(output, set,
                set.smooth.get(), set.smoothStairs.get(), set.smoothSlab.get(), set.smoothWall.get(), set.smoothButton.get(), set.smoothPressurePlate.get(),
                set.baseName + "_smooth");
        
        List<DeferredBlock> variants = List.of(set.getCobbled(), set.getChiseled(), set.getBricks(), set.getSmooth());
        for (DeferredBlock variant : variants) {
            stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, variant, set.getBase());
        }
        smeltBricks(output, set.getBricks(), set.getCrackedBricks(), "bricks");
        smeltBricks(output, set.getBricksStairs(), set.getCrackedBricksStairs(), "bricks_stairs");
        smeltBricks(output, set.getBricksSlab(), set.getCrackedBricksSlab(), "bricks_slab");
        smeltBricks(output, set.getBricksWall(), set.getCrackedBricksWall(), "bricks_wall");
        smeltBricks(output, set.getBricksButton(), set.getCrackedBricksButton(), "bricks_button");
        smeltBricks(output, set.getBricksPressurePlate(), set.getCrackedBricksPressurePlate(), "bricks_pressure_plate");

    }
    public static void smeltBricks(RecipeOutput output, DeferredBlock input, DeferredBlock result, String suffix) {
        oreSmelting(
                output,
                List.of(input),
                RecipeCategory.BUILDING_BLOCKS, // or REDSTONE etc
                result,
                0.1f,
                200,
                "smelting"
        );
    }
    public static void registerFullSimpleStoneSet(RecipeOutput output, SimpleStoneSet set, String baseName) {
        stairBuilder(set.getStairs(), Ingredient.of(set.getStone()))
                .unlockedBy("has_" + (set.getStone()), has(set.getStone()))
                .save(output,  baseName + "_stairs");
        slab(output, RecipeCategory.BUILDING_BLOCKS, set.getSlab(), set.getStone());
        wall(output, RecipeCategory.BUILDING_BLOCKS, set.getWall(), set.getStone());
        buttonBuilder(set.getButton(), Ingredient.of(set.getStone()));
        pressurePlate(output, set.getPressurePlate(), set.getStone());

        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, set.getStairs(), set.getStone());
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, set.getSlab(), set.getStone(), 2);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, set.getWall(), set.getStone());
    }
    public static void registerColorSetRecipes(RecipeOutput output, Item dye, ColorSet set, String recipePrefix) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, set.getWool().asItem())
                .requires(dye)
                .requires(ModTags.Items.WOOL)
                .unlockedBy("has_" + (dye), has(dye))
                .unlockedBy("has_" + (ModTags.Items.WOOL), has(ModTags.Items.WOOL))
                .save(output,  recipePrefix + "_wool");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, set.getCarpet().asItem(), 3)
                .pattern("AA")
                .define('A', set.getWool())
                .unlockedBy("has_" + (set.getWool()), has(set.getWool()))
                .save(output,  recipePrefix + "_carpet");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, set.getConcretePowder().asItem(), 8)
                .requires(dye)
                .requires(Ingredient.of(Items.SAND), 4)
                .requires(Ingredient.of(Items.GRAVEL), 4)
                .unlockedBy("has_" + (dye), has(dye))
                .save(output,  recipePrefix + "_concrete_powder");
        
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, set.getConcrete().asItem(), 8)
                .pattern("CCC")
                .pattern("CDC")
                .pattern("CCC")
                .define('C', ModTags.Items.CONCRETE)
                .define('D', dye)
                .unlockedBy("has_" + dye, has(dye))
                .unlockedBy("has_concrete", has(ModTags.Items.CONCRETE))
                .save(output, recipePrefix + "_concrete");
        
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, set.getTerracotta().asItem(), 8)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', ModTags.Items.TERRACOTTA)
                .define('B', dye)
                .unlockedBy("has_" + (dye), has(dye))
                .unlockedBy("has_terracotta", has(ModTags.Items.TERRACOTTA))
                .save(output,  recipePrefix + "_terracotta");
        oreSmelting(
                output,
                List.of(set.getTerracotta()),
                RecipeCategory.DECORATIONS,
                set.getGlazedTerracotta(),
                0.1f,
                200,
                recipePrefix + "_glazed_terracotta"
        );
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, set.getStainedGlass().asItem(), 8)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', ModTags.Items.GLASS)
                .define('B', dye)
                .unlockedBy("has_" + (dye), has(dye))
                .unlockedBy("has_glass", has(ModTags.Items.GLASS))
                .save(output,  recipePrefix + "_stained_glass");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, set.getStainedGlassPane().asItem(), 8)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', ModTags.Items.GLASS_PANES)
                .define('B', dye)
                .unlockedBy("has_" + (dye), has(dye))
                .unlockedBy("has_glass_panes", has(ModTags.Items.GLASS_PANES))
                .save(output,  recipePrefix + "_stained_glass_pane_from_glass_panes");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, set.getStainedGlassPane().asItem(), 16)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', set.getStainedGlass())
                .unlockedBy("has_" + (set.getStainedGlass()), has(set.getStainedGlass()))
                .save(output,  recipePrefix + "_stained_glass_pane_from_stained_glass");
    }
    public static void registerTemplateRecipe (RecipeOutput output, Item template, Item inputBlock) {
        ItemStack result = new ItemStack(template, 2);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.getItem())
                .pattern("DTD")
                .pattern("DBD")
                .pattern("DDD")
                .define('T', template)
                .define('D', Items.DIAMOND)
                .define('B', inputBlock)
                .unlockedBy("has_" + (template), has(template))
                .save(output, RecipeIdHelper.between(inputBlock, result.getItem(), ""));

    }
    public static void offerWashedRecipe(RecipeOutput output, Item result, Item inputA) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, result)
                .requires(inputA)
                .requires(ModTags.Items.WATER_TAG)
                .unlockedBy("has_" + (inputA), has(inputA))
                .save(output, RecipeIdHelper.between(inputA, result, ""));
    }
    public static void offerSodaRecipe(RecipeOutput output, Item result, Item inputA) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result)
                .requires(inputA)
                .requires(Items.SUGAR)
                .requires(ModItems.SODA_CAN)
                .unlockedBy("has_" + (inputA), has(inputA))
                .unlockedBy("has_" + (ModItems.SODA_CAN), has(ModItems.SODA_CAN))
                .save(output, RecipeIdHelper.between(inputA, result, ""));
    }
    public static void offerSodaRecipeDirt(RecipeOutput output, Item result, Item inputA) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result)
                .requires(inputA)
                .requires(ModItems.SODA_CAN)
                .unlockedBy("has_" + (inputA), has(inputA))
                .unlockedBy("has_" + (ModItems.SODA_CAN), has(ModItems.SODA_CAN))
                .save(output, RecipeIdHelper.between(inputA, result, ""));

    }
    public static void offerTwoIngredientSodaRecipe(RecipeOutput output, Item result, Item inputA, Item inputB) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result)
                .requires(inputA)
                .requires(inputB)
                .requires(Items.SUGAR)
                .requires(ModItems.SODA_CAN)
                .unlockedBy("has_" + (inputA), has(inputA))
                .unlockedBy("has_" + (ModItems.SODA_CAN), has(ModItems.SODA_CAN))
                .save(output, RecipeIdHelper.between(inputA, result, ""));

    }
    public static void registerSmallSquareBlockRecipe(RecipeOutput output, Block inputA, Block outputBlock) {
        ItemStack result = new ItemStack(outputBlock, 4);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result.getItem())
                .pattern("II")
                .pattern("II")
                .define('I', inputA)
                .unlockedBy("has_" + (inputA), has(inputA))
                .save(output, RecipeIdHelper.between(inputA.asItem(), result.getItem(), ""));
    }
    public static void registerSmallSquareRecipe(RecipeOutput output, Item inputA, Item outputItem, int count) {
        ItemStack result = new ItemStack(outputItem, count);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result.getItem())
                .pattern("II")
                .pattern("II")
                .define('I', inputA)
                .unlockedBy("has_" + (inputA), has(inputA))
                .save(output, RecipeIdHelper.between(inputA, outputItem, ""));
    }
    public static void registerToolAndArmorSmithingRecipe(RecipeOutput output, Item template, SmithingBaseSet baseSet, Item addition, GemSet resultSet) {

        String name = resultSet.getName();

        registerSmithing(output, template, baseSet.getSwordItem(), addition, resultSet.getSword().get(), "smithing_" + name + "_sword", RecipeCategory.TOOLS);
        registerSmithing(output, template, baseSet.getShovelItem(), addition, resultSet.getShovel().get(), "smithing_" + name + "_shovel", RecipeCategory.TOOLS);
        registerSmithing(output, template, baseSet.getPickaxeItem(), addition, resultSet.getPickaxe().get(), "smithing_" + name + "_pickaxe", RecipeCategory.TOOLS);
        registerSmithing(output, template, baseSet.getAxeItem(), addition, resultSet.getAxe().get(), "smithing_" + name + "_axe", RecipeCategory.TOOLS);
        registerSmithing(output, template, baseSet.getHoeItem(), addition, resultSet.getHoe().get(), "smithing_" + name + "_hoe", RecipeCategory.TOOLS);
        registerSmithing(output, template, baseSet.getHelmetItem(), addition, resultSet.getHelmet().get(), "smithing_" + name + "_helmet", RecipeCategory.COMBAT);
        registerSmithing(output, template, baseSet.getChestplateItem(), addition, resultSet.getChestplate().get(), "smithing_" + name + "_chestplate", RecipeCategory.COMBAT);
        registerSmithing(output, template, baseSet.getLeggingsItem(), addition, resultSet.getLeggings().get(), "smithing_" + name + "_leggings", RecipeCategory.COMBAT);
        registerSmithing(output, template, baseSet.getBootsItem(), addition, resultSet.getBoots().get(), "smithing_" + name + "_boots", RecipeCategory.COMBAT);
    }
    public static void registerToolAndArmorSmithingRecipeVanilla(RecipeOutput output, Item template, VanillaGemSet baseSet, Item addition, GemSet resultSet) {
        registerToolAndArmorSmithingRecipe(output, template, baseSet, addition, resultSet);
    }
    public static void registerSmithing(RecipeOutput output, Item template, Item base, Item addition, Item result, String recipename, RecipeCategory category) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(base), Ingredient.of(addition), category, result)
                .unlocks("has_" + (addition), has(addition))
                .save(output, recipename);

    }
    public static void registerCrystalLanternRecipe(RecipeOutput output, Item inputA, Item result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result)
                .pattern("III")
                .pattern("IAI")
                .pattern("III")
                .define('A', inputA)
                .define('I', Items.IRON_NUGGET)
                .unlockedBy("has_" + (inputA), has(inputA))
                .save(output, RecipeIdHelper.between(inputA, result, ""));
    }
    public static void offerReversibleCompactingRecipes(RecipeOutput output, RecipeCategory blockCategory, Item item, RecipeCategory itemCategory, Item block) {

        ShapedRecipeBuilder.shaped(blockCategory, block)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', item)
                .unlockedBy("has_" + item, has(item))
                .save(output);

        ShapelessRecipeBuilder.shapeless(itemCategory, item, 9)
                .requires(block)
                .unlockedBy("has_" + block, has(block))
                .save(output, RecipeIdHelper.between(block, item, ""));
    }
    public static void registerToolAndArmorRecipes(RecipeOutput output, GemSet gemSet, Item material, String recipeName) {

        // Sword
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, gemSet.getSword())
                .pattern("A")
                .pattern("A")
                .pattern("I")
                .define('A', material)
                .define('I', Items.STICK)
                .unlockedBy("has_" + (material), has(material))
                .save(output,  recipeName + "_sword");

        // Shovel
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, gemSet.getShovel())
                .pattern("A")
                .pattern("I")
                .pattern("I")
                .define('A', material)
                .define('I', Items.STICK)
                .unlockedBy("has_" + (material), has(material))
                .save(output,  recipeName + "_shovel");

        // Pickaxe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, gemSet.getPickaxe())
                .pattern("AAA")
                .pattern(" I ")
                .pattern(" I ")
                .define('A', material)
                .define('I', Items.STICK)
                .unlockedBy("has_" + (material), has(material))
                .save(output,  recipeName + "_pickaxe");

        // Axe 1
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, gemSet.getAxe())
                .pattern("AA")
                .pattern("IA")
                .pattern("I ")
                .define('A', material)
                .define('I', Items.STICK)
                .unlockedBy("has_" + (material), has(material))
                .save(output,  recipeName + "_axe_1");
        // Hoe 1
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, gemSet.getHoe())
                .pattern("AA")
                .pattern(" I")
                .pattern(" I")
                .define('A', material)
                .define('I', Items.STICK)
                .unlockedBy("has_" + (material), has(material))
                .save(output,  recipeName + "_hoe_1");

        // Helmet
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, gemSet.getHelmet())
                .pattern("AAA")
                .pattern("A A")
                .define('A', material)
                .unlockedBy("has_" + (material), has(material))
                .save(output,  recipeName + "_helmet");

        // Chestplate
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, gemSet.getChestplate())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', material)
                .unlockedBy("has_" + (material), has(material))
                .save(output,  recipeName + "_chestplate");

        // Leggings
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, gemSet.getLeggings())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', material)
                .unlockedBy("has_" + (material), has(material))
                .save(output,  recipeName + "_leggings");

        // Boots
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, gemSet.getBoots())
                .pattern("A A")
                .pattern("A A")
                .define('A', material)
                .unlockedBy("has_" + (material), has(material))
                .save(output,  recipeName + "_boots");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, gemSet.getGem(), 1)
                .requires(gemSet.getShard(), 9)
                .unlockedBy("has_" + (gemSet.getGem()), has(gemSet.getShard()))
                .save(output,  recipeName + "_gem_from_shards");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, gemSet.getShard(), 9)
                .requires(gemSet.getGem(), 1)
                .unlockedBy("has_" + (gemSet.getGem()), has(gemSet.getShard()))
                .save(output,  recipeName + "_shards_from_gem");


    }
    public static void registerClaySealSetRecipes(RecipeOutput output, SimpleStoneBaseSet source, SimpleStoneBaseSet sealed) {
        List<Block> sourceVariants = List.of(
                source.getStoneBlock(),
                source.getSlabBlock(),
                source.getStairsBlock(),
                source.getWallBlock(),
                source.getButtonBlock(),
                source.getPressurePlateBlock()
        );
        List<Block> sealedVariants = List.of(
                sealed.getStoneBlock(),
                sealed.getSlabBlock(),
                sealed.getStairsBlock(),
                sealed.getWallBlock(),
                sealed.getButtonBlock(),
                sealed.getPressurePlateBlock()
        );

        for (int i = 0; i < sourceVariants.size(); i++) {
            Block sourceBlock = sourceVariants.get(i);
            Block sealedBlock = sealedVariants.get(i);
            if (sourceBlock != null && sealedBlock != null) {
                offerClaySealRecipe(output, sealedBlock.asItem(), sourceBlock.asItem());
            }
        }

    }
    public static void offerClaySealRecipe(RecipeOutput output, Item result, Item inputA) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, result)
                .requires(inputA)
                .requires(Items.CLAY_BALL)
                .unlockedBy("has_" + (inputA), has(inputA))
                .save(output, RecipeIdHelper.between(inputA, result, "_clay_sealing"));
    }


    public static class RecipeIdHelper {

        public static String getPath(Item item) {
            return BuiltInRegistries.ITEM.getKey(item).getPath();
        }

        public static ResourceLocation id(String path) {
            return ResourceLocation.fromNamespaceAndPath("strawberry", path);
        }

        public static ResourceLocation of(Item item) {
            return BuiltInRegistries.ITEM.getKey(item);
        }

        public static ResourceLocation between(Item from, Item to, String suffix) {
            return id(getPath(from) + "_to_" + getPath(to) + suffix);
        }

    }
}


