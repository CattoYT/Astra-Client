// 
// Decompiled by Procyon v0.5.36
// 

package me.catto.astra.events.events.impl;

import me.catto.astra.events.events.EventType;
import me.catto.astra.events.events.MultiTypeEvent;

public class UpdatePlayerEvent extends MultiTypeEvent
{
    public float yaw;
    public float pitch;
    public double x;
    public double y;
    public double z;
    public boolean onGround;
    
    public float getYaw() {
        return this.yaw;
    }
    
    public void setYaw(final float yaw) {
        this.yaw = yaw;
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public void setPitch(final float pitch) {
        this.pitch = pitch;
    }
    
    public double getX() {
        return this.x;
    }
    
    public void setX(final double x) {
        this.x = x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setY(final double y) {
        this.y = y;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public void setZ(final double z) {
        this.z = z;
    }
    
    public boolean isOnGround() {
        return this.onGround;
    }
    
    public void setOnGround(final boolean onGround) {
        this.onGround = onGround;
    }
    
    public UpdatePlayerEvent(final float yaw, final float pitch, final double x, final double y, final double z, final boolean onGround, final EventType type) {
        super(type);
        this.yaw = yaw;
        this.pitch = pitch;
        this.x = x;
        this.y = y;
        this.z = z;
        this.onGround = onGround;
    }
    
    public void setType(final EventType t) {
        this.type = t;
    }
    
    public boolean pre() {
        return this.type == EventType.PRE;
    }
    
    public boolean post() {
        return this.type == EventType.POST;
    }
}
