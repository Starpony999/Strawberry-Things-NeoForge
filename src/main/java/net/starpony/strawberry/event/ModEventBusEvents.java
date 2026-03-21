package net.starpony.strawberry.event;

import net.starpony.strawberry.Strawberry;
import net.starpony.strawberry.entity.ModEntities;
import net.starpony.strawberry.entity.client.MoobloomModel;
import net.starpony.strawberry.entity.MoobloomEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = Strawberry.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MoobloomModel.LAYER_LOCATION, MoobloomModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.MOOBLOOM.get(), MoobloomEntity.createAttributes().build());
    }
}
