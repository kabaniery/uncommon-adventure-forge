package com.kabaniery.uncommonadventure.blocks;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import com.kabaniery.uncommonadventure.blocks.DeathCloneBox.DeathCloneBox;
import com.kabaniery.uncommonadventure.blocks.PortalBlock.PortalBlock;
import com.kabaniery.uncommonadventure.blocks.WarpController.WarpController;
import com.kabaniery.uncommonadventure.blocks.WinterCloset.WinterCloset;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GeneralBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, UncommonAdventureMod.MODID);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        CommonDropBlocks.BLOCKS_REGISTER.register(eventBus);
        GeneralBlockItems.init();
    }

    public static final RegistryObject<Block> DEATH_CLONE_BLOCK = BLOCKS.register("death_clone_box",
            DeathCloneBox::new);
    public static final RegistryObject<Block> MAGENTA_ORE = BLOCKS.register("magenta_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE)));
}
