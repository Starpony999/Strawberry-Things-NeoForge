package net.starpony.strawberry.util.sets;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.starpony.strawberry.block.ModBlocks;
import net.starpony.strawberry.item.ModItems;

public class VanillaSets {
    public static final VanillaGemSet NETHERITE = new VanillaGemSet(
            "netherite",
            Items.NETHERITE_INGOT,
            ModItems.NETHERITE_NUGGET.get(),
            Items.NETHERITE_HOE,
            Items.NETHERITE_AXE,
            Items.NETHERITE_PICKAXE,
            Items.NETHERITE_SWORD,
            Items.NETHERITE_SHOVEL,
            Items.NETHERITE_HELMET,
            Items.NETHERITE_CHESTPLATE,
            Items.NETHERITE_LEGGINGS,
            Items.NETHERITE_BOOTS,
            ModItems.NETHERITE_HORSE_ARMOR.get()

    );
    public static final VanillaGemSet DIAMOND = new VanillaGemSet(
            "diamond",
            Items.DIAMOND,
            ModItems.DIAMOND_SHARD.get(),
            Items.DIAMOND_HOE,
            Items.DIAMOND_AXE,
            Items.DIAMOND_PICKAXE,
            Items.DIAMOND_SWORD,
            Items.DIAMOND_SHOVEL,
            Items.DIAMOND_HELMET,
            Items.DIAMOND_CHESTPLATE,
            Items.DIAMOND_LEGGINGS,
            Items.DIAMOND_BOOTS,
            Items.DIAMOND_HORSE_ARMOR
    );
    public static final VanillaGemSet IRON = new VanillaGemSet(
            "iron",
            Items.IRON_INGOT,
            Items.IRON_NUGGET,
            Items.IRON_HOE,
            Items.IRON_AXE,
            Items.IRON_PICKAXE,
            Items.IRON_SWORD,
            Items.IRON_SHOVEL,
            Items.IRON_HELMET,
            Items.IRON_CHESTPLATE,
            Items.IRON_LEGGINGS,
            Items.IRON_BOOTS,
            Items.IRON_HORSE_ARMOR
    );
    public static final VanillaGemSet GOLD = new VanillaGemSet(
            "gold",
            Items.GOLD_INGOT,
            Items.GOLD_NUGGET,
            Items.GOLDEN_HOE,
            Items.GOLDEN_AXE,
            Items.GOLDEN_PICKAXE,
            Items.GOLDEN_SWORD,
            Items.GOLDEN_SHOVEL,
            Items.GOLDEN_HELMET,
            Items.GOLDEN_CHESTPLATE,
            Items.GOLDEN_LEGGINGS,
            Items.GOLDEN_BOOTS,
            Items.GOLDEN_HORSE_ARMOR
    );
    public static final VanillaGemSet COPPER = new VanillaGemSet(
            "copper",
            Items.COPPER_INGOT,
            null, // Items.COPPER_NUGGET
            null, // Items.COPPER_HOE
            null, // Items.COPPER_AXE
            null, // Items.COPPER_PICKAXE
            null, // Items.COPPER_SWORD
            null, // Items.COPPER_
            null, // Items.COPPER_HELMET
            null, // Items.COPPER_CHESTPLATE
            null, // Items.COPPER_LEGGINGS
            null, // Items.COPPER_BOOTS
            null // Items.COPPER_HORSE_ARMOR
    );
    public static final VanillaGemSet LEVEL2 = new VanillaGemSet(
            "level_2",
            null,
            null,
            Items.STONE_HOE,
            Items.STONE_AXE,
            Items.STONE_PICKAXE,
            Items.STONE_SWORD,
            Items.STONE_SHOVEL,
            Items.CHAINMAIL_HELMET,
            Items.CHAINMAIL_CHESTPLATE,
            Items.CHAINMAIL_LEGGINGS,
            Items.CHAINMAIL_BOOTS,
            null
    );
    public static final VanillaGemSet LEVEL1 = new VanillaGemSet(
            "level_1",
            null,
            null,
            Items.WOODEN_HOE,
            Items.WOODEN_AXE,
            Items.WOODEN_PICKAXE,
            Items.WOODEN_SWORD,
            Items.WOODEN_SHOVEL,
            Items.LEATHER_HELMET,
            Items.LEATHER_CHESTPLATE,
            Items.LEATHER_LEGGINGS,
            Items.LEATHER_BOOTS,
            Items.LEATHER_HORSE_ARMOR
    );
    public static final VanillaSimpleStoneSet COBBLESTONE = new VanillaSimpleStoneSet(
            Blocks.COBBLESTONE,
            Blocks.COBBLESTONE_STAIRS,
            Blocks.COBBLESTONE_SLAB,
            Blocks.COBBLESTONE_WALL,
            ModBlocks.COBBLESTONE_BUTTON.get(),
            ModBlocks.COBBLESTONE_PRESSURE_PLATE.get()
    );
    /* public static final VanillaStoneSet STONE = new VanillaStoneSet(
            Blocks.STONE,
            Blocks.STONE_STAIRS,
            Blocks.STONE_SLAB,
            ModBlocks.STONE_WALL,
            Blocks.STONE_BUTTON,
            Blocks.STONE_PRESSURE_PLATE,
            Blocks.COBBLESTONE,
            Blocks.COBBLESTONE_STAIRS,
            Blocks.COBBLESTONE_SLAB,
            Blocks.COBBLESTONE_WALL,
            ModBlocks.COBBLESTONE_BUTTON.get(),
            ModBlocks.COBBLESTONE_PRESSURE_PLATE.get(),
            Blocks.CHISELED_STONE_BRICKS,
            ModBlocks.CHISELED_STONE_STAIRS,
            ModBlocks.CHISELED_STONE_SLAB,
            ModBlocks.CHISELED_STONE_WALL,
            ModBlocks.CHISELED_STONE_BUTTON,
            ModBlocks.CHISELED_STONE_PRESSURE_PLATE,
            Blocks.STONE_BRICKS,
            Blocks.STONE_BRICK_STAIRS,
            Blocks.STONE_BRICK_SLAB,
            Blocks.STONE_BRICK_WALL,
            ModBlocks.STONE_BRICK_BUTTON,
            ModBlocks.STONE_BRICK_PRESSURE_PLATE,
            Blocks.CRACKED_STONE_BRICKS,
            ModBlocks.CRACKED_STONE_BRICK_STAIRS,
            ModBlocks.CRACKED_STONE_BRICK_SLAB,
            ModBlocks.CRACKED_STONE_BRICK_WALL,
            ModBlocks.CRACKED_STONE_BRICK_BUTTON,
            ModBlocks.CRACKED_STONE_BRICK_PRESSURE_PLATE,
            Blocks.SMOOTH_STONE,
            ModBlocks.SMOOTH_STONE_STAIRS,
            Blocks.SMOOTH_STONE_SLAB,
            ModBlocks.SMOOTH_STONE_WALL,
            ModBlocks.SMOOTH_STONE_BUTTON,
            ModBlocks.SMOOTH_STONE_PRESSURE_PLATE,
            ModBlocks.STONE_TILES,
            ModBlocks.STONE_TILES_STAIRS,
            ModBlocks.STONE_TILES_SLAB,
            ModBlocks.STONE_TILES_WALL,
            ModBlocks.STONE_TILES_BUTTON,
            ModBlocks.STONE_TILES_PRESSURE_PLATE,
            ModBlocks.CRACKED_STONE_TILES,
            ModBlocks.CRACKED_STONE_TILES_STAIRS,
            ModBlocks.CRACKED_STONE_TILES_SLAB,
            ModBlocks.CRACKED_STONE_TILES_WALL,
            ModBlocks.CRACKED_STONE_TILES_BUTTON,
            ModBlocks.CRACKED_STONE_TILES_PRESSURE_PLATE
    );*/

}


