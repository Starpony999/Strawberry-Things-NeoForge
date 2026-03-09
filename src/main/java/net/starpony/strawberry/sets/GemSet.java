package net.starpony.strawberry.sets;

import net.minecraft.world.item.Item;
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

    private final DeferredItem<Item> helmet;
    private final DeferredItem<Item> chestplate;
    private final DeferredItem<Item> leggings;
    private final DeferredItem<Item> boots;
    private final DeferredItem<Item> horseArmor;

    public GemSet(
            String name,
            DeferredItem<Item> gem,
            DeferredItem<Item> shard,
            DeferredItem<Item> hoe,
            DeferredItem<Item> axe,
            DeferredItem<Item> pickaxe,
            DeferredItem<Item> sword,
            DeferredItem<Item> shovel,
            DeferredItem<Item> helmet,
            DeferredItem<Item> chestplate,
            DeferredItem<Item> leggings,
            DeferredItem<Item> boots,
            DeferredItem<Item> horseArmor
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

    public DeferredItem<Item> getHelmet() {
        return helmet;
    }

    public DeferredItem<Item> getChestplate() {
        return chestplate;
    }

    public DeferredItem<Item> getLeggings() {
        return leggings;
    }

    public DeferredItem<Item> getBoots() {
        return boots;
    }

    public DeferredItem<Item> getHorseArmor() {
        return horseArmor;
    }
}
