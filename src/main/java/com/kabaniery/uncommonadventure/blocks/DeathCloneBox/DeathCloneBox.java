package com.kabaniery.uncommonadventure.blocks.DeathCloneBox;

import com.kabaniery.uncommonadventure.item.GeneralItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DeathCloneBox extends Block implements EntityBlock {
    public DeathCloneBox() {
        super(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK));
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new DeathCloneBlockEntity(blockPos, blockState);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState pState, Level pLevel, @NotNull BlockPos pPos,
                                          @NotNull Player pPlayer, @NotNull InteractionHand pHand, @NotNull BlockHitResult pHit) {
        if (!pLevel.isClientSide) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof DeathCloneBlockEntity entity) {
                ItemStack stack = pPlayer.getItemInHand(pHand);
                if (!stack.is(GeneralItems.CLONE_LOCATOR.get())) {
                    return InteractionResult.FAIL;
                }
                BlockPos locator_pos = entity.getBlockPos();
                if (locator_pos.getX() != pPos.getX() || locator_pos.getZ() != pPos.getZ() || locator_pos.getY() != pPos.getY()) {
                    return InteractionResult.FAIL;
                }

                entity.destroy(pLevel, pPos);
                pLevel.removeBlockEntity(pPos);
                pLevel.removeBlock(pPos, false);
                stack.shrink(1);

                return InteractionResult.CONSUME;
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if (!pLevel.isClientSide()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof DeathCloneBlockEntity entity) {
                entity.destroy(pLevel, pPos);
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }
}
