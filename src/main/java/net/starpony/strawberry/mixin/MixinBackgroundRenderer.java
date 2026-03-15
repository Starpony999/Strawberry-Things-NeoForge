package net.starpony.strawberry.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.FogShape;
import net.starpony.strawberry.util.DragonsGraceUtil;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BackgroundRenderer.class)
public class MixinBackgroundRenderer {
    @Inject(
            method = "applyFog(Lnet/minecraft/client/render/Camera;Lnet/minecraft/client/render/BackgroundRenderer$FogType;FZF)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void onApplyFog(
            Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci
    ) {
        if (fogType == BackgroundRenderer.FogType.FOG_TERRAIN
                && camera.getSubmersionType() == CameraSubmersionType.LAVA
                && DragonsGraceUtil.hasDragonsGrace(MinecraftClient.getInstance().player)) {

            // Cancel default fog behavior
            ci.cancel();
            // Set fog parameters manually
            RenderSystem.setShaderFogStart(0.0f);
            RenderSystem.setShaderFogEnd(32.0f);
            RenderSystem.setShaderFogShape(FogShape.SPHERE); // 0x0000 = SPHERE; 0x0001 = CYLINDER (check version!)

            // Set fog color to bright orange
            RenderSystem.clearColor(1.0f, 0.5f, 0.0f, 1.0f);
        }
    }
}