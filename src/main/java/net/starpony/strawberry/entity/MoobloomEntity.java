package net.starpony.strawberry.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.SuspiciousStewEffects;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.starpony.strawberry.effect.ModEffects;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MoobloomEntity extends Animal {
    private static final EntityDimensions BABY_DIMENSIONS = EntityType.MOOSHROOM.getDimensions().scale(0.5F).withEyeHeight(0.665F);
    public static final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public MoobloomEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals(){
        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25, stack -> stack.is(Items.BONE_MEAL), false));

        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25));

        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));

    }
    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10d)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.FOLLOW_RANGE, 10D);
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return itemStack.is(Items.BONE_MEAL);
    }

    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }
    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.COW_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.COW_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.COW_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState block) {
        this.playSound(SoundEvents.COW_STEP, 0.15F, 1.0F);
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (itemstack.is(Items.BOWL) && !this.isBaby()) {
            player.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
            ItemStack stew = Items.SUSPICIOUS_STEW.getDefaultInstance();
            SuspiciousStewEffects.Entry effect = getRandomEffect();
            stew.set(DataComponents.SUSPICIOUS_STEW_EFFECTS, SuspiciousStewEffects.EMPTY.withEffectAdded(effect));
            ItemStack result = ItemUtils.createFilledResult(itemstack, player, stew);
            player.setItemInHand(hand, result);

            return InteractionResult.sidedSuccess(this.level().isClientSide);
        } else {
            return super.mobInteract(player, hand);
        }
    }

    private SuspiciousStewEffects.Entry getRandomEffect() {
        List<Holder<MobEffect>> effects = List.of(
                MobEffects.FIRE_RESISTANCE,
                MobEffects.BLINDNESS,
                MobEffects.SATURATION,
                MobEffects.JUMP,
                MobEffects.POISON,
                MobEffects.REGENERATION,
                MobEffects.NIGHT_VISION,
                MobEffects.WEAKNESS,
                MobEffects.WITHER,
                ModEffects.DRAGONS_GRACE
        );

        Holder<MobEffect> randomEffect = effects.get(this.random.nextInt(effects.size()));
        int duration = 200 + this.random.nextInt(600); // 10-40 seconds

        return new SuspiciousStewEffects.Entry(randomEffect, duration);
    }

    @Nullable
    public MoobloomEntity getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return ModEntities.MOOBLOOM.get().create(level);
    }

    @Override
    public EntityDimensions getDefaultDimensions(Pose pose) {
        return this.isBaby() ? BABY_DIMENSIONS : super.getDefaultDimensions(pose);
    }
}
