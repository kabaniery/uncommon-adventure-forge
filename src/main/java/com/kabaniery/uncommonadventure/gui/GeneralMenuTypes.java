package com.kabaniery.uncommonadventure.gui;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GeneralMenuTypes {
    public static final DeferredRegister<MenuType<?>> REGISTER =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, UncommonAdventureMod.MODID);


    public static final RegistryObject<MenuType<BrokenGuiMenu>> BROKEN_GUI = REGISTER.register("broken_gui",
            () -> new MenuType<>(BrokenGuiMenu::new, FeatureFlags.DEFAULT_FLAGS));

    public static void register(IEventBus bus) {
        REGISTER.register(bus);
    }
}
