package net.starpony.strawberry.util.sets;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.Block;


public class VanillaStoneSet {
    public final String baseName;

    // Base variants
    public final Block base;
    public final Block stairs;
    public final Block slab;
    public final Block wall;
    public final Block button;
    public final Block pressurePlate;

    // Cobbled
    public final Block cobbled;
    public final Block cobbledStairs;
    public final Block cobbledSlab;
    public final Block cobbledWall;
    public final Block cobbledButton;
    public final Block cobbledPressurePlate;

    // Chiseled
    public final Block chiseled;
    public final Block chiseledStairs;
    public final Block chiseledSlab;
    public final Block chiseledWall;
    public final Block chiseledButton;
    public final Block chiseledPressurePlate;

    // Bricks
    public final Block bricks;
    public final Block bricksStairs;
    public final Block bricksSlab;
    public final Block bricksWall;
    public final Block bricksButton;
    public final Block bricksPressurePlate;

    // Cracked Bricks
    public final Block crackedBricks;
    public final Block crackedBricksStairs;
    public final Block crackedBricksSlab;
    public final Block crackedBricksWall;
    public final Block crackedBricksButton;
    public final Block crackedBricksPressurePlate;

    // Smooth
    public final Block smooth;
    public final Block smoothStairs;
    public final Block smoothSlab;
    public final Block smoothWall;
    public final Block smoothButton;
    public final Block smoothPressurePlate;

    // Tiles
    public final Block tiles;
    public final Block tilesStairs;
    public final Block tilesSlab;
    public final Block tilesWall;
    public final Block tilesButton;
    public final Block tilesPressurePlate;

    // Cracked Tiles
    public final Block crackedTiles;
    public final Block crackedTilesStairs;
    public final Block crackedTilesSlab;
    public final Block crackedTilesWall;
    public final Block crackedTilesButton;
    public final Block crackedTilesPressurePlate;


    public VanillaStoneSet(
            String baseName,
            Block base, Block stairs, Block slab, Block wall, Block button, Block pressurePlate,
            Block cobbled, Block cobbledStairs, Block cobbledSlab, Block cobbledWall, Block cobbledButton, Block cobbledPressurePlate,
            Block chiseled, Block chiseledStairs, Block chiseledSlab, Block chiseledWall, Block chiseledButton, Block chiseledPressurePlate,
            Block bricks, Block bricksStairs, Block bricksSlab, Block bricksWall, Block bricksButton, Block bricksPressurePlate,
            Block crackedBricks, Block crackedBricksStairs, Block crackedBricksSlab, Block crackedBricksWall, Block crackedBricksButton, Block crackedBricksPressurePlate,
            Block smooth, Block smoothStairs, Block smoothSlab, Block smoothWall, Block smoothButton, Block smoothPressurePlate,
            Block tiles, Block tilesStairs, Block tilesSlab, Block tilesWall, Block tilesButton, Block tilesPressurePlate,
            Block crackedTiles, Block crackedTilesStairs, Block crackedTilesSlab, Block crackedTilesWall, Block crackedTilesButton, Block crackedTilesPressurePlate
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

        this.tiles = tiles;
        this.tilesStairs = tilesStairs;
        this.tilesSlab = tilesSlab;
        this.tilesWall = tilesWall;
        this.tilesButton = tilesButton;
        this.tilesPressurePlate = tilesPressurePlate;

        this.crackedTiles = crackedTiles;
        this.crackedTilesStairs = crackedTilesStairs;
        this.crackedTilesSlab = crackedTilesSlab;
        this.crackedTilesWall = crackedTilesWall;
        this.crackedTilesButton = crackedTilesButton;
        this.crackedTilesPressurePlate = crackedTilesPressurePlate;

    }

    public Block getBase() { return base; }
    public Block getStairs() { return stairs; }
    public Block getSlab() { return slab; }
    public Block getWall() { return wall; }
    public Block getButton() { return button; }
    public Block getPressurePlate() { return pressurePlate; }

    public Block getCobbled() { return cobbled; }
    public Block getCobbledStairs() { return cobbledStairs; }
    public Block getCobbledSlab() { return cobbledSlab; }
    public Block getCobbledWall() { return cobbledWall; }
    public Block getCobbledButton() { return cobbledButton; }
    public Block getCobbledPressurePlate() { return cobbledPressurePlate; }

    public Block getChiseled() { return chiseled; }
    public Block getChiseledStairs() { return chiseledStairs; }
    public Block getChiseledSlab() { return chiseledSlab; }
    public Block getChiseledWall() { return chiseledWall; }
    public Block getChiseledButton() { return chiseledButton; }
    public Block getChiseledPressurePlate() { return chiseledPressurePlate; }

    public Block getBricks() { return bricks; }
    public Block getBricksStairs() { return bricksStairs; }
    public Block getBricksSlab() { return bricksSlab; }
    public Block getBricksWall() { return bricksWall; }
    public Block getBricksButton() { return bricksButton; }
    public Block getBricksPressurePlate() { return bricksPressurePlate; }

    public Block getCrackedBricks() { return crackedBricks; }
    public Block getCrackedBricksStairs() { return crackedBricksStairs; }
    public Block getCrackedBricksSlab() { return crackedBricksSlab; }
    public Block getCrackedBricksWall() { return crackedBricksWall; }
    public Block getCrackedBricksButton() { return crackedBricksButton; }
    public Block getCrackedBricksPressurePlate() { return crackedBricksPressurePlate; }

    public Block getSmooth() { return smooth; }
    public Block getSmoothStairs() { return smoothStairs; }
    public Block getSmoothSlab() { return smoothSlab; }
    public Block getSmoothWall() { return smoothWall; }
    public Block getSmoothButton() { return smoothButton; }
    public Block getSmoothPressurePlate() { return smoothPressurePlate; }

    public Block getTiles() { return tiles; }
    public Block getTilesStairs() { return tilesStairs; }
    public Block getTilesSlab() { return tilesSlab; }
    public Block getTilesWall() { return tilesWall; }
    public Block getTilesButton() { return tilesButton; }
    public Block getTilesPressurePlate() { return tilesPressurePlate; }

    public Block getCrackedTiles() { return crackedTiles; }
    public Block getCrackedTilesStairs() { return crackedTilesStairs; }
    public Block getCrackedTilesSlab() { return crackedTilesSlab; }
    public Block getCrackedTilesWall() { return crackedTilesWall; }
    public Block getCrackedTilesButton() { return crackedTilesButton; }
    public Block getCrackedTilesPressurePlate() { return crackedTilesPressurePlate; }
}