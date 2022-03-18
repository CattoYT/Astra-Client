package me.catto.astra;

import me.catto.astra.module.ModuleManager;
import org.lwjgl.opengl.Display;

public class Astra {

    public static Astra instance = new Astra();

    public static String name = "Astra", version = "1.8.8 B1", creator = "Catto";

    public static ModuleManager moduleManager;

    public static void startClient() {
        moduleManager = new ModuleManager();





        Display.setTitle(name + " " + version + " by " + creator);
    }
}
