package net.starpony.strawberry.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.starpony.strawberry.Strawberry;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, Strawberry.MOD_ID);

    public static final Holder<MobEffect> DRAGONS_GRACE = MOB_EFFECTS.register("dragons_grace",
            () -> new DragonsGraceEffect(MobEffectCategory.BENEFICIAL, 0xFF4500));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
