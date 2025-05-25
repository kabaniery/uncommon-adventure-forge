package com.kabaniery.uncommonadventure.networking;

import com.kabaniery.uncommonadventure.capabilities.freezing.PlayerFreezingProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class FreezeSyncPacket {
    private final double freezing;
    private final boolean disabled;

    public FreezeSyncPacket(double freezing, boolean disabled) {
        this.freezing = freezing;
        this.disabled = disabled;
    }

    public static void encode(FreezeSyncPacket msg, FriendlyByteBuf buf) {
        buf.writeDouble(msg.freezing);
        buf.writeBoolean(msg.disabled);
    }

    public static FreezeSyncPacket decode(FriendlyByteBuf buf) {
        double freezing = buf.readDouble();
        boolean disabled = buf.readBoolean();
        return new FreezeSyncPacket(freezing, disabled);
    }

    public static void handle(FreezeSyncPacket msg, Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            Minecraft.getInstance().player.getCapability(PlayerFreezingProvider.PLAYER_FREEZING).ifPresent(cap -> {
                cap.setDisabled(msg.disabled);
                cap.setFreezing(msg.freezing);
            });
        });

        ctx.setPacketHandled(true);
    }
}
