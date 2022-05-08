// 
// Decompiled by Procyon v0.5.36
// 

package me.catto.astra.events.events;

public class MultiTypeEvent extends Event
{
    public EventType type;
    
    public MultiTypeEvent() {
        this.type = EventType.PRE;
    }
    
    public MultiTypeEvent(final EventType type) {
        this.type = type;
    }
    
    public boolean isPre() {
        return this.type == EventType.PRE;
    }
    
    public boolean isPost() {
        return this.type == EventType.POST;
    }
}
