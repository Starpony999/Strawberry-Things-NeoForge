package net.starpony.strawberry.util.sets;

import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.registries.DeferredBlock;

public class StoneSet {
    public final String baseName;

    // Base variants
    public final DeferredBlock<Block> base;
    public final DeferredBlock<StairBlock> stairs;
    public final DeferredBlock<SlabBlock> slab;
    public final DeferredBlock<WallBlock> wall;
    public final DeferredBlock<ButtonBlock> button;
    public final DeferredBlock<PressurePlateBlock> pressurePlate;

    // Cobbled
    public final DeferredBlock<Block> cobbled;
    public final DeferredBlock<StairBlock> cobbledStairs;
    public final DeferredBlock<SlabBlock> cobbledSlab;
    public final DeferredBlock<WallBlock> cobbledWall;
    public final DeferredBlock<ButtonBlock> cobbledButton;
    public final DeferredBlock<PressurePlateBlock> cobbledPressurePlate;

    // Chiseled
    public final DeferredBlock<Block> chiseled;
    public final DeferredBlock<StairBlock> chiseledStairs;
    public final DeferredBlock<SlabBlock> chiseledSlab;
    public final DeferredBlock<WallBlock> chiseledWall;
    public final DeferredBlock<ButtonBlock> chiseledButton;
    public final DeferredBlock<PressurePlateBlock> chiseledPressurePlate;

    // Bricks
    public final DeferredBlock<Block> bricks;
    public final DeferredBlock<StairBlock> bricksStairs;
    public final DeferredBlock<SlabBlock> bricksSlab;
    public final DeferredBlock<WallBlock> bricksWall;
    public final DeferredBlock<ButtonBlock> bricksButton;
    public final DeferredBlock<PressurePlateBlock> bricksPressurePlate;

    // Cracked Bricks
    public final DeferredBlock<Block> crackedBricks;
    public final DeferredBlock<StairBlock> crackedBricksStairs;
    public final DeferredBlock<SlabBlock> crackedBricksSlab;
    public final DeferredBlock<WallBlock> crackedBricksWall;
    public final DeferredBlock<ButtonBlock> crackedBricksButton;
    public final DeferredBlock<PressurePlateBlock> crackedBricksPressurePlate;

    // Smooth
    public final DeferredBlock<Block> smooth;
    public final DeferredBlock<StairBlock> smoothStairs;
    public final DeferredBlock<SlabBlock> smoothSlab;
    public final DeferredBlock<WallBlock> smoothWall;
    public final DeferredBlock<ButtonBlock> smoothButton;
    public final DeferredBlock<PressurePlateBlock> smoothPressurePlate;

    public StoneSet(
            String baseName,
            DeferredBlock<Block> base, DeferredBlock<StairBlock> stairs, DeferredBlock<SlabBlock> slab, DeferredBlock<WallBlock> wall, DeferredBlock<ButtonBlock> button, DeferredBlock<PressurePlateBlock> pressurePlate,
            DeferredBlock<Block> cobbled, DeferredBlock<StairBlock> cobbledStairs, DeferredBlock<SlabBlock> cobbledSlab, DeferredBlock<WallBlock> cobbledWall, DeferredBlock<ButtonBlock> cobbledButton, DeferredBlock<PressurePlateBlock> cobbledPressurePlate,
            DeferredBlock<Block> chiseled, DeferredBlock<StairBlock> chiseledStairs, DeferredBlock<SlabBlock> chiseledSlab, DeferredBlock<WallBlock> chiseledWall, DeferredBlock<ButtonBlock> chiseledButton, DeferredBlock<PressurePlateBlock> chiseledPressurePlate,
            DeferredBlock<Block> bricks, DeferredBlock<StairBlock> bricksStairs, DeferredBlock<SlabBlock> bricksSlab, DeferredBlock<WallBlock> bricksWall, DeferredBlock<ButtonBlock> bricksButton, DeferredBlock<PressurePlateBlock> bricksPressurePlate,
            DeferredBlock<Block> crackedBricks, DeferredBlock<StairBlock> crackedBricksStairs, DeferredBlock<SlabBlock> crackedBricksSlab, DeferredBlock<WallBlock> crackedBricksWall, DeferredBlock<ButtonBlock> crackedBricksButton, DeferredBlock<PressurePlateBlock> crackedBricksPressurePlate,
            DeferredBlock<Block> smooth, DeferredBlock<StairBlock> smoothStairs, DeferredBlock<SlabBlock> smoothSlab, DeferredBlock<WallBlock> smoothWall, DeferredBlock<ButtonBlock> smoothButton, DeferredBlock<PressurePlateBlock> smoothPressurePlate
    ) {
        this.baseName = baseName;

        this.base = base;
        this.stairs = stairs;
        this.slab = slab;
        this.wall = wall;
        this.button = button;
        this.pressurePlate = pressurePlate;

        this.cobbled = cobbled;
        this.cobbledStairs = cobbledStairs;
        this.cobbledSlab = cobbledSlab;
        this.cobbledWall = cobbledWall;
        this.cobbledButton = cobbledButton;
        this.cobbledPressurePlate = cobbledPressurePlate;

        this.chiseled = chiseled;
        this.chiseledStairs = chiseledStairs;
        this.chiseledSlab = chiseledSlab;
        this.chiseledWall = chiseledWall;
        this.chiseledButton = chiseledButton;
        this.chiseledPressurePlate = chiseledPressurePlate;

        this.bricks = bricks;
        this.bricksStairs = bricksStairs;
        this.bricksSlab = bricksSlab;
        this.bricksWall = bricksWall;
        this.bricksButton = bricksButton;
        this.bricksPressurePlate = bricksPressurePlate;

        this.crackedBricks = crackedBricks;
        this.crackedBricksStairs = crackedBricksStairs;
        this.crackedBricksSlab = crackedBricksSlab;
        this.crackedBricksWall = crackedBricksWall;
        this.crackedBricksButton = crackedBricksButton;
        this.crackedBricksPressurePlate = crackedBricksPressurePlate;

        this.smooth = smooth;
        this.smoothStairs = smoothStairs;
        this.smoothSlab = smoothSlab;
        this.smoothWall = smoothWall;
        this.smoothButton = smoothButton;
        this.smoothPressurePlate = smoothPressurePlate;
    }

    public DeferredBlock<Block> getBase() { return base; }
    public DeferredBlock<StairBlock> getStairs() { return stairs; }
    public DeferredBlock<SlabBlock> getSlab() { return slab; }
    public DeferredBlock<WallBlock> getWall() { return wall; }
    public DeferredBlock<ButtonBlock> getButton() { return button; }
    public DeferredBlock<PressurePlateBlock> getPressurePlate() { return pressurePlate; }

    public DeferredBlock<Block> getCobbled() { return cobbled; }
    public DeferredBlock<StairBlock> getCobbledStairs() { return cobbledStairs; }
    public DeferredBlock<SlabBlock> getCobbledSlab() { return cobbledSlab; }
    public DeferredBlock<WallBlock> getCobbledWall() { return cobbledWall; }
    public DeferredBlock<ButtonBlock> getCobbledButton() { return cobbledButton; }
    public DeferredBlock<PressurePlateBlock> getCobbledPressurePlate() { return cobbledPressurePlate; }

    public DeferredBlock<Block> getChiseled() { return chiseled; }
    public DeferredBlock<StairBlock> getChiseledStairs() { return chiseledStairs; }
    public DeferredBlock<SlabBlock> getChiseledSlab() { return chiseledSlab; }
    public DeferredBlock<WallBlock> getChiseledWall() { return chiseledWall; }
    public DeferredBlock<ButtonBlock> getChiseledButton() { return chiseledButton; }
    public DeferredBlock<PressurePlateBlock> getChiseledPressurePlate() { return chiseledPressurePlate; }

    public DeferredBlock<Block> getBricks() { return bricks; }
    public DeferredBlock<StairBlock> getBricksStairs() { return bricksStairs; }
    public DeferredBlock<SlabBlock> getBricksSlab() { return bricksSlab; }
    public DeferredBlock<WallBlock> getBricksWall() { return bricksWall; }
    public DeferredBlock<ButtonBlock> getBricksButton() { return bricksButton; }
    public DeferredBlock<PressurePlateBlock> getBricksPressurePlate() { return bricksPressurePlate; }

    public DeferredBlock<Block> getCrackedBricks() { return crackedBricks; }
    public DeferredBlock<StairBlock> getCrackedBricksStairs() { return crackedBricksStairs; }
    public DeferredBlock<SlabBlock> getCrackedBricksSlab() { return crackedBricksSlab; }
    public DeferredBlock<WallBlock> getCrackedBricksWall() { return crackedBricksWall; }
    public DeferredBlock<ButtonBlock> getCrackedBricksButton() { return crackedBricksButton; }
    public DeferredBlock<PressurePlateBlock> getCrackedBricksPressurePlate() { return crackedBricksPressurePlate; }

    public DeferredBlock<Block> getSmooth() { return smooth; }
    public DeferredBlock<StairBlock> getSmoothStairs() { return smoothStairs; }
    public DeferredBlock<SlabBlock> getSmoothSlab() { return smoothSlab; }
    public DeferredBlock<WallBlock> getSmoothWall() { return smoothWall; }
    public DeferredBlock<ButtonBlock> getSmoothButton() { return smoothButton; }
    public DeferredBlock<PressurePlateBlock> getSmoothPressurePlate() { return smoothPressurePlate; }
}