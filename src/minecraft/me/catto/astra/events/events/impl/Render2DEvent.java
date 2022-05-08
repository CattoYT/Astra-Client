// 
// Decompiled by Procyon v0.5.36
// 

package me.catto.astra.events.events.impl;

import me.catto.astra.events.events.Event;
import net.minecraft.client.gui.ScaledResolution;

public class Render2DEvent extends Event
{
    public final float partialTicks;
    public final ScaledResolution resolution;
    
    public Render2DEvent(final float partialTicks, final ScaledResolution resolution) {
        this.partialTicks = partialTicks;
        this.resolution = resolution;
    }
}
