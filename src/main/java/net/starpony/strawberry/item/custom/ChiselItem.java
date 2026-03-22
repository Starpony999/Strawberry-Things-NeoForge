package net.starpony.strawberry.item.custom;

import net.starpony.strawberry.block.ModBlocks;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP_STONE =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS,
                    Blocks.CRACKED_STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS,
                    Blocks.CHISELED_STONE_BRICKS, Blocks.MOSSY_STONE_BRICKS,
                    Blocks.MOSSY_STONE_BRICKS, Blocks.STONE,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.END_STONE_BRICKS, Blocks.END_STONE
            );
    private static final Map<Block, Block> CHISEL_MAP_DEEPSLATE =
            Map.of(
                    Blocks.DEEPSLATE, Blocks.POLISHED_DEEPSLATE,
                    Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                    Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS,
                    Blocks.CRACKED_DEEPSLATE_BRICKS, Blocks.DEEPSLATE_TILES,
                    Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES,
                    Blocks.CRACKED_DEEPSLATE_TILES, Blocks.CHISELED_DEEPSLATE,
                    Blocks.CHISELED_DEEPSLATE, Blocks.DEEPSLATE
            );

    public ChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        Block resultBlock = null;

        if (CHISEL_MAP_STONE.containsKey(clickedBlock)) {
            resultBlock = CHISEL_MAP_STONE.get(clickedBlock);
        } else if (CHISEL_MAP_DEEPSLATE.containsKey(clickedBlock)) {
            resultBlock = CHISEL_MAP_DEEPSLATE.get(clickedBlock);
        }

        if (resultBlock != null) {
            if (!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), resultBlock.defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }
}