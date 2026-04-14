package net.starpony.strawberry.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.*;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.fml.common.Mod;
import net.starpony.strawberry.block.*;
import net.starpony.strawberry.item.ModItems;
import net.starpony.strawberry.util.sets.ColorSet;
import net.starpony.strawberry.util.sets.SimpleStoneSet;
import net.starpony.strawberry.util.sets.StoneSet;
import net.starpony.strawberry.util.sets.WoodSet;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        HolderLookup.RegistryLookup<Enchantment> enchants =
                this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        dropSelf(ModBlocks.ALUMINUM_BLOCK.get());
        dropSelf(ModBlocks.RUBY_BLOCK.get());
        dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        dropSelf(ModBlocks.RAW_ALUMINUM_BLOCK.get());
        dropSelf(ModBlocks.THULITE_CRYSTAL_BLOCK.get());
        dropSelf(ModBlocks.OTHERWORLDLY_AMETHYST_BLOCK.get());
        dropSelf(ModBlocks.RAW_ROSE_QUARTZ_BLOCK.get());
        dropSelf(ModBlocks.ROSE_QUARTZ_BLOCK.get());

        dropSelf(ModBlocks.CRYSTAL_LANTERN_BLOCK.get());
        dropSelf(ModBlocks.REDSTONE_LANTERN.get());
        dropSelf(ModBlocks.CRYSTAL.lantern.get());
        dropSelf(ModBlocks.THULITE.lantern.get());

        dropSelf(ModBlocks.NIGHT_TERRIA.get());
        dropSelf(ModBlocks.GNEISS.get());
        dropSelf(ModBlocks.SCHIST.get());

        this.add(ModBlocks.BUDDING_THULITE_CRYSTAL_BLOCK.get(), noDrop());

        add(ModBlocks.RUBY_ORE.get(), block -> createOreDrop(block, ModItems.RUBY.getGem().get()));
        add(ModBlocks.DEEPSLATE_RUBY_ORE.get(), block -> createOreDrop(block, ModItems.RUBY.getGem().get()));
        add(ModBlocks.SAPPHIRE_ORE.get(), block -> createOreDrop(block, ModItems.SAPPHIRE.getGem().get()));
        add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), block -> createOreDrop(block, ModItems.SAPPHIRE.getGem().get()));
        add(ModBlocks.ROSE_QUARTZ_ORE.get(), block -> createOreDrop(block, ModItems.RAW_ROSE_QUARTZ.get()));
        add(ModBlocks.END_ROSE_QUARTZ_ORE.get(), block -> createOreDrop(block, ModItems.RAW_ROSE_QUARTZ.get()));
        add(ModBlocks.ENDERTHYST_ORE.get(), block -> createOreDrop(block, ModItems.ENDERTHYST.get()));
        add(ModBlocks.NETHERTHYST_ORE.get(), block -> createOreDrop(block, ModItems.NETHERTHYST.get()));
        add(ModBlocks.DEEPSLATE_ALUMINUM_ORE.get(), block -> createMultipleOreDrops(block, ModItems.ALUMINUM_SCRAP.get(), 3, 5));
        add(ModBlocks.ALUMINUM_ORE.get(), block -> createMultipleOreDrops(block, ModItems.ALUMINUM_SCRAP.get(), 3, 5));

        handleSimpleStoneSet(ModBlocks.WASHED_ANDESITE_BRICKS);
        handleSimpleStoneSet(ModBlocks.ANDESITE_BRICKS);
        handleSimpleStoneSet(ModBlocks.WASHED_DIORITE_BRICKS);
        handleSimpleStoneSet(ModBlocks.DIORITE_BRICKS);
        handleSimpleStoneSet(ModBlocks.WASHED_GRANITE_BRICKS);
        handleSimpleStoneSet(ModBlocks.GRANITE_BRICKS);

        handleStoneSet(ModBlocks.GRIMSTONE);
        handleStoneSet(ModBlocks.NIGHTSTONE);

        handleSimpleStoneSet(ModBlocks.WASHED_COBBLESTONE);
        handleSimpleStoneSet(ModBlocks.WASHED_COBBLESTONE_BRICKS);
        handleSimpleStoneSet(ModBlocks.WEATHERED_COBBLESTONE);
        handleSimpleStoneSet(ModBlocks.WEATHERED_COBBLESTONE_BRICKS);
        handleSimpleStoneSet(ModBlocks.AGED_COBBLESTONE);
        handleSimpleStoneSet(ModBlocks.AGED_COBBLESTONE_BRICKS);
        handleSimpleStoneSet(ModBlocks.EXPOSED_COBBLESTONE);
        handleSimpleStoneSet(ModBlocks.EXPOSED_COBBLESTONE_BRICKS);
        handleSimpleStoneSet(ModBlocks.SEALED_COBBLESTONE);
        handleSimpleStoneSet(ModBlocks.SEALED_WASHED_COBBLESTONE);
        handleSimpleStoneSet(ModBlocks.SEALED_EXPOSED_COBBLESTONE);
        handleSimpleStoneSet(ModBlocks.SEALED_WEATHERED_COBBLESTONE);
        handleSimpleStoneSet(ModBlocks.SEALED_AGED_COBBLESTONE);
        handleSimpleStoneSet(ModBlocks.SEALED_WASHED_COBBLESTONE_BRICKS);
        handleSimpleStoneSet(ModBlocks.SEALED_EXPOSED_COBBLESTONE_BRICKS);
        handleSimpleStoneSet(ModBlocks.SEALED_WEATHERED_COBBLESTONE_BRICKS);
        handleSimpleStoneSet(ModBlocks.SEALED_AGED_COBBLESTONE_BRICKS);

        handleColorSet(ModBlocks.CERISE);
        handleColorSet(ModBlocks.TURQUOISE);
        handleColorSet(ModBlocks.LAVENDER);
        handleColorSet(ModBlocks.INDIGO);

        handleWoodSet(ModBlocks.SYCAMORE);
        handleWoodSet(ModBlocks.PLUM);
        handleNightmareWoodSet(ModBlocks.BLOODWOOD);
        handleNightmareWoodSet(ModBlocks.VOID);
        this.dropSelf(ModBlocks.HELLSHROOM_LIGHT.get());

        this.add(ModBlocks.THULITE_CLUSTER.get(), block -> this.createSilkTouchDispatchTable(block, LootItem.lootTableItem(ModItems.THULITE_SHARD).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))).apply(ApplyBonusCount.addUniformBonusCount(enchants.getOrThrow(Enchantments.FORTUNE))).when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTags.CLUSTER_MAX_HARVESTABLES))).otherwise((LootPoolEntryContainer.Builder<?>)this.applyExplosionDecay(block, LootItem.lootTableItem(ModItems.THULITE_SHARD).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))))));
        this.dropWhenSilkTouch(ModBlocks.SMALL_THULITE_BUD.get());
        this.dropWhenSilkTouch(ModBlocks.MEDIUM_THULITE_BUD.get());
        this.dropWhenSilkTouch(ModBlocks.LARGE_THULITE_BUD.get());

        this.add(ModBlocks.CAULIFLOWER_CROP.get(), createCropDrops(ModBlocks.CAULIFLOWER_CROP.get(), ModItems.CAULIFLOWER.get(), ModItems.CAULIFLOWER_SEEDS.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CAULIFLOWER_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CauliflowerCropBlock.AGE, CauliflowerCropBlock.MAX_AGE))));
        this.add(ModBlocks.GRAPE_CROP.get(), createCropDrops(ModBlocks.GRAPE_CROP.get(), ModItems.GRAPES.get(), ModItems.GRAPE_SEEDS.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GRAPE_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GrapeCropBlock.AGE, GrapeCropBlock.MAX_AGE))));
        this.add(ModBlocks.CORN_CROP.get(), createCropDrops(ModBlocks.CORN_CROP.get(), ModItems.CORN.get(), ModItems.CORN_SEEDS.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CORN_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, CornCropBlock.MAX_AGE))));

        addBerryBush(ModBlocks.STRAWBERRY_BUSH.get(), ModItems.STRAWBERRY.get(), StrawberryBushBlock.AGE, enchants);
        addBerryBush(ModBlocks.BLUEBERRY_BUSH.get(), ModItems.BLUEBERRY.get(), BlueberryBushBlock.AGE, enchants);
    }

    /*
     * =========================
     * HELPERS
     * =========================
     */

    private void handleSimpleStoneSet(SimpleStoneSet set) {
        dropSelf(set.getStone().get());
        dropSelf(set.getWall().get());
        dropSelf(set.getStairs().get());
        dropSelf(set.getButton().get());
        dropSelf(set.getPressurePlate().get());

        add(set.getSlab().get(),
                block -> createSlabItemTable(set.getSlab().get()));
    }
    private void handleStoneSet(StoneSet set) {
        // ===== BASE =====
        dropSelf(set.getBase().get());
        dropSelf(set.getStairs().get());
        add(set.getSlab().get(), block -> createSlabItemTable(set.getSlab().get()));
        dropSelf(set.getWall().get());
        dropSelf(set.getButton().get());
        dropSelf(set.getPressurePlate().get());

        // ===== COBBLED =====
        dropSelf(set.getCobbled().get());
        dropSelf(set.getCobbledStairs().get());
        add(set.getCobbledSlab().get(), block -> createSlabItemTable(set.getCobbledSlab().get()));
        dropSelf(set.getCobbledWall().get());
        dropSelf(set.getCobbledButton().get());
        dropSelf(set.getCobbledPressurePlate().get());

        // ===== CHISELED =====
        dropSelf(set.getChiseled().get());
        dropSelf(set.getChiseledStairs().get());
        add(set.getChiseledSlab().get(), block -> createSlabItemTable(set.getChiseledSlab().get()));
        dropSelf(set.getChiseledWall().get());
        dropSelf(set.getChiseledButton().get());
        dropSelf(set.getChiseledPressurePlate().get());

        // ===== BRICKS =====
        dropSelf(set.getBricks().get());
        dropSelf(set.getBricksStairs().get());
        add(set.getBricksSlab().get(), block -> createSlabItemTable(set.getBricksSlab().get()));
        dropSelf(set.getBricksWall().get());
        dropSelf(set.getBricksButton().get());
        dropSelf(set.getBricksPressurePlate().get());

        // ===== CRACKED BRICKS =====
        dropSelf(set.getCrackedBricks().get());
        dropSelf(set.getCrackedBricksStairs().get());
        add(set.getCrackedBricksSlab().get(), block -> createSlabItemTable(set.getCrackedBricksSlab().get()));
        dropSelf(set.getCrackedBricksWall().get());
        dropSelf(set.getCrackedBricksButton().get());
        dropSelf(set.getCrackedBricksPressurePlate().get());

        // ===== SMOOTH =====
        dropSelf(set.getSmooth().get());
        dropSelf(set.getSmoothStairs().get());
        add(set.getSmoothSlab().get(), block -> createSlabItemTable(set.getSmoothSlab().get()));
        dropSelf(set.getSmoothWall().get());
        dropSelf(set.getSmoothButton().get());
        dropSelf(set.getSmoothPressurePlate().get());
    }
    private void handleWoodSet(WoodSet set) {
        dropSelf(set.getLog().get());
        dropSelf(set.getWood().get());
        dropSelf(set.getPlanks().get());
        dropSelf(set.getStrippedLog().get());
        dropSelf(set.getStrippedWood().get());
        dropSelf(set.getSapling().get());

        add(set.getLeaves().get(),
                block -> createLeavesDrops(block, set.getSapling().get(), NORMAL_LEAVES_SAPLING_CHANCES));

        dropSelf(set.getStairs().get());
        dropSelf(set.getButton().get());
        dropSelf(set.getPressurePlate().get());
        dropSelf(set.getFence().get());
        dropSelf(set.getFenceGate().get());
        dropSelf(set.getTrapdoor().get());

        add(set.getSlab().get(),
                block -> createSlabItemTable(set.getSlab().get()));

        add(set.getDoor().get(),
                block -> createDoorTable(set.getDoor().get()));

        add(set.sign.get(), block ->
                createSingleItemTable(set.getSignItem().get()));
        add(set.wallSign.get(), block ->
                createSingleItemTable(set.getSignItem().get()));
        add(set.hangingSign.get(), block ->
                createSingleItemTable(set.getHangingSignItem().get()));
        add(set.wallHangingSign.get(), block ->
                createSingleItemTable(set.getHangingSignItem().get()));
    }
    private void handleNightmareWoodSet(WoodSet set) {
        dropSelf(set.getLog().get());
        dropSelf(set.getWood().get());
        dropSelf(set.getStrippedLog().get());
        dropSelf(set.getStrippedWood().get());
        dropSelf(set.getPlanks().get());
        dropSelf(set.getSapling().get());
        dropSelf(set.getWartBlock().get());
        dropSelf(set.getStairs().get());
        dropSelf(set.getButton().get());
        dropSelf(set.getPressurePlate().get());
        dropSelf(set.getFence().get());
        dropSelf(set.getFenceGate().get());
        dropSelf(set.getTrapdoor().get());

        add(set.getSlab().get(),
                block -> createSlabItemTable(set.getSlab().get()));

        add(set.getDoor().get(),
                block -> createDoorTable(set.getDoor().get()));
        add(set.sign.get(), block ->
                createSingleItemTable(set.getSignItem().get()));
        add(set.wallSign.get(), block ->
                createSingleItemTable(set.getSignItem().get()));
        add(set.hangingSign.get(), block ->
                createSingleItemTable(set.getHangingSignItem().get()));
        add(set.wallHangingSign.get(), block ->
                createSingleItemTable(set.getHangingSignItem().get()));
    }
    private void handleColorSet (ColorSet set){
        dropSelf(set.getCarpet().get());
        dropSelf(set.getConcrete().get());
        dropSelf(set.getConcretePowder().get());
        dropSelf(set.getTerracotta().get());
        dropSelf(set.getGlazedTerracotta().get());
        dropSelf(set.getWool().get());
        dropWhenSilkTouch(set.getStainedGlassPane().get());
        dropWhenSilkTouch(set.getStainedGlass().get());
    }
    private void addBerryBush(Block block, Item berry, net.minecraft.world.level.block.state.properties.IntegerProperty ageProperty, HolderLookup.RegistryLookup<Enchantment> enchants) {

        this.add(block, b -> applyExplosionDecay(b,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ageProperty, 3)))
                                .add(LootItem.lootTableItem(berry))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 3)))
                                .apply(ApplyBonusCount.addUniformBonusCount(enchants.getOrThrow(Enchantments.FORTUNE))))
                        .withPool(LootPool.lootPool()
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ageProperty, 2)))
                                .add(LootItem.lootTableItem(berry))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                                .apply(ApplyBonusCount.addUniformBonusCount(enchants.getOrThrow(Enchantments.FORTUNE))))
        ));
    }
    protected LootTable.Builder createMultipleOreDrops(Block block, Item item, float min, float max) {
        HolderLookup.RegistryLookup<Enchantment> enchants =
                this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        return createSilkTouchDispatchTable(block,
                applyExplosionDecay(block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                .apply(ApplyBonusCount.addOreBonusCount(enchants.getOrThrow(Enchantments.FORTUNE)))
                ));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
