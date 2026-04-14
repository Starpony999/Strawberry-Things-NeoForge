package net.starpony.strawberry.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {

    public static final FoodProperties CAULIFLOWER = new FoodProperties.Builder()
            .nutrition(3).saturationModifier(0.25f).build();

    public static final FoodProperties CORN = new FoodProperties.Builder()
            .nutrition(5).saturationModifier(0.6f).build();

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

    public static final FoodProperties PLUM = new FoodProperties.Builder()
            .nutrition(4).saturationModifier(0.5f).build();

    public static final FoodProperties CHERRY = new FoodProperties.Builder()
            .nutrition(3).saturationModifier(0.4f).build();

    public static final FoodProperties CHOCOLATE = new FoodProperties.Builder()
            .nutrition(2).saturationModifier(0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 2), .5f)
            .build();

    // Sodas give twice the nutrition, but half the saturation
    // Sprite gets the same amount of saturation since it uses lemons and limes

    public static final FoodProperties STRAWBERRY_SODA = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.15f).build();

    public static final FoodProperties GRAPE_SODA = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.2f).build();

    public static final FoodProperties BLUEBERRY_SODA = new FoodProperties.Builder()
            .nutrition(4).saturationModifier(0.15f).build();

    public static final FoodProperties LEMON_LIME_SODA = new FoodProperties.Builder()
            .nutrition(8).saturationModifier(0.3f).build();

    public static final FoodProperties ORANGE_SODA = new FoodProperties.Builder()
            .nutrition(8).saturationModifier(0.25f).build();

    public static final FoodProperties LEMONADE = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.1f).build();

    public static final FoodProperties VANILLA = new FoodProperties.Builder()
            .nutrition(1).saturationModifier(0.1f).build();

    public static final FoodProperties CHOCOLATE_SYRUP = new FoodProperties.Builder()
            .nutrition(1).saturationModifier(0.1f).build();

    public static final FoodProperties CHOCOLATE_MILK = new FoodProperties.Builder()
            .nutrition(1).saturationModifier(0.1f)
            .build();

    public static final FoodProperties COLA_SODA = new FoodProperties.Builder()
            .nutrition(4).saturationModifier(0.2f).build();

    public static final FoodProperties PLUM_SODA = new FoodProperties.Builder()
            .nutrition(8).saturationModifier(0.25f).build();

    public static final FoodProperties CHERRY_SODA = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.2f).build();

    public static final FoodProperties DIRT_SODA = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 1200, 2), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 1200, 2), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 200, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1200, 10), 1f)
            .build();
}