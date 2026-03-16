package net.starpony.strawberry.mixin;

import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.starpony.strawberry.util.DragonsGraceUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityFluidMixin {

    @Inject(method = "isEyeInFluid", at = @At("HEAD"), cancellable = true)
    private void strawberry$treatLavaAsWater(CallbackInfoReturnable<Boolean> cir) {
        Entity self = (Entity)(Object)this;

        if (self instanceof Player player) {
            if (DragonsGraceUtil.hasDragonsGrace(player)
                    && player.isEyeInFluid(FluidTags.LAVA)) {

                cir.setReturnValue(true);
            }
        }
    }
}