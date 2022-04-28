package me.catto.astra.events.event;

public interface EventListener<T> {
    void call(T event);
}
