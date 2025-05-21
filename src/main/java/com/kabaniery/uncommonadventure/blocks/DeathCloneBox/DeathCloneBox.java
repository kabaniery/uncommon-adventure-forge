package com.kabaniery.uncommonadventure.blocks.DeathCloneBox;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
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
                //TODO: добавить проверку на локатор
                entity.destroy(pLevel, pPos);
                pLevel.removeBlockEntity(pPos);
                pLevel.removeBlock(pPos, false);

                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }
}
