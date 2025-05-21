package com.kabaniery.uncommonadventure.blocks;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import com.kabaniery.uncommonadventure.blocks.DeathCloneBox.DeathCloneBox;
import com.kabaniery.uncommonadventure.item.GeneralItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GeneralBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, UncommonAdventureMod.MODID);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(RegistryObject<T> block, String name) {
        return GeneralItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static final RegistryObject<Block> DEATH_CLONE_BLOCK = BLOCKS.register("death_clone_box",
            DeathCloneBox::new);

    public static final RegistryObject<Item> DEATH_CLONE_BOX_ITEM = registerBlockItem(DEATH_CLONE_BLOCK, "death_clone_box");

}
