package net.starpony.strawberry.util.sets;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

public class TorchSet {
    public final String name;
    public final DeferredBlock<Block> torch;
    public final DeferredBlock<Block> wallTorch;
    public final DeferredBlock<Block> lantern;

    public TorchSet(
            String name,
            DeferredBlock<Block> torch,
            DeferredBlock<Block> wallTorch,
            DeferredBlock<Block> lantern
    ) {
        this.name = name;
        this.torch = torch;
        this.wallTorch = wallTorch;
        this.lantern = lantern;
    }

}
