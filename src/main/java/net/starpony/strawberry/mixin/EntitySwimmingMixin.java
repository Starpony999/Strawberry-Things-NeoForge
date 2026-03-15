package net.starpony.strawberry.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.Vec3d;
import net.starpony.strawberry.util.DragonsGraceUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class EntitySwimmingMixin {

    @Inject(method = "updateSwimming", at = @At("HEAD"))
    private void onUpdateSwimming(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity)(Object) this;

        if (!DragonsGraceUtil.hasDragonsGrace(player)) return;

        boolean inLavaBlock = player.getWorld()
                .getFluidState(player.getBlockPos())
                .isIn(FluidTags.LAVA);

        boolean shouldSwim = player.isSprinting()
                && player.isSubmergedIn(FluidTags.LAVA)
                && !player.hasVehicle()
                && inLavaBlock;

        ((EntitySwimmingAccessor) player).callSetSwimming(shouldSwim);

        if (DragonsGraceUtil.hasDragonsGrace(player) && player.isSwimming()) {
            Vec3d velocity = player.getVelocity();

            double x = velocity.x;
            double y = velocity.y;
            double z = velocity.z;

            // Boost horizontal speed
            x *= 1.9;
            z *= 1.9;

            if (player.isSubmergedIn(FluidTags.LAVA)) {
                // Add slight upward lift if sinking
                if (y < 0) {
                    y += 0.03;
                }

                // Vertical control via pitch
                float pitch = player.getPitch(); // Negative = looking up
                double verticalInfluence = -pitch / 90.0 * 0.05;
                y += verticalInfluence;
            }

            // Apply the final velocity
            player.setVelocity(x, y, z);
        }

    }
}
