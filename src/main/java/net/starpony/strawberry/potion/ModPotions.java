package net.starpony.strawberry.potion;

import net.starpony.strawberry.Strawberry;
import net.starpony.strawberry.effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, Strawberry.MOD_ID);

    public static final Holder<Potion> DRAGONS_GRACE_POTION = POTIONS.register("dragons_grace_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.DRAGONS_GRACE
                    , 1200, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}