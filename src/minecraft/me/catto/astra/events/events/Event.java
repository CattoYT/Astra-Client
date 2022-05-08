// 
// Decompiled by Procyon v0.5.36
// 

package me.catto.astra.events.events;

public class Event
{
    public boolean cancelled;
    
    public Event() {
        this.cancelled = false;
    }
    
    public void cancel() {
        this.cancelled = true;
    }
}
