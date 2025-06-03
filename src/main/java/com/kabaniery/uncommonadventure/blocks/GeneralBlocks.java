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
        GeneralBlockItems.init();
    }

    public static final RegistryObject<Block> DEATH_CLONE_BLOCK = BLOCKS.register("death_clone_box",
            DeathCloneBox::new);

    public static final RegistryObject<Block> WARP_CONTROLLER_BLOCK = BLOCKS.register("warp_controller",
            WarpController::new);

    public static final RegistryObject<Block> ARMED_FRAME_BLOCK = BLOCKS.register("armed_frame_block",
            UndestroyableBlock::new);

    public static final RegistryObject<Block> WINTER_CLOSET = BLOCKS.register("winter_closet",
            WinterCloset::new);

    public static final RegistryObject<Block> POISONED_SNOW_BLOCK = BLOCKS.register("poisoned_snow_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SNOW_BLOCK)));

    public static final RegistryObject<Block> FROZEN_DIRT = BLOCKS.register("frozen_dirt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.ICE)));

    public static final RegistryObject<Block> POISONED_ICE = BLOCKS.register("poisoned_ice",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.ICE)));

    public static final RegistryObject<Block> PORTAL_BLOCK = BLOCKS.register("portal_block",
            PortalBlock::new);

    public static final RegistryObject<Block> MAGENTA_ORE = BLOCKS.register("magenta_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE)));
}
