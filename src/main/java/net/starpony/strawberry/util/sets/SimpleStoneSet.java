package net.starpony.strawberry.util.sets;

import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.registries.DeferredBlock;

public class SimpleStoneSet {
    public final DeferredBlock<Block> block;
    public final DeferredBlock<SlabBlock> slab;
    public final DeferredBlock<StairBlock> stairs;
    public final DeferredBlock<WallBlock> wall;
    public final DeferredBlock<ButtonBlock> button;
    public final DeferredBlock<PressurePlateBlock> pressurePlate;

    public SimpleStoneSet(DeferredBlock<Block> block,
                          DeferredBlock<StairBlock> stairs,
                          DeferredBlock<SlabBlock> slab,
                          DeferredBlock<WallBlock> wall,
                          DeferredBlock<ButtonBlock> button,
                          DeferredBlock<PressurePlateBlock> pressurePlate) {
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

    public DeferredBlock<WallBlock> getWall() {
        return wall;
    }

    public DeferredBlock<SlabBlock> getSlab() {
        return slab;
    }

    public DeferredBlock<StairBlock> getStairs() {
        return stairs;
    }

    public DeferredBlock<ButtonBlock> getButton() {
        return button;
    }

    public DeferredBlock<PressurePlateBlock> getPressurePlate() {
        return pressurePlate;
    }
}