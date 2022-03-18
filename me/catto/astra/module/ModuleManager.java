package me.catto.astra.module;

import me.catto.astra.module.combat.*;
import me.catto.astra.module.movement.*;

import java.util.ArrayList;

import me.catto.astra.module.movement.Sprint;

public class ModuleManager {

    private static ArrayList<Module> mods;

    public ModuleManager() {
        mods = new ArrayList<Module>();
        //COMBAT
        newMod(new Aura());
        //MOVEMENT
        newMod(new Sprint());
        //PLAYER

        //RENDER

        //MISC
    }

    public static void newMod(Module m) {
        mods.add(m);
    }

    public static ArrayList<Module> getModules() {
        return mods;
    }

    public static void onUpdate() {
        for(Module m : mods) {
            m.onUpdate();
        }
    }

    public static void  onRender() {
        for (Module m : mods) {
            m.onRender();
        }
    }

    public static void onKey(int k) {
        for(Module m : mods) {
            if(m.getKey() == k) {
                m.toggle();
            }
        }
    }

}
