package net.starpony.strawberry.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.FluidTags;
import net.starpony.strawberry.util.DragonsGraceUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerIsSwimmingMixin {

    @Inject(method = "isSwimming", at = @At("HEAD"), cancellable = true)
    private void overrideIsSwimming(CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity player = (PlayerEntity)(Object)this;

        if (!DragonsGraceUtil.hasDragonsGrace(player)) return;

        boolean shouldSwim = player.isSprinting()
                && player.isSubmergedIn(FluidTags.LAVA)
                && !player.hasVehicle()
                && player.getWorld().getFluidState(player.getBlockPos()).isIn(FluidTags.LAVA);

        if (shouldSwim) {
            cir.setReturnValue(true); // force swimming
        }
    }
}
