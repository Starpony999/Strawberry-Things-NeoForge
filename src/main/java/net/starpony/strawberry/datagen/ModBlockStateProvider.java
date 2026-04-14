package net.starpony.strawberry.datagen;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.neoforged.neoforge.client.model.generators.MultiPartBlockStateBuilder;
import net.starpony.strawberry.Strawberry;
import net.starpony.strawberry.block.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.starpony.strawberry.util.sets.ColorSet;
import net.starpony.strawberry.util.sets.SimpleStoneSet;
import net.starpony.strawberry.util.sets.StoneSet;
import net.starpony.strawberry.util.sets.TorchSet;
import net.starpony.strawberry.util.sets.WoodSet;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Strawberry.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.ALUMINUM_BLOCK);
        blockWithItem(ModBlocks.ALUMINUM_ORE);
        blockWithItem(ModBlocks.RAW_ALUMINUM_BLOCK);
        blockWithItem(ModBlocks.RUBY_BLOCK);
        blockWithItem(ModBlocks.RUBY_ORE);
        blockWithItem(ModBlocks.SAPPHIRE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ALUMINUM_ORE);
        blockWithItem(ModBlocks.ROSE_QUARTZ_ORE);
        blockWithItem(ModBlocks.END_ROSE_QUARTZ_ORE);
        blockWithItem(ModBlocks.THULITE_CRYSTAL_BLOCK);
        blockWithItem(ModBlocks.OTHERWORLDLY_AMETHYST_BLOCK);
        blockWithItem(ModBlocks.ENDERTHYST_ORE);
        blockWithItem(ModBlocks.NETHERTHYST_ORE);
        blockWithItem(ModBlocks.RAW_ROSE_QUARTZ_BLOCK);
        blockWithItem(ModBlocks.ROSE_QUARTZ_BLOCK);
        blockWithItem(ModBlocks.HELLSHROOM_LIGHT);
        blockWithItem(ModBlocks.NIGHT_TERRIA);

        blockWithItem(ModBlocks.BUDDING_THULITE_CRYSTAL_BLOCK);
        thuliteClusterBlock(ModBlocks.SMALL_THULITE_BUD, "small_amethyst_bud");
        thuliteClusterBlock(ModBlocks.MEDIUM_THULITE_BUD, "medium_amethyst_bud");
        thuliteClusterBlock(ModBlocks.LARGE_THULITE_BUD, "large_amethyst_bud");
        thuliteClusterBlock(ModBlocks.THULITE_CLUSTER, "amethyst_cluster");
        randomTextureBlock(ModBlocks.GNEISS);
        blockWithItem(ModBlocks.SCHIST);

        registerTorchSet(ModBlocks.CRYSTAL);
        lanternBlock(ModBlocks.REDSTONE_LANTERN);
        registerTorchSet(ModBlocks.THULITE);

        registerSimpleStoneSet(ModBlocks.WASHED_DIORITE_BRICKS);
        registerSimpleStoneSet(ModBlocks.DIORITE_BRICKS);
        registerSimpleStoneSet(ModBlocks.WASHED_ANDESITE_BRICKS);
        registerSimpleStoneSet(ModBlocks.ANDESITE_BRICKS);
        registerSimpleStoneSet(ModBlocks.WASHED_GRANITE_BRICKS);
        registerSimpleStoneSet(ModBlocks.GRANITE_BRICKS);
        registerSimpleStoneSet(ModBlocks.WASHED_COBBLESTONE);
        registerSimpleStoneSet(ModBlocks.WASHED_COBBLESTONE_BRICKS);
        registerSimpleStoneSet(ModBlocks.WEATHERED_COBBLESTONE);
        registerSimpleStoneSet(ModBlocks.WEATHERED_COBBLESTONE_BRICKS);
        registerSimpleStoneSet(ModBlocks.AGED_COBBLESTONE);
        registerSimpleStoneSet(ModBlocks.AGED_COBBLESTONE_BRICKS);
        registerSimpleStoneSet(ModBlocks.EXPOSED_COBBLESTONE);
        registerSimpleStoneSet(ModBlocks.EXPOSED_COBBLESTONE_BRICKS);
        registerSimpleStoneSet(ModBlocks.SEALED_COBBLESTONE);
        registerSimpleStoneSet(ModBlocks.SEALED_WASHED_COBBLESTONE);
        registerSimpleStoneSet(ModBlocks.SEALED_EXPOSED_COBBLESTONE);
        registerSimpleStoneSet(ModBlocks.SEALED_WEATHERED_COBBLESTONE);
        registerSimpleStoneSet(ModBlocks.SEALED_AGED_COBBLESTONE);
        registerSimpleStoneSet(ModBlocks.SEALED_WASHED_COBBLESTONE_BRICKS);
        registerSimpleStoneSet(ModBlocks.SEALED_EXPOSED_COBBLESTONE_BRICKS);
        registerSimpleStoneSet(ModBlocks.SEALED_WEATHERED_COBBLESTONE_BRICKS);
        registerSimpleStoneSet(ModBlocks.SEALED_AGED_COBBLESTONE_BRICKS);

        registerWoodSet(ModBlocks.SYCAMORE);
        registerWoodSet(ModBlocks.PLUM);
        registerNightmareWoodSet(ModBlocks.BLOODWOOD);
        registerNightmareWoodSet(ModBlocks.VOID);

        registerFullStoneSet(ModBlocks.NIGHTSTONE);
        registerFullStoneSet(ModBlocks.GRIMSTONE);

        registerColorSet(ModBlocks.CERISE);
        registerColorSet(ModBlocks.TURQUOISE);
        registerColorSet(ModBlocks.LAVENDER);
        registerColorSet(ModBlocks.INDIGO);

        customLamp();

        makeCrop(ModBlocks.CAULIFLOWER_CROP.get(), "cauliflower_stage_", "cauliflower_");
        makeCrop(ModBlocks.GRAPE_CROP.get(), "grape_stage_", "grape_");
        makeCrop(ModBlocks.CORN_CROP.get(), "corn_stage_", "corn_");

        makeBush(ModBlocks.STRAWBERRY_BUSH.get(), "strawberry_stage_", "strawberry_");
        makeBush(ModBlocks.BLUEBERRY_BUSH.get(), "blueberry_stage_", "blueberry_");
    }

//Bushes
    public void makeBush(Block block, String modelName, String textureName) {
        getVariantBuilder(block).forAllStates(state -> {
         int age = state.getValue(SweetBerryBushBlock.AGE);

        ConfiguredModel model = new ConfiguredModel(
                models().cross(modelName + age,
                        ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "block/" + textureName + age)
                ).renderType("cutout")
        );

        return new ConfiguredModel[]{ model };
    });
}
//Crops
    public void makeCrop(CropBlock block, String modelName, String textureName) {
    Function<BlockState, ConfiguredModel[]> function = state -> {
        IntegerProperty ageProp = getAgeProperty(block);
        int age = state.getValue(ageProp);

        ConfiguredModel model = new ConfiguredModel(
                models().crop(modelName + age,
                        ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "block/" + textureName + age)
                ).renderType("cutout")
        );

        return new ConfiguredModel[]{ model };
    };

    getVariantBuilder(block).forAllStates(function);
}
    private IntegerProperty getAgeProperty(CropBlock block) {
        try {
            // Uses reflection to call getAgeProperty() on any subclass
            return (IntegerProperty) block.getClass().getMethod("getAgeProperty").invoke(block);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get age property for crop block: " + block, e);
        }
    }
//Lamp
    private void customLamp() {
        getVariantBuilder(ModBlocks.CRYSTAL_LANTERN_BLOCK.get()).forAllStates(state -> {
            if(state.getValue(CrystalLanternBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("crystal_lantern_block_on",
                        ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "block/" + "crystal_lantern_block_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("crystal_lantern_block_off",
                        ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "block/" + "crystal_lantern_block_off")))};
            }
        });

        simpleBlockItem(ModBlocks.CRYSTAL_LANTERN_BLOCK.get(), models().cubeAll("crystal_lantern_block_on",
                ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "block/" + "crystal_lantern_block_on")));
    }
 //Utils
    public void registerSimpleStoneSet(SimpleStoneSet set) {
        simpleBlock(set.getStone().get(), cubeAll(set.getStone().get()));
        blockItem(set.getStone());
        stairsBlock(set.getStairs().get(), blockTexture(set.getStone().get()));
        blockItem(set.getStairs());
        slabBlock(set.getSlab().get(), blockTexture(set.getStone().get()), blockTexture(set.getStone().get()));
        blockItem(set.getSlab());
        buttonBlock(set.getButton().get(), blockTexture(set.getStone().get()));
        pressurePlateBlock(set.getPressurePlate().get(), blockTexture(set.getStone().get()));
        blockItem(set.getPressurePlate());
        wallBlock(set.getWall().get(), blockTexture(set.getStone().get()));
        blockItem(set.getWall(), "_inventory");
    }
    public void registerWoodSet(WoodSet set) {
        logBlock((RotatedPillarBlock) set.getLog().get());
        axisBlock((RotatedPillarBlock) set.getWood().get(), blockTexture(set.getLog().get()), blockTexture(set.getLog().get()));
        logBlock((RotatedPillarBlock) set.getStrippedLog().get());
        axisBlock((RotatedPillarBlock) set.getStrippedWood().get(), blockTexture(set.getStrippedLog().get()), blockTexture(set.getStrippedLog().get()));
        blockItem(set.getLog());
        blockItem(set.getWood());
        blockItem(set.getStrippedLog());
        blockItem(set.getStrippedWood());
        blockWithItem(set.getPlanks());
        leavesBlock(set.getLeaves());
        saplingBlock(set.getSapling());
        stairsBlock(set.getStairs().get(), blockTexture(set.getPlanks().get()));
        slabBlock(set.getSlab().get(), blockTexture(set.getPlanks().get()), blockTexture(set.getPlanks().get()));
        buttonBlock(set.getButton().get(), blockTexture(set.getPlanks().get()));
        pressurePlateBlock(set.getPressurePlate().get(), blockTexture(set.getPlanks().get()));
        fenceBlock(set.getFence().get(), blockTexture(set.getPlanks().get()));
        fenceGateBlock(set.getFenceGate().get(), blockTexture(set.getPlanks().get()));
        doorBlockWithRenderType(set.getDoor().get(),
                modLoc("block/" + set.getName() + "_door_bottom"),
                modLoc("block/" + set.getName() + "_door_top"),
                "cutout");
        trapdoorBlockWithRenderType(set.getTrapdoor().get(),
                modLoc("block/" + set.getName() + "_trapdoor"),
                true,
                "cutout");
        blockItem(set.getStairs());
        blockItem(set.getSlab());
        blockItem(set.getPressurePlate());
        blockItem(set.getFenceGate());
        blockItem(set.getTrapdoor(), "_bottom");
        signBlock(((StandingSignBlock) set.getSign().get()), ((WallSignBlock) set.getWallSign().get()),
                blockTexture(set.planks.get()));
        hangingSignBlock(set.getHangingSign().get(), set.getWallHangingSign().get(),
                blockTexture(set.planks.get()));
    }
    public void registerNightmareWoodSet(WoodSet set) {
        logBlock((RotatedPillarBlock) set.getLog().get());
        axisBlock((RotatedPillarBlock) set.getWood().get(), blockTexture(set.getLog().get()), blockTexture(set.getLog().get()));
        logBlock((RotatedPillarBlock) set.getStrippedLog().get());
        axisBlock((RotatedPillarBlock) set.getStrippedWood().get(), blockTexture(set.getStrippedLog().get()), blockTexture(set.getStrippedLog().get()));
        blockItem(set.getLog());
        blockItem(set.getWood());
        blockItem(set.getStrippedLog());
        blockItem(set.getStrippedWood());
        blockWithItem(set.getPlanks());
        blockWithItem(set.getWartBlock());
        saplingBlock(set.getSapling());
        stairsBlock(set.getStairs().get(), blockTexture(set.getPlanks().get()));
        slabBlock(set.getSlab().get(), blockTexture(set.getPlanks().get()), blockTexture(set.getPlanks().get()));
        buttonBlock(set.getButton().get(), blockTexture(set.getPlanks().get()));
        pressurePlateBlock(set.getPressurePlate().get(), blockTexture(set.getPlanks().get()));
        fenceBlock(set.getFence().get(), blockTexture(set.getPlanks().get()));
        fenceGateBlock(set.getFenceGate().get(), blockTexture(set.getPlanks().get()));
        doorBlockWithRenderType(set.getDoor().get(),
                modLoc("block/" + set.getName() + "_door_bottom"),
                modLoc("block/" + set.getName() + "_door_top"),
                "cutout");
        trapdoorBlockWithRenderType(set.getTrapdoor().get(),
                modLoc("block/" + set.getName() + "_trapdoor"),
                true,
                "cutout");
        blockItem(set.getStairs());
        blockItem(set.getSlab());
        blockItem(set.getPressurePlate());
        blockItem(set.getFenceGate());
        blockItem(set.getTrapdoor(), "_bottom");
    }
    public void registerFullStoneSet(StoneSet set) {
        simpleBlockWithItem(set.getBase().get(), cubeAll(set.getBase().get()));
        simpleBlockWithItem(set.getCobbled().get(), cubeAll(set.getCobbled().get()));
        simpleBlockWithItem(set.getChiseled().get(), cubeAll(set.getChiseled().get()));
        simpleBlockWithItem(set.getBricks().get(), cubeAll(set.getBricks().get()));
        simpleBlockWithItem(set.getCrackedBricks().get(), cubeAll(set.getCrackedBricks().get()));
        simpleBlockWithItem(set.getSmooth().get(), cubeAll(set.getSmooth().get()));
        // Helper method for one stone variant
        Consumer<StoneVariant> registerVariant = variant -> {
            stairsBlock(variant.stairs.get(), blockTexture(variant.base.get()));
            slabBlock(variant.slab.get(), blockTexture(variant.base.get()), blockTexture(variant.base.get()));
            wallBlock(variant.wall.get(), blockTexture(variant.base.get()));
            buttonBlock(variant.button.get(), blockTexture(variant.base.get()));
            pressurePlateBlock(variant.pressurePlate.get(), blockTexture(variant.base.get()));

            // Register block items
            blockItem(variant.stairs);
            blockItem(variant.slab);
            blockItem(variant.wall, "_inventory");
            blockItem(variant.button, "_inventory");
            blockItem(variant.pressurePlate);
        };
        registerVariant.accept(new StoneVariant(set.getBase(), set.getStairs(), set.getSlab(), set.getWall(), set.getButton(), set.getPressurePlate()));
        registerVariant.accept(new StoneVariant(set.getCobbled(), set.getCobbledStairs(), set.getCobbledSlab(), set.getCobbledWall(), set.getCobbledButton(), set.getCobbledPressurePlate()));
        registerVariant.accept(new StoneVariant(set.getChiseled(), set.getChiseledStairs(), set.getChiseledSlab(), set.getChiseledWall(), set.getChiseledButton(), set.getChiseledPressurePlate()));
        registerVariant.accept(new StoneVariant(set.getBricks(), set.getBricksStairs(), set.getBricksSlab(), set.getBricksWall(), set.getBricksButton(), set.getBricksPressurePlate()));
        registerVariant.accept(new StoneVariant(set.getCrackedBricks(), set.getCrackedBricksStairs(), set.getCrackedBricksSlab(), set.getCrackedBricksWall(), set.getCrackedBricksButton(), set.getCrackedBricksPressurePlate()));
        registerVariant.accept(new StoneVariant(set.getSmooth(), set.getSmoothStairs(), set.getSmoothSlab(), set.getSmoothWall(), set.getSmoothButton(), set.getSmoothPressurePlate()));
    }
    private static class StoneVariant {
        public final DeferredBlock<Block> base;
        public final DeferredBlock<StairBlock> stairs;
        public final DeferredBlock<SlabBlock> slab;
        public final DeferredBlock<WallBlock> wall;
        public final DeferredBlock<ButtonBlock> button;
        public final DeferredBlock<PressurePlateBlock> pressurePlate;

        public StoneVariant(DeferredBlock<Block> base, DeferredBlock<StairBlock> stairs, DeferredBlock<SlabBlock> slab,
                            DeferredBlock<WallBlock> wall, DeferredBlock<ButtonBlock> button,
                            DeferredBlock<PressurePlateBlock> pressurePlate) {
            this.base = base;
            this.stairs = stairs;
            this.slab = slab;
            this.wall = wall;
            this.button = button;
            this.pressurePlate = pressurePlate;
        }
    }
    public void registerColorSet(ColorSet set) {
        blockWithItem(set.getConcrete());
        blockWithItem(set.getConcretePowder());
        blockWithItem(set.getTerracotta());
        blockWithItem(set.getGlazedTerracotta());
        blockWithItem(set.getWool());
        blockWithItem(set.getStainedGlass());

        glassPaneBlock(
                (StainedGlassPaneBlock) set.getStainedGlassPane().get(),
                blockTexture(set.getStainedGlass().get()),
                blockTexture(set.getStainedGlass().get())
        );
        blockItem(set.getStainedGlassPane(), "_inventory");

        simpleBlock(set.getCarpet().get(), models().carpet(set.getName() + "_carpet", blockTexture(set.getWool().get())));
        blockItem(set.getCarpet());
    }
    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
    public void glassPaneBlock(StainedGlassPaneBlock block, ResourceLocation paneTexture, ResourceLocation edgeTexture) {
        paneBlock(
                (IronBarsBlock) block,
                paneTexture,
                edgeTexture
        );
    }
    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("strawberry:block/" + deferredBlock.getId().getPath()));
    }
    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("strawberry:block/" + deferredBlock.getId().getPath() + appendix));
    }

    private void thuliteClusterBlock(DeferredBlock<Block> block, String parentModel) {
        String name = BuiltInRegistries.BLOCK.getKey(block.get()).getPath();
        ModelFile model = models().withExistingParent(name, mcLoc("block/" + parentModel))
                .texture("cross", modLoc("block/" + name))
                .renderType("cutout");

        getVariantBuilder(block.get()).forAllStates(state -> {
            Direction direction = state.getValue(AmethystClusterBlock.FACING);
            return ConfiguredModel.builder()
                    .modelFile(model)
                    .rotationX(getXRotation(direction))
                    .rotationY(getYRotation(direction))
                    .build();
        });
    }
    private int getXRotation(Direction direction) {
        return switch (direction) {
            case DOWN -> 180;
            case UP -> 0;
            default -> 90;
        };
    }
    private int getYRotation(Direction direction) {
        return switch (direction) {
            case NORTH -> 0;
            case SOUTH -> 180;
            case WEST -> 270;
            case EAST -> 90;
            default -> 0;
        };
    }

    public void randomTextureBlock(DeferredBlock<Block> block) {
        String name = block.getId().getPath();
        ModelFile model0 = models().cubeAll(name + "_0", modLoc("block/" + name + "_0"));
        ModelFile model1 = models().cubeAll(name + "_1", modLoc("block/" + name + "_1"));
        ModelFile model2 = models().cubeAll(name + "_2", modLoc("block/" + name + "_2"));
        ModelFile model3 = models().cubeAll(name + "_3", modLoc("block/" + name + "_3"));
        getVariantBuilder(block.get())
                .partialState().with(RandomTextureBlock.VARIANT, 0).modelForState().modelFile(model0).addModel()
                .partialState().with(RandomTextureBlock.VARIANT, 1).modelForState().modelFile(model1).addModel()
                .partialState().with(RandomTextureBlock.VARIANT, 2).modelForState().modelFile(model2).addModel()
                .partialState().with(RandomTextureBlock.VARIANT, 3).modelForState().modelFile(model3).addModel();

        // Item model → ALWAYS texture 3
        simpleBlockItem(block.get(), model3);
    }

    public void registerTorchSet(TorchSet set) {
        torchBlock((TorchBlock) set.torch.get(), modLoc("block/" + set.name + "_torch"));
        wallTorchBlock((WallTorchBlock) set.wallTorch.get(), modLoc("block/" + set.name + "_torch"));
        simpleBlockItem(set.torch.get(), models().singleTexture(set.name + "_torch", mcLoc("item/generated"), "layer0", modLoc("block/" + set.name + "_torch")));
        lanternBlock(set.lantern);
    }
    private void torchBlock(TorchBlock block, ResourceLocation texture) {
        String name = key(block).getPath();
        ModelFile model = models().torch(name, texture).renderType("cutout");
        simpleBlock(block, model);
    }

    private void wallTorchBlock(WallTorchBlock block, ResourceLocation texture) {
        String name = key(block).getPath();
        ModelFile model = models().torchWall(name, texture).renderType("cutout");

        getVariantBuilder(block).forAllStates(state -> {
            Direction direction = state.getValue(WallTorchBlock.FACING);
            return ConfiguredModel.builder()
                    .modelFile(model)
                    .rotationY(getYRotation(direction))
                    .build();
        });
    }

    public void lanternBlock(DeferredBlock<Block> block) {
        String name = block.getId().getPath();

        ModelFile standing = models().withExistingParent(name,
                        mcLoc("block/template_lantern"))
                .texture("lantern", modLoc("block/" + name));

        ModelFile hanging = models().withExistingParent(name + "_hanging",
                        mcLoc("block/template_hanging_lantern"))
                .texture("lantern", modLoc("block/" + name));

        getVariantBuilder(block.get())
                .partialState().with(BlockStateProperties.HANGING, false)
                .modelForState().modelFile(standing).addModel()
                .partialState().with(BlockStateProperties.HANGING, true)
                .modelForState().modelFile(hanging).addModel();

        itemModels().withExistingParent(name,
                        mcLoc("item/generated"))
                .texture("layer0", modLoc("item/" + name));
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }
    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }
    private String name(Block block) {
        return key(block).getPath();
    }
    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
}
