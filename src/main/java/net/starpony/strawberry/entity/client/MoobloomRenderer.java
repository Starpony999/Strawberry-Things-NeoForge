package net.starpony.strawberry.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.starpony.strawberry.Strawberry;
import net.starpony.strawberry.entity.MoobloomEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MoobloomRenderer extends MobRenderer<MoobloomEntity, MoobloomModel<MoobloomEntity>> {
    public MoobloomRenderer(EntityRendererProvider.Context context) {
        super(context, new MoobloomModel<>(context.bakeLayer(MoobloomModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(MoobloomEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "textures/entity/moobloom/moobloom_yellow.png");
    }

    @Override
    public void render(MoobloomEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.45f, 0.45f, 0.45f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}