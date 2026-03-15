package net.starpony.strawberry.mixin;

import net.starpony.strawberry.util.DragonsGraceUtil;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameOverlayRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(InGameOverlayRenderer.class)
public abstract class InGameOverlayRendererMixin {
    @Shadow
    private static void renderFireOverlay(MinecraftClient client, MatrixStack matrices) {}


    @Redirect(
            method = "renderOverlays(Lnet/minecraft/client/MinecraftClient;Lnet/minecraft/client/util/math/MatrixStack;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameOverlayRenderer;renderFireOverlay(Lnet/minecraft/client/MinecraftClient;Lnet/minecraft/client/util/math/MatrixStack;)V"
            )
    )
    private static void suppressFireOverlay(MinecraftClient client, MatrixStack matrices) {
        PlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null && DragonsGraceUtil.hasDragonsGrace(player)) {
            return; // skip overlay
        }
        // Call the shadowed method
        renderFireOverlay(client, matrices);
    }
}
