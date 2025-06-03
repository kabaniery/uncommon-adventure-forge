package com.kabaniery.uncommonadventure.blocks;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import com.kabaniery.uncommonadventure.blocks.PortalBlock.PortalBlock;
import com.kabaniery.uncommonadventure.blocks.WarpController.WarpController;
import com.kabaniery.uncommonadventure.blocks.WinterCloset.WinterCloset;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class CommonDropBlocks {
    public static final DeferredRegister<Block> BLOCKS_REGISTER =
            DeferredRegister.create(ForgeRegistries.BLOCKS, UncommonAdventureMod.MODID);


    public static final RegistryObject<Block> WARP_CONTROLLER_BLOCK = BLOCKS_REGISTER.register("warp_controller",
            WarpController::new);

    public static final RegistryObject<Block> ARMED_FRAME_BLOCK = BLOCKS_REGISTER.register("armed_frame_block",
            UndestroyableBlock::new);

    public static final RegistryObject<Block> WINTER_CLOSET = BLOCKS_REGISTER.register("winter_closet",
            WinterCloset::new);

    public static final RegistryObject<Block> POISONED_SNOW_BLOCK = BLOCKS_REGISTER.register("poisoned_snow_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SNOW_BLOCK)));

    public static final RegistryObject<Block> FROZEN_DIRT = BLOCKS_REGISTER.register("frozen_dirt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.ICE)));

    public static final RegistryObject<Block> POISONED_ICE = BLOCKS_REGISTER.register("poisoned_ice",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.ICE)));

    public static final RegistryObject<Block> PORTAL_BLOCK = BLOCKS_REGISTER.register("portal_block",
            PortalBlock::new);

}
