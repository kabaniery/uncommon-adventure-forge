package com.kabaniery.uncommonadventure.item.WarpStone;

import com.kabaniery.uncommonadventure.item.GeneralItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class WarpStone extends Item {
    public WarpStone() {
        super(new Properties().stacksTo(1).rarity(Rarity.RARE));
    }

    public BlockPos getDestPosition(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        if (tag.contains("x")) {
            int x = tag.getInt("x");
            int y = tag.getInt("y");
            int z = tag.getInt("z");
            return new BlockPos(x, y, z);
        } else {
            return null;
        }
    }

    public static void setPosition(ItemStack stack, BlockPos pos) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putInt("x", pos.getX());
        tag.putInt("y", pos.getY());
        tag.putInt("z", pos.getZ());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack handed = pPlayer.getItemInHand(pUsedHand);
        if (pLevel.dimension() == Level.OVERWORLD && pPlayer instanceof ServerPlayer serverPlayer) {
            BlockPos destPos = getDestPosition(handed);
            System.out.println("destPos: " + destPos);
            if (destPos != null) {
                ItemStack newItem = GeneralItems.BROKEN_WARP_STONE.get().getDefaultInstance();
                newItem.setCount(1);
                serverPlayer.setItemInHand(pUsedHand, newItem);
                serverPlayer.teleportTo(destPos.getX(), destPos.getY() + 1, destPos.getZ());
            }
        }
        return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
    }
}
