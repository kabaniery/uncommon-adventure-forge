package com.kabaniery.uncommonadventure.creative;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import com.kabaniery.uncommonadventure.blocks.GeneralBlockItems;
import com.kabaniery.uncommonadventure.datagenerators.BlockGroups;
import com.kabaniery.uncommonadventure.item.GeneralItems;
import com.kabaniery.uncommonadventure.item.armor.BasicInsulatedArmors;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class GeneralTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_DEFERRED_REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UncommonAdventureMod.MODID);

    public static final RegistryObject<CreativeModeTab> COMMON_ITEMS = CREATIVE_MODE_TAB_DEFERRED_REGISTER.register("common_items",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(GeneralItems.BOILED_ROTTEN_FLESH.get()))
                    .title(Component.translatable("uncommonadventure.common_items"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(GeneralItems.BOILED_ROTTEN_FLESH.get());
                        output.accept(GeneralItems.CLONE_LOCATOR.get());
                        output.accept(GeneralBlockItems.DEATH_CLONE_BOX_ITEM.get());
                        output.accept(GeneralBlockItems.WARP_CONTROLLER_ITEM.get());
                        output.accept(GeneralBlockItems.ARMED_FRAME_ITEM.get());
                        output.accept(GeneralBlockItems.WINTER_CLOSET_ITEM.get());
                        output.accept(GeneralBlockItems.POISONED_SNOW.get());
                        output.accept(GeneralBlockItems.FROZEN_DIRT.get());
                        output.accept(GeneralBlockItems.POISONED_ICE.get());

                        output.accept(BasicInsulatedArmors.BASIC_HELMET.get());
                        output.accept(BasicInsulatedArmors.BASIC_CHESTPLATE.get());
                        output.accept(BasicInsulatedArmors.BASIC_LEGGINS.get());
                        output.accept(BasicInsulatedArmors.BASIC_BOOTS.get());
                    }))
                    .build());

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TAB_DEFERRED_REGISTER.register(bus);
    }
}
