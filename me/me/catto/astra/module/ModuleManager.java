package me.catto.astra.module;

import me.catto.astra.module.combat.*;
import me.catto.astra.module.movement.*;
import me.catto.astra.module.render.*;
import me.catto.astra.module.misc.*;


import java.util.ArrayList;

public class ModuleManager {

    private static ArrayList<Module> mods;

    public ModuleManager() {
        mods = new ArrayList<Module>();
        //COMBAT
        newMod(new FastBow());
        newMod(new Aura());
        //MOVEMENT
        newMod(new Sprint());
        newMod(new AutoWalk());
        newMod(new Dolphin());
        newMod(new Fly());
        newMod(new NoFall());
        newMod(new Parkour());
        newMod(new Sneak());
        newMod(new Speed());
        newMod(new Spider());
        newMod(new Step());
        newMod(new NoSlow());
        //PLAYER

        //RENDER
        newMod(new ChestESP());
        newMod(new PlayerESP());
        newMod(new MobESP());

        newMod(new ClickGui());
        //MISC

        //EXPLOIT
        newMod(new ResetVL());
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
