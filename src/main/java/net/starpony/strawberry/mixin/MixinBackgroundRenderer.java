package net.starpony.strawberry.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.world.level.material.FogType;
import net.starpony.strawberry.util.DragonsGraceUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FogRenderer.class)
public class MixinBackgroundRenderer {

    @Inject(
            method = "setupFog",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void strawberry$overrideLavaFog(
            Camera camera,
            FogRenderer.FogMode fogMode,
            float viewDistance,
            boolean thickFog,
            float tickDelta,
            CallbackInfo ci
    ) {
        if (fogMode == FogRenderer.FogMode.FOG_TERRAIN
                && camera.getFluidInCamera() == FogType.LAVA
                && DragonsGraceUtil.hasDragonsGrace(Minecraft.getInstance().player)) {

            ci.cancel();

            RenderSystem.setShaderFogStart(0.0F);
            RenderSystem.setShaderFogEnd(32.0F);
        }
    }
}