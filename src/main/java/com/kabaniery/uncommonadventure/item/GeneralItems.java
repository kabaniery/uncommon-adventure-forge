package com.kabaniery.uncommonadventure.item;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import com.kabaniery.uncommonadventure.item.CloneLocator.CloneLocator;
import com.kabaniery.uncommonadventure.item.WarpStone.DisabledWarpStone;
import com.kabaniery.uncommonadventure.item.WarpStone.WarpStone;
import com.kabaniery.uncommonadventure.item.armor.BasicInsulatedArmors;
import com.kabaniery.uncommonadventure.item.overheated.OverHeatedItems;
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
        OverHeatedItems.init();
    }

    public static final RegistryObject<Item> BOILED_ROTTEN_FLESH = ITEMS.register("boiled_rotten_flesh",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLONE_LOCATOR = ITEMS.register("clone_locator", CloneLocator::new);

    public static final RegistryObject<Item> DISABLED_WARP_STONE = ITEMS.register("disabled_warp_stone", DisabledWarpStone::new);
    public static final RegistryObject<Item> WARP_STONE = ITEMS.register("warp_stone", WarpStone::new);
    public static final RegistryObject<Item> BROKEN_WARP_STONE = ITEMS.register("broken_warp_stone",
            () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> MAGENTA_CRYSTAL = ITEMS.register("magenta_crystal",
            () -> new Item(new Item.Properties().stacksTo(64)));
}
