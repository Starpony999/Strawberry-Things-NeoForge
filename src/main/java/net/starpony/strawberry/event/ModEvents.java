package net.starpony.strawberry.event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.starpony.strawberry.item.ModItems;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.starpony.strawberry.Strawberry;
import net.starpony.strawberry.potion.ModPotions;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.crafting.DataComponentIngredient;

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
}
