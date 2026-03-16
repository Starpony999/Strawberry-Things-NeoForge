package net.starpony.strawberry.mixin;

import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.player.Player;
import net.starpony.strawberry.util.DragonsGraceUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class PlayerSprintInLavaMixin {

    @Inject(method = "tick", at = @At("TAIL"))
    private void strawberry$enableSprintInLava(CallbackInfo ci) {
        Player player = (Player)(Object)this;

        if (!DragonsGraceUtil.hasDragonsGrace(player)) return;

        boolean inLava = player.level()
                .getFluidState(player.blockPosition())
                .is(FluidTags.LAVA);

        boolean movingForward = player.zza > 0;

        if (inLava && movingForward) {
            player.setSprinting(true);
        }
    }
}