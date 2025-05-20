package com.kabaniery.uncommonadventure;

import com.kabaniery.uncommonadventure.datagenerators.MItemModelProviders;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UncommonAdventureMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        System.out.println("Gathering data");
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new MItemModelProviders(output, existingFileHelper));
    }
}
