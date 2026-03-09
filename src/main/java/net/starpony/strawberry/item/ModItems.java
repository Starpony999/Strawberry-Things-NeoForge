package net.starpony.strawberry.item;

import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.starpony.strawberry.Strawberry;
/*import net.starpony.strawberry.block.ModBlocks;
import net.starpony.strawberry.item.custom.ChiselItem;
import net.starpony.strawberry.item.custom.HammerItem;
import net.starpony.strawberry.item.custom.SodaItem;*/
import net.starpony.strawberry.sets.GemSet;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(Strawberry.MOD_ID);

    // Gems and Minerals
    public static final DeferredItem<Item> ALUMINUM_SCRAP = ITEMS.register("aluminum_scrap", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_ALUMINUM = ITEMS.register("raw_aluminum", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_SHARD = ITEMS.register("diamond_shard", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_NUGGET = ITEMS.register("netherite_nugget", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NETHERTHYST = ITEMS.register("netherthyst", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ENDERTHYST = ITEMS.register("enderthyst", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> THULITE_SHARD = ITEMS.register("thulite_shard", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_ROSE_QUARTZ = ITEMS.register("raw_rose_quartz", () -> new Item(new Item.Properties()));
 /*   public static final GemSet RUBY = registerGemSet("ruby", ModToolMaterials.RUBY, ModArmorMaterials.RUBY, true);
    public static final GemSet SAPPHIRE = registerGemSet("sapphire", ModToolMaterials.SAPPHIRE, ModArmorMaterials.SAPPHIRE, true);
    public static final GemSet ROSE_QUARTZ = registerGemSet("rose_quartz", ModToolMaterials.ROSE_QUARTZ, ModArmorMaterials.ROSE_QUARTZ, true);
    public static final GemSet OTHERWORLDLY_AMETHYST = registerGemSet("otherworldly_amethyst", ModToolMaterials.OTHERWORLDLY_AMETHYST, ModArmorMaterials.OTHERWORLDLY_AMETHYST, false);
*/
    // MISC
 //   public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel", () -> new ChiselItem(new Item.Properties().durability(32)));
    public static final DeferredItem<Item> BRIQUETTE = ITEMS.register("briquette", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FUSION_KEY = ITEMS.register("fusion_key", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SODA_CAN = ITEMS.register("soda_can", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CRYSTAL_LANTERN = ITEMS.register("crystal_lantern", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TOILET_PAPER = ITEMS.register("toilet_paper", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SMALL_LIGHT = ITEMS.register("small_light", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> REDSTONE_LANTERN = ITEMS.register("redstone_lantern", () -> new Item(new Item.Properties()));
/*
    // Food
    public static final DeferredItem<Item> CAULIFLOWER = ITEMS.register("cauliflower", () -> new Item(new Item.Properties().food(ModFoodComponents.CAULIFLOWER)));
    public static final DeferredItem<Item> CAULIFLOWER_SEEDS = ITEMS.register("cauliflower_seeds", () -> new BlockItem(ModBlocks.CAULIFLOWER_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> STRAWBERRY = ITEMS.register("strawberry", () -> new BlockItem(ModBlocks.STRAWBERRY_BUSH.get(), new Item.Properties().food(ModFoodComponents.STRAWBERRY)));
    public static final DeferredItem<Item> LIME = ITEMS.register("lime", () -> new Item(new Item.Properties().food(ModFoodComponents.LIME)));
    public static final DeferredItem<Item> LEMON = ITEMS.register("lemon", () -> new Item(new Item.Properties().food(ModFoodComponents.LEMON)));
    public static final DeferredItem<Item> GRAPES = ITEMS.register("grapes", () -> new Item(new Item.Properties().food(ModFoodComponents.GRAPES)));
    public static final DeferredItem<Item> GRAPE_SEEDS = ITEMS.register("grape_seeds", () -> new BlockItem(ModBlocks.GRAPE_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> BLUEBERRY = ITEMS.register("blueberry", () -> new BlockItem(ModBlocks.BLUEBERRY_BUSH.get(), new Item.Properties().food(ModFoodComponents.BLUEBERRY)));
    public static final DeferredItem<Item> ORANGE = ITEMS.register("orange", () -> new Item(new Item.Properties().food(ModFoodComponents.ORANGE)));

    // Sodas
    public static final DeferredItem<Item> DIRT_SODA = ITEMS.register("dirt_soda", () -> new SodaItem(new Item.Properties().stacksTo(1).food(ModFoodComponents.DIRT_SODA)));
    public static final DeferredItem<Item> STRAWBERRY_SODA = ITEMS.register("strawberry_soda", () -> new SodaItem(new Item.Properties().stacksTo(1).food(ModFoodComponents.STRAWBERRY_SODA)));
    public static final DeferredItem<Item> LEMON_LIME_SODA = ITEMS.register("lemon_lime_soda", () -> new SodaItem(new Item.Properties().stacksTo(1).food(ModFoodComponents.LEMON_LIME_SODA)));
    public static final DeferredItem<Item> GRAPE_SODA = ITEMS.register("grape_soda", () -> new SodaItem(new Item.Properties().stacksTo(1).food(ModFoodComponents.GRAPE_SODA)));
    public static final DeferredItem<Item> BLUEBERRY_SODA = ITEMS.register("blueberry_soda", () -> new SodaItem(new Item.Properties().stacksTo(1).food(ModFoodComponents.BLUEBERRY_SODA)));
    public static final DeferredItem<Item> ORANGE_SODA = ITEMS.register("orange_soda", () -> new SodaItem(new Item.Properties().stacksTo(1).food(ModFoodComponents.ORANGE_SODA)));

    // Individual GemSet Items
    public static final DeferredItem<Item> ROSE_QUARTZ_HAMMER = ITEMS.register("rose_quartz_hammer", () -> new HammerItem(ModToolMaterials.ROSE_QUARTZ, new Item.Properties()));
    public static final DeferredItem<Item> OTHERWORLDLY_AMETHYST_HAMMER = ITEMS.register("otherworldly_amethyst_hammer", () -> new HammerItem(ModToolMaterials.OTHERWORLDLY_AMETHYST, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_HORSE_ARMOR = ITEMS.register("netherite_horse_armor", () -> new AnimalArmorItem(ArmorMaterials.NETHERITE, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Properties().stacksTo(1)));
*/
    //Registry Helpers
  /*  public static GemSet registerGemSet(String name, ToolMaterial toolMaterial, ArmorMaterial armorMaterial, boolean withShard) {

        String lower = name.toLowerCase();

        DeferredItem<Item> sword = ITEMS.register(lower + "_sword",
                () -> new SwordItem(toolMaterial, new Item.Properties()));

        DeferredItem<Item> pickaxe = ITEMS.register(lower + "_pickaxe",
                () -> new PickaxeItem(toolMaterial, new Item.Properties()));

        DeferredItem<Item> shovel = ITEMS.register(lower + "_shovel",
                () -> new ShovelItem(toolMaterial, new Item.Properties()));

        DeferredItem<Item> axe = ITEMS.register(lower + "_axe",
                () -> new AxeItem(toolMaterial, new Item.Properties()));

        DeferredItem<Item> hoe = ITEMS.register(lower + "_hoe",
                () -> new HoeItem(toolMaterial, new Item.Properties()));

        DeferredItem<Item> helmet = ITEMS.register(lower + "_helmet",
                () -> new ModArmorItem(armorMaterial, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));

        DeferredItem<Item> chestplate = ITEMS.register(lower + "_chestplate",
                () -> new ModArmorItem(armorMaterial, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));

        DeferredItem<Item> leggings = ITEMS.register(lower + "_leggings",
                () -> new ModArmorItem(armorMaterial, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));

        DeferredItem<Item> boots = ITEMS.register(lower + "_boots",
                () -> new ModArmorItem(armorMaterial, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1)));

        DeferredItem<Item> horseArmor = ITEMS.register(lower + "_horse_armor",
                () -> new AnimalArmorItem(armorMaterial, AnimalArmorItem.Type.EQUESTRIAN, true, new Item.Properties().stacksTo(1)));

        DeferredItem<Item> gem = ITEMS.register(lower,
                () -> new Item(new Item.Properties()));

        DeferredItem<Item> shard = withShard
                ? ITEMS.register(lower + "_shard", () -> new Item(new Item.Properties()))
                : null;

        return new GemSet(name, gem, shard, hoe, axe, pickaxe, sword, shovel,
                helmet, chestplate, leggings, boots, horseArmor);
    }
  */
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}