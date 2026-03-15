package net.starpony.strawberry.mixin;

import com.mojang.serialization.MapCodec;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

@Mixin(FoliagePlacerType.class)
public interface FoliagePlacerTypeInvoker {
    @Invoker("register")
    static <P extends FoliagePlacer> FoliagePlacerType<P> callRegister(String id, MapCodec<P> codec) {
        throw new AssertionError(); // Invoker body is ignored
    }
}
