package net.starpony.strawberry.trim;

import net.starpony.strawberry.Strawberry;
import net.starpony.strawberry.item.ModItems;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;

import java.util.Map;

public class ModTrimMaterials {
    public static final ResourceKey<TrimMaterial> RUBY =
            ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "ruby"));
    public static final ResourceKey<TrimMaterial> SAPPHIRE =
            ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "sapphire"));
    public static final ResourceKey<TrimMaterial> ROSE_QUARTZ =
            ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "rose_quartz"));
    public static final ResourceKey<TrimMaterial> OTHERWORLDLY_AMETHYST =
            ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "otherworldly_amethyst"));
    public static final ResourceKey<TrimMaterial> ALUMINUM_INGOT =
            ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "aluminum_ingot"));


    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        register(context, RUBY, ModItems.RUBY.getGem().get(), Style.EMPTY.withColor(TextColor.parseColor("#f44336").getOrThrow()), 0.4F);
        register(context, SAPPHIRE, ModItems.SAPPHIRE.getGem().get(), Style.EMPTY.withColor(TextColor.parseColor("#031CFC").getOrThrow()), 0.9F);
        register(context, ROSE_QUARTZ, ModItems.ROSE_QUARTZ.getGem().get(), Style.EMPTY.withColor(TextColor.parseColor("#d5a6bd").getOrThrow()), 0.5F);
        register(context, OTHERWORLDLY_AMETHYST, ModItems.OTHERWORLDLY_AMETHYST.getGem().get(), Style.EMPTY.withColor(TextColor.parseColor("#9e65c4").getOrThrow()), 1.0F);
        register(context, ALUMINUM_INGOT, ModItems.ALUMINUM_INGOT.get(), Style.EMPTY.withColor(TextColor.parseColor("#bcbcbc").getOrThrow()), 0.2F);
    }

    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> trimKey, Item item,
                                 Style style, float itemModelIndex) {
        TrimMaterial trimmaterial = TrimMaterial.create(trimKey.location().getPath(), item, itemModelIndex,
                Component.translatable(Util.makeDescriptionId("trim_material", trimKey.location())).withStyle(style), Map.of());
        context.register(trimKey, trimmaterial);
    }
}
