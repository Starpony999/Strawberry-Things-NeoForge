package net.starpony.strawberry.util;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.starpony.strawberry.Strawberry;

public class ModParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(net.minecraft.core.registries.Registries.PARTICLE_TYPE, Strawberry.MOD_ID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CRYSTAL_FLAME =
            PARTICLES.register("crystal_flame", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> THULITE_FLAME =
            PARTICLES.register("thulite_flame", () -> new SimpleParticleType(false));

    public static void register(IEventBus eventBus) {
        PARTICLES.register(eventBus);
    }
}
