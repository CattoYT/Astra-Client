// 
// Decompiled by Procyon v0.5.36
// 

package me.catto.astra.events.events.impl;

import me.catto.astra.events.events.Event;

public class MoveEvent extends Event
{
    public double x;
    public double y;
    public double z;
    public boolean safewalk;
    
    public MoveEvent(final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.safewalk = false;
    }
}
