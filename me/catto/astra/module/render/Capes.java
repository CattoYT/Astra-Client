package me.catto.astra.module.render;

import me.catto.astra.Astra;
import me.catto.astra.module.Category;
import me.catto.astra.module.Module;

import de.Hero.clickgui.elements.Element;
import de.Hero.clickgui.elements.ModuleButton;
import de.Hero.clickgui.elements.menu.ElementSlider;
import de.Hero.clickgui.util.ColorUtil;
import de.Hero.clickgui.util.FontUtil;
import de.Hero.settings.SettingsManager;
import de.Hero.settings.Setting;
import java.util.ArrayList;
import org.lwjgl.input.Keyboard;



public class Capes extends Module {
    public Capes() {
        super("Capes", 0, Category.RENDER);
    }

    @Override
    public void setup() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("Astra");
        options.add("Astolfo");
        Astra.instance.settingsManager.rSetting(new Setting("Cape", this, "Astra", options));

        super.onEnable();

        if(Astra.instance.settingsManager.getSettingByName("Cape").getValString().equalsIgnoreCase("Astra")) {
            renderCape("http://astra.catto.me/cape/astra.png");
        }
        if(Astra.instance.settingsManager.getSettingByName("Cape").getValString().equalsIgnoreCase("Astolfo")) {
            renderCape("http://astra.catto.me/cape/astolfo.png");
    }
    
//TODO fix the capes
        }

    public void renderCape(String url) {
        }

}
