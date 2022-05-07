package me.catto.astra.events.riseevents.packet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.network.Packet;

@Getter
@Setter
@AllArgsConstructor
public final class PacketSendEvent{
    private Packet<?> packet;
}
