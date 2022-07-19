package me.catto.astra.module;

import me.catto.astra.module.combat.*;
import me.catto.astra.module.exploit.Disabler;
import me.catto.astra.module.movement.*;
import me.catto.astra.module.render.*;
import me.catto.astra.module.misc.*;
import me.catto.astra.module.player.*;


import java.util.ArrayList;

public class ModuleManager {

    private static ArrayList<Module> mods;

    public ModuleManager() {
        mods = new ArrayList<Module>();
        //COMBAT
        newMod(new FastBow());
        newMod(new Aura());
        //newMod(new Criticals());
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
        newMod(new BunnyHop());
        newMod(new NoSlow());

        //PLAYER
        newMod(new FastPlace());
        newMod(new Scaffold());
        //RENDER
        newMod(new ESP());
        newMod(new Capes());
        newMod(new Xray());
        newMod(new NewClickGUI());

        newMod(new ClickGui());
        //MISC
        newMod(new Disabler());
        newMod(new AutoRespawn());
        //EXPLOIT
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

    public Module getModule(final Class<?> clazz) {
        return this.mods.stream().filter(mod -> mod.getClass() == clazz).findFirst().orElse(null);
    }

}
