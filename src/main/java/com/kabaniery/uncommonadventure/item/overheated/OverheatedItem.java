package com.kabaniery.uncommonadventure.item.overheated;

import com.simibubi.create.AllItems;
import com.simibubi.create.content.kinetics.belt.BeltBlock;
import com.simibubi.create.content.kinetics.belt.BeltBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class OverheatedItem extends Item {
    public OverheatedItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (pContext.getLevel().isClientSide()) {
            return InteractionResult.SUCCESS;
        } else {
            Level world = pContext.getLevel();
            BlockPos clickedPos = pContext.getClickedPos();
            BlockEntity blockEntity = world.getBlockEntity(clickedPos);
            if (blockEntity instanceof BeltBlockEntity belt) {
                belt.getInventory().ejectAll();
                System.out.println("OKEy");
                List<BlockPos> chain = BeltBlock.getBeltChain(world, clickedPos);
                for (BlockPos segmentPos : chain) {
                    world.removeBlockEntity(segmentPos);
                    world.setBlock(segmentPos, Blocks.AIR.defaultBlockState(), 3);
                }
                world.addFreshEntity(new ItemEntity(
                        world,
                        clickedPos.getX(),
                        clickedPos.getY(),
                        clickedPos.getZ(),
                        AllItems.BELT_CONNECTOR.asStack()
                ));
            }
            return InteractionResult.SUCCESS;
        }
    }
}
