// 
// Decompiled by Procyon v0.5.36
// 

package me.catto.astra.events.events.impl;

import me.catto.astra.events.events.Event;
import me.catto.astra.utils.sexutils.Button;

public class MoveButtonEvent extends Event
{
    private Button left;
    private Button right;
    private Button backward;
    private Button forward;
    private boolean sneak;
    private boolean jump;
    
    public MoveButtonEvent(final Button left, final Button right, final Button backward, final Button forward, final boolean sneak, final boolean jump) {
        this.left = left;
        this.right = right;
        this.backward = backward;
        this.forward = forward;
        this.sneak = sneak;
        this.jump = jump;
    }
    
    public Button getLeft() {
        return this.left;
    }
    
    public void setLeft(final Button left) {
        this.left = left;
    }
    
    public Button getRight() {
        return this.right;
    }
    
    public void setRight(final Button right) {
        this.right = right;
    }
    
    public Button getBackward() {
        return this.backward;
    }
    
    public void setBackward(final Button backward) {
        this.backward = backward;
    }
    
    public Button getForward() {
        return this.forward;
    }
    
    public void setForward(final Button forward) {
        this.forward = forward;
    }
    
    public boolean isSneak() {
        return this.sneak;
    }
    
    public void setSneak(final boolean sneak) {
        this.sneak = sneak;
    }
    
    public boolean isJump() {
        return this.jump;
    }
    
    public void setJump(final boolean jump) {
        this.jump = jump;
    }
    
    public void setForward(final boolean forward) {
        this.getForward().button = forward;
    }
    
    public void setBackward(final boolean backward) {
        this.getBackward().button = backward;
    }
    
    public void setLeft(final boolean left) {
        this.getLeft().button = left;
    }
    
    public void setRight(final boolean right) {
        this.getRight().button = right;
    }
}
