// 
// Decompiled by Procyon v0.5.36
// 

package me.catto.astra.events.events.impl;

import me.catto.astra.events.events.Event;

public class SlowdownEvent extends Event
{
    public float reducer;
    
    public SlowdownEvent(final float reducer) {
        this.reducer = reducer;
    }
}
