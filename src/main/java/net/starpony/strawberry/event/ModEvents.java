package net.starpony.strawberry.event;

import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.crafting.DataComponentIngredient;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.starpony.strawberry.Strawberry;
import net.starpony.strawberry.item.ModItems;
import net.starpony.strawberry.potion.ModPotions;

@EventBusSubscriber(modid = Strawberry.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {
    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.FIRE_RESISTANCE, Items.BLAZE_POWDER, ModPotions.DRAGONS_GRACE_POTION);
        builder.addRecipe(
                DataComponentIngredient.of(true, PotionContents.createItemStack(Items.POTION, Potions.WATER)),
                Ingredient.of(Items.LILY_OF_THE_VALLEY),
                new ItemStack(ModItems.VANILLA.get())
        );
    }

    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        if (event.getType() != VillagerProfession.FARMER) {
            return;
        }

        // Level 1 (Novice): Farmer sells seeds
        event.getTrades().get(1).add((entity, random) -> new net.minecraft.world.item.trading.MerchantOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModItems.CAULIFLOWER_SEEDS.get(), 12),
                16,
                2,
                0.05F
        ));
        event.getTrades().get(1).add((entity, random) -> new net.minecraft.world.item.trading.MerchantOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModItems.GRAPE_SEEDS.get(), 12),
                16,
                2,
                0.05F
        ));
        event.getTrades().get(1).add((entity, random) -> new net.minecraft.world.item.trading.MerchantOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModItems.CORN_SEEDS.get(), 12),
                16,
                2,
                0.05F
        ));

        // Level 2 (Apprentice): Farmer buys produce
        event.getTrades().get(2).add(new VillagerTrades.EmeraldForItems(ModItems.CAULIFLOWER.get(), 20, 16, 5));
        event.getTrades().get(2).add(new VillagerTrades.EmeraldForItems(ModItems.GRAPES.get(), 20, 16, 5));
        event.getTrades().get(2).add(new VillagerTrades.EmeraldForItems(ModItems.CORN.get(), 20, 16, 5));
    }
}
