package com.kabaniery.uncommonadventure.datagenerators;

import com.kabaniery.uncommonadventure.blocks.CommonDropBlocks;
import com.kabaniery.uncommonadventure.blocks.GeneralBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class BlockGroups {
    public static final Set<RegistryObject<Block>> SIDE_TOP = Set.of(

    );

    public static final Set<RegistryObject<Block>> ALL_SIDE = Set.of(
            CommonDropBlocks.ARMED_FRAME_BLOCK,
            CommonDropBlocks.POISONED_SNOW_BLOCK,
            CommonDropBlocks.FROZEN_DIRT,
            CommonDropBlocks.POISONED_ICE,
            GeneralBlocks.MAGENTA_ORE
    );
}
