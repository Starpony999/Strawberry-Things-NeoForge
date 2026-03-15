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
        // Force-extinguish every tick to remove burning visuals in first and third person.
        livingEntity.setRemainingFireTicks(0);
        livingEntity.clearFire();

        if (!(livingEntity instanceof Player player) || !player.isInLava()) {
            return true;
        }

        // Use the actual swimming pose/state while in lava and sprinting.
        boolean shouldSwim = player.isSprinting() && !player.isPassenger();
        player.setSwimming(shouldSwim);

        Vec3 velocity = player.getDeltaMovement();

        if (shouldSwim) {
            // Apply input-driven acceleration like fluid swimming.
            Vec3 movementInput = new Vec3(player.xxa, 0.0D, player.zza);
            if (movementInput.lengthSqr() > 0.0001D) {
                player.moveRelative(0.035F + amplifier * 0.01F, movementInput);
                velocity = player.getDeltaMovement();
            }

            // Add forward propulsion based on look direction while moving forward.
            if (player.zza > 0.0F) {
                Vec3 look = player.getLookAngle();
                double forwardForce = 0.055D + (amplifier * 0.015D);
                velocity = velocity.add(look.x * forwardForce, look.y * forwardForce * 0.12D, look.z * forwardForce);
            }
        }

        // Vertical controls: crouch dives, otherwise slight buoyancy to avoid hard sinking.
        if (player.isShiftKeyDown()) {
            velocity = velocity.add(0.0D, -0.045D, 0.0D);
        } else if (velocity.y < 0.0D) {
            velocity = velocity.add(0.0D, 0.03D, 0.0D);
        }

        // Counteract heavy lava drag while preserving some fluid feel.
        double horizontalScale = shouldSwim ? 1.12D : 1.04D;
        velocity = new Vec3(velocity.x * horizontalScale, velocity.y, velocity.z * horizontalScale);

        player.setDeltaMovement(velocity);
        player.hasImpulse = true;
        return true;
    }
}
