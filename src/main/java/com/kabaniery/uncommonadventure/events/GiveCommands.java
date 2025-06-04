package com.kabaniery.uncommonadventure.events;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = UncommonAdventureMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GiveCommands {
    @SubscribeEvent
    public static void onCommandRegister(RegisterCommandsEvent event) {
        registerMyCommand(event.getDispatcher());
    }

    private static void registerMyCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("starter") // /mycommand
                        .executes(context -> {
                            ServerPlayer player = context.getSource().getPlayer();
                            List<Item> givedItems = List.of(Items.COBBLESTONE, Items.IRON_INGOT,
                                    Items.COBBLESTONE, Items.ANDESITE, Items.COPPER_INGOT,
                                    Items.OAK_LOG, Items.KELP);
                            givedItems.forEach(item -> {
                                ItemStack stack = new ItemStack(item);
                                stack.setCount(64);
                                player.addItem(stack);
                            });
                            context.getSource().sendSuccess(
                                    () -> Component.literal("Выдано"), false);
                            return 1;
                        }));
    }
}
