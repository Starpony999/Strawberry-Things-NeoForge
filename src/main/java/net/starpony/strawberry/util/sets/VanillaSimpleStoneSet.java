package net.starpony.strawberry.util.sets;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.Block;


public class VanillaSimpleStoneSet {
    public final Block block;
    public final Block slab;
    public final Block stairs;
    public final Block wall;
    public final Block button;
    public final Block pressurePlate;

    public VanillaSimpleStoneSet(Block block,
                                 Block stairs,
                                 Block slab,
                                 Block wall,
                                 Block button,
                                 Block pressurePlate) {
        this.block = block;
        this.stairs = stairs;
        this.slab = slab;
        this.wall = wall;
        this.button = button;
        this.pressurePlate = pressurePlate;
    }

    public Block getStone() {
        return block;
    }

    public Block getWall() {
        return wall;
    }

    public Block getSlab() {
        return slab;
    }

    public Block getStairs() {
        return stairs;
    }

    public Block getButton() {
        return button;
    }

    public Block getPressurePlate() {
        return pressurePlate;
    }
}