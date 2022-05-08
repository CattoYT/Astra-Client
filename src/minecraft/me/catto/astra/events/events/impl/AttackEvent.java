// 
// Decompiled by Procyon v0.5.36
// 

package me.catto.astra.events.events.impl;

import me.catto.astra.events.events.EventType;
import me.catto.astra.events.events.MultiTypeEvent;
import net.minecraft.entity.Entity;

public class AttackEvent extends MultiTypeEvent
{
    public final Entity target;
    public EventType type;
    
    public AttackEvent(final Entity target, final EventType type) {
        this.target = target;
        this.type = type;
    }
}
