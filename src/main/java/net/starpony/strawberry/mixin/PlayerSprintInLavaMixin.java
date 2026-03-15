package net.starpony.strawberry.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.FluidTags;
import net.starpony.strawberry.util.DragonsGraceUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerSprintInLavaMixin {

    @Inject(method = "tickMovement", at = @At("TAIL"))
    private void enableSprintInLava(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity)(Object)this;
        if (!DragonsGraceUtil.hasDragonsGrace(player)) return;

        boolean inLava = player.getWorld()
                .getFluidState(player.getBlockPos())
                .isIn(FluidTags.LAVA);
        boolean movingForward = player.forwardSpeed > 0;

        if (inLava && movingForward) {
            // use the LivingEntity invoker
            ((LivingEntitySprintAccessor)player).callSetSprinting(true);
        }
    }
}
