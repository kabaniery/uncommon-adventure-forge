package com.kabaniery.uncommonadventure.item.WarpStone;

import com.kabaniery.uncommonadventure.item.GeneralItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class DisabledWarpStone extends Item {
    public DisabledWarpStone() {
        super(new Properties().stacksTo(1).rarity(Rarity.RARE));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack handed = pPlayer.getItemInHand(pUsedHand);
        if (pLevel.dimension() == Level.OVERWORLD && pPlayer instanceof ServerPlayer serverPlayer) {
            BlockPos spawnPos = serverPlayer.getRespawnPosition();
            if (spawnPos != null) {
                ItemStack warp = GeneralItems.WARP_STONE.get().getDefaultInstance();
                BlockPos pos = pPlayer.getOnPos();
                WarpStone.setPosition(warp, pos);

                pPlayer.setItemInHand(pUsedHand, warp);
                pPlayer.setPosRaw(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ());
                return new InteractionResultHolder<>(InteractionResult.SUCCESS, warp);
            }
            return new InteractionResultHolder<>(InteractionResult.FAIL, handed);
        }
        return new InteractionResultHolder<>(InteractionResult.PASS, handed);
    }
}
