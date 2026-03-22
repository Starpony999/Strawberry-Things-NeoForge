package net.starpony.strawberry.util.sets;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ColorSet {
    public final String name;
    public final DeferredBlock<Block> concrete;
    public final DeferredBlock<Block> concretePowder;
    public final DeferredBlock<Block> terracotta;
    public final DeferredBlock<Block> glazedTerracotta;
    public final DeferredBlock<Block> wool;
    public final DeferredBlock<Block> stainedGlass;
    public final DeferredBlock<StainedGlassPaneBlock> stainedGlassPane;
    public final DeferredBlock<Block> carpet;

    public ColorSet(String name,
                    DeferredBlock<Block> concrete,
                    DeferredBlock<Block> concretePowder,
                    DeferredBlock<Block> terracotta,
                    DeferredBlock<Block> glazedTerracotta,
                    DeferredBlock<Block> wool,
                    DeferredBlock<Block> stainedGlass,
                    DeferredBlock<StainedGlassPaneBlock> stainedGlassPane,
                    DeferredBlock<Block> carpet) {
        this.name = name;
        this.concrete = concrete;
        this.concretePowder = concretePowder;
        this.terracotta = terracotta;
        this.glazedTerracotta = glazedTerracotta;
        this.wool = wool;
        this.stainedGlass = stainedGlass;
        this.stainedGlassPane = stainedGlassPane;
        this.carpet = carpet;
    }

    public String getName() {
        return name;
    }

    public DeferredBlock<Block> getConcrete() {
        return concrete;
    }

    public DeferredBlock<Block> getConcretePowder() {
        return concretePowder;
    }

    public DeferredBlock<Block> getTerracotta() {
        return terracotta;
    }

    public DeferredBlock<Block> getGlazedTerracotta() {
        return glazedTerracotta;
    }

    public DeferredBlock<Block> getWool() {
        return wool;
    }

    public DeferredBlock<Block> getStainedGlass() {
        return stainedGlass;
    }

    public DeferredBlock<StainedGlassPaneBlock> getStainedGlassPane() {
        return stainedGlassPane;
    }

    public DeferredBlock<Block> getCarpet() {
        return carpet;
    }
}
