package com.kabaniery.uncommonadventure.item.CloneLocator;

import com.kabaniery.uncommonadventure.particles.GeneralParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class CloneLocator extends Item {

    public CloneLocator() {
        super(new Item.Properties().stacksTo(1));
    }

    public static BlockPos getPos(ItemStack stack) {
        int x = stack.getOrCreateTag().getInt("x");
        int y = stack.getOrCreateTag().getInt("y");
        int z = stack.getOrCreateTag().getInt("z");
        return new BlockPos(x, y, z);
    }

    public static void setPos(ItemStack stack, BlockPos pos) {
        stack.getOrCreateTag().putInt("x", pos.getX());
        stack.getOrCreateTag().putInt("y", pos.getY());
        stack.getOrCreateTag().putInt("z", pos.getZ());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (pLevel.isClientSide()) {
            ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
            BlockPos playerPos = pPlayer.getOnPos();
            BlockPos deathPos = getPos(itemStack);
            Vec3 dot_vec = new Vec3(deathPos.getX() - playerPos.getX(),
                    deathPos.getY() - playerPos.getY(),
                    deathPos.getZ() - playerPos.getZ()).normalize();
            for (int i = 0; i < 15; i++) {
                pLevel.addParticle(GeneralParticles.DEATH_DOT_PARTICLE.get(),
                        playerPos.getX() + (i * dot_vec.x() / 3),
                        playerPos.getY() + 1 + (i * dot_vec.y() / 3),
                        playerPos.getZ() + (i * dot_vec.z() / 3),
                        0, 0, 0);
            }
        }
        return InteractionResultHolder.sidedSuccess(pPlayer.getItemInHand(pUsedHand), pLevel.isClientSide());
    }


}
