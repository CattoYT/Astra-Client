package me.catto.astra.utils.sexutils;

import net.minecraft.network.Packet;

public final class PacketUtil extends MinecraftInstance
{
    public static void send(final Packet packet) {
        PacketUtil.mc.getNetHandler().getNetworkManager().sendPacket(packet);
    }

    public static void sendSilent(final Packet packet) {
        PacketUtil.mc.getNetHandler().getNetworkManager().sendPacketNoEvent(packet);
    }

    public static void receive(final Packet packet) {
        PacketUtil.mc.getNetHandler().getNetworkManager().receiveNoEvent(packet);
    }
}
