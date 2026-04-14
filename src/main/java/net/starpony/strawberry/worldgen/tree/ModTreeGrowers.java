package net.starpony.strawberry.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.starpony.strawberry.Strawberry;
import net.starpony.strawberry.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower SYCAMORE = new TreeGrower(Strawberry.MOD_ID + ":sycamore",
            Optional.empty(), Optional.of(ModConfiguredFeatures.SYCAMORE_KEY), Optional.empty());
    public static final TreeGrower PLUM = new TreeGrower(Strawberry.MOD_ID + ":plum",
            Optional.empty(), Optional.of(ModConfiguredFeatures.PLUM_KEY), Optional.empty());
    public static final TreeGrower BLOODWOOD = new TreeGrower(Strawberry.MOD_ID + ":bloodwood",
            Optional.empty(), Optional.of(ModConfiguredFeatures.BLOODWOOD_KEY), Optional.empty());
    public static final TreeGrower VOID = new TreeGrower(Strawberry.MOD_ID + ":void",
            Optional.empty(), Optional.of(ModConfiguredFeatures.VOID_KEY), Optional.empty());

}
