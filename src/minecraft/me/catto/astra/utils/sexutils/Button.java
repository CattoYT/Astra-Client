// 
// Decompiled by Procyon v0.5.36
// 

package me.catto.astra.utils.sexutils;

public class Button
{
    public boolean button;
    public double offset;
    
    public Button(final boolean button, final double offset) {
        this.button = button;
        this.offset = offset;
    }
    
    public boolean isButton() {
        return this.button;
    }
    
    public void setButton(final boolean button) {
        this.button = button;
    }
    
    public double getOffset() {
        return this.offset;
    }
    
    public void setOffset(final double offset) {
        this.offset = offset;
    }
}
