package net.starpony.strawberry.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {

    public static final FoodProperties CAULIFLOWER = new FoodProperties.Builder()
            .nutrition(3).saturationModifier(0.25f).build();

    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder()
            .nutrition(3).saturationModifier(0.3f).build();

    public static final FoodProperties GRAPES = new FoodProperties.Builder()
            .nutrition(3).saturationModifier(0.4f).build();

    public static final FoodProperties BLUEBERRY = new FoodProperties.Builder()
            .nutrition(2).saturationModifier(0.3f).build();

    public static final FoodProperties LEMON = new FoodProperties.Builder()
            .nutrition(4).saturationModifier(0.2f).build();

    public static final FoodProperties LIME = new FoodProperties.Builder()
            .nutrition(4).saturationModifier(0.3f).build();

    public static final FoodProperties ORANGE = new FoodProperties.Builder()
            .nutrition(4).saturationModifier(0.5f).build();

    public static final FoodProperties STRAWBERRY_SODA = new FoodProperties.Builder()
            .nutrition(4).saturationModifier(0.25f).build();

    public static final FoodProperties GRAPE_SODA = new FoodProperties.Builder()
            .nutrition(4).saturationModifier(0.4f).build();

    public static final FoodProperties BLUEBERRY_SODA = new FoodProperties.Builder()
            .nutrition(2).saturationModifier(0.3f).build();

    public static final FoodProperties LEMON_LIME_SODA = new FoodProperties.Builder()
            .nutrition(4).saturationModifier(0.3f).build();

    public static final FoodProperties ORANGE_SODA = new FoodProperties.Builder()
            .nutrition(4).saturationModifier(0.5f).build();

    public static final FoodProperties DIRT_SODA = new FoodProperties.Builder()
            .nutrition(3).saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 1200, 2), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 1200, 2), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 200, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1200, 10), 1f)
            .build();
}