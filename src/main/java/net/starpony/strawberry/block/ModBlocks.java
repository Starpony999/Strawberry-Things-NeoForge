package net.starpony.strawberry.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.starpony.strawberry.Strawberry;
import net.starpony.strawberry.sets.*;
import net.starpony.strawberry.item.ModItems;

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
    public static final DeferredBlock<Block> THULITE_CRYSTAL_BLOCK = registerBlock("thulite_crystal_block", () -> new Block(BlockBehaviour.Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> OTHERWORLDLY_AMETHYST_BLOCK = registerBlock("otherworldly_amethyst_block", () -> new Block(BlockBehaviour.Properties.of().strength(50f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

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
    /* public static final DeferredBlock<Block> CAULIFLOWER_CROP = registerBlockWithoutItem("cauliflower_crop", () -> new CauliflowerCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> GRAPE_CROP = registerBlockWithoutItem("grape_crop", () -> new GrapeCropBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> STRAWBERRY_BUSH = registerBlockWithoutItem("strawberry_bush", () -> new StrawberryBushBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH), ModItems.STRAWBERRY.get()));
    public static final DeferredBlock<Block> BLUEBERRY_BUSH = registerBlockWithoutItem("blueberry_bush", () -> new BlueberryBushBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH), ModItems.BLUEBERRY.get()));
*/
    // Special blocks
    // public static final DeferredBlock<Block> CRYSTAL_LANTERN_BLOCK = registerBlock("crystal_lantern_block", () -> new CrystalLanternBlock(BlockBehaviour.Properties.of().strength(1f).requiresCorrectToolForDrops().lightLevel(state -> state.get(CrystalLanternBlock.CLICKED) ? 15 : 0)));

    // Sets
  /*  public static final SimpleStoneSet ANDESITE_BRICKS = registerSimpleStoneSet("andesite_bricks");
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
    public static final StoneSet GRIMSTONE = registerStoneSet("grimstone");
    public static final StoneSet NIGHTSTONE = registerStoneSet("nightstone");
    public static final WoodSet SYCAMORE = registerWoodSet("sycamore", ModSaplingGenerators.SYCAMORE);
    public static final WoodSet PLUM = registerWoodSet("plum", ModSaplingGenerators.PLUM);
*/
    // Registry helpers
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {DeferredBlock<T> deferred = BLOCKS.register(name, block);registerBlockItem(name, deferred);return deferred;}
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));}
    private static <T extends Block> DeferredBlock<T> registerBlockWithoutItem(String name, Supplier<T> block) {return BLOCKS.register(name, block);}

    // Set Methods
  /*  private static SimpleStoneSet registerSimpleStoneSet(String name) {
        DeferredBlock<Block> base = registerBlock(name,
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        DeferredBlock<Block> stairs = registerBlock(name + "_stairs",
                () -> new StairBlock(() -> base.get().defaultBlockState(),
                        BlockBehaviour.Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.STONE)));

        DeferredBlock<Block> slab = registerBlock(name + "_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .strength(2f)
                        .sound(SoundType.STONE)));

        DeferredBlock<Block> wall = registerBlock(name + "_wall",
                () -> new WallBlock(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        return new SimpleStoneSet(base, stairs, slab, wall);
    }*/ //SimpleStoneSet

   /* private static StoneSet registerStoneSet(String name) {
        // Base stone
        DeferredBlock<Block> base = registerBlock(name,
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        DeferredBlock<Block> stairs = registerBlock(name + "_stairs",
                () -> new StairBlock(() -> base.get().defaultBlockState(),
                        BlockBehaviour.Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.STONE)));

        DeferredBlock<Block> slab = registerBlock(name + "_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .strength(2f)
                        .sound(SoundType.STONE)));

        DeferredBlock<Block> wall = registerBlock(name + "_wall",
                () -> new WallBlock(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        DeferredBlock<Block> button = registerBlock(name + "_button",
                () -> new ButtonBlock(BlockSetType.STONE, 30,
                        BlockBehaviour.Properties.of().noCollission()));

        DeferredBlock<Block> pressurePlate = registerBlock(name + "_pressure_plate",
                () -> new PressurePlateBlock(BlockSetType.STONE, PushReaction.DESTROY,
                        BlockBehaviour.Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.STONE)));

        // Cobbled
        DeferredBlock<Block> cobbled = registerBlock("cobbled_" + name,
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        DeferredBlock<Block> cobbledStairs = registerBlock("cobbled_" + name + "_stairs",
                () -> new StairBlock(() -> cobbled.get().defaultBlockState(),
                        BlockBehaviour.Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.STONE)));

        DeferredBlock<Block> cobbledSlab = registerBlock("cobbled_" + name + "_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .strength(2f)
                        .sound(SoundType.STONE)));

        DeferredBlock<Block> cobbledWall = registerBlock("cobbled_" + name + "_wall",
                () -> new WallBlock(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        DeferredBlock<Block> cobbledButton = registerBlock("cobbled_" + name + "_button",
                () -> new ButtonBlock(BlockSetType.STONE, 30,
                        BlockBehaviour.Properties.of().noCollission()));

        DeferredBlock<Block> cobbledPressurePlate = registerBlock("cobbled_" + name + "_pressure_plate",
                () -> new PressurePlateBlock(BlockSetType.STONE, PushReaction.DESTROY,
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

        DeferredBlock<Block> chiseledStairs = registerBlock("chiseled_" + name + "_stairs",
                () -> new StairBlock(() -> chiseled.get().defaultBlockState(),
                        BlockBehaviour.Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.STONE)));

        DeferredBlock<Block> chiseledSlab = registerBlock("chiseled_" + name + "_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .strength(2f)
                        .sound(SoundType.STONE)));

        DeferredBlock<Block> chiseledWall = registerBlock("chiseled_" + name + "_wall",
                () -> new WallBlock(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        DeferredBlock<Block> chiseledButton = registerBlock("chiseled_" + name + "_button",
                () -> new ButtonBlock(BlockSetType.STONE, 30,
                        BlockBehaviour.Properties.of().noCollission()));

        DeferredBlock<Block> chiseledPressurePlate = registerBlock("chiseled_" + name + "_pressure_plate",
                () -> new PressurePlateBlock(BlockSetType.STONE, PushReaction.DESTROY,
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

        DeferredBlock<Block> bricksStairs = registerBlock(name + "_bricks_stairs",
                () -> new StairBlock(() -> bricks.get().defaultBlockState(),
                        BlockBehaviour.Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.STONE)));

        DeferredBlock<Block> bricksSlab = registerBlock(name + "_bricks_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .strength(2f)
                        .sound(SoundType.STONE)));

        DeferredBlock<Block> bricksWall = registerBlock(name + "_bricks_wall",
                () -> new WallBlock(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        DeferredBlock<Block> bricksButton = registerBlock(name + "_bricks_button",
                () -> new ButtonBlock(BlockSetType.STONE, 30,
                        BlockBehaviour.Properties.of().noCollission()));

        DeferredBlock<Block> bricksPressurePlate = registerBlock(name + "_bricks_pressure_plate",
                () -> new PressurePlateBlock(BlockSetType.STONE, PushReaction.DESTROY,
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

        DeferredBlock<Block> crackedBricksStairs = registerBlock("cracked_" + name + "_bricks_stairs",
                () -> new StairBlock(() -> crackedBricks.get().defaultBlockState(),
                        BlockBehaviour.Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.STONE)));

        DeferredBlock<Block> crackedBricksSlab = registerBlock("cracked_" + name + "_bricks_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .strength(2f)
                        .sound(SoundType.STONE)));

        DeferredBlock<Block> crackedBricksWall = registerBlock("cracked_" + name + "_bricks_wall",
                () -> new WallBlock(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        DeferredBlock<Block> crackedBricksButton = registerBlock("cracked_" + name + "_bricks_button",
                () -> new ButtonBlock(BlockSetType.STONE, 30,
                        BlockBehaviour.Properties.of().noCollission()));

        DeferredBlock<Block> crackedBricksPressurePlate = registerBlock("cracked_" + name + "_bricks_pressure_plate",
                () -> new PressurePlateBlock(BlockSetType.STONE, PushReaction.DESTROY,
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

        DeferredBlock<Block> smoothStairs = registerBlock("smooth_" + name + "_stairs",
                () -> new StairBlock(() -> smooth.get().defaultBlockState(),
                        BlockBehaviour.Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.STONE)));

        DeferredBlock<Block> smoothSlab = registerBlock("smooth_" + name + "_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.of()
                        .strength(2f)
                        .sound(SoundType.STONE)));

        DeferredBlock<Block> smoothWall = registerBlock("smooth_" + name + "_wall",
                () -> new WallBlock(BlockBehaviour.Properties.of()
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        DeferredBlock<Block> smoothButton = registerBlock("smooth_" + name + "_button",
                () -> new ButtonBlock(BlockSetType.STONE, 30,
                        BlockBehaviour.Properties.of().noCollission()));

        DeferredBlock<Block> smoothPressurePlate = registerBlock("smooth_" + name + "_pressure_plate",
                () -> new PressurePlateBlock(BlockSetType.STONE, PushReaction.DESTROY,
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
    } */ //StoneSet

   /* private static WoodSet registerWoodSet(String name, SaplingGenerator generator) {
        DeferredBlock<Block> log = registerBlock(name + "_log",
                () -> new PillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));

        DeferredBlock<Block> strippedLog = registerBlock(name + "_stripped_log",
                () -> new PillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));

        DeferredBlock<Block> wood = registerBlock(name + "_wood",
                () -> new PillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));

        DeferredBlock<Block> strippedWood = registerBlock(name + "_stripped_wood",
                () -> new PillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

        DeferredBlock<Block> planks = registerBlock(name + "_planks",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

        DeferredBlock<Block> leaves = registerBlock(name + "_leaves",
                () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

        DeferredBlock<Block> sapling = registerBlock(name + "_sapling",
                () -> new SaplingBlock(generator, BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        DeferredBlock<Block> stairs = registerBlock(name + "_stairs",
                () -> new StairsBlock(planks.get().defaultBlockState(),
                        BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));

        DeferredBlock<Block> slab = registerBlock(name + "_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));

        DeferredBlock<Block> button = registerBlock(name + "_button",
                () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).noCollission()));

        DeferredBlock<Block> pressurePlate = registerBlock(name + "_pressure_plate",
                () -> new PressurePlateBlock(BlockSetType.OAK, PushReaction.DESTROY, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)));

        DeferredBlock<Block> fence = registerBlock(name + "_fence",
                () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));

        DeferredBlock<Block> fenceGate = registerBlock(name + "_fence_gate",
                () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)));

        DeferredBlock<Block> door = registerBlock(name + "_door",
                () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion()));

        DeferredBlock<Block> trapdoor = registerBlock(name + "_trapdoor",
                () -> new TrapdoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion()));

        return new WoodSet(name, log, strippedLog, wood, strippedWood, planks, leaves, sapling,
                stairs, slab, button, pressurePlate, fence, fenceGate, door, trapdoor);
    } */ //Wood Set

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}