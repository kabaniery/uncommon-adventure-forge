package com.kabaniery.uncommonadventure.events;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import com.kabaniery.uncommonadventure.blocks.DeathCloneBox.DeathCloneBlockEntity;
import com.kabaniery.uncommonadventure.blocks.GeneralBlocks;
import com.kabaniery.uncommonadventure.item.CloneLocator.CloneLocator;
import com.kabaniery.uncommonadventure.item.GeneralItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.animal.Panda;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = UncommonAdventureMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerInventoryEvents {
    private static final HashMap<UUID, BlockPos> death_positions = new HashMap<>();

    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;

        GeneralBlocks.DEATH_CLONE_BLOCK.get();

        BlockPos pos = player.blockPosition();
        Level world = player.serverLevel();

        world.setBlock(pos, GeneralBlocks.DEATH_CLONE_BLOCK.get().defaultBlockState(), 2);
        BlockEntity blockEntity = world.getBlockEntity(pos);

        if (blockEntity instanceof DeathCloneBlockEntity be) {
            be.setItems(event.getDrops());
            event.getDrops().clear();
            death_positions.put(player.getUUID(), pos);
        }
    }

    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerRespawnEvent event) {
        System.out.println("OK");
        if (!(event.getEntity() instanceof ServerPlayer player)) return;

        System.out.println("a2");

        if (!death_positions.containsKey(player.getUUID())) return;

        System.out.println("a3");

        ItemStack stack = GeneralItems.CLONE_LOCATOR.get().getDefaultInstance();
        CloneLocator.setPos(stack, death_positions.get(player.getUUID()));
        player.getInventory().placeItemBackInInventory(stack, true);
    }
}
