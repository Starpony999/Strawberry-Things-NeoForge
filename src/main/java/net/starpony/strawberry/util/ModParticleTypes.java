package net.starpony.strawberry.util;

import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;

public class ModParticleTypes extends ParticleTypes {

    public static final SimpleParticleType CRYSTAL_FLAME = register("crystal_flame", false);
    public static final SimpleParticleType THULITE_FLAME = register("thulite_flame", false);



    private static SimpleParticleType register(String key, boolean overrideLimiter) {
        return (SimpleParticleType) Registry.register(BuiltInRegistries.PARTICLE_TYPE, key, new SimpleParticleType(overrideLimiter));
    }
}
