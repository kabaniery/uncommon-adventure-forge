package com.kabaniery.uncommonadventure.item.overheated;

import com.kabaniery.uncommonadventure.item.GeneralItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class OverHeatedItems {
    public static final RegistryObject<Item> TEST_OVERHEATED_ITEM = GeneralItems.ITEMS.register("test_overheated_item",
            () -> new OverheatedItem(new Item.Properties()));

    public static void init() {}
}
