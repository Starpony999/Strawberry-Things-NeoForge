package net.starpony.strawberry.datagen;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.*;
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

        registerWoodSet(ModBlocks.SYCAMORE);
        registerWoodSet(ModBlocks.PLUM);
        registerNightmareWoodSet(ModBlocks.BLOODWOOD);

        registerFullStoneSet(ModBlocks.NIGHTSTONE);
        registerFullStoneSet(ModBlocks.GRIMSTONE);

        registerColorSet(ModBlocks.CERISE);
        registerColorSet(ModBlocks.TURQUOISE);
        registerColorSet(ModBlocks.LAVENDER);
        registerColorSet(ModBlocks.INDIGO);

        customLamp();

        makeCrop(((CropBlock) ModBlocks.CAULIFLOWER_CROP.get()), "cauliflower_crop_stage", "cauliflower_crop_stage");
        makeCrop(((CropBlock) ModBlocks.GRAPE_CROP.get()), "grape_crop_stage", "grape_crop_stage");
        makeBush(((SweetBerryBushBlock) ModBlocks.STRAWBERRY_BUSH.get()), "strawberry_bush_stage", "strawberry_bush_stage");
        makeBush(((SweetBerryBushBlock) ModBlocks.BLUEBERRY_BUSH.get()), "blueberry_bush_stage", "blueberry_bush_stage");
    }

//Bushes
    public void makeBush(SweetBerryBushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] states(BlockState state, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(StrawberryBushBlock.AGE),
                ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "block/" + textureName + state.getValue(StrawberryBushBlock.AGE))).renderType("cutout"));
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(BlueberryBushBlock.AGE),
                ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "block/" + textureName + state.getValue(BlueberryBushBlock.AGE))).renderType("cutout"));
        return models;
    }
//Crops
    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CauliflowerCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "block/" + textureName + state.getValue(((CauliflowerCropBlock) block).getAgeProperty()))).renderType("cutout"));
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((GrapeCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "block/" + textureName + state.getValue(((GrapeCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
//Lamp
    private void customLamp() {
        getVariantBuilder(ModBlocks.CRYSTAL_LANTERN_BLOCK.get()).forAllStates(state -> {
            if(state.getValue(CrystalLanternBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("crystal_lantern_on",
                        ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "block/" + "crystal_lantern_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("crystal_lantern_off",
                        ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "block/" + "crystal_lantern_off")))};
            }
        });

        simpleBlockItem(ModBlocks.CRYSTAL_LANTERN_BLOCK.get(), models().cubeAll("crystal_lantern_on",
                ResourceLocation.fromNamespaceAndPath(Strawberry.MOD_ID, "block/" + "crystal_lantern_on")));
    }
 //Utils
    public void registerSimpleStoneSet(SimpleStoneSet set) {
        blockItem(set.getStone());
        stairsBlock(set.getStairs().get(), blockTexture(set.getStone().get()));
        blockItem(set.getStairs());
        slabBlock(set.getSlab().get(), blockTexture(set.getStone().get()), blockTexture(set.getStone().get()));
        blockItem(set.getSlab());
        buttonBlock(set.getButton().get(), blockTexture(set.getStone().get()));
        pressurePlateBlock(set.getPressurePlate().get(), blockTexture(set.getStone().get()));
        blockItem(set.getPressurePlate());
        wallBlock(set.getWall().get(), blockTexture(set.getStone().get()));
        blockItem(set.getWall());
    }
    public void registerWoodSet(WoodSet set) {
        // Logs & Wood
        logBlock((RotatedPillarBlock) set.getLog().get());
        axisBlock((RotatedPillarBlock) set.getWood().get(), blockTexture(set.getLog().get()), blockTexture(set.getLog().get()));

        logBlock((RotatedPillarBlock) set.getStrippedLog().get());
        axisBlock((RotatedPillarBlock) set.getStrippedWood().get(), blockTexture(set.getStrippedLog().get()), blockTexture(set.getStrippedLog().get()));

        blockItem(set.getLog());
        blockItem(set.getWood());
        blockItem(set.getStrippedLog());
        blockItem(set.getStrippedWood());

        // Planks
        blockWithItem(set.getPlanks());

        // Leaves & Saplings
        leavesBlock(set.getLeaves());
        saplingBlock(set.getSapling());

        // Stairs, Slabs, Buttons, Pressure Plates
        stairsBlock(set.getStairs().get(), blockTexture(set.getPlanks().get()));
        slabBlock(set.getSlab().get(), blockTexture(set.getPlanks().get()), blockTexture(set.getPlanks().get()));
        buttonBlock(set.getButton().get(), blockTexture(set.getPlanks().get()));
        pressurePlateBlock(set.getPressurePlate().get(), blockTexture(set.getPlanks().get()));

        // Fences & Gates
        fenceBlock(set.getFence().get(), blockTexture(set.getPlanks().get()));
        fenceGateBlock(set.getFenceGate().get(), blockTexture(set.getPlanks().get()));

        // Doors & Trapdoors
        doorBlockWithRenderType(set.getDoor().get(),
                modLoc("block/" + set.getName() + "_door_bottom"),
                modLoc("block/" + set.getName() + "_door_top"),
                "cutout");

        trapdoorBlockWithRenderType(set.getTrapdoor().get(),
                modLoc("block/" + set.getName() + "_trapdoor"),
                true,
                "cutout");

        // Block Items for all interactive blocks
        blockItem(set.getStairs());
        blockItem(set.getSlab());
        blockItem(set.getPressurePlate());
        blockItem(set.getFenceGate());
        blockItem(set.getTrapdoor(), "_bottom");
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
            blockItem(variant.wall);
            blockItem(variant.button);
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
        // Solid blocks
        blockItem(set.getConcrete());
        blockItem(set.getConcretePowder());
        blockItem(set.getTerracotta());
        blockItem(set.getGlazedTerracotta());
        blockItem(set.getWool());

        // Stained glass
        blockItem(set.getStainedGlass());
        glassPaneBlock(
                set.getStainedGlassPane().get(),
                set.getName() + "_stained_glass_pane", // registry name as string
                blockTexture(set.getStainedGlass().get()),      // pane texture
                modLoc("block/" + set.getName() + "_stained_glass_pane_top") // edge texture
        );
        simpleBlock(set.getCarpet().get(), models().carpet(set.getName() + "_carpet", blockTexture(set.getWool().get())));
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
    public void glassPaneBlock(StainedGlassPaneBlock block, String name, ResourceLocation paneTexture, ResourceLocation edgeTexture) {
        ModelFile noSide = this.models().withExistingParent(name + "_noside", modLoc("block/template_glass_pane_noside"))
                .texture("pane", paneTexture);
        ModelFile noSideAlt = this.models().withExistingParent(name + "_noside_alt", modLoc("block/template_glass_pane_noside_alt"))
                .texture("pane", paneTexture);
        ModelFile post = this.models().withExistingParent(name + "_post", modLoc("block/template_glass_pane_post"))
                .texture("pane", paneTexture)
                .texture("edge", edgeTexture);
        ModelFile side = this.models().withExistingParent(name + "_side", modLoc("block/template_glass_pane_side"))
                .texture("pane", paneTexture)
                .texture("edge", edgeTexture);
        ModelFile sideAlt = this.models().withExistingParent(name + "_side_alt", modLoc("block/template_glass_pane_side_alt"))
                .texture("pane", paneTexture)
                .texture("edge", edgeTexture);

        MultiPartBlockStateBuilder builder = getMultipartBuilder(block);
        builder.part().modelFile(post).addModel().end();

        for (Direction dir : Direction.Plane.HORIZONTAL) {
            boolean alt = dir == Direction.SOUTH;

            builder.part()
                    .modelFile(!alt && dir != Direction.WEST ? side : sideAlt)
                    .rotationY(dir.getAxis() == Direction.Axis.X ? 90 : 0)
                    .addModel()
                    .condition(PipeBlock.PROPERTY_BY_DIRECTION.get(dir), true)
                    .end();

            builder.part()
                    .modelFile(!alt && dir != Direction.EAST ? noSide : noSideAlt)
                    .rotationY(dir == Direction.WEST ? 270 : (dir == Direction.SOUTH ? 90 : 0))
                    .addModel()
                    .condition(PipeBlock.PROPERTY_BY_DIRECTION.get(dir), false)
                    .end();
        }
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
}