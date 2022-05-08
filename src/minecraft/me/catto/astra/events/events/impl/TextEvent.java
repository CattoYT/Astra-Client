// 
// Decompiled by Procyon v0.5.36
// 

package me.catto.astra.events.events.impl;

import me.catto.astra.events.events.Event;

public class TextEvent extends Event
{
    private String text;
    
    public TextEvent(final String text) {
        this.text = text;
    }
    
    public String getText() {
        return this.text;
    }
    
    public void setText(final String text) {
        this.text = text;
    }
}
