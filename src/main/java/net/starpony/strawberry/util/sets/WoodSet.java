package net.starpony.strawberry.util.sets;

import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.starpony.strawberry.block.ModFlammableRotatedPillarBlock;

public class WoodSet {

    private final String name;
    public final DeferredBlock<Block> log;
    public final DeferredBlock<Block> strippedLog;
    public final DeferredBlock<Block> wood;
    public final DeferredBlock<Block> strippedWood;
    public final DeferredBlock<Block> planks;
    public final DeferredBlock<LeavesBlock> leaves;
    public final DeferredBlock<Block> sapling;
    public final DeferredBlock<StairBlock> stairs;
    public final DeferredBlock<SlabBlock> slab;
    public final DeferredBlock<ButtonBlock> button;
    public final DeferredBlock<PressurePlateBlock> pressurePlate;
    public final DeferredBlock<FenceBlock> fence;
    public final DeferredBlock<FenceGateBlock> fenceGate;
    public final DeferredBlock<DoorBlock> door;
    public final DeferredBlock<TrapDoorBlock> trapdoor;

    public WoodSet(String name,
                   DeferredBlock<Block> log,
                   DeferredBlock<Block> strippedLog,
                   DeferredBlock<Block> wood,
                   DeferredBlock<Block> strippedWood,
                   DeferredBlock<Block> planks,
                   DeferredBlock<LeavesBlock> leaves,
                   DeferredBlock<Block> sapling,
                   DeferredBlock<StairBlock> stairs,
                   DeferredBlock<SlabBlock> slab,
                   DeferredBlock<ButtonBlock> button,
                   DeferredBlock<PressurePlateBlock> pressurePlate,
                   DeferredBlock<FenceBlock> fence,
                   DeferredBlock<FenceGateBlock> fenceGate,
                   DeferredBlock<DoorBlock> door,
                   DeferredBlock<TrapDoorBlock> trapdoor) {

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

        ModFlammableRotatedPillarBlock.registerStrippable(log, strippedLog);
        ModFlammableRotatedPillarBlock.registerStrippable(wood, strippedWood);

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

    public DeferredBlock<LeavesBlock> getLeaves() {
        return leaves;
    }

    public DeferredBlock<Block> getSapling() {
        return sapling;
    }

    public DeferredBlock<StairBlock> getStairs() {
        return stairs;
    }

    public DeferredBlock<SlabBlock> getSlab() {
        return slab;
    }

    public DeferredBlock<ButtonBlock> getButton() {
        return button;
    }

    public DeferredBlock<PressurePlateBlock> getPressurePlate() {
        return pressurePlate;
    }

    public DeferredBlock<FenceBlock> getFence() {
        return fence;
    }

    public DeferredBlock<FenceGateBlock > getFenceGate() {
        return fenceGate;
    }

    public DeferredBlock<DoorBlock> getDoor() {
        return door;
    }

    public DeferredBlock<TrapDoorBlock> getTrapdoor() {
        return trapdoor;
    }
}