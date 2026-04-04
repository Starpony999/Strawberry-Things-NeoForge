package net.starpony.strawberry.util.sets;

import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.registries.DeferredBlock;

public class SimpleStoneSet implements SimpleStoneBaseSet {
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

    @Override
    public Block getStoneBlock() {
        return block == null ? null : block.get();
    }

    public DeferredBlock<WallBlock> getWall() {
        return wall;
    }

    @Override
    public Block getWallBlock() {
        return wall == null ? null : wall.get();
    }

    public DeferredBlock<SlabBlock> getSlab() {
        return slab;
    }

    @Override
    public Block getSlabBlock() {
        return slab == null ? null : slab.get();
    }

    public DeferredBlock<StairBlock> getStairs() {
        return stairs;
    }

    @Override
    public Block getStairsBlock() {
        return stairs == null ? null : stairs.get();
    }

    public DeferredBlock<ButtonBlock> getButton() {
        return button;
    }

    @Override
    public Block getButtonBlock() {
        return button == null ? null : button.get();
    }

    public DeferredBlock<PressurePlateBlock> getPressurePlate() {
        return pressurePlate;
    }

    @Override
    public Block getPressurePlateBlock() {
        return pressurePlate == null ? null : pressurePlate.get();
    }
}
