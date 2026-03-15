package net.starpony.strawberry.mixin;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;


@Mixin(Entity.class)
public interface EntityAccessor {
    /**
     * @Invoker exposes the protected/private setSwimming(boolean) as a public method on this interface
     */
    @Invoker("setSwimming")
    void invokeSetSwimming(boolean swimming);
}