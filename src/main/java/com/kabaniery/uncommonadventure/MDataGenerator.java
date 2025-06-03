package com.kabaniery.uncommonadventure;

import com.kabaniery.uncommonadventure.datagenerators.GeneralLootTableProvider;
import com.kabaniery.uncommonadventure.datagenerators.MBlockModelProviders;
import com.kabaniery.uncommonadventure.datagenerators.MItemModelProviders;
import com.kabaniery.uncommonadventure.datagenerators.loot.BlockLootTables;
import com.kabaniery.uncommonadventure.datagenerators.MWorldGenProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = UncommonAdventureMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        System.out.println("Gathering data");
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new MBlockModelProviders(output, existingFileHelper));

        generator.addProvider(event.includeClient(), new MItemModelProviders(output, existingFileHelper));

        generator.addProvider(event.includeServer(), new MWorldGenProvider(output, lookupProvider));

        generator.addProvider(event.includeServer(), GeneralLootTableProvider.create(output));
    }
}
