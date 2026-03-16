package net.starpony.strawberry.mixin;

import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.starpony.strawberry.util.DragonsGraceUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class EntitySwimmingMixin {

    @Inject(method = "updateSwimming", at = @At("TAIL"))
    private void onUpdateSwimming(CallbackInfo ci) {
        Player player = (Player)(Object) this;

        if (!DragonsGraceUtil.hasDragonsGrace(player)) return;

        boolean inLavaBlock = player.level()
                .getFluidState(player.blockPosition())
                .is(FluidTags.LAVA);

        boolean shouldSwim = player.isSprinting()
                && player.isEyeInFluid(FluidTags.LAVA)
                && !player.isPassenger()
                && inLavaBlock;

        ((EntitySwimmingAccessor) player).callSetSwimming(shouldSwim);

        if (player.isSwimming()) {

            Vec3 velocity = player.getDeltaMovement();

            double x = velocity.x;
            double y = velocity.y;
            double z = velocity.z;

            // Boost horizontal speed
            x *= 1.9;
            z *= 1.9;

            if (player.isEyeInFluid(FluidTags.LAVA)) {

                // Add slight upward lift if sinking
                if (y < 0) {
                    y += 0.03;
                }

                // Vertical control via pitch
                float pitch = player.getXRot();
                double verticalInfluence = -pitch / 90.0 * 0.05;
                y += verticalInfluence;
            }

            player.setDeltaMovement(x, y, z);
        }
    }
}