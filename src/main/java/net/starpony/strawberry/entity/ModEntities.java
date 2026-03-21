package net.starpony.strawberry.entity;

import net.starpony.strawberry.Strawberry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Strawberry.MOD_ID);

    public static final Supplier<EntityType<MoobloomEntity>> MOOBLOOM =
            ENTITY_TYPES.register("moobloom", () -> EntityType.Builder.of(MoobloomEntity::new, MobCategory.CREATURE)
                    .sized(0.9F, 1.4F).build("moobloom"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
