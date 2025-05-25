package com.kabaniery.uncommonadventure.networking;

import com.kabaniery.uncommonadventure.UncommonAdventureMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class PacketHandler {
    private static final String PROTOCOL_VERSION = "1.0";

    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(UncommonAdventureMod.MODID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    private static int packetId = 0;

    public static void registerPackets() {
        INSTANCE.registerMessage(packetId++,
                FreezeSyncPacket.class,
                FreezeSyncPacket::encode,
                FreezeSyncPacket::decode,
                FreezeSyncPacket::handle);
    }

    public static void sendToServer(Object packet) {
        INSTANCE.send(PacketDistributor.SERVER.noArg(), packet);
    }

    public static void sendToPlayer(Object packet, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), packet);
    }
}
