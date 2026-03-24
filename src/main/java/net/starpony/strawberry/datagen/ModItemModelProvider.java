package net.starpony.strawberry.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.starpony.strawberry.Strawberry;
import net.starpony.strawberry.block.ModBlocks;
import net.starpony.strawberry.item.ModItems;
import net.starpony.strawberry.util.sets.GemSet;
import net.starpony.strawberry.util.sets.SimpleStoneSet;
import net.starpony.strawberry.util.sets.StoneSet;
import net.starpony.strawberry.util.sets.WoodSet;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {

    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Strawberry.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        // ---- Gem Sets ----
        gemSetItem(ModItems.RUBY);
        gemSetItem(ModItems.SAPPHIRE);
        gemSetItem(ModItems.ROSE_QUARTZ);
        gemSetItem(ModItems.OTHERWORLDLY_AMETHYST);
        handheldItem(ModItems.OTHERWORLDLY_AMETHYST_HAMMER);
        handheldItem(ModItems.ROSE_QUARTZ_HAMMER);
        basicItem(ModItems.NETHERITE_HORSE_ARMOR.asItem());

        // ---- Standalone Materials ----
        basicItem(ModItems.ALUMINUM_INGOT.get());
        basicItem(ModItems.ALUMINUM_SCRAP.get());
        basicItem(ModItems.RAW_ALUMINUM.get());
        basicItem(ModItems.DIAMOND_SHARD.get());
        basicItem(ModItems.THULITE_SHARD.get());
        basicItem(ModItems.NETHERTHYST.get());
        basicItem(ModItems.ENDERTHYST.get());
        basicItem(ModItems.NETHERITE_NUGGET.get());

        // ---- Food ----
        basicItem(ModItems.CAULIFLOWER.get());
        basicItem(ModItems.CAULIFLOWER_SEEDS.asItem());
        basicItem(ModItems.DIRT_SODA.get());
        basicItem(ModItems.STRAWBERRY.get());
        basicItem(ModItems.STRAWBERRY_SODA.get());
        basicItem(ModItems.GRAPES.get());
        basicItem(ModItems.GRAPE_SEEDS.asItem());
        basicItem(ModItems.GRAPE_SODA.get());
        basicItem(ModItems.LEMON.get());
        basicItem(ModItems.LEMONADE.get());
        basicItem(ModItems.LIME.get());
        basicItem(ModItems.LEMON_LIME_SODA.get());
        basicItem(ModItems.BLUEBERRY.get());
        basicItem(ModItems.BLUEBERRY_SODA.get());
        basicItem(ModItems.ORANGE.get());
        basicItem(ModItems.ORANGE_SODA.get());


        // ---- MISC ----
        basicItem(ModItems.SUNSET_VIBES_MUSIC_DISC.get());
        basicItem(ModItems.FUSION_KEY.get());
        basicItem(ModItems.SODA_CAN.get());
        basicItem(ModItems.TOILET_PAPER.get());
        basicItem(ModItems.SMALL_LIGHT.get());
        basicItem(ModItems.RAW_ROSE_QUARTZ.get());
        basicItem(ModItems.BRIQUETTE.get());
        handheldItem(ModItems.CHISEL.get());
        basicItem(ModItems.STRAWBERRY_REDSTONE.get());
        withExistingParent(ModItems.MOOBLOOM_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        // ---- Templates ----
        basicItem(ModItems.SHINING_UPGRADE_SMITHING_TEMPLATE.get());
        basicItem(ModItems.COVER_SMITHING_TEMPLATE.get());
        basicItem(ModItems.SIMPLE_UPGRADE_SMITHING_TEMPLATE.get());
        basicItem(ModItems.STARS_SMITHING_TEMPLATE.get());

        // ---- Dyes ----
        basicItem(ModItems.CERISE_DYE.get());
        basicItem(ModItems.TURQUOISE_DYE.get());
        basicItem(ModItems.INDIGO_DYE.get());
        basicItem(ModItems.LAVENDER_DYE.get());

        // ---- Wood Sets ----
        woodSetItem(ModBlocks.SYCAMORE);
        woodSetItem(ModBlocks.PLUM);
        woodSetItem(ModBlocks.BLOODWOOD);

        // ---- Simple Stone Sets ----
        simpleStoneSetItem(ModBlocks.GRANITE_BRICKS);
        simpleStoneSetItem(ModBlocks.GRANITE_BRICKS);
        simpleStoneSetItem(ModBlocks.ANDESITE_BRICKS);
        simpleStoneSetItem(ModBlocks.WASHED_ANDESITE_BRICKS);
        simpleStoneSetItem(ModBlocks.DIORITE_BRICKS);
        simpleStoneSetItem(ModBlocks.WASHED_DIORITE_BRICKS);
        simpleStoneSetItem(ModBlocks.GRANITE_BRICKS);;
        simpleStoneSetItem(ModBlocks.WASHED_GRANITE_BRICKS);
        simpleStoneSetItem(ModBlocks.WASHED_COBBLESTONE);
        simpleStoneSetItem(ModBlocks.WASHED_COBBLESTONE_BRICKS);
        simpleStoneSetItem(ModBlocks.WEATHERED_COBBLESTONE);
        simpleStoneSetItem(ModBlocks.WEATHERED_COBBLESTONE_BRICKS);
        simpleStoneSetItem(ModBlocks.AGED_COBBLESTONE);
        simpleStoneSetItem(ModBlocks.AGED_COBBLESTONE_BRICKS);
        simpleStoneSetItem(ModBlocks.EXPOSED_COBBLESTONE);
        simpleStoneSetItem(ModBlocks.EXPOSED_COBBLESTONE_BRICKS);

                // ---- Stone Sets ----
        stoneSetItem(ModBlocks.NIGHTSTONE);
        stoneSetItem(ModBlocks.GRIMSTONE);

    }
    private void stoneSetItem (StoneSet set) {
        buttonItem(set.getButton(), set.getBase());
        wallItem(set.getWall(), set.getBase());
        buttonItem(set.getCobbledButton(), set.getCobbled());
        wallItem(set.getCobbledWall(), set.getCobbled());
        buttonItem(set.getChiseledButton(), set.getChiseled());
        wallItem(set.getChiseledWall(), set.getChiseled());
        buttonItem(set.getBricksButton(), set.getBricks());
        wallItem(set.getBricksWall(), set.getBricks());
        buttonItem(set.getCrackedBricksButton(), set.getCrackedBricks());
        wallItem(set.getCrackedBricksWall(), set.getCrackedBricks());
        buttonItem(set.getSmoothButton(), set.getSmooth());
        wallItem(set.getSmoothWall(), set.getSmooth());
    }
    private void simpleStoneSetItem (SimpleStoneSet set) {
        buttonItem(set.getButton(), set.getStone());
        wallItem(set.getWall(), set.getStone());
    }
    private void woodSetItem(WoodSet set) {
        buttonItem(set.getButton(), set.getPlanks());
        fenceItem(set.getFence(), set.getPlanks());
        basicItem(set.getDoor().asItem());
        saplingItem(set.getSapling());}
    private void gemSetItem(GemSet set) {
        basicItem(set.getGem().get());
        if(set.getShard() != null) basicItem(set.getShard().get());

        handheldItem(set.getSword());
        handheldItem(set.getPickaxe());
        handheldItem(set.getShovel());
        handheldItem(set.getAxe());
        handheldItem(set.getHoe());

        trimmedArmorItem(set.getHelmet());
        trimmedArmorItem(set.getChestplate());
        trimmedArmorItem(set.getLeggings());
        trimmedArmorItem(set.getBoots());
        if(set.getHorseArmor() != null) basicItem(set.getHorseArmor().get());
    }
    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID,
                        "block/" + item.getId().getPath()));
    }
    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(DeferredItem<ArmorItem> itemDeferredItem) {
        final String MOD_ID = Strawberry.MOD_ID;

        if(itemDeferredItem.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemDeferredItem.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemDeferredItem.getId().getPath()));
            });
        }
    }
    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld"))
                .texture("layer0",
                        ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID,
                                "item/" + item.getId().getPath()));
    }
    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}