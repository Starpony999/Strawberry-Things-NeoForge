package net.starpony.strawberry.util;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.starpony.strawberry.effect.ModEffects;

public class DragonsGraceUtil {

    public static boolean hasDragonsGrace(Entity entity) {
        if (!(entity instanceof Player player)) {
            return false;
        } else {
            return player.hasStatusEffect(ModEffects.DRAGONS_GRACE);
        }
    }
}
