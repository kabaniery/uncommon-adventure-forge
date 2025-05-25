package com.kabaniery.uncommonadventure.item;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import com.kabaniery.uncommonadventure.item.CloneLocator.CloneLocator;
import com.kabaniery.uncommonadventure.item.armor.BasicInsulatedArmors;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GeneralItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, UncommonAdventureMod.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

        // Кастомные хранилища
        BasicInsulatedArmors.init();
    }

    public static final RegistryObject<Item> BOILED_ROTTEN_FLESH = ITEMS.register("boiled_rotten_flesh",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLONE_LOCATOR = ITEMS.register("clone_locator", CloneLocator::new);
}
