package net.starpony.strawberry.client;

import net.minecraft.client.Minecraft;
import net.minecraft.world.level.material.FogType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderBlockScreenEffectEvent;
import net.neoforged.neoforge.client.event.ViewportEvent;
import net.starpony.strawberry.Strawberry;
import net.starpony.strawberry.util.DragonsGraceUtil;

@EventBusSubscriber(modid = Strawberry.MOD_ID, value = Dist.CLIENT)
public final class DragonsGraceClientEvents {
    private DragonsGraceClientEvents() {
    }

    @SubscribeEvent
    public static void onRenderFog(ViewportEvent.RenderFog event) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null || !DragonsGraceUtil.hasDragonsGrace(minecraft.player)) {
            return;
        }

        if (event.getCamera().getFluidInCamera() != FogType.LAVA) {
            return;
        }

        event.setNearPlaneDistance(0.0F);
        event.setFarPlaneDistance(Math.max(event.getFarPlaneDistance(), 32.0F));
        event.setCanceled(true);
    }

    @SubscribeEvent
    public static void onComputeFogColor(ViewportEvent.ComputeFogColor event) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null || !DragonsGraceUtil.hasDragonsGrace(minecraft.player)) {
            return;
        }

        if (event.getCamera().getFluidInCamera() != FogType.LAVA) {
            return;
        }

        // Bright orange tint while submerged in lava.
        event.setRed(1.0F);
        event.setGreen(0.45F);
        event.setBlue(0.05F);
    }

    @SubscribeEvent
    public static void onRenderBlockOverlay(RenderBlockScreenEffectEvent event) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null || !DragonsGraceUtil.hasDragonsGrace(minecraft.player)) {
            return;
        }

        if (event.getOverlayType() == RenderBlockScreenEffectEvent.OverlayType.FIRE) {
            event.setCanceled(true);
        }
    }
}
