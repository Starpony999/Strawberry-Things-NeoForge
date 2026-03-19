package net.starpony.strawberry.item;

import net.minecraft.world.level.ItemLike;
import net.starpony.strawberry.Strawberry;
import net.starpony.strawberry.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.starpony.strawberry.util.sets.SetUtils;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Strawberry.MOD_ID);

    public static final Supplier<CreativeModeTab> STRAWBERRY_ITEMS_TAB = CREATIVE_MODE_TAB.register("bismuth_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TOILET_PAPER.get()))
                    .title(Component.translatable("creativetab.strawberry.strawberry_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RUBY.getGem());
                        output.accept(ModItems.SAPPHIRE.getGem());
                        output.accept(ModItems.ALUMINUM_SCRAP);
                        output.accept(ModItems.ALUMINUM_INGOT);
                        output.accept(ModItems.RAW_ALUMINUM);
                        output.accept(ModItems.NETHERITE_NUGGET);
                        output.accept(ModItems.RUBY.getShard());
                        output.accept(ModItems.SAPPHIRE.getShard());
                        output.accept(ModItems.DIAMOND_SHARD);
                        output.accept(ModItems.ROSE_QUARTZ.getShard());
                        output.accept(ModItems.THULITE_SHARD);
                        output.accept(ModItems.OTHERWORLDLY_AMETHYST.getGem());
                        output.accept(ModItems.NETHERTHYST);
                        output.accept(ModItems.ENDERTHYST);
                        output.accept(ModItems.RAW_ROSE_QUARTZ);
                        output.accept(ModItems.ROSE_QUARTZ.getGem());
                        output.accept(ModItems.COVER_SMITHING_TEMPLATE);
                        output.accept(ModItems.STARS_SMITHING_TEMPLATE);
                        output.accept(ModItems.SHINING_UPGRADE_SMITHING_TEMPLATE);
                        output.accept(ModItems.SIMPLE_UPGRADE_SMITHING_TEMPLATE);
                        output.accept(ModItems.CRYSTAL_LANTERN);
                        output.accept(ModItems.REDSTONE_LANTERN);
                        output.accept(ModItems.SMALL_LIGHT);
                        output.accept(ModItems.TOILET_PAPER);
                        output.accept(ModItems.BRIQUETTE);
                        output.accept(ModItems.SUNSET_VIBES_MUSIC_DISC);
                        output.accept(ModItems.STRAWBERRY);
                        output.accept(ModItems.BLUEBERRY);
                        output.accept(ModItems.GRAPES);
                        output.accept(ModItems.GRAPE_SEEDS);
                        output.accept(ModItems.ORANGE);
                        output.accept(ModItems.LIME);
                        output.accept(ModItems.LEMON);
                        output.accept(ModItems.CAULIFLOWER);
                        output.accept(ModItems.CAULIFLOWER_SEEDS);
                        output.accept(ModItems.SODA_CAN);
                        output.accept(ModItems.STRAWBERRY_SODA);
                        output.accept(ModItems.BLUEBERRY_SODA);
                        output.accept(ModItems.GRAPE_SODA);
                        output.accept(ModItems.ORANGE_SODA);
                        output.accept(ModItems.LEMON_LIME_SODA);
                        output.accept(ModItems.DIRT_SODA);
                        output.accept(ModItems.LEMONADE);
                      //  output.accept(ModDyes.CERISE_DYE);
                     //   output.accept(ModDyes.TURQUOISE_DYE);

                    }).build());

    public static final Supplier<CreativeModeTab> STRAWBERRY_BLOCK_TAB = CREATIVE_MODE_TAB.register("strawberry_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.WASHED_ANDESITE_BRICKS.block))
                    //.withTabsBefore(ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "strawberry_items_tab"))
                    .title(Component.translatable("creativetab.strawberry.strawberry_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.RUBY_BLOCK);
                        output.accept(ModBlocks.SAPPHIRE_BLOCK);
                        output.accept(ModBlocks.ALUMINUM_BLOCK);
                        output.accept(ModBlocks.ALUMINUM_ORE);
                        output.accept(ModBlocks.RAW_ALUMINUM_BLOCK);
                        output.accept(ModBlocks.RUBY_ORE);
                        output.accept(ModBlocks.SAPPHIRE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_RUBY_ORE);
                        output.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_ALUMINUM_ORE);
                        output.accept(ModBlocks.ROSE_QUARTZ_ORE);
                        output.accept(ModBlocks.END_ROSE_QUARTZ_ORE);
                        output.accept(ModBlocks.THULITE_CRYSTAL_BLOCK);
                        output.accept(ModBlocks.OTHERWORLDLY_AMETHYST_BLOCK);
                        output.accept(ModBlocks.ENDERTHYST_ORE);
                        output.accept(ModBlocks.NETHERTHYST_ORE);
                        output.accept(ModBlocks.RAW_ROSE_QUARTZ_BLOCK);
                        output.accept(ModBlocks.ROSE_QUARTZ_BLOCK);
                        output.accept(ModBlocks.CRYSTAL_LANTERN_BLOCK);

                        SetUtils.addSimpleStoneSet(output, ModBlocks.ANDESITE_BRICKS);
                        SetUtils.addSimpleStoneSet(output, ModBlocks.WASHED_ANDESITE_BRICKS);
                        SetUtils.addSimpleStoneSet(output, ModBlocks.DIORITE_BRICKS);
                        SetUtils.addSimpleStoneSet(output, ModBlocks.WASHED_DIORITE_BRICKS);
                        SetUtils.addSimpleStoneSet(output, ModBlocks.GRANITE_BRICKS);
                        SetUtils.addSimpleStoneSet(output, ModBlocks.WASHED_GRANITE_BRICKS);
                        SetUtils.addSimpleStoneSet(output, ModBlocks.WASHED_COBBLESTONE);
                        SetUtils.addSimpleStoneSet(output, ModBlocks.WASHED_COBBLESTONE_BRICKS);
                        SetUtils.addSimpleStoneSet(output, ModBlocks.WEATHERED_COBBLESTONE);
                        SetUtils.addSimpleStoneSet(output, ModBlocks.WEATHERED_COBBLESTONE_BRICKS);
                        SetUtils.addSimpleStoneSet(output, ModBlocks.AGED_COBBLESTONE);
                        SetUtils.addSimpleStoneSet(output, ModBlocks.AGED_COBBLESTONE_BRICKS);
                        SetUtils.addSimpleStoneSet(output, ModBlocks.EXPOSED_COBBLESTONE);
                        SetUtils.addSimpleStoneSet(output, ModBlocks.EXPOSED_COBBLESTONE_BRICKS);

                        SetUtils.addStoneSet(output, ModBlocks.GRIMSTONE);
                        SetUtils.addStoneSet(output, ModBlocks.NIGHTSTONE);

                       /* SetUtils.addWoodSet(output, ModBlocks.SYCAMORE);
                        SetUtils.addWoodSet(output, ModBlocks.PLUM);

                        SetUtils.addColorSet(output, ModBlocks.CERISE);
                        SetUtils.addColorSet(output, ModBlocks.TURQUOISE); */
                    }).build());
    public static final Supplier<CreativeModeTab> STRAWBERRY_TOOLS_ARMOR_TAB = CREATIVE_MODE_TAB.register("strawberry_tools_armor_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RUBY.getPickaxe().get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "strawberry_blocks_tab"))
                    .title(Component.translatable("creativetab.strawberry.strawberry_tools_armor"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SAPPHIRE.getSword());
                        output.accept(ModItems.SAPPHIRE.getShovel());
                        output.accept(ModItems.SAPPHIRE.getPickaxe());
                        output.accept(ModItems.SAPPHIRE.getAxe());
                        output.accept(ModItems.SAPPHIRE.getHoe());
                        output.accept(ModItems.SAPPHIRE.getHelmet());
                        output.accept(ModItems.SAPPHIRE.getChestplate());
                        output.accept(ModItems.SAPPHIRE.getLeggings());
                        output.accept(ModItems.SAPPHIRE.getBoots());
                        output.accept(ModItems.SAPPHIRE.getHorseArmor());

                        output.accept(ModItems.RUBY.getSword());
                        output.accept(ModItems.RUBY.getShovel());
                        output.accept(ModItems.RUBY.getPickaxe());
                        output.accept(ModItems.RUBY.getAxe());
                        output.accept(ModItems.RUBY.getHoe());
                        output.accept(ModItems.RUBY.getHelmet());
                        output.accept(ModItems.RUBY.getChestplate());
                        output.accept(ModItems.RUBY.getLeggings());
                        output.accept(ModItems.RUBY.getBoots());
                        output.accept(ModItems.RUBY.getHorseArmor());

                        output.accept(ModItems.ROSE_QUARTZ.getSword());
                        output.accept(ModItems.ROSE_QUARTZ.getShovel());
                        output.accept(ModItems.ROSE_QUARTZ.getPickaxe());
                        output.accept(ModItems.ROSE_QUARTZ.getAxe());
                        output.accept(ModItems.ROSE_QUARTZ.getHoe());
                        output.accept(ModItems.ROSE_QUARTZ_HAMMER);
                        output.accept(ModItems.ROSE_QUARTZ.getHelmet());
                        output.accept(ModItems.ROSE_QUARTZ.getChestplate());
                        output.accept(ModItems.ROSE_QUARTZ.getLeggings());
                        output.accept(ModItems.ROSE_QUARTZ.getBoots());
                        output.accept(ModItems.ROSE_QUARTZ.getHorseArmor());

                        output.accept(ModItems.OTHERWORLDLY_AMETHYST.getSword());
                        output.accept(ModItems.OTHERWORLDLY_AMETHYST.getShovel());
                        output.accept(ModItems.OTHERWORLDLY_AMETHYST.getPickaxe());
                        output.accept(ModItems.OTHERWORLDLY_AMETHYST.getAxe());
                        output.accept(ModItems.OTHERWORLDLY_AMETHYST.getHoe());
                        output.accept(ModItems.OTHERWORLDLY_AMETHYST_HAMMER);
                        output.accept(ModItems.OTHERWORLDLY_AMETHYST.getHelmet());
                        output.accept(ModItems.OTHERWORLDLY_AMETHYST.getChestplate());
                        output.accept(ModItems.OTHERWORLDLY_AMETHYST.getLeggings());
                        output.accept(ModItems.OTHERWORLDLY_AMETHYST.getBoots());
                        output.accept(ModItems.OTHERWORLDLY_AMETHYST.getHorseArmor());
                        output.accept(ModItems.NETHERITE_HORSE_ARMOR);
                     /* output.accept(ModItems.BUCKET_OF_MUD);
                        output.accept(ModItems.FISHING_ROD); */
                        output.accept(ModItems.FUSION_KEY);
                        output.accept(ModItems.CHISEL);
                     /* output.accept(ModItems.SHEARS);
                        output.accept(ModItems.COMPASS);*/
                    }).build());
    public static final Supplier<CreativeModeTab> STRAWBERRY_REDSTONE_TAB = CREATIVE_MODE_TAB.register("strawberry_redstone_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STRAWBERRY_REDSTONE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "strawberry_blocks_tab"))
                    .title(Component.translatable("creativetab.strawberry.strawberry_redstone"))
                    .displayItems((itemDisplayParameters, output) -> {
                        SetUtils.addSimpleRedStoneSet(output, ModBlocks.ANDESITE_BRICKS);
                        SetUtils.addSimpleRedStoneSet(output, ModBlocks.WASHED_ANDESITE_BRICKS);
                        SetUtils.addSimpleRedStoneSet(output, ModBlocks.DIORITE_BRICKS);
                        SetUtils.addSimpleRedStoneSet(output, ModBlocks.WASHED_DIORITE_BRICKS);
                        SetUtils.addSimpleRedStoneSet(output, ModBlocks.GRANITE_BRICKS);
                        SetUtils.addSimpleRedStoneSet(output, ModBlocks.WASHED_GRANITE_BRICKS);
                        SetUtils.addSimpleRedStoneSet(output, ModBlocks.WASHED_COBBLESTONE);
                        SetUtils.addSimpleRedStoneSet(output, ModBlocks.WASHED_COBBLESTONE_BRICKS);
                        SetUtils.addSimpleRedStoneSet(output, ModBlocks.WEATHERED_COBBLESTONE);
                        SetUtils.addSimpleRedStoneSet(output, ModBlocks.WEATHERED_COBBLESTONE_BRICKS);
                        SetUtils.addSimpleRedStoneSet(output, ModBlocks.AGED_COBBLESTONE);
                        SetUtils.addSimpleRedStoneSet(output, ModBlocks.AGED_COBBLESTONE_BRICKS);
                        SetUtils.addSimpleRedStoneSet(output, ModBlocks.EXPOSED_COBBLESTONE);
                        SetUtils.addSimpleRedStoneSet(output, ModBlocks.EXPOSED_COBBLESTONE_BRICKS);

                        SetUtils.addRedStoneSet(output, ModBlocks.GRIMSTONE);
                        SetUtils.addRedStoneSet(output, ModBlocks.NIGHTSTONE);

                       /* SetUtils.addRedWoodSet(output, ModBlocks.SYCAMORE);
                        SetUtils.addRedWoodSet(output, ModBlocks.PLUM);*/

                    }).build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
