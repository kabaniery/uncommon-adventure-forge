package com.kabaniery.uncommonadventure.blocks;

import com.kabaniery.uncommonadventure.item.GeneralItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class GeneralBlockItems {
    public static final RegistryObject<Item> DEATH_CLONE_BOX_ITEM = registerBlockItem(GeneralBlocks.DEATH_CLONE_BLOCK, "death_clone_box");
    public static final RegistryObject<Item> WARP_CONTROLLER_ITEM = registerBlockItem(CommonDropBlocks.WARP_CONTROLLER_BLOCK, "warp_controller");
    public static final RegistryObject<Item> ARMED_FRAME_ITEM = registerBlockItem(CommonDropBlocks.ARMED_FRAME_BLOCK, "armed_frame_block");
    public static final RegistryObject<Item> WINTER_CLOSET_ITEM = registerBlockItem(CommonDropBlocks.WINTER_CLOSET, "winter_closet");
    public static final RegistryObject<Item> POISONED_SNOW = registerBlockItem(CommonDropBlocks.POISONED_SNOW_BLOCK, "poisoned_snow_block");
    public static final RegistryObject<Item> FROZEN_DIRT = registerBlockItem(CommonDropBlocks.FROZEN_DIRT, "frozen_dirt");
    public static final RegistryObject<Item> POISONED_ICE = registerBlockItem(CommonDropBlocks.POISONED_ICE, "poisoned_ice");
    public static final RegistryObject<Item> PORTAL_BLOCK = registerBlockItem(CommonDropBlocks.PORTAL_BLOCK, "portal_block");
    public static final RegistryObject<Item> MAGENTA_ORE = registerBlockItem(GeneralBlocks.MAGENTA_ORE, "magenta_ore");

    private static <T extends Block> RegistryObject<Item> registerBlockItem(RegistryObject<T> block, String name) {
        return GeneralItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void init() {}
}
