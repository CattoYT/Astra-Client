// 
// Decompiled by Procyon v0.5.36
// 

package me.catto.astra.events.events.impl;

import me.catto.astra.events.events.Event;

public class LightningEvent extends Event
{
    public final double x;
    public final double y;
    public final double z;
    
    public LightningEvent(final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
