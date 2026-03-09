package net.starpony.strawberry.sets;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

public class WoodSet {

    private final String name;
    public final DeferredBlock<Block> log;
    public final DeferredBlock<Block> strippedLog;
    public final DeferredBlock<Block> wood;
    public final DeferredBlock<Block> strippedWood;
    public final DeferredBlock<Block> planks;
    public final DeferredBlock<Block> leaves;
    public final DeferredBlock<Block> sapling;
    public final DeferredBlock<Block> stairs;
    public final DeferredBlock<Block> slab;
    public final DeferredBlock<Block> button;
    public final DeferredBlock<Block> pressurePlate;
    public final DeferredBlock<Block> fence;
    public final DeferredBlock<Block> fenceGate;
    public final DeferredBlock<Block> door;
    public final DeferredBlock<Block> trapdoor;

    public WoodSet(String name,
                   DeferredBlock<Block> log,
                   DeferredBlock<Block> strippedLog,
                   DeferredBlock<Block> wood,
                   DeferredBlock<Block> strippedWood,
                   DeferredBlock<Block> planks,
                   DeferredBlock<Block> leaves,
                   DeferredBlock<Block> sapling,
                   DeferredBlock<Block> stairs,
                   DeferredBlock<Block> slab,
                   DeferredBlock<Block> button,
                   DeferredBlock<Block> pressurePlate,
                   DeferredBlock<Block> fence,
                   DeferredBlock<Block> fenceGate,
                   DeferredBlock<Block> door,
                   DeferredBlock<Block> trapdoor) {

        this.name = name;
        this.log = log;
        this.strippedLog = strippedLog;
        this.wood = wood;
        this.strippedWood = strippedWood;
        this.planks = planks;
        this.leaves = leaves;
        this.sapling = sapling;
        this.stairs = stairs;
        this.slab = slab;
        this.button = button;
        this.pressurePlate = pressurePlate;
        this.fence = fence;
        this.fenceGate = fenceGate;
        this.door = door;
        this.trapdoor = trapdoor;
    }

    public String getName() {
        return name;
    }

    public DeferredBlock<Block> getLog() {
        return log;
    }

    public DeferredBlock<Block> getStrippedLog() {
        return strippedLog;
    }

    public DeferredBlock<Block> getWood() {
        return wood;
    }

    public DeferredBlock<Block> getStrippedWood() {
        return strippedWood;
    }

    public DeferredBlock<Block> getPlanks() {
        return planks;
    }

    public DeferredBlock<Block> getLeaves() {
        return leaves;
    }

    public DeferredBlock<Block> getSapling() {
        return sapling;
    }

    public DeferredBlock<Block> getStairs() {
        return stairs;
    }

    public DeferredBlock<Block> getSlab() {
        return slab;
    }

    public DeferredBlock<Block> getButton() {
        return button;
    }

    public DeferredBlock<Block> getPressurePlate() {
        return pressurePlate;
    }

    public DeferredBlock<Block> getFence() {
        return fence;
    }

    public DeferredBlock<Block> getFenceGate() {
        return fenceGate;
    }

    public DeferredBlock<Block> getDoor() {
        return door;
    }

    public DeferredBlock<Block> getTrapdoor() {
        return trapdoor;
    }
}