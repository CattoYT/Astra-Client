
package me.catto.astra.utils.sexutils;

public final class MillisTimer
{
    public long millis;
    
    public MillisTimer() {
        this.millis = -1L;
    }
    
    public boolean hasTimeReached(final long ms) {
        return System.currentTimeMillis() >= this.millis + ms;
    }
    
    public long getTimeDiff(final long ms) {
        return ms + this.millis - System.currentTimeMillis();
    }
    
    public boolean delay(final float milliSec) {
        return System.nanoTime() / 1000000.0f - this.millis >= milliSec;
    }
    
    public MillisTimer reset() {
        this.millis = System.currentTimeMillis();
        return this;
    }
    
    public boolean hasTicksPassed(final float ticks) {
        return System.currentTimeMillis() - this.millis >= ticks * 50.0f;
    }
}
