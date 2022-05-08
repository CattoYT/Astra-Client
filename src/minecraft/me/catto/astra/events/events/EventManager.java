// 
// Decompiled by Procyon v0.5.36
// 

package me.catto.astra.events.events;

import me.catto.astra.Astra;
import com.google.common.eventbus.Subscribe;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class EventManager
{
    private final Map<Class, CopyOnWriteArrayList<Method>> listeners;
    
    public EventManager() {
        this.listeners = new HashMap<Class, CopyOnWriteArrayList<Method>>();
    }
    
    public void shutdown() {
        this.listeners.clear();
    }
    
    public void registerListener(final Object listener) {
        for (final Method method : listener.getClass().getMethods()) {
            if (method.isAnnotationPresent((Class<? extends Annotation>)Subscribe.class) && method.getParameterTypes().length == 1 && (method.getParameterTypes()[0].getSuperclass() == Event.class || method.getParameterTypes()[0].getSuperclass().getSuperclass() == Event.class)) {
                final Class<?> ev = method.getParameterTypes()[0];
                if (!this.listeners.containsKey(ev)) {
                    final CopyOnWriteArrayList<Method> m = new CopyOnWriteArrayList<Method>();
                    m.add(method);
                    this.listeners.put(ev, m);
                }
                else {
                    this.listeners.get(ev).add(method);
                }
            }
        }

    }
    public void call(final Event event) {
        if (Astra.useExperimentalEventBus) {
            Astra.eventBus.post((Object)event);
        }
        else {
            this.dispatch(event);
        }
    }
    public void unregisterListener(final Object listener) {
        this.listeners.values().forEach(list -> list.forEach(func -> list.removeIf(method -> method.getDeclaringClass() == listener.getClass())));
    }

    private void dispatch(final Event event) {
        final Iterator<Method> iterator = null;
        final Method[] m = new Method[1];
        this.listeners.forEach((targetEvent, methods) -> {
            if (targetEvent == event.getClass()) {
                methods.iterator();
                while (iterator.hasNext()) {
                    m[0] = iterator.next();
                    m[0].setAccessible(true);
                    try {
                        m[0].invoke(Astra.moduleManager.getModule(m[0].getDeclaringClass()), event);
                    }
                    catch (IllegalAccessException ex) {}
                    catch (InvocationTargetException ex2) {}
                }
            }
        });
    }//FIX WHATEVER THIS SHIT IS
}//I WANNA GIVE THIS UP
//I WANNA LET THIS DOWN
//I WANNA TURN AROUND
//AND DESERT YOU
