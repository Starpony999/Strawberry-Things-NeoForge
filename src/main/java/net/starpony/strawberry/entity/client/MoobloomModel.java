package net.starpony.strawberry.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.starpony.strawberry.Strawberry;

public class MoobloomModel<T extends Entity> extends EntityModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "moobloom"), "main");

    private final ModelPart head;
    private final ModelPart flower;
    private final ModelPart body;
    private final ModelPart body_r1;
    private final ModelPart flower2;
    private final ModelPart flower3;
    private final ModelPart flower4;
    private final ModelPart back_left_leg;
    private final ModelPart back_right_leg;
    private final ModelPart front_left_leg;
    private final ModelPart front_right_leg;

    public MoobloomModel(ModelPart root) {
        this.head = root.getChild("Head");
        this.flower = this.head.getChild("flower");
        this.body = root.getChild("Body");
        this.body_r1 = this.body.getChild("Body_r1");
        this.flower2 = this.body.getChild("flower2");
        this.flower3 = this.body.getChild("flower3");
        this.flower4 = this.body.getChild("flower4");
        this.back_left_leg = root.getChild("back_left_leg");
        this.back_right_leg = root.getChild("back_right_leg");
        this.front_left_leg = root.getChild("front_left_leg");
        this.front_right_leg = root.getChild("front_right_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(22, 0).addBox(4.0F, -5.0F, -2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(-5.0F, -5.0F, -2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 4.0F, -12.0F));

        PartDefinition flower = Head.addOrReplaceChild("flower", CubeListBuilder.create().texOffs(37, 0).addBox(-2.0F, -31.0F, -13.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(27, 2).addBox(-3.0F, -31.0F, -13.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(53, 8).addBox(-2.0F, -35.0F, -13.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(53, 11).addBox(-3.0F, -32.0F, -13.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(52, 7).addBox(-3.0F, -34.0F, -13.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 24.0F, 11.0F));

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(-3.0F, 7.0F, -2.0F));

        PartDefinition Body_r1 = Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(18, 4).addBox(-8.0F, -10.0F, 12.0F, 12.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 17.0F, 2.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition flower2 = Body.addOrReplaceChild("flower2", CubeListBuilder.create().texOffs(37, 0).addBox(-2.0F, -30.0F, -13.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(27, 2).addBox(-3.0F, -31.0F, -13.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(53, 8).addBox(-2.0F, -35.0F, -13.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(53, 11).addBox(-3.0F, -32.0F, -13.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(52, 7).addBox(-3.0F, -34.0F, -13.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 25.0F, -1.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition flower3 = Body.addOrReplaceChild("flower3", CubeListBuilder.create().texOffs(37, 0).addBox(-2.0F, -31.0F, -13.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(27, 2).addBox(-3.0F, -31.0F, -13.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(53, 8).addBox(-2.0F, -35.0F, -13.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(53, 11).addBox(-3.0F, -32.0F, -13.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(52, 7).addBox(-3.0F, -34.0F, -13.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 23.0F, -5.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition flower4 = Body.addOrReplaceChild("flower4", CubeListBuilder.create().texOffs(37, 0).addBox(-2.0F, -31.0F, -13.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(27, 2).addBox(-3.0F, -31.0F, -13.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(53, 8).addBox(-2.0F, -35.0F, -13.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(53, 11).addBox(-3.0F, -32.0F, -13.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(52, 7).addBox(-3.0F, -34.0F, -13.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 24.0F, -17.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition back_left_leg = partdefinition.addOrReplaceChild("back_left_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 12.0F, 6.0F));

        PartDefinition back_right_leg = partdefinition.addOrReplaceChild("back_right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 12.0F, 6.0F));

        PartDefinition front_left_leg = partdefinition.addOrReplaceChild("front_left_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 12.0F, -8.0F));

        PartDefinition front_right_leg = partdefinition.addOrReplaceChild("front_right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 12.0F, -8.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {
        head.yRot = netHeadYaw * ((float)Math.PI / 180F);
        head.xRot = headPitch * ((float)Math.PI / 180F);

        front_left_leg.xRot = (float)Math.cos(limbSwing * 0.6662F) * limbSwingAmount;
        front_right_leg.xRot = (float)Math.cos(limbSwing * 0.6662F + Math.PI) * limbSwingAmount;
        back_left_leg.xRot = (float)Math.cos(limbSwing * 0.6662F + Math.PI) * limbSwingAmount;
        back_right_leg.xRot = (float)Math.cos(limbSwing * 0.6662F) * limbSwingAmount;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int i1, int i2) {
        head.render(poseStack, vertexConsumer, i, i1, i2);
        body.render(poseStack, vertexConsumer, i, i1, i2);
        back_left_leg.render(poseStack, vertexConsumer, i, i1, i2);
        back_right_leg.render(poseStack, vertexConsumer, i, i1, i2);
        front_left_leg.render(poseStack, vertexConsumer, i, i1, i2);
        front_right_leg.render(poseStack, vertexConsumer, i, i1, i2);
    }
}
