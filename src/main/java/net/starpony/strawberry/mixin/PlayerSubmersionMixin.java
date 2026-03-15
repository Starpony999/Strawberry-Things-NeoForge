package net.starpony.strawberry.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.FluidTags;
import net.starpony.strawberry.util.DragonsGraceUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Make lava count as water for the submerged flag when Dragon's Grace is active.
 */
@Mixin(PlayerEntity.class)
public abstract class PlayerSubmersionMixin {
    // shadow the protected field from PlayerEntity
    @Shadow protected boolean isSubmergedInWater;

    @Inject(method = "updateWaterSubmersionState", at = @At("HEAD"), cancellable = true)
    private void onUpdateWaterSubmersionState(CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity self = (PlayerEntity)(Object)this;

        boolean submerged = self.isSubmergedIn(FluidTags.WATER)
                || (DragonsGraceUtil.hasDragonsGrace(self)
                && self.isSubmergedIn(FluidTags.LAVA));

        this.isSubmergedInWater = submerged;
        cir.setReturnValue(submerged);
    }
}
