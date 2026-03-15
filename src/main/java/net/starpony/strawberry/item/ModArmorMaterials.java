package net.starpony.strawberry.item;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.starpony.strawberry.Strawberry;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {

    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, Strawberry.MOD_ID);

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> SAPPHIRE_ARMOR_MATERIAL = register("sapphire",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 2);
                attribute.put(ArmorItem.Type.LEGGINGS, 6);
                attribute.put(ArmorItem.Type.CHESTPLATE, 7);
                attribute.put(ArmorItem.Type.HELMET, 3);
                attribute.put(ArmorItem.Type.BODY, 8);
            }), 15, 1f, 0f, () -> ModItems.SAPPHIRE.getGem().get());

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> RUBY_ARMOR_MATERIAL = register("ruby",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 3);
                attribute.put(ArmorItem.Type.LEGGINGS, 6);
                attribute.put(ArmorItem.Type.CHESTPLATE, 8);
                attribute.put(ArmorItem.Type.HELMET, 3);
                attribute.put(ArmorItem.Type.BODY, 11);
            }), 17, 2.5f, 0.5f, () -> ModItems.RUBY.getGem().get());

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> ROSE_QUARTZ_ARMOR_MATERIAL = register("rose_quartz",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 4);
                attribute.put(ArmorItem.Type.LEGGINGS, 7);
                attribute.put(ArmorItem.Type.CHESTPLATE, 9);
                attribute.put(ArmorItem.Type.HELMET, 4);
                attribute.put(ArmorItem.Type.BODY, 12);
            }), 20, 3f, 3f, () -> ModItems.ROSE_QUARTZ.getGem().get());

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> OTHERWORLDLY_AMETHYST_ARMOR_MATERIAL = register("otherworldly_amethyst",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 5);
                attribute.put(ArmorItem.Type.LEGGINGS, 8);
                attribute.put(ArmorItem.Type.CHESTPLATE, 10);
                attribute.put(ArmorItem.Type.HELMET, 5);
                attribute.put(ArmorItem.Type.BODY, 15);
            }), 17, 4f, 5f, () -> ModItems.OTHERWORLDLY_AMETHYST.getGem().get());

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> NETHERITE_HORSE_ARMOR_MATERIAL = register("netherite_horse_armor",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BODY, 15);
            }), 15, 0f, 0.1f, () -> net.minecraft.world.item.Items.NETHERITE_INGOT);

    private static DeferredHolder<ArmorMaterial, ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection,
                    int enchantability, float toughness, float knockbackResistance,
                    Supplier<Item> ingredientItem) {     Holder<SoundEvent> equipSound;
        if (name.equals("netherite_horse_armor")) {
            equipSound = SoundEvents.ARMOR_EQUIP_NETHERITE;
        } else {
            equipSound = SoundEvents.ARMOR_EQUIP_DIAMOND;
        }

        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, name)));

        return ARMOR_MATERIALS.register(name,
                () -> new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance));
    }

    public static void register(IEventBus eventBus) {
        ARMOR_MATERIALS.register(eventBus);
    }
}