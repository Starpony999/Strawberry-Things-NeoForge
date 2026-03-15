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

        boolean isTryingToSwim = player.isSprinting() && player.zza > 0.0F;
        player.setSwimming(isTryingToSwim);

        Vec3 velocity = player.getDeltaMovement();

        // Add true forward propulsion while sprint-swimming so lava feels like water swimming.
        if (isTryingToSwim) {
            Vec3 look = player.getLookAngle();
            double forwardForce = 0.06D + (amplifier * 0.015D);
            double verticalControl = 0.04D;
            velocity = velocity.add(
                    look.x * forwardForce,
                    look.y * forwardForce * verticalControl,
                    look.z * forwardForce
            );
        }

        // Buoyancy and vertical control.
        if (player.isShiftKeyDown()) {
            velocity = velocity.add(0.0D, -0.04D, 0.0D); // dive
        } else if (velocity.y < 0.0D) {
            velocity = velocity.add(0.0D, 0.03D, 0.0D); // avoid sinking like a rock
        }

        // Counteract lava drag a bit so movement remains responsive.
        double horizontalDampReduction = isTryingToSwim ? 1.08D : 1.02D;
        velocity = new Vec3(velocity.x * horizontalDampReduction, velocity.y, velocity.z * horizontalDampReduction);

        player.setDeltaMovement(velocity);
        player.hasImpulse = true;
        return true;
    }
}
