package net.starpony.strawberry.item.custom;

import com.google.common.collect.ImmutableMap;
import net.starpony.strawberry.effect.ModEffects;
import net.starpony.strawberry.item.ModArmorMaterials;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {

  /*  private static final Map<Holder<ArmorMaterial>, List<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<Holder<ArmorMaterial>, List<MobEffectInstance>>())
                    .put(ModArmorMaterials.RUBY_ARMOR_MATERIAL,
                            List.of(
                                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 2, false, false),
                                    new MobEffectInstance(ModEffects.DRAGONS_GRACE, 400, 2, false, false)
                            ))
                    .put(ModArmorMaterials.SAPPHIRE_ARMOR_MATERIAL,
                            List.of(
                                    new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 400, 1, false, false),
                                    new MobEffectInstance(MobEffects.WATER_BREATHING, 400, 1, false, false)
                            ))
                    .build(); */

    public ModArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

  /*  @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof Player player && !level.isClientSide() && hasFullSuitOfArmorOn(player)) {
            evaluateArmorEffects(player);
        }
    }*/

   /* private void evaluateArmorEffects(Player player) {
        for (Map.Entry<Holder<ArmorMaterial>, List<MobEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            Holder<ArmorMaterial> material = entry.getKey();
            List<MobEffectInstance> effects = entry.getValue();

            if (hasPlayerCorrectArmorOn(material, player)) {
                addEffectsToPlayer(player, effects);
            }
        }
    }*/

    private void addEffectsToPlayer(Player player, List<MobEffectInstance> effects) {
        boolean hasAllEffects = effects.stream().allMatch(effect -> player.hasEffect(effect.getEffect()));
        if (!hasAllEffects) {
            for (MobEffectInstance effect : effects) {
                player.addEffect(new MobEffectInstance(
                        effect.getEffect(),
                        effect.getDuration(),
                        effect.getAmplifier(),
                        effect.isAmbient(),
                        effect.isVisible()
                ));
            }
        }
    }

    private boolean hasPlayerCorrectArmorOn(Holder<ArmorMaterial> material, Player player) {
        for (ItemStack stack : player.getArmorSlots()) {
            if (!(stack.getItem() instanceof ArmorItem)) return false;
        }

        ArmorItem boots = (ArmorItem) player.getInventory().getArmor(0).getItem();
        ArmorItem leggings = (ArmorItem) player.getInventory().getArmor(1).getItem();
        ArmorItem chestplate = (ArmorItem) player.getInventory().getArmor(2).getItem();
        ArmorItem helmet = (ArmorItem) player.getInventory().getArmor(3).getItem();

        return boots.getMaterial() == material
                && leggings.getMaterial() == material
                && chestplate.getMaterial() == material
                && helmet.getMaterial() == material;
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        return !player.getInventory().getArmor(0).isEmpty()
                && !player.getInventory().getArmor(1).isEmpty()
                && !player.getInventory().getArmor(2).isEmpty()
                && !player.getInventory().getArmor(3).isEmpty();
    }
}
