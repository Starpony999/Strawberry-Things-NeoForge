package net.starpony.strawberry.mixin;

import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.player.Player;
import net.starpony.strawberry.util.DragonsGraceUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerIsSwimmingMixin {

    @Inject(method = "isSwimming", at = @At("HEAD"), cancellable = true)
    private void strawberry$overrideIsSwimming(CallbackInfoReturnable<Boolean> cir) {
        Player player = (Player)(Object)this;

        if (!DragonsGraceUtil.hasDragonsGrace(player)) return;

        boolean shouldSwim =
                player.isSprinting()
                        && player.level().getFluidState(player.blockPosition()).is(FluidTags.LAVA)
                        && !player.isPassenger();

        if (shouldSwim) {
            cir.setReturnValue(true); // force swimming
        }
    }
}