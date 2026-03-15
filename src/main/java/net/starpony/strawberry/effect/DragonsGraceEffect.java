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
        // Keep fire state cleared while effect is active.
        livingEntity.setRemainingFireTicks(0);
        livingEntity.clearFire();

        if (!(livingEntity instanceof Player player) || !player.isInLava()) {
            return true;
        }

        boolean shouldSwim = player.isSprinting() && !player.isPassenger();
        player.setSwimming(shouldSwim);

        if (!shouldSwim) {
            return true;
        }

        // Use vanilla-style input acceleration while in fluid.
        Vec3 movementInput = new Vec3(player.xxa, 0.0D, player.zza);
        if (movementInput.lengthSqr() > 0.0001D) {
            player.moveRelative(0.02F + (0.005F * amplifier), movementInput);
        }

        Vec3 velocity = player.getDeltaMovement();

        // Vertical control uses swim look angle and sneak-to-dive; no passive upward float.
        if (player.zza > 0.0F) {
            Vec3 look = player.getLookAngle();
            velocity = velocity.add(0.0D, look.y * 0.03D, 0.0D);
        }
        if (player.isShiftKeyDown()) {
            velocity = velocity.add(0.0D, -0.04D, 0.0D);
        }

        // Lava still feels thicker than water, but not unusably so.
        velocity = velocity.multiply(0.91D, 0.90D, 0.91D);

        player.setDeltaMovement(velocity);
        player.hasImpulse = true;
        return true;
    }
}
