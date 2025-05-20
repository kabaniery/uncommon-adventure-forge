package com.kabaniery.uncommonadventure.datagenerators;

import com.kabaniery.uncommonadventure.item.GeneralItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class MItemModelProviders extends ItemModelProvider {
    public MItemModelProviders(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, "yourmodid", existingFileHelper);
    }

    @Override
    protected void registerModels() {
        System.out.println("REGISTERED MODELS");
        basicItem(GeneralItems.BOILED_ROTTEN_FLESH.get());
    }
}
