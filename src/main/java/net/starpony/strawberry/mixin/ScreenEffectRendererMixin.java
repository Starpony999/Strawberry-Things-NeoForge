package net.starpony.strawberry.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import net.starpony.strawberry.util.DragonsGraceUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ScreenEffectRenderer.class)
public abstract class ScreenEffectRendererMixin {

    @Shadow
    private static void renderFire(Minecraft minecraft, PoseStack poseStack) {}

    @Redirect(
            method = "renderScreenEffect",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/ScreenEffectRenderer;renderFire(Lnet/minecraft/client/Minecraft;Lcom/mojang/blaze3d/vertex/PoseStack;)V"
            )
    )
    private static void suppressFireOverlay(Minecraft minecraft, PoseStack poseStack) {
        LocalPlayer player = minecraft.player;

        if (player != null && DragonsGraceUtil.hasDragonsGrace(player)) {
            return; // Skip overlay
        }

        renderFire(minecraft, poseStack); // call shadowed method
    }
}