package net.starpony.strawberry;

import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.starpony.strawberry.util.DragonsGraceUtil;

@EventBusSubscriber(modid = Strawberry.MOD_ID)
public final class DragonsGraceCommonEvents {
    private DragonsGraceCommonEvents() {
    }

    @SubscribeEvent
    public static void onLivingPostTick(EntityTickEvent.Post event) {
        if (!(event.getEntity() instanceof LivingEntity livingEntity)) {
            return;
        }

        if (!DragonsGraceUtil.hasDragonsGrace(livingEntity)) {
            return;
        }

        // Run after normal lava/burning updates so fire visuals stay gone.
        livingEntity.setRemainingFireTicks(0);
        livingEntity.clearFire();
    }
}
