package net.starpony.strawberry;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.starpony.strawberry.block.ModBlocks;
import net.starpony.strawberry.effect.ModEffects;
import net.starpony.strawberry.entity.ModEntities;
import net.starpony.strawberry.entity.client.MoobloomRenderer;
import net.starpony.strawberry.item.ModItems;
import net.starpony.strawberry.item.ModArmorMaterials;
import net.starpony.strawberry.potion.ModPotions;
import net.starpony.strawberry.sound.ModSounds;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Strawberry.MOD_ID)
public class Strawberry {
    public static final String MOD_ID = "strawberry";
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public Strawberry(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);
        ModCreativeModeTabs.register(modEventBus);
        ModArmorMaterials.register(modEventBus);
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);
        ModSounds.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);


        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        private static void registerColorSetRenderLayers(net.starpony.strawberry.util.sets.ColorSet set) {
            ItemBlockRenderTypes.setRenderLayer(set.getStainedGlass().get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(set.getStainedGlassPane().get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(set.getCarpet().get(), RenderType.cutout());
        }

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.CAULIFLOWER_CROP.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRAPE_CROP.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.STRAWBERRY_BUSH.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLUEBERRY_BUSH.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.SYCAMORE.sapling.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.PLUM.sapling.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLOODWOOD.sapling.get(), RenderType.cutout());
                registerColorSetRenderLayers(ModBlocks.CERISE);
                registerColorSetRenderLayers(ModBlocks.TURQUOISE);
                registerColorSetRenderLayers(ModBlocks.LAVENDER);
                registerColorSetRenderLayers(ModBlocks.INDIGO);
                EntityRenderers.register(ModEntities.MOOBLOOM.get(), MoobloomRenderer::new);
            });
        }
    }
}
