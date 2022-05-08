// 
// Decompiled by Procyon v0.5.36
// 

package me.catto.astra.events.events.impl;

import me.catto.astra.events.events.Event;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.Packet;

public class SilentPacketEvent extends Event
{
    public Packet<?> packet;
    public EnumPacketDirection direction;
    
    public SilentPacketEvent(final Packet<?> packet, final EnumPacketDirection direction) {
        this.packet = packet;
        this.direction = direction;
    }
}
