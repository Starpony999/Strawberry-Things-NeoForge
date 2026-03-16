package net.starpony.strawberry.mixin;

import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(LivingEntity.class)
public interface LivingEntitySprintAccessor {

    @Invoker("setSprinting")
    void callSetSprinting(boolean sprinting);

}