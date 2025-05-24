package com.kabaniery.uncommonadventure.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class UndestroyableBlock extends Block {
    public UndestroyableBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.BEDROCK));
    }
}
