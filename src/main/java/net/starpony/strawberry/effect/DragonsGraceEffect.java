package net.starpony.strawberry.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class DragonsGraceEffect extends MobEffect {
    public DragonsGraceEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        // Keep the player from burning while the effect is active.
        livingEntity.clearFire();

        if (!(livingEntity instanceof Player player) || !player.isInLava()) {
            return true;
        }

        // Allow full swim mode in lava while sprinting.
        player.setSwimming(player.isSprinting());

        Vec3 currentVelocity = player.getDeltaMovement();

        // Buoyancy and directional control similar to water swimming.
        double verticalBoost = currentVelocity.y < 0.0D ? 0.05D : 0.02D;
        float pitch = player.getXRot();
        double pitchInfluence = -pitch / 90.0D * 0.04D;

        // Slight horizontal boost to offset lava drag.
        double horizontalBoost = 1.15D;
        Vec3 boostedVelocity = new Vec3(
                currentVelocity.x * horizontalBoost,
                currentVelocity.y + verticalBoost + pitchInfluence,
                currentVelocity.z * horizontalBoost
        );

        player.setDeltaMovement(boostedVelocity);
        player.hasImpulse = true;

        return true;
    }
}
