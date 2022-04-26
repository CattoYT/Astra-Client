package me.catto.astra;

import de.Hero.clickgui.ClickGUI;
import de.Hero.settings.SettingsManager;
import me.catto.astra.altmanager.AltManager;
import me.catto.astra.extensions.DiscordRP;
import me.catto.astra.module.ModuleManager;
import me.catto.astra.module.Module;

import org.lwjgl.opengl.Display;

public class Astra {

    public static Astra instance = new Astra();

    public static String name = "Astra", version = "1.8.8 | Build B4", creator = "Catto";

    public static SettingsManager settingsManager;
    public static ModuleManager moduleManager;
    public static ClickGUI clickGUI;
    public static AltManager altManager;


    public static DiscordRP discordRP = new DiscordRP();

    public static void startClient() {
        settingsManager = new SettingsManager();
        moduleManager = new ModuleManager();
        clickGUI = new ClickGUI();
        altManager = new AltManager();
        discordRP.start();





        Display.setTitle(name + " " + version + " by " + creator);
    }

    public static DiscordRP getDiscordRP() {
        return discordRP;
    }
}
