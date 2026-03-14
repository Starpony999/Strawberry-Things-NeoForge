package net.starpony.strawberry.util;

import net.starpony.strawberry.Strawberry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_TOOL_LEVEL_4 = createTag("needs_tool_level_4");
        public static final TagKey<Block> INCORRECT_FOR_TOOL_LEVEL_4 = createTag("incorrect_for_tool_level_4");
        public static final TagKey<Block> INCORRECT_FOR_SAPPHIRE_TOOL = createTag("incorrect_for_sapphire_tool");
        public static final TagKey<Block> INCORRECT_FOR_RUBY_TOOL = createTag("incorrect_for_ruby_tool");
        public static final TagKey<Block> INCORRECT_FOR_ROSE_QUARTZ_TOOL = createTag("incorrect_for_rose_quartz_tool");
        public static final TagKey<Block> INCORRECT_FOR_OTHERWORLDLY_AMETHYST_TOOL = createTag("incorrect_for_otherworldly_amethyst_tool");
        public static final TagKey<Block> NEEDS_SAPPHIRE_TOOL = createTag("needs_sapphire_tool");
        public static final TagKey<Block> NEEDS_RUBY_TOOL = createTag("needs_ruby_tool");
        public static final TagKey<Block> NEEDS_ROSE_QUARTZ_TOOL = createTag("needs_rose_quartz_tool");
        public static final TagKey<Block> NEEDS_OTHERWORLDLY_AMETHYST_TOOL = createTag("needs_otherworldly_amethyst_tool");
        /*public static final TagKey<Block> NIGHTSTONE_CUTTER = createTag("nightstone_cutter");
        public static final TagKey<Block> NIGHTSTONE_BRICKS_CUTTER = createTag("nightstone_bricks_cutter");
        public static final TagKey<Block> SMOOTH_NIGHTSTONE_CUTTER = createTag("smooth_nightstone_cutter");
        public static final TagKey<Block> COBBLED_NIGHTSTONE_CUTTER = createTag("cobbled_nightstone_cutter");
        public static final TagKey<Block> CHISELED_NIGHTSTONE_CUTTER = createTag("chiseled_nightstone_cutter");
*/
        public static final TagKey<Block> CONCRETE = createTag("concrete");
        public static final TagKey<Block> GLASS = createTag("glass");
        public static final TagKey<Block> GLASS_PANES = createTag("glass_panes");
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> WATER_TAG = createTag("water_tag");
        public static final TagKey<Item> NETHERITE_REPAIR = createTag("netherite_repair");
        public static final TagKey<Item> SAPPHIRE_REPAIR = createTag("sapphire_repair");
        public static final TagKey<Item> RUBY_REPAIR = createTag("ruby_repair");
        public static final TagKey<Item> ROSE_QUARTZ_REPAIR = createTag("rose_quartz_repair");
        public static final TagKey<Item> OTHERWORLDLY_AMETHYST_REPAIR = createTag("otherworldly_amethyst_repair");
        public static final TagKey<Item> CONCRETE = createTag("concrete");
        public static final TagKey<Item> GLASS = createTag("glass");
        public static final TagKey<Item> GLASS_PANES = createTag("glass_panes");
        public static final TagKey<Item> CONCRETE_POWDER = createTag("concrete_powder");
        public static final TagKey<Item> TERRACOTTA = createTag("terracotta");
        public static final TagKey<Item> WOOL = createTag("wool");
        public static final TagKey<Item> WOOL_CARPETS = createTag("wool_carpets");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, name));
        }
    }
}