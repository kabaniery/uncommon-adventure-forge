package com.kabaniery.uncommonadventure;

import com.kabaniery.uncommonadventure.blocks.GeneralBlocks;
import com.kabaniery.uncommonadventure.blocks.blockEntities.GeneralBlockEntities;
import com.kabaniery.uncommonadventure.creative.GeneralTabs;
import com.kabaniery.uncommonadventure.entity.GeneralEntities;
import com.kabaniery.uncommonadventure.gui.GeneralMenuTypes;
import com.kabaniery.uncommonadventure.item.GeneralItems;
import com.kabaniery.uncommonadventure.networking.PacketHandler;
import com.kabaniery.uncommonadventure.particles.GeneralParticles;
import com.kabaniery.uncommonadventure.world.surfaces.FrozenSurfacesBuilder;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(UncommonAdventureMod.MODID)
public class UncommonAdventureMod
{
    public static final String MODID = "uncommonadventure";
    private static final Logger LOGGER = LogUtils.getLogger();


    public UncommonAdventureMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        GeneralMenuTypes.register(modEventBus);
        GeneralTabs.register(modEventBus);
        GeneralItems.register(modEventBus);
        GeneralBlocks.register(modEventBus);
        GeneralBlockEntities.register(modEventBus);
        GeneralEntities.register(modEventBus);
        GeneralParticles.register(modEventBus);


        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            PacketHandler.registerPackets();
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, UncommonAdventureMod.MODID, FrozenSurfacesBuilder.FROZEN_SURFACE);
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        {
            event.accept(GeneralItems.BOILED_ROTTEN_FLESH);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
