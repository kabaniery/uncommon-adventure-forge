package com.kabaniery.uncommonadventure.world.teleport;

import com.kabaniery.uncommonadventure.blocks.CommonDropBlocks;
import com.kabaniery.uncommonadventure.blocks.GeneralBlocks;
import com.kabaniery.uncommonadventure.blocks.PortalBlock.PortalBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class ToFrozenTeleporter implements ITeleporter {
    public static BlockPos thisPos = BlockPos.ZERO;
    public boolean insideDimension = true;

    public ToFrozenTeleporter(BlockPos pos, boolean insideDimension) {
        this.insideDimension = insideDimension;
        this.thisPos = pos;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        entity = repositionEntity.apply(false);
        int y = 61;

        if (!insideDimension) {
            y = this.thisPos.getY();
        }

        BlockPos destinationPos = new BlockPos(thisPos.getX(), y, thisPos.getZ());

        int tries = 0;

        while ((destWorld.getBlockState(destinationPos).getBlock() != Blocks.AIR) &&
                !destWorld.getBlockState(destinationPos).canBeReplaced(Fluids.WATER) &&
                (destWorld.getBlockState(destinationPos.above()).getBlock()  != Blocks.AIR) &&
                !destWorld.getBlockState(destinationPos.above()).canBeReplaced(Fluids.WATER) && (tries < 25)) {
            destinationPos = destinationPos.above(2);
            tries++;
        }

        entity.setPos(destinationPos.getX(), destinationPos.getY(), destinationPos.getZ());

        if (insideDimension) {
            boolean doSetBlock = true;
            for (BlockPos checkPos : BlockPos.betweenClosed(destinationPos.below(10).west(10),
                    destinationPos.above(10).east(10))) {
                if (destWorld.getBlockState(checkPos).getBlock() instanceof PortalBlock) {
                    doSetBlock = false;
                    break;
                }
            }
            if (doSetBlock) {
                destWorld.setBlock(destinationPos, CommonDropBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
            }
        }

        return entity;
    }
}
