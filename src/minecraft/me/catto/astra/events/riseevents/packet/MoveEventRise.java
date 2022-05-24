package me.catto.astra.events.riseevents.packet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.catto.astra.events.events.Event;

@Getter
@Setter
@AllArgsConstructor
public final class MoveEventRise extends Event {
    private double x, y, z;
}
