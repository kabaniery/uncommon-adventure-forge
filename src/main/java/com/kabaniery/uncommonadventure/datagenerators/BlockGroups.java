package com.kabaniery.uncommonadventure.datagenerators;

import com.kabaniery.uncommonadventure.blocks.GeneralBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashSet;
import java.util.Set;

public class BlockGroups {
    public static final Set<RegistryObject<Block>> SIDE_TOP = Set.of(

    );

    public static final Set<RegistryObject<Block>> ALL_SIDE = Set.of(
            GeneralBlocks.ARMED_FRAME_BLOCK,
            GeneralBlocks.POISONED_SNOW_BLOCK,
            GeneralBlocks.FROZEN_DIRT
    );
}
