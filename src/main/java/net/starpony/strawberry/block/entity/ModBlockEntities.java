package net.starpony.strawberry.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.starpony.strawberry.Strawberry;
import net.starpony.strawberry.block.ModBlocks;
import net.starpony.strawberry.entity.ModHangingSignBlockEntity;
import net.starpony.strawberry.entity.ModSignBlockEntity;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Strawberry.MOD_ID);

    public static final Supplier<BlockEntityType<ModSignBlockEntity>> MOD_SIGN =
            BLOCK_ENTITIES.register("mod_sign", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            ModBlocks.SYCAMORE.getSign().get(), ModBlocks.SYCAMORE.getWallSign().get(),
                            ModBlocks.PLUM.getSign().get(), ModBlocks.PLUM.getWallSign().get(),
                            ModBlocks.BLOODWOOD.getSign().get(), ModBlocks.BLOODWOOD.getWallSign().get()
                    ).build(null));

    public static final Supplier<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN =
            BLOCK_ENTITIES.register("mod_hanging_sign", () ->
                    BlockEntityType.Builder.of(ModHangingSignBlockEntity::new,
                            ModBlocks.SYCAMORE.getHangingSign().get(), ModBlocks.SYCAMORE.getWallHangingSign().get(),
                            ModBlocks.PLUM.getHangingSign().get(), ModBlocks.PLUM.getWallHangingSign().get(),
                            ModBlocks.BLOODWOOD.getHangingSign().get(), ModBlocks.BLOODWOOD.getWallHangingSign().get()
                    ).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
