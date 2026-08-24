package net.starpony.strawberry.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.fml.common.asm.enumextension.*;
import net.starpony.strawberry.block.ModBlocks;
import net.starpony.strawberry.item.ModItems;

import java.util.function.IntFunction;
import java.util.function.Supplier;

public class ModBoatEntity extends Boat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(ModBoatEntity.class, EntityDataSerializers.INT);

    public ModBoatEntity(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level);
    }

    public ModBoatEntity(Level level, double pX, double pY, double pZ) {
        this(ModEntities.MOD_BOAT.get(), level);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    @Override
    public Item getDropItem() {
        return switch (getModVariant()) {
            case SYCAMORE -> ModItems.SYCAMORE.getBoat().get();
            case PLUM -> ModItems.PLUM.getBoat().get();
            case BLOODWOOD -> ModItems.BLOODWOOD.getBoat().get();
            case VOID -> ModItems.VOID.getBoat().get();
        };
    }

    public void setVariant(Type pVariant) {
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }

    public Type getModVariant() {
        return Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_TYPE, Type.SYCAMORE.ordinal());
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("Type", this.getModVariant().getSerializedName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setVariant(Type.byName(pCompound.getString("Type")));
        }
    }
    @NetworkedEnum(NetworkedEnum.NetworkCheck.CLIENTBOUND)
    @NamedEnum(1)
    public static enum Type implements StringRepresentable, IExtensibleEnum {
        SYCAMORE(() -> ModBlocks.SYCAMORE.planks.get(), "sycamore"),
        PLUM(() -> ModBlocks.PLUM.planks.get(), "plum"),
        BLOODWOOD(() -> ModBlocks.BLOODWOOD.planks.get(), "bloodwood"),
        VOID(() -> ModBlocks.VOID.planks.get(), "void");


        private final String name;
        /** @deprecated */
        @Deprecated
        private final Block planks;
        private final Supplier<Block> planksSupplier;
        final Supplier<Item> boatItem;
        final Supplier<Item> chestBoatItem;
        private final Supplier<Item> stickItem;
        private final boolean raft;
        public static final StringRepresentable.EnumCodec<ModBoatEntity.Type> CODEC = StringRepresentable.fromEnum(ModBoatEntity.Type::values);
        private static final IntFunction<ModBoatEntity.Type> BY_ID = ByIdMap.continuous(Enum::ordinal, values(), ByIdMap.OutOfBoundsStrategy.ZERO);

        @ReservedConstructor
        private Type(Block planks, String name) {
            this(planks, name, false);
        }

        private Type(Supplier<Block> planks, String name) {
            this(planks, name, () -> Items.AIR, () -> Items.AIR, () -> Items.STICK, false);
        }

        @ReservedConstructor
        private Type(Block planks, String name, boolean raft) {
            this.name = name;
            this.planks = planks;
            this.planksSupplier = () -> planks;
            this.boatItem = () -> Items.AIR;
            this.chestBoatItem = () -> Items.AIR;
            this.stickItem = () -> Items.STICK;
            this.raft = raft;
        }

        private Type(Supplier<Block> planks, String name, Supplier<Item> boatItem, Supplier<Item> chestBoatItem, Supplier<Item> stickItem, boolean raft) {
            this.name = name;
            this.planks = Blocks.AIR;
            this.planksSupplier = planks;
            this.boatItem = boatItem;
            this.chestBoatItem = chestBoatItem;
            this.stickItem = stickItem;
            this.raft = raft;
        }

        public String getSerializedName() {return this.name;}
        public String getName() {return this.name;}
        public Block getPlanks() {return (Block)this.planksSupplier.get();}
        public Item getSticks() {return (Item)this.stickItem.get();}
        public boolean isRaft() {return this.raft;}
        public String toString() {return this.name;}
        public static ModBoatEntity.Type byId(int id) {return (ModBoatEntity.Type)BY_ID.apply(id);}
        public static ModBoatEntity.Type byName(String name) {return (ModBoatEntity.Type)CODEC.byName(name, PLUM);}
        public static ExtensionInfo getExtensionInfo() {return ExtensionInfo.nonExtended(ModBoatEntity.Type.class);}
    }
}

