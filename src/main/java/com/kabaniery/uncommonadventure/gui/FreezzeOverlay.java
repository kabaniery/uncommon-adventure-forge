package com.kabaniery.uncommonadventure.gui;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import com.kabaniery.uncommonadventure.capabilities.freezing.IPlayerFreezing;
import com.kabaniery.uncommonadventure.capabilities.freezing.PlayerFreezingProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UncommonAdventureMod.MODID, value = Dist.CLIENT)
public class FreezzeOverlay {
    @SubscribeEvent
    public static void onRenderGuiOverlay(RenderGuiOverlayEvent.Pre event) {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;

        if (player == null || mc.options.hideGui || event.isCanceled()) return;

        IPlayerFreezing freezing = player.getCapability(PlayerFreezingProvider.PLAYER_FREEZING).orElse(null);

        if (freezing == null) return;

        if (freezing.isDisabled()) return;

        double percent = 1 - freezing.getFreezing() / 20;

        int screenWidth = mc.getWindow().getGuiScaledWidth();
        int screenHeight = mc.getWindow().getGuiScaledHeight();

        int barWidth = 100;  // ширина полной полоски
        int barHeight = 10;  // высота полоски

        int x = screenWidth / 2 - barWidth / 2;
        int y = screenHeight - 30;

        // Цвета: ARGB
        int backgroundColor = 0xAA000000;  // полупрозрачный чёрный
        int barColor = 0xFF00FFFF;

        GuiGraphics guiGraphics = event.getGuiGraphics();

        guiGraphics.fill(x, y, x + barWidth, y + barHeight, backgroundColor);

        guiGraphics.fill((int) (x + (barWidth * percent)), y, x + barWidth, y + barHeight, barColor);
    }
}
