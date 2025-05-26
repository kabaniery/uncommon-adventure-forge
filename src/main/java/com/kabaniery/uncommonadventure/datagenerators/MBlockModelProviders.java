package com.kabaniery.uncommonadventure.datagenerators;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import com.kabaniery.uncommonadventure.blocks.GeneralBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;


public class MBlockModelProviders extends BlockStateProvider {
    public MBlockModelProviders(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, UncommonAdventureMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        BlockGroups.ALL_SIDE.forEach(this::commonBlockWithItem);
    }

    private void commonBlockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
}
