// 
// Decompiled by Procyon v0.5.36
// 

package me.catto.astra.events.events.impl;

import me.catto.astra.events.events.Event;

public class Render3DEvent extends Event
{
    public float partialTicks;
    
    public Render3DEvent(final float partialTicks) {
        this.partialTicks = 0.0f;
        this.partialTicks = partialTicks;
    }
}
