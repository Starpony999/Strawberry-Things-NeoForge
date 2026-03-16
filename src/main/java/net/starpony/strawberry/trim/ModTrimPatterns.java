package net.starpony.strawberry.trim;

import net.starpony.strawberry.Strawberry;
import net.starpony.strawberry.item.ModItems;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModTrimPatterns {
    public static final ResourceKey<TrimPattern> COVER = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "cover"));
    public static final ResourceKey<TrimPattern> STARS = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "stars"));

    public static void bootstrap(BootstrapContext<TrimPattern> context) {
        register(context, ModItems.COVER_SMITHING_TEMPLATE, COVER);
        register(context, ModItems.STARS_SMITHING_TEMPLATE, STARS);
    }

    private static void register(BootstrapContext<TrimPattern> context, DeferredItem<Item> item, ResourceKey<TrimPattern> key) {
        TrimPattern trimPattern = new TrimPattern(key.location(), item.getDelegate(),
                Component.translatable(Util.makeDescriptionId("trim_pattern", key.location())), false);
        context.register(key, trimPattern);
    }
}