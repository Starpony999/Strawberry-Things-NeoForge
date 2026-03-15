package net.starpony.strawberry.mixin;

import net.minecraft.world.entity.player.Player;
import net.starpony.strawberry.util.DragonsGraceUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class PlayerLavaSwimStateMixin {
    @Inject(method = "updateSwimming", at = @At("TAIL"))
    private void strawberry$keepLavaSwimStateForDragonsGrace(CallbackInfo ci) {
        Player player = (Player) (Object) this;

        boolean shouldSwimInLava = DragonsGraceUtil.hasDragonsGrace(player)
                && player.isInLava()
                && player.isSprinting()
                && player.zza > 0.0F
                && !player.isPassenger();

        if (shouldSwimInLava) {
            player.setSwimming(true);
        }
    }
}
