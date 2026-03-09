package net.starpony.strawberry.sets;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

public class StoneSet {
    public final String baseName;

    // Base variants
    public final DeferredBlock<Block> base;
    public final DeferredBlock<Block> stairs;
    public final DeferredBlock<Block> slab;
    public final DeferredBlock<Block> wall;
    public final DeferredBlock<Block> button;
    public final DeferredBlock<Block> pressurePlate;

    // Cobbled
    public final DeferredBlock<Block> cobbled;
    public final DeferredBlock<Block> cobbledStairs;
    public final DeferredBlock<Block> cobbledSlab;
    public final DeferredBlock<Block> cobbledWall;
    public final DeferredBlock<Block> cobbledButton;
    public final DeferredBlock<Block> cobbledPressurePlate;

    // Chiseled
    public final DeferredBlock<Block> chiseled;
    public final DeferredBlock<Block> chiseledStairs;
    public final DeferredBlock<Block> chiseledSlab;
    public final DeferredBlock<Block> chiseledWall;
    public final DeferredBlock<Block> chiseledButton;
    public final DeferredBlock<Block> chiseledPressurePlate;

    // Bricks
    public final DeferredBlock<Block> bricks;
    public final DeferredBlock<Block> bricksStairs;
    public final DeferredBlock<Block> bricksSlab;
    public final DeferredBlock<Block> bricksWall;
    public final DeferredBlock<Block> bricksButton;
    public final DeferredBlock<Block> bricksPressurePlate;

    // Cracked Bricks
    public final DeferredBlock<Block> crackedBricks;
    public final DeferredBlock<Block> crackedBricksStairs;
    public final DeferredBlock<Block> crackedBricksSlab;
    public final DeferredBlock<Block> crackedBricksWall;
    public final DeferredBlock<Block> crackedBricksButton;
    public final DeferredBlock<Block> crackedBricksPressurePlate;

    // Smooth
    public final DeferredBlock<Block> smooth;
    public final DeferredBlock<Block> smoothStairs;
    public final DeferredBlock<Block> smoothSlab;
    public final DeferredBlock<Block> smoothWall;
    public final DeferredBlock<Block> smoothButton;
    public final DeferredBlock<Block> smoothPressurePlate;

    public StoneSet(
            String baseName,
            DeferredBlock<Block> base, DeferredBlock<Block> stairs, DeferredBlock<Block> slab, DeferredBlock<Block> wall, DeferredBlock<Block> button, DeferredBlock<Block> pressurePlate,
            DeferredBlock<Block> cobbled, DeferredBlock<Block> cobbledStairs, DeferredBlock<Block> cobbledSlab, DeferredBlock<Block> cobbledWall, DeferredBlock<Block> cobbledButton, DeferredBlock<Block> cobbledPressurePlate,
            DeferredBlock<Block> chiseled, DeferredBlock<Block> chiseledStairs, DeferredBlock<Block> chiseledSlab, DeferredBlock<Block> chiseledWall, DeferredBlock<Block> chiseledButton, DeferredBlock<Block> chiseledPressurePlate,
            DeferredBlock<Block> bricks, DeferredBlock<Block> bricksStairs, DeferredBlock<Block> bricksSlab, DeferredBlock<Block> bricksWall, DeferredBlock<Block> bricksButton, DeferredBlock<Block> bricksPressurePlate,
            DeferredBlock<Block> crackedBricks, DeferredBlock<Block> crackedBricksStairs, DeferredBlock<Block> crackedBricksSlab, DeferredBlock<Block> crackedBricksWall, DeferredBlock<Block> crackedBricksButton, DeferredBlock<Block> crackedBricksPressurePlate,
            DeferredBlock<Block> smooth, DeferredBlock<Block> smoothStairs, DeferredBlock<Block> smoothSlab, DeferredBlock<Block> smoothWall, DeferredBlock<Block> smoothButton, DeferredBlock<Block> smoothPressurePlate
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
    public DeferredBlock<Block> getStairs() { return stairs; }
    public DeferredBlock<Block> getSlab() { return slab; }
    public DeferredBlock<Block> getWall() { return wall; }
    public DeferredBlock<Block> getButton() { return button; }
    public DeferredBlock<Block> getPressurePlate() { return pressurePlate; }

    public DeferredBlock<Block> getCobbled() { return cobbled; }
    public DeferredBlock<Block> getCobbledStairs() { return cobbledStairs; }
    public DeferredBlock<Block> getCobbledSlab() { return cobbledSlab; }
    public DeferredBlock<Block> getCobbledWall() { return cobbledWall; }
    public DeferredBlock<Block> getCobbledButton() { return cobbledButton; }
    public DeferredBlock<Block> getCobbledPressurePlate() { return cobbledPressurePlate; }

    public DeferredBlock<Block> getChiseled() { return chiseled; }
    public DeferredBlock<Block> getChiseledStairs() { return chiseledStairs; }
    public DeferredBlock<Block> getChiseledSlab() { return chiseledSlab; }
    public DeferredBlock<Block> getChiseledWall() { return chiseledWall; }
    public DeferredBlock<Block> getChiseledButton() { return chiseledButton; }
    public DeferredBlock<Block> getChiseledPressurePlate() { return chiseledPressurePlate; }

    public DeferredBlock<Block> getBricks() { return bricks; }
    public DeferredBlock<Block> getBricksStairs() { return bricksStairs; }
    public DeferredBlock<Block> getBricksSlab() { return bricksSlab; }
    public DeferredBlock<Block> getBricksWall() { return bricksWall; }
    public DeferredBlock<Block> getBricksButton() { return bricksButton; }
    public DeferredBlock<Block> getBricksPressurePlate() { return bricksPressurePlate; }

    public DeferredBlock<Block> getCrackedBricks() { return crackedBricks; }
    public DeferredBlock<Block> getCrackedBricksStairs() { return crackedBricksStairs; }
    public DeferredBlock<Block> getCrackedBricksSlab() { return crackedBricksSlab; }
    public DeferredBlock<Block> getCrackedBricksWall() { return crackedBricksWall; }
    public DeferredBlock<Block> getCrackedBricksButton() { return crackedBricksButton; }
    public DeferredBlock<Block> getCrackedBricksPressurePlate() { return crackedBricksPressurePlate; }

    public DeferredBlock<Block> getSmooth() { return smooth; }
    public DeferredBlock<Block> getSmoothStairs() { return smoothStairs; }
    public DeferredBlock<Block> getSmoothSlab() { return smoothSlab; }
    public DeferredBlock<Block> getSmoothWall() { return smoothWall; }
    public DeferredBlock<Block> getSmoothButton() { return smoothButton; }
    public DeferredBlock<Block> getSmoothPressurePlate() { return smoothPressurePlate; }
}