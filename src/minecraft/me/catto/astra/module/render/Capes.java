package me.catto.astra.module.render;

import me.catto.astra.Astra;
import me.catto.astra.module.Category;
import me.catto.astra.module.Module;

import de.Hero.settings.Setting;
import net.minecraft.client.renderer.entity.layers.LayerCape;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;


public class Capes extends Module {

    public static String chosenCape;
    public static boolean capeIsToggled;

    public Capes() {
        super("Capes", 0, Category.RENDER);
    }


    @Override
    public void setup() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("Astra");
        options.add("Astolfo");
        Astra.settingsManager.rSetting(new Setting("Cape", this, "Astolfo", options));
    }

    public void onUpdate() {
        if(!this.isToggled()) {
            toggle();
        }
        if(this.isToggled()) {
            chosenCape = Astra.settingsManager.getSettingByName("Cape").getValString();
            capeIsToggled = true;

        }
    }


    public void onDisable() {
        capeIsToggled = false;
    }


}
