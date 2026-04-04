package net.starpony.strawberry.util.sets;

import net.minecraft.world.item.Item;

public class VanillaGemSet {

    private final String name;

    private final Item gem;
    private final Item shard;

    private final Item hoe;
    private final Item axe;
    private final Item pickaxe;
    private final Item sword;
    private final Item shovel;

    private final Item helmet;
    private final Item chestplate;
    private final Item leggings;
    private final Item boots;
    private final Item horseArmor;

    public VanillaGemSet(
            String name,
            Item gem,
            Item shard,
            Item hoe,
            Item axe,
            Item pickaxe,
            Item sword,
            Item shovel,
            Item helmet,
            Item chestplate,
            Item leggings,
            Item boots,
            Item horseArmor
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

    public Item getGem() {
        return gem;
    }

    public Item getShard() {
        return shard;
    }

    public Item getHoe() {
        return hoe;
    }

    public Item getAxe() {
        return axe;
    }

    public Item getPickaxe() {
        return pickaxe;
    }

    public Item getSword() {
        return sword;
    }

    public Item getShovel() {
        return shovel;
    }

    public Item getHelmet() {
        return helmet;
    }

    public Item getChestplate() {
        return chestplate;
    }

    public Item getLeggings() {
        return leggings;
    }

    public Item getBoots() {
        return boots;
    }

    public Item getHorseArmor() {
        return horseArmor;
    }
}
