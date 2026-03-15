package net.starpony.strawberry.mixin;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

/**
 * Allows access to Entity#setSwimming(boolean)
 */
@Mixin(Entity.class)
public interface EntitySwimmingAccessor {
    @Invoker("setSwimming")
    void callSetSwimming(boolean swimming);

}
