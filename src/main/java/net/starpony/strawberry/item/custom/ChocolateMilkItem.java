package net.starpony.strawberry.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MilkBucketItem;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public class ChocolateMilkItem extends MilkBucketItem {
    public ChocolateMilkItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack result = super.finishUsingItem(stack, level, entity);

        if (!level.isClientSide) {
            List<MobEffectInstance> toRemove = new ArrayList<>();
            for (MobEffectInstance effect : entity.getActiveEffects()) {
                if (effect.getEffect().value().getCategory() == MobEffectCategory.HARMFUL) {
                    toRemove.add(effect);
                }
            }
            for (MobEffectInstance effect : toRemove) {
                entity.removeEffect(effect.getEffect());
            }
        }

        if (result.isEmpty() && entity instanceof Player) {
            return new ItemStack(Items.BUCKET);
        }

        return result;
    }
}
