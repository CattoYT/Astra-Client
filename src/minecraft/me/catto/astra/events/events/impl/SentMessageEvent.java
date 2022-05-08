// 
// Decompiled by Procyon v0.5.36
// 

package me.catto.astra.events.events.impl;

import me.catto.astra.events.events.Event;

public class SentMessageEvent extends Event
{
    public String message;
    public boolean sendToChat;
    
    public SentMessageEvent(final String message, final boolean sendToChat) {
        this.message = message;
        this.sendToChat = sendToChat;
    }
}
