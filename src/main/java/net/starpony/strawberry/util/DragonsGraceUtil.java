package net.starpony.strawberry.util;

import net.minecraft.world.entity.LivingEntity;
import net.starpony.strawberry.effect.ModEffects;

public final class DragonsGraceUtil {
    private DragonsGraceUtil() {
    }

    public static boolean hasDragonsGrace(LivingEntity entity) {
        return entity != null && entity.hasEffect(ModEffects.DRAGONS_GRACE);
    }
}
