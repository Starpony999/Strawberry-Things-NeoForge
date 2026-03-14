package net.starpony.strawberry.item;

import net.starpony.strawberry.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {

    public static final Tier RUBY = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_RUBY_TOOL,
            1773, 8.5f, 3.5f, 17, () -> Ingredient.of(ModItems.RUBY.getGem()));

    public static final Tier SAPPHIRE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_SAPPHIRE_TOOL,
            660, 7.0f, 3.0f, 15, () -> Ingredient.of(ModItems.SAPPHIRE.getGem()));

    public static final Tier ROSE_QUARTZ = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_ROSE_QUARTZ_TOOL,
            2550, 10.0f, 5.0f, 20, () -> Ingredient.of(ModItems.ROSE_QUARTZ.getGem()));

    public static final Tier OTHERWORLDLY_AMETHYST = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_OTHERWORLDLY_AMETHYST_TOOL,
            3201, 50.0f, 5.0f, 17, () -> Ingredient.of(ModItems.OTHERWORLDLY_AMETHYST.getGem()));
}
