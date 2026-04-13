package net.starpony.strawberry.util.sets;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.starpony.strawberry.block.ModFlammableRotatedPillarBlock;
import net.starpony.strawberry.block.ModNonFlammableRotatedPillarBlock;

public class WoodSet {

    private final String name;
    public final DeferredBlock<Block> log;
    public final DeferredBlock<Block> strippedLog;
    public final DeferredBlock<Block> wood;
    public final DeferredBlock<Block> strippedWood;
    public final DeferredBlock<Block> planks;
    public final DeferredBlock<Block> leaves;
    public final DeferredBlock<Block> wartBlock;
    public final DeferredBlock<Block> sapling;
    public final DeferredBlock<StairBlock> stairs;
    public final DeferredBlock<SlabBlock> slab;
    public final DeferredBlock<ButtonBlock> button;
    public final DeferredBlock<PressurePlateBlock> pressurePlate;
    public final DeferredBlock<FenceBlock> fence;
    public final DeferredBlock<FenceGateBlock> fenceGate;
    public final DeferredBlock<DoorBlock> door;
    public final DeferredBlock<TrapDoorBlock> trapdoor;
    public final DeferredBlock<Block> sign;
    public final DeferredBlock<Block> wallSign;
    public final DeferredBlock<Block> hangingSign;
    public final DeferredBlock<Block> wallHangingSign;
    public final DeferredItem<Item> signItem;
    public final DeferredItem<Item> hangingSignItem;

    public WoodSet(String name,
                   DeferredBlock<Block> log,
                   DeferredBlock<Block> strippedLog,
                   DeferredBlock<Block> wood,
                   DeferredBlock<Block> strippedWood,
                   DeferredBlock<Block> planks,
                   DeferredBlock<Block> leaves,
                   DeferredBlock<Block> wartBlock,
                   DeferredBlock<Block> sapling,
                   DeferredBlock<StairBlock> stairs,
                   DeferredBlock<SlabBlock> slab,
                   DeferredBlock<ButtonBlock> button,
                   DeferredBlock<PressurePlateBlock> pressurePlate,
                   DeferredBlock<FenceBlock> fence,
                   DeferredBlock<FenceGateBlock> fenceGate,
                   DeferredBlock<DoorBlock> door,
                   DeferredBlock<TrapDoorBlock> trapdoor,
                   DeferredBlock<Block> sign,
                   DeferredBlock<Block> wallSign,
                   DeferredBlock<Block> hangingSign,
                   DeferredBlock<Block> wallHangingSign,
                   DeferredItem<Item> signItem,
                   DeferredItem<Item> hangingSignItem
    ) {

        this.name = name;
        this.log = log;
        this.strippedLog = strippedLog;
        this.wood = wood;
        this.strippedWood = strippedWood;
        this.planks = planks;
        this.leaves = leaves;
        this.wartBlock = wartBlock;
        this.sapling = sapling;
        this.stairs = stairs;
        this.slab = slab;
        this.button = button;
        this.pressurePlate = pressurePlate;
        this.fence = fence;
        this.fenceGate = fenceGate;
        this.door = door;
        this.trapdoor = trapdoor;
        this.sign = sign;
        this.wallSign = wallSign;
        this.hangingSign = hangingSign;
        this.wallHangingSign = wallHangingSign;
        this.signItem = signItem;
        this.hangingSignItem = hangingSignItem;

        ModFlammableRotatedPillarBlock.registerStrippable(log, strippedLog);
        ModFlammableRotatedPillarBlock.registerStrippable(wood, strippedWood);
        ModNonFlammableRotatedPillarBlock.registerStrippable(log, strippedLog);
        ModNonFlammableRotatedPillarBlock.registerStrippable(wood, strippedWood);

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

    public DeferredBlock<Block> getWartBlock() {
        return wartBlock;
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

    public DeferredBlock<Block> getSign() {return sign;}

    public DeferredBlock<Block> getWallSign() {return wallSign;}

    public DeferredBlock<Block> getHangingSign() {return hangingSign;}

    public DeferredBlock<Block> getWallHangingSign() {return wallHangingSign;}

    public DeferredItem<Item> getSignItem() {return signItem;}

    public DeferredItem<Item> getHangingSignItem() {return hangingSignItem;}

}