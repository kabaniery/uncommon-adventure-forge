package com.kabaniery.uncommonadventure.blocks;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import com.kabaniery.uncommonadventure.blocks.DeathCloneBox.DeathCloneBox;
import com.kabaniery.uncommonadventure.blocks.WarpController.WarpController;
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
        GeneralBlockItems.init();
    }

    public static final RegistryObject<Block> DEATH_CLONE_BLOCK = BLOCKS.register("death_clone_box",
            DeathCloneBox::new);

    public static final RegistryObject<Block> WARP_CONTROLLER_BLOCK = BLOCKS.register("warp_controller",
            WarpController::new);

    public static final RegistryObject<Block> ARMED_FRAME_BLOCK = BLOCKS.register("armed_frame_block",
            UndestroyableBlock::new);

}
