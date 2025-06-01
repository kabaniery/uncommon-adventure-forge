package com.kabaniery.uncommonadventure.blocks.PortalBlock;

import com.kabaniery.uncommonadventure.world.dimension.GeneralDimensions;
import com.kabaniery.uncommonadventure.world.teleport.ToFrozenTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class PortalBlock extends Block {
    public PortalBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.STONE));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pPlayer.canChangeDimensions()) {
            if (pPlayer.level() instanceof ServerLevel serverLevel) {
                MinecraftServer server = serverLevel.getServer();
                ResourceKey<Level> dimension = serverLevel.dimension() == GeneralDimensions.FROZENWORLD_LEVEL_KEY ?
                        Level.OVERWORLD : GeneralDimensions.FROZENWORLD_LEVEL_KEY;

                ServerLevel portalDimension = server.getLevel(dimension);
                if (portalDimension != null && !pPlayer.isPassenger()) {
                    if(dimension == GeneralDimensions.FROZENWORLD_LEVEL_KEY) {
                        pPlayer.changeDimension(portalDimension, new ToFrozenTeleporter(pPos, true));
                    } else {
                        pPlayer.changeDimension(portalDimension, new ToFrozenTeleporter(pPos, false));
                    }
                }
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.CONSUME;
    }
}
