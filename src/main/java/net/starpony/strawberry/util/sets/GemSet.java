package net.starpony.strawberry.util.sets;

import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;

public class GemSet {

    private final String name;

    private final DeferredItem<Item> gem;
    private final DeferredItem<Item> shard;

    private final DeferredItem<Item> hoe;
    private final DeferredItem<Item> axe;
    private final DeferredItem<Item> pickaxe;
    private final DeferredItem<Item> sword;
    private final DeferredItem<Item> shovel;

    private final DeferredItem<ArmorItem> helmet;
    private final DeferredItem<ArmorItem> chestplate;
    private final DeferredItem<ArmorItem> leggings;
    private final DeferredItem<ArmorItem> boots;
    private final DeferredItem<ArmorItem> horseArmor;

    public GemSet(
            String name,
            DeferredItem<Item> gem,
            DeferredItem<Item> shard,
            DeferredItem<Item> hoe,
            DeferredItem<Item> axe,
            DeferredItem<Item> pickaxe,
            DeferredItem<Item> sword,
            DeferredItem<Item> shovel,
            DeferredItem<ArmorItem> helmet,
            DeferredItem<ArmorItem> chestplate,
            DeferredItem<ArmorItem> leggings,
            DeferredItem<ArmorItem> boots,
            DeferredItem<ArmorItem> horseArmor
    ) {
        this.name = name;

        this.gem = gem;
        this.shard = shard;

        this.hoe = hoe;
        this.axe = axe;
        this.pickaxe = pickaxe;
        this.sword = sword;
        this.shovel = shovel;

        this.helmet = helmet;
        this.chestplate = chestplate;
        this.leggings = leggings;
        this.boots = boots;
        this.horseArmor = horseArmor;
    }

    public String getName() {
        return name;
    }

    public DeferredItem<Item> getGem() {
        return gem;
    }

    public DeferredItem<Item> getShard() {
        return shard;
    }

    public DeferredItem<Item> getHoe() {
        return hoe;
    }

    public DeferredItem<Item> getAxe() {
        return axe;
    }

    public DeferredItem<Item> getPickaxe() {
        return pickaxe;
    }

    public DeferredItem<Item> getSword() {
        return sword;
    }

    public DeferredItem<Item> getShovel() {
        return shovel;
    }

    public DeferredItem<ArmorItem> getHelmet() {
        return helmet;
    }

    public DeferredItem<ArmorItem> getChestplate() {
        return chestplate;
    }

    public DeferredItem<ArmorItem> getLeggings() {
        return leggings;
    }

    public DeferredItem<ArmorItem> getBoots() {
        return boots;
    }

    public DeferredItem<ArmorItem> getHorseArmor() {
        return horseArmor;
    }
}
