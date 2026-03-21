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

public class MoobloomModel<T extends Entity> extends EntityModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(new ResourceLocation("strawberry", "moobloom"), "main");

    private final ModelPart head;
    private final ModelPart flower;
    private final ModelPart body;
    private final ModelPart body_r1;
    private final ModelPart flower2;
    private final ModelPart flower3;
    private final ModelPart flower4;
    private final ModelPart backLeftLeg;
    private final ModelPart backRightLeg;
    private final ModelPart frontLeftLeg;
    private final ModelPart frontRightLeg;

    public MoobloomModel(ModelPart root) {
        this.head = root.getChild("Head");
        this.flower = this.head.getChild("Flower");
        this.body = root.getChild("Body");
        this.body_r1 = this.body.getChild("Body_r1");
        this.flower2 = this.body.getChild("Flower2");
        this.flower3 = this.body.getChild("Flower3");
        this.flower4 = this.body.getChild("Flower4");
        this.backLeftLeg = root.getChild("back_left_leg");
        this.backRightLeg = root.getChild("back_right_leg");
        this.frontLeftLeg = root.getChild("front_left_leg");
        this.frontRightLeg = root.getChild("front_right_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        PartDefinition head = root.addOrReplaceChild("Head",
                CubeListBuilder.create()
                        .texOffs(22, 0).addBox(4F, -5F, -2F, 1, 3, 1)
                        .texOffs(22, 0).addBox(-5F, -5F, -2F, 1, 3, 1)
                        .texOffs(0, 0).addBox(-4F, -4F, -4F, 8, 8, 6),
                PartPose.offset(-2F, 4F, -12F));

        head.addOrReplaceChild("Flower",
                CubeListBuilder.create()
                        .texOffs(37, 0).addBox(-2F, -31F, -13F, 1, 3, 1)
                        .texOffs(27, 2).addBox(-3F, -31F, -13F, 3, 1, 1)
                        .texOffs(53, 8).addBox(-2F, -35F, -13F, 2, 1, 1)
                        .texOffs(53, 11).addBox(-3F, -32F, -13F, 3, 1, 1)
                        .texOffs(52, 7).addBox(-3F, -34F, -13F, 4, 2, 1),
                PartPose.offset(2F, 24F, 11F));

        PartDefinition body = root.addOrReplaceChild("Body",
                CubeListBuilder.create(), PartPose.offset(-3F, 7F, -2F));

        body.addOrReplaceChild("Body_r1",
                CubeListBuilder.create().texOffs(18, 4).addBox(-8F, -10F, 12F, 12, 18, 10),
                PartPose.offsetAndRotation(3F, 17F, 2F, (float)Math.PI / 2F, 0F, 0F));

        // Flowers
        body.addOrReplaceChild("Flower2",
                CubeListBuilder.create().texOffs(37, 0).addBox(-2F, -30F, -13F, 1, 3, 1),
                PartPose.offsetAndRotation(11F, 25F, -1F, 0F, (float)Math.PI / 2F, 0F));

        body.addOrReplaceChild("Flower3",
                CubeListBuilder.create().texOffs(37, 0).addBox(-2F, -31F, -13F, 1, 3, 1),
                PartPose.offsetAndRotation(1F, 23F, -5F, 0F, (float)Math.PI, 0F));

        body.addOrReplaceChild("Flower4",
                CubeListBuilder.create().texOffs(37, 0).addBox(-2F, -31F, -13F, 1, 3, 1),
                PartPose.offsetAndRotation(2F, 24F, -17F, 0F, (float)Math.PI, 0F));

        // Legs
        root.addOrReplaceChild("back_left_leg",
                CubeListBuilder.create().texOffs(0, 16).addBox(-2F, 0F, -2F, 4, 12, 4),
                PartPose.offset(-6F, 12F, 6F));
        root.addOrReplaceChild("back_right_leg",
                CubeListBuilder.create().texOffs(0, 16).addBox(-2F, 0F, -2F, 4, 12, 4),
                PartPose.offset(2F, 12F, 6F));
        root.addOrReplaceChild("front_left_leg",
                CubeListBuilder.create().texOffs(0, 16).addBox(-2F, 0F, -2F, 4, 12, 4),
                PartPose.offset(-6F, 12F, -8F));
        root.addOrReplaceChild("front_right_leg",
                CubeListBuilder.create().texOffs(0, 16).addBox(-2F, 0F, -2F, 4, 12, 4),
                PartPose.offset(2F, 12F, -8F));

        return LayerDefinition.create(mesh, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {
        head.yRot = netHeadYaw * ((float)Math.PI / 180F);
        head.xRot = headPitch * ((float)Math.PI / 180F);

        frontLeftLeg.xRot = (float)Math.cos(limbSwing * 0.6662F) * limbSwingAmount;
        frontRightLeg.xRot = (float)Math.cos(limbSwing * 0.6662F + Math.PI) * limbSwingAmount;
        backLeftLeg.xRot = (float)Math.cos(limbSwing * 0.6662F + Math.PI) * limbSwingAmount;
        backRightLeg.xRot = (float)Math.cos(limbSwing * 0.6662F) * limbSwingAmount;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int i1, int i2) {
        head.render(poseStack, vertexConsumer, i, i1, i2);
        body.render(poseStack, vertexConsumer, i, i1, i2);
        backLeftLeg.render(poseStack, vertexConsumer, i, i1, i2);
        backRightLeg.render(poseStack, vertexConsumer, i, i1, i2);
        frontLeftLeg.render(poseStack, vertexConsumer, i, i1, i2);
        frontRightLeg.render(poseStack, vertexConsumer, i, i1, i2);
    }
}