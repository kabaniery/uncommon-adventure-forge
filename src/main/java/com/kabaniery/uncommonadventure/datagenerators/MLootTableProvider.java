package com.kabaniery.uncommonadventure.datagenerators;

import com.kabaniery.uncommonadventure.blocks.CommonDropBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;

import java.util.Set;

public class MLootTableProvider extends BlockLootSubProvider {
    protected MLootTableProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        CommonDropBlocks.BLOCKS_REGISTER.getEntries().stream().forEach(block -> this.dropSelf(block.get()));
    }
}
