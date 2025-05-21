package com.kabaniery.uncommonadventure.creative;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import com.kabaniery.uncommonadventure.blocks.GeneralBlocks;
import com.kabaniery.uncommonadventure.item.GeneralItems;
import com.simibubi.create.Create;
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
                        output.accept(GeneralBlocks.DEATH_CLONE_BOX_ITEM.get());
                    }))
                    .build());

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TAB_DEFERRED_REGISTER.register(bus);
    }
}
