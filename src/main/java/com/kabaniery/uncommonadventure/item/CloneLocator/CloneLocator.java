package com.kabaniery.uncommonadventure.item.CloneLocator;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CloneLocator extends Item {

    public CloneLocator() {
        super(new Item.Properties().stacksTo(1));
    }

    public BlockPos getPos(ItemStack stack) {
        int x = stack.getOrCreateTag().getInt("x");
        int y = stack.getOrCreateTag().getInt("y");
        int z = stack.getOrCreateTag().getInt("z");
        return new BlockPos(x, y, z);
    }

    public void setPos(ItemStack stack, BlockPos pos) {
        stack.getOrCreateTag().putInt("x", pos.getX());
        stack.getOrCreateTag().putInt("y", pos.getY());
        stack.getOrCreateTag().putInt("z", pos.getZ());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide()) {
            //TODO: Вставить
            System.out.println("Locator activated");
            System.out.println(getPos(pPlayer.getItemInHand(pUsedHand)));
            return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
        }
        return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }


}
