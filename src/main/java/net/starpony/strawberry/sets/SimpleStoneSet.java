package net.starpony.strawberry.sets;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

public class SimpleStoneSet {
    public final DeferredBlock<Block> block;
    public final DeferredBlock<Block> slab;
    public final DeferredBlock<Block> stairs;
    public final DeferredBlock<Block> wall;
    public final DeferredBlock<Block> button;
    public final DeferredBlock<Block> pressurePlate;

    public SimpleStoneSet(DeferredBlock<Block> block,
                          DeferredBlock<Block> stairs,
                          DeferredBlock<Block> slab,
                          DeferredBlock<Block> wall,
                          DeferredBlock<Block> button,
                          DeferredBlock<Block> pressurePlate) {
        this.block = block;
        this.stairs = stairs;
        this.slab = slab;
        this.wall = wall;
        this.button = button;
        this.pressurePlate = pressurePlate;
    }

    public DeferredBlock<Block> getStone() {
        return block;
    }

    public DeferredBlock<Block> getWall() {
        return wall;
    }

    public DeferredBlock<Block> getSlab() {
        return slab;
    }

    public DeferredBlock<Block> getStairs() {
        return stairs;
    }

    public DeferredBlock<Block> getButton() {
        return button;
    }

    public DeferredBlock<Block> getPressurePlate() {
        return pressurePlate;
    }
}