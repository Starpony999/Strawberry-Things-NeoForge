package net.starpony.strawberry.util.sets;


import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public class SetUtils {

    public static void addStoneSet(CreativeModeTab.Output output, StoneSet stone) {
        output.accept(stone.getBase());
        output.accept(stone.getWall());
        output.accept(stone.getStairs());
        output.accept(stone.getSlab());

        // Cobbled
        output.accept(stone.getCobbled());
        output.accept(stone.getCobbledWall());
        output.accept(stone.getCobbledStairs());
        output.accept(stone.getCobbledSlab());

        // Smooth
        output.accept(stone.getSmooth());
        output.accept(stone.getSmoothWall());
        output.accept(stone.getSmoothStairs());
        output.accept(stone.getSmoothSlab());

        // Bricks
        output.accept(stone.getBricks());
        output.accept(stone.getBricksWall());
        output.accept(stone.getBricksStairs());
        output.accept(stone.getBricksSlab());

        // Cracked Bricks
        output.accept(stone.getCrackedBricks());
        output.accept(stone.getCrackedBricksWall());
        output.accept(stone.getCrackedBricksStairs());
        output.accept(stone.getCrackedBricksSlab());

        // Chiseled
        output.accept(stone.getChiseled());
        output.accept(stone.getChiseledWall());
        output.accept(stone.getChiseledStairs());
        output.accept(stone.getChiseledSlab());
    }
    public static void addSimpleStoneSet(CreativeModeTab.Output output, SimpleStoneSet stoneSet) {
        output.accept(stoneSet.getStone());
        output.accept(stoneSet.getWall());
        output.accept(stoneSet.getStairs());
        output.accept(stoneSet.getSlab());
    }
    public static void addWoodSet(CreativeModeTab.Output output, WoodSet woodSet) {
        // Logs and wood
        output.accept(woodSet.getLog());
        output.accept(woodSet.getStrippedLog());
        output.accept(woodSet.getWood());
        output.accept(woodSet.getStrippedWood());

        // Planks, leaves, sapling
        output.accept(woodSet.getPlanks());
        output.accept(woodSet.getLeaves());
        output.accept(woodSet.getSapling());

        // Block variants
        output.accept(woodSet.getStairs());
        output.accept(woodSet.getSlab());
        output.accept(woodSet.getButton());
        output.accept(woodSet.getPressurePlate());

        // Fences and doors
        output.accept(woodSet.getFence());
        output.accept(woodSet.getFenceGate());
        output.accept(woodSet.getDoor());
        output.accept(woodSet.getTrapdoor());
    }
    public static void addRedStoneSet(CreativeModeTab.Output output, StoneSet stone) {
        output.accept(stone.getButton());
        output.accept(stone.getPressurePlate());
        output.accept(stone.getCobbledButton());
        output.accept(stone.getCobbledPressurePlate());
        output.accept(stone.getSmoothButton());
        output.accept(stone.getSmoothPressurePlate());
        output.accept(stone.getBricksButton());
        output.accept(stone.getBricksPressurePlate());
        output.accept(stone.getCrackedBricksButton());
        output.accept(stone.getCrackedBricksPressurePlate());
        output.accept(stone.getChiseledButton());
        output.accept(stone.getChiseledPressurePlate());
    }
    public static void addSimpleRedStoneSet(CreativeModeTab.Output output, SimpleStoneSet stoneSet) {
        output.accept(stoneSet.getButton());
        output.accept(stoneSet.getPressurePlate());
    }
    public static void addRedWoodSet(CreativeModeTab.Output output, WoodSet woodSet) {
        output.accept(woodSet.getButton());
        output.accept(woodSet.getPressurePlate());
        output.accept(woodSet.getFence());
        output.accept(woodSet.getFenceGate());
        output.accept(woodSet.getDoor());
        output.accept(woodSet.getTrapdoor());
    }
    public static void addColorSet(CreativeModeTab.Output output, ColorSet colorSet) {
        output.accept(colorSet.getConcrete());
        output.accept(colorSet.getConcretePowder());
        output.accept(colorSet.getTerracotta());
        output.accept(colorSet.getGlazedTerracotta());
        output.accept(colorSet.getWool());
        output.accept(colorSet.getStainedGlass());
        output.accept(colorSet.getStainedGlassPane());
        output.accept(colorSet.getCarpet());
    }
}

