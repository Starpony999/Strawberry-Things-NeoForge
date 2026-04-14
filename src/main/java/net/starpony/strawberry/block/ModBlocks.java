package net.starpony.strawberry.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.starpony.strawberry.Strawberry;
import net.starpony.strawberry.block.signs.ModStandingSignBlock;
import net.starpony.strawberry.item.ModItems;
import net.starpony.strawberry.util.ModParticleTypes;
import net.starpony.strawberry.util.ModWoodTypes;
import net.starpony.strawberry.util.sets.*;
import net.starpony.strawberry.worldgen.tree.ModTreeGrowers;

import java.awt.*;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Strawberry.MOD_ID);

    // Blocks
    public static final DeferredBlock<Block> RUBY_BLOCK = registerBlock("ruby_block", () -> new Block(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block", () -> new Block(BlockBehaviour.Properties.of().strength(5f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> ALUMINUM_BLOCK = registerBlock("aluminum_block", () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> RAW_ALUMINUM_BLOCK = registerBlock("raw_aluminum_block", () -> new Block(BlockBehaviour.Properties.of().strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> RAW_ROSE_QUARTZ_BLOCK = registerBlock("raw_rose_quartz_block", () -> new Block(BlockBehaviour.Properties.of().strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ROSE_QUARTZ_BLOCK = registerBlock("rose_quartz_block", () -> new Block(BlockBehaviour.Properties.of().strength(5f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> OTHERWORLDLY_AMETHYST_BLOCK = registerBlock("otherworldly_amethyst_block", () -> new Block(BlockBehaviour.Properties.of().strength(50f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> HELLSHROOM_LIGHT = registerBlock("hellshroom_light", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(1.0F).sound(SoundType.SHROOMLIGHT).lightLevel(p_152663_ -> 15)));
    public static final DeferredBlock<Block> NIGHT_TERRIA = registerBlock("night_terria", () -> new Block(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.GRAVEL)));


    //Thulite Geodes
    public static final DeferredBlock<Block> GNEISS = registerBlock("gneiss", () -> new RandomTextureBlock(BlockBehaviour.Properties.of().strength(1.25f).requiresCorrectToolForDrops().sound(SoundType.BASALT)));
    public static final DeferredBlock<Block> SCHIST = registerBlock("schist", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(0.75f).requiresCorrectToolForDrops().sound(SoundType.CALCITE)));

    public static final DeferredBlock<Block> THULITE_CRYSTAL_BLOCK = registerBlock("thulite_crystal_block", () -> new Block(BlockBehaviour.Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> BUDDING_THULITE_CRYSTAL_BLOCK = registerBlock("budding_thulite_crystal_block", () -> new BuddingThuliteBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> THULITE_CLUSTER = registerBlock("thulite_cluster", () -> new  AmethystClusterBlock(7.0F, 3.0F, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).forceSolidOn().noOcclusion().sound(SoundType.AMETHYST_CLUSTER).strength(1.5F).lightLevel(p_152632_ -> 5).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> LARGE_THULITE_BUD = registerBlock("large_thulite_bud", () -> new AmethystClusterBlock(5.0F, 3.0F, BlockBehaviour.Properties.of().sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel(p_152629_ -> 4)));
    public static final DeferredBlock<Block> MEDIUM_THULITE_BUD = registerBlock("medium_thulite_bud", () -> new AmethystClusterBlock(4.0F, 3.0F, BlockBehaviour.Properties.of().sound(SoundType.LARGE_AMETHYST_BUD).lightLevel(p_152617_ -> 2)));
    public static final DeferredBlock<Block> SMALL_THULITE_BUD = registerBlock("small_thulite_bud", () -> new AmethystClusterBlock(3.0F, 4.0F, BlockBehaviour.Properties.of().sound(SoundType.SMALL_AMETHYST_BUD).lightLevel(p_187409_ -> 1)));
    // Ores
    public static final DeferredBlock<Block> ALUMINUM_ORE = registerBlock("aluminum_ore", () -> new DropExperienceBlock(UniformInt.of(1, 3), BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_ALUMINUM_ORE = registerBlock("deepslate_aluminum_ore", () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of().strength(4.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> RUBY_ORE = registerBlock("ruby_ore", () -> new DropExperienceBlock(UniformInt.of(2, 5), BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore", () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.of().strength(4.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore", () -> new DropExperienceBlock(UniformInt.of(2, 5), BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore", () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.of().strength(4.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> ROSE_QUARTZ_ORE = registerBlock("rose_quartz_ore", () -> new DropExperienceBlock(UniformInt.of(2, 6), BlockBehaviour.Properties.of().strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> END_ROSE_QUARTZ_ORE = registerBlock("end_rose_quartz_ore", () -> new DropExperienceBlock(UniformInt.of(4, 8), BlockBehaviour.Properties.of().strength(5f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ENDERTHYST_ORE = registerBlock("enderthyst_ore", () -> new Block(BlockBehaviour.Properties.of().strength(30f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> NETHERTHYST_ORE = registerBlock("netherthyst_ore", () -> new Block(BlockBehaviour.Properties.of().strength(30f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    // Crops
    public static final DeferredBlock<CropBlock> CAULIFLOWER_CROP = BLOCKS.register("cauliflower_crop",
            () -> new CauliflowerCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final DeferredBlock<CropBlock> GRAPE_CROP = registerBlockWithoutItem("grape_crop",
            () -> new GrapeCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final DeferredBlock<CropBlock> CORN_CROP = BLOCKS.register("corn_crop",
            () -> new CauliflowerCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final DeferredBlock<Block> STRAWBERRY_BUSH = registerBlockWithoutItem("strawberry_bush",
            () -> new StrawberryBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)));
    public static final DeferredBlock<Block> BLUEBERRY_BUSH = registerBlockWithoutItem("blueberry_bush",
            () -> new BlueberryBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)));

    // Lanterns
    public static final DeferredBlock<Block> CRYSTAL_LANTERN_BLOCK = registerBlock("crystal_lantern_block",
            () -> new CrystalLanternBlock(BlockBehaviour.Properties.of().strength(1f)
                    .requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(CrystalLanternBlock.CLICKED) ? 15 : 0)));
    public static final DeferredBlock<Block> REDSTONE_LANTERN = registerBlock("redstone_lantern",
            () -> new RedstoneLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).lightLevel(state -> 15)));
    public static final TorchSet CRYSTAL = registerTorchSet("crystal", ModParticleTypes.CRYSTAL_FLAME);
    public static final TorchSet THULITE = registerTorchSet("thulite", ModParticleTypes.THULITE_FLAME);

     // Sets
    public static final SimpleStoneSet ANDESITE_BRICKS = registerSimpleStoneSet("andesite_bricks");
    public static final SimpleStoneSet WASHED_ANDESITE_BRICKS = registerSimpleStoneSet("washed_andesite_bricks");
    public static final SimpleStoneSet DIORITE_BRICKS = registerSimpleStoneSet("diorite_bricks");
    public static final SimpleStoneSet WASHED_DIORITE_BRICKS = registerSimpleStoneSet("washed_diorite_bricks");
    public static final SimpleStoneSet GRANITE_BRICKS = registerSimpleStoneSet("granite_bricks");
    public static final SimpleStoneSet WASHED_GRANITE_BRICKS = registerSimpleStoneSet("washed_granite_bricks");
    public static final SimpleStoneSet WASHED_COBBLESTONE = registerSimpleStoneSet("washed_cobblestone");
    public static final SimpleStoneSet WASHED_COBBLESTONE_BRICKS = registerSimpleStoneSet("washed_cobblestone_bricks");
    public static final SimpleStoneSet WEATHERED_COBBLESTONE = registerSimpleStoneSet("weathered_cobblestone");
    public static final SimpleStoneSet WEATHERED_COBBLESTONE_BRICKS = registerSimpleStoneSet("weathered_cobblestone_bricks");
    public static final SimpleStoneSet AGED_COBBLESTONE = registerSimpleStoneSet("aged_cobblestone");
    public static final SimpleStoneSet AGED_COBBLESTONE_BRICKS = registerSimpleStoneSet("aged_cobblestone_bricks");
    public static final SimpleStoneSet EXPOSED_COBBLESTONE = registerSimpleStoneSet("exposed_cobblestone");
    public static final SimpleStoneSet EXPOSED_COBBLESTONE_BRICKS = registerSimpleStoneSet("exposed_cobblestone_bricks");
    public static final SimpleStoneSet SEALED_COBBLESTONE = registerSimpleStoneSet("sealed_cobblestone");
    public static final SimpleStoneSet SEALED_WASHED_COBBLESTONE = registerSimpleStoneSet("sealed_washed_cobblestone");
    public static final SimpleStoneSet SEALED_EXPOSED_COBBLESTONE = registerSimpleStoneSet("sealed_exposed_cobblestone");
    public static final SimpleStoneSet SEALED_WEATHERED_COBBLESTONE = registerSimpleStoneSet("sealed_weathered_cobblestone");
    public static final SimpleStoneSet SEALED_AGED_COBBLESTONE = registerSimpleStoneSet("sealed_aged_cobblestone");
    public static final SimpleStoneSet SEALED_WASHED_COBBLESTONE_BRICKS = registerSimpleStoneSet("sealed_washed_cobblestone_bricks");
    public static final SimpleStoneSet SEALED_EXPOSED_COBBLESTONE_BRICKS = registerSimpleStoneSet("sealed_exposed_cobblestone_bricks");
    public static final SimpleStoneSet SEALED_WEATHERED_COBBLESTONE_BRICKS = registerSimpleStoneSet("sealed_weathered_cobblestone_bricks");
    public static final SimpleStoneSet SEALED_AGED_COBBLESTONE_BRICKS = registerSimpleStoneSet("sealed_aged_cobblestone_bricks");


   // public static final SimpleStoneSet BLUE_ICE = registerIceSet("blue_ice", Blocks.BLUE_ICE, 2.8f);
   // public static final SimpleStoneSet PACKED_ICE = registerIceSet("packed_ice", Blocks.PACKED_ICE, 0.5f);
   // public static final SimpleStoneSet ICE = registerIceSet("packed_ice", Blocks.ICE, 0.5f);

    public static final StoneSet GRIMSTONE = registerStoneSet("grimstone");
    public static final StoneSet NIGHTSTONE = registerStoneSet("nightstone");

    public static final WoodSet SYCAMORE = registerWoodSet("sycamore", ModTreeGrowers.SYCAMORE, ModWoodTypes.SYCAMORE);
    public static final WoodSet PLUM = registerWoodSet("plum", ModTreeGrowers.PLUM, ModWoodTypes.PLUM);
    public static final WoodSet BLOODWOOD = registerNightmareWoodSet("bloodwood", ModTreeGrowers.BLOODWOOD, ModWoodTypes.BLOODWOOD);
    public static final WoodSet VOID = registerNightmareWoodSet("void", ModTreeGrowers.VOID, ModWoodTypes.VOID);

    public static final ColorSet CERISE = registerColorSet("cerise", DyeColor.RED);
    public static final ColorSet TURQUOISE = registerColorSet("turquoise", DyeColor.CYAN);
    public static final ColorSet INDIGO = registerColorSet("indigo", DyeColor.BLUE);
    public static final ColorSet LAVENDER = registerColorSet("lavender", DyeColor.PURPLE);
    public static final ColorSet TAN = registerColorSet("tan", DyeColor.BROWN);

    // Registry helpers
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {DeferredBlock<T> deferred = BLOCKS.register(name, block);registerBlockItem(name, deferred);return deferred;}
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));}
    private static <T extends Block> DeferredBlock<T> registerBlockWithoutItem(String name, Supplier<T> block) {return BLOCKS.register(name, block);}

    // Set Methods
    private static SimpleStoneSet registerSimpleStoneSet(String name) {
        DeferredBlock<Block> base = registerBlock(name,
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        DeferredBlock<StairBlock> stairs = registerBlock(name + "_stairs",
                () -> new StairBlock(base.get().defaultBlockState(),
                        BlockBehaviour.Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.STONE)));

        DeferredBlock<SlabBlock> slab = registerBlock(name + "_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .strength(2f)
                        .sound(SoundType.STONE)));

        DeferredBlock<WallBlock> wall = registerBlock(name + "_wall",
                () -> new WallBlock(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

         DeferredBlock<ButtonBlock> button = registerBlock(name + "_button",
                () -> new ButtonBlock(BlockSetType.STONE, 30,
                        BlockBehaviour.Properties.of()
                                .noCollission()));

        DeferredBlock<PressurePlateBlock> pressurePlate = registerBlock(name + "_pressure_plate",
                () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.of()
                        .strength(2f)
                        .requiresCorrectToolForDrops()));


        return new SimpleStoneSet(base, stairs, slab, wall, button, pressurePlate);
    }
    private static StoneSet registerStoneSet(String name) {
        // Base stone
        DeferredBlock<Block> base = registerBlock(name,
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        DeferredBlock<StairBlock> stairs = registerBlock(name + "_stairs",
                () -> new StairBlock(base.get().defaultBlockState(),
                        BlockBehaviour.Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.STONE)));

        DeferredBlock<SlabBlock> slab = registerBlock(name + "_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .strength(2f)
                        .sound(SoundType.STONE)));

        DeferredBlock<WallBlock> wall = registerBlock(name + "_wall",
                () -> new WallBlock(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        DeferredBlock<ButtonBlock> button = registerBlock(name + "_button",
                () -> new ButtonBlock(BlockSetType.STONE, 30,
                        BlockBehaviour.Properties.of().noCollission()));

        DeferredBlock<PressurePlateBlock> pressurePlate = registerBlock(name + "_pressure_plate",
                () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()));

        // Cobbled
        DeferredBlock<Block> cobbled = registerBlock("cobbled_" + name,
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        DeferredBlock<StairBlock> cobbledStairs = registerBlock("cobbled_" + name + "_stairs",
                () -> new StairBlock(cobbled.get().defaultBlockState(),
                        BlockBehaviour.Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.STONE)));

        DeferredBlock<SlabBlock> cobbledSlab = registerBlock("cobbled_" + name + "_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .strength(2f)
                        .sound(SoundType.STONE)));

        DeferredBlock<WallBlock> cobbledWall = registerBlock("cobbled_" + name + "_wall",
                () -> new WallBlock(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        DeferredBlock<ButtonBlock> cobbledButton = registerBlock("cobbled_" + name + "_button",
                () -> new ButtonBlock(BlockSetType.STONE, 30,
                        BlockBehaviour.Properties.of().noCollission()));

        DeferredBlock<PressurePlateBlock> cobbledPressurePlate = registerBlock("cobbled_" + name + "_pressure_plate",
                () -> new PressurePlateBlock(BlockSetType.STONE,
                        BlockBehaviour.Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.STONE)));

        // Chiseled
        DeferredBlock<Block> chiseled = registerBlock("chiseled_" + name,
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        DeferredBlock<StairBlock> chiseledStairs = registerBlock("chiseled_" + name + "_stairs",
                () -> new StairBlock(chiseled.get().defaultBlockState(),
                        BlockBehaviour.Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.STONE)));

        DeferredBlock<SlabBlock> chiseledSlab = registerBlock("chiseled_" + name + "_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .strength(2f)
                        .sound(SoundType.STONE)));

        DeferredBlock<WallBlock> chiseledWall = registerBlock("chiseled_" + name + "_wall",
                () -> new WallBlock(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        DeferredBlock<ButtonBlock> chiseledButton = registerBlock("chiseled_" + name + "_button",
                () -> new ButtonBlock(BlockSetType.STONE, 30,
                        BlockBehaviour.Properties.of().noCollission()));

        DeferredBlock<PressurePlateBlock> chiseledPressurePlate = registerBlock("chiseled_" + name + "_pressure_plate",
                () -> new PressurePlateBlock(BlockSetType.STONE,
                        BlockBehaviour.Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.STONE)));

        // Bricks
        DeferredBlock<Block> bricks = registerBlock(name + "_bricks",
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        DeferredBlock<StairBlock> bricksStairs = registerBlock(name + "_bricks_stairs",
                () -> new StairBlock(bricks.get().defaultBlockState(),
                        BlockBehaviour.Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.STONE)));

        DeferredBlock<SlabBlock> bricksSlab = registerBlock(name + "_bricks_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .strength(2f)
                        .sound(SoundType.STONE)));

        DeferredBlock<WallBlock> bricksWall = registerBlock(name + "_bricks_wall",
                () -> new WallBlock(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        DeferredBlock<ButtonBlock> bricksButton = registerBlock(name + "_bricks_button",
                () -> new ButtonBlock(BlockSetType.STONE, 30,
                        BlockBehaviour.Properties.of().noCollission()));

        DeferredBlock<PressurePlateBlock> bricksPressurePlate = registerBlock(name + "_bricks_pressure_plate",
                () -> new PressurePlateBlock(BlockSetType.STONE,
                        BlockBehaviour.Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.STONE)));

        // Cracked Bricks
        DeferredBlock<Block> crackedBricks = registerBlock("cracked_" + name + "_bricks",
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        DeferredBlock<StairBlock> crackedBricksStairs = registerBlock("cracked_" + name + "_bricks_stairs",
                () -> new StairBlock(crackedBricks.get().defaultBlockState(),
                        BlockBehaviour.Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.STONE)));

        DeferredBlock<SlabBlock> crackedBricksSlab = registerBlock("cracked_" + name + "_bricks_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .strength(2f)
                        .sound(SoundType.STONE)));

        DeferredBlock<WallBlock> crackedBricksWall = registerBlock("cracked_" + name + "_bricks_wall",
                () -> new WallBlock(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        DeferredBlock<ButtonBlock> crackedBricksButton = registerBlock("cracked_" + name + "_bricks_button",
                () -> new ButtonBlock(BlockSetType.STONE, 30,
                        BlockBehaviour.Properties.of().noCollission()));

        DeferredBlock<PressurePlateBlock> crackedBricksPressurePlate = registerBlock("cracked_" + name + "_bricks_pressure_plate",
                () -> new PressurePlateBlock(BlockSetType.STONE,
                        BlockBehaviour.Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.STONE)));

        // Smooth
        DeferredBlock<Block> smooth = registerBlock("smooth_" + name,
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        DeferredBlock<StairBlock> smoothStairs = registerBlock("smooth_" + name + "_stairs",
                () -> new StairBlock(smooth.get().defaultBlockState(),
                        BlockBehaviour.Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.STONE)));

        DeferredBlock<SlabBlock> smoothSlab = registerBlock("smooth_" + name + "_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .strength(2f)
                        .sound(SoundType.STONE)));

        DeferredBlock<WallBlock> smoothWall = registerBlock("smooth_" + name + "_wall",
                () -> new WallBlock(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        DeferredBlock<ButtonBlock> smoothButton = registerBlock("smooth_" + name + "_button",
                () -> new ButtonBlock(BlockSetType.STONE, 30,
                        BlockBehaviour.Properties.of().noCollission()));

        DeferredBlock<PressurePlateBlock> smoothPressurePlate = registerBlock("smooth_" + name + "_pressure_plate",
                () -> new PressurePlateBlock(BlockSetType.STONE,
                        BlockBehaviour.Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.STONE)));

        return new StoneSet(
                name,
                base, stairs, slab, wall, button, pressurePlate,
                cobbled, cobbledStairs, cobbledSlab, cobbledWall, cobbledButton, cobbledPressurePlate,
                chiseled, chiseledStairs, chiseledSlab, chiseledWall, chiseledButton, chiseledPressurePlate,
                bricks, bricksStairs, bricksSlab, bricksWall, bricksButton, bricksPressurePlate,
                crackedBricks, crackedBricksStairs, crackedBricksSlab, crackedBricksWall, crackedBricksButton, crackedBricksPressurePlate,
                smooth, smoothStairs, smoothSlab, smoothWall, smoothButton, smoothPressurePlate
        );
    }
    private static ColorSet registerColorSet(String name, DyeColor dyeColor) {
        DeferredBlock<Block> concrete = registerBlock(name + "_concrete",
                () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
        DeferredBlock<Block> concretePowder = registerBlock(name + "_concrete_powder",
                () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE_POWDER)));
        DeferredBlock<Block> terracotta = registerBlock(name + "_terracotta",
                () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
        DeferredBlock<Block> glazedTerracotta = registerBlock(name + "_glazed_terracotta",
                () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_GLAZED_TERRACOTTA)));
        DeferredBlock<Block> wool = registerBlock(name + "_wool",
                () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
        DeferredBlock<Block> stainedGlass = registerBlock(name + "_stained_glass",
                () -> new StainedGlassBlock(dyeColor, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
        DeferredBlock<Block> stainedGlassPane = registerBlock(name + "_stained_glass_pane",
                () -> new StainedGlassPaneBlock(dyeColor, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE)));
        DeferredBlock<Block> carpet = registerBlock(name + "_carpet",
                () -> new CarpetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CARPET)));

        return new ColorSet(name, concrete, concretePowder, terracotta, glazedTerracotta, wool,
                stainedGlass, stainedGlassPane, carpet);
    }
    private static WoodSet registerWoodSet(String name, TreeGrower grower, WoodType woodType) {
        DeferredBlock<Block> log = registerBlock(name + "_log",
                () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));

        DeferredBlock<Block> strippedLog = registerBlock(name + "_stripped_log",
                () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));

        DeferredBlock<Block> wood = registerBlock(name + "_wood",
                () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));

        DeferredBlock<Block> strippedWood = registerBlock(name + "_stripped_wood",
                () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

        DeferredBlock<Block> planks = registerBlock(name + "_planks",
                () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                    @Override
                    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                        return 5;
                    }
                });

        DeferredBlock<Block> leaves = registerBlock(name + "_leaves",
                () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                    @Override
                    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                        return 60;
                    }

                    @Override
                    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                        return 30;
                    }
                });

        DeferredBlock<Block> sapling = registerBlock(name + "_sapling",
                () -> new SaplingBlock(grower, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

        DeferredBlock<StairBlock> stairs = registerBlock(name + "_stairs",
                () -> new StairBlock(planks.get().defaultBlockState(),
                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));

        DeferredBlock<SlabBlock> slab = registerBlock(name + "_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));

        DeferredBlock<ButtonBlock> button = registerBlock(name + "_button",
                () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).noCollission()));

        DeferredBlock<PressurePlateBlock> pressurePlate = registerBlock(name + "_pressure_plate",
                () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));

        DeferredBlock<FenceBlock> fence = registerBlock(name + "_fence",
                () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));

        DeferredBlock<FenceGateBlock> fenceGate = registerBlock(name + "_fence_gate",
                () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));

        DeferredBlock<DoorBlock> door = registerBlock(name + "_door",
                () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion()));

        DeferredBlock<TrapDoorBlock> trapdoor = registerBlock(name + "_trapdoor",
                () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion()));

        DeferredBlock<Block> sign = registerBlock(name + "_sign",
                () -> new ModStandingSignBlock(woodType, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));

        DeferredBlock<Block> wallSign = registerBlock(name + "_wall_sign",
                () -> new ModStandingSignBlock(woodType, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)));

        DeferredBlock<Block> hangingSign = registerBlock(name + "_hanging_sign",
                () -> new ModStandingSignBlock(woodType, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)));

        DeferredBlock<Block> wallHangingSign = registerBlock(name + "_wall_hanging_sign",
                () -> new ModStandingSignBlock(woodType, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)));


        return new WoodSet(name, log, strippedLog, wood, strippedWood, planks, leaves, null, sapling,
                stairs, slab, button, pressurePlate, fence, fenceGate, door, trapdoor, sign, wallSign, hangingSign, wallHangingSign, null, null);
    }  //Wood Set
    private static WoodSet registerNightmareWoodSet(String name, TreeGrower grower, WoodType woodType) {
        DeferredBlock<Block> log = registerBlock(name + "_stem",
                () -> new ModNonFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STEM)));

        DeferredBlock<Block> strippedLog = registerBlock(name + "_stripped_stem",
                () -> new ModNonFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_WARPED_STEM)));

        DeferredBlock<Block> wood = registerBlock(name + "_hyphae",
                () -> new ModNonFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_HYPHAE)));

        DeferredBlock<Block> strippedWood = registerBlock(name + "_stripped_hyphae",
                () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_WARPED_HYPHAE)));

        DeferredBlock<Block> planks = registerBlock(name + "_planks",
                () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));

        DeferredBlock<Block> wartBlock = registerBlock(name + "_wart_block",
                () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_WART_BLOCK)) );

        DeferredBlock<Block> sapling = registerBlock(name + "_fungus",
                () -> new ModSaplingBlock(grower, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FUNGUS), ModBlocks.NIGHTSTONE.base));

        DeferredBlock<StairBlock> stairs = registerBlock(name + "_stairs",
                () -> new StairBlock(planks.get().defaultBlockState(),
                        BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STAIRS)));

        DeferredBlock<SlabBlock> slab = registerBlock(name + "_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_SLAB)));

        DeferredBlock<ButtonBlock> button = registerBlock(name + "_button",
                () -> new ButtonBlock(BlockSetType.WARPED, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_BUTTON).noCollission()));

        DeferredBlock<PressurePlateBlock> pressurePlate = registerBlock(name + "_pressure_plate",
                () -> new PressurePlateBlock(BlockSetType.WARPED, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PRESSURE_PLATE)));

        DeferredBlock<FenceBlock> fence = registerBlock(name + "_fence",
                () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FENCE)));

        DeferredBlock<FenceGateBlock> fenceGate = registerBlock(name + "_fence_gate",
                () -> new FenceGateBlock(WoodType.WARPED, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FENCE_GATE)));

        DeferredBlock<DoorBlock> door = registerBlock(name + "_door",
                () -> new DoorBlock(BlockSetType.WARPED, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_DOOR).noOcclusion()));

        DeferredBlock<TrapDoorBlock> trapdoor = registerBlock(name + "_trapdoor",
                () -> new TrapDoorBlock(BlockSetType.WARPED, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_TRAPDOOR).noOcclusion()));

        DeferredBlock<Block> sign = registerBlock(name + "_sign",
                () -> new ModStandingSignBlock(woodType, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_SIGN)));

        DeferredBlock<Block> wallSign = registerBlock(name + "_wall_sign",
                () -> new ModStandingSignBlock(woodType, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_WALL_SIGN)));

        DeferredBlock<Block> hangingSign = registerBlock(name + "_hanging_sign",
                () -> new ModStandingSignBlock(woodType, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_HANGING_SIGN)));

        DeferredBlock<Block> wallHangingSign = registerBlock(name + "_wall_hanging_sign",
                () -> new ModStandingSignBlock(woodType, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_WALL_HANGING_SIGN)));

        return new WoodSet(name, log, strippedLog, wood, strippedWood, planks, null, wartBlock, sapling,
                stairs, slab, button, pressurePlate, fence, fenceGate, door, trapdoor, sign, wallSign, hangingSign, wallHangingSign, null, null);
    }  //Wood Set for Nightmare Dimension
    private static SimpleStoneSet registerIceSet(String name, Block block, Float strength){
        DeferredBlock<StairBlock> stairs = registerBlock(name + "_stairs",
                () -> new StairBlock(block.defaultBlockState(),
                        BlockBehaviour.Properties.of()
                                .strength(strength)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.GLASS)));

        DeferredBlock<SlabBlock> slab = registerBlock(name + "_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .strength(strength)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.GLASS)));

        DeferredBlock<WallBlock> wall = registerBlock(name + "_wall",
                () -> new WallBlock(BlockBehaviour.Properties.of()
                        .strength(strength)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.GLASS)));
        return new SimpleStoneSet(null, stairs, slab, wall, null, null);
    }
    private static TorchSet registerTorchSet(String name, SimpleParticleType particle) {

        DeferredBlock<Block> torch = registerBlock(name + "_torch",
                () -> new TorchBlock(
                        particle,
                        BlockBehaviour.Properties.of()
                                .noCollission()
                                .instabreak()
                                .lightLevel(state -> 15)
                                .sound(SoundType.WOOD)
                                .pushReaction(PushReaction.DESTROY)
                )
        );

        DeferredBlock<Block> wallTorch = registerBlock(name + "_wall_torch",
                () -> new WallTorchBlock(
                        particle,
                        BlockBehaviour.Properties.of()
                                .noCollission()
                                .instabreak()
                                .lightLevel(state -> 15)
                                .sound(SoundType.WOOD)
                                .dropsLike(torch.get())
                                .pushReaction(PushReaction.DESTROY)
                )
        );

        DeferredBlock<Block> lantern = registerBlock(name + "_lantern",
                () -> new ColoredLanternBlock(
                        BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN)
                                .lightLevel(state -> 15)
                )
        );

        return new TorchSet(name, torch, wallTorch, lantern);
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
