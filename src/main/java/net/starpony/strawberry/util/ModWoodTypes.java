package net.starpony.strawberry.util;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.starpony.strawberry.Strawberry;

public class ModWoodTypes {
    public static final WoodType SYCAMORE = WoodType.register (new WoodType(Strawberry.MOD_ID + ":sycamore", BlockSetType.OAK));
    public static final WoodType PLUM = WoodType.register (new WoodType(Strawberry.MOD_ID + ":plum", BlockSetType.OAK));
    public static final WoodType BLOODWOOD = WoodType.register (new WoodType(Strawberry.MOD_ID + ":bloodwood", BlockSetType.WARPED));
}
