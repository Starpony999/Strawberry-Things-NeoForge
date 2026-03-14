package net.starpony.strawberry.item.custom;


import net.minecraft.world.item.Item;
import net.starpony.strawberry.item.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;


public class SodaItem extends Item {

    public SodaItem(Properties properties) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack result = super.finishUsingItem(stack, level, entity);

        if (result.isEmpty() && entity instanceof Player) {
            return new ItemStack(ModItems.SODA_CAN.get());
        }

        return result;
    }
}