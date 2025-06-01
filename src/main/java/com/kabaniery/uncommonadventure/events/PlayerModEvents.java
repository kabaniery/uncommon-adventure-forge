package com.kabaniery.uncommonadventure.events;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import com.kabaniery.uncommonadventure.blocks.DeathCloneBox.DeathCloneBlockEntity;
import com.kabaniery.uncommonadventure.blocks.GeneralBlocks;
import com.kabaniery.uncommonadventure.capabilities.freezing.PlayerFreezingProvider;
import com.kabaniery.uncommonadventure.item.CloneLocator.CloneLocator;
import com.kabaniery.uncommonadventure.item.GeneralItems;
import com.kabaniery.uncommonadventure.item.armor.material.FrozenResistMaterial;
import com.kabaniery.uncommonadventure.networking.FreezeSyncPacket;
import com.kabaniery.uncommonadventure.networking.PacketHandler;
import com.kabaniery.uncommonadventure.world.dimension.GeneralDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = UncommonAdventureMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerModEvents {
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
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        if (!death_positions.containsKey(player.getUUID())) return;


        ItemStack stack = GeneralItems.CLONE_LOCATOR.get().getDefaultInstance();
        CloneLocator.setPos(stack, death_positions.get(player.getUUID()));
        player.getInventory().placeItemBackInInventory(stack, true);
    }

    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player player) {
            if (!player.getCapability(PlayerFreezingProvider.PLAYER_FREEZING).isPresent()) {
                event.addCapability(new ResourceLocation(UncommonAdventureMod.MODID, "player_freezing"), new PlayerFreezingProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            event.getEntity().getCapability(PlayerFreezingProvider.PLAYER_FREEZING).ifPresent(newStore -> {
                newStore.setFreezing(20);
                newStore.setDisabled(true);
            });
        }
    }

    @SubscribeEvent
    public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        Player player = event.getEntity();
        player.getCapability(PlayerFreezingProvider.PLAYER_FREEZING).ifPresent(freezing -> {
            if (event.getTo().equals(GeneralDimensions.FROZENWORLD_LEVEL_KEY)) {
                freezing.setDisabled(false);
            } else {
                freezing.setDisabled(true);
            }

            PacketHandler.sendToPlayer(new FreezeSyncPacket(freezing.getFreezing(), freezing.isDisabled()), (ServerPlayer) player);
        });

    }

    private static int tick = 0;
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.side == LogicalSide.SERVER) {
            tick++;
            Player player = event.player;
            player.getCapability(PlayerFreezingProvider.PLAYER_FREEZING).ifPresent(freezing -> {
                if (player.getOnPos().getY() > 30 && !freezing.isDisabled()) {
                    Integer resistance = 100;
                    for (ItemStack itemStack : player.getInventory().armor) {
                        if (itemStack.getItem() instanceof ArmorItem armorItem && armorItem.getMaterial() instanceof FrozenResistMaterial material) {
                            resistance = Math.min(resistance, material.getFrozenResistance());
                        } else {
                            resistance = 0;
                            break;
                        }
                    }
                    freezing.substractFreezing(resistance);
                } else {
                    freezing.addFreezing(1);
                }

                if (tick == 20) {
                    if (freezing.getFreezing() == 0)
                        player.hurt(player.level().damageSources().freeze(), 3);

                    PacketHandler.sendToPlayer(new FreezeSyncPacket(freezing.getFreezing(), freezing.isDisabled()), (ServerPlayer) player);
                }
            });
            if (tick == 20) {
                tick = 0;
            }
        }
    }
}
