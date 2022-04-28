package me.catto.astra.module.render;

import java.util.ArrayList;

import me.catto.astra.Astra;
import org.lwjgl.input.Keyboard;

import de.Hero.settings.Setting;
import me.catto.astra.module.Module;
import me.catto.astra.module.Category;

public class ClickGui extends Module{

    public ClickGui() {
        super("ClickGui", Keyboard.KEY_RSHIFT, Category.RENDER);
    }

    @Override
    public void setup() {
        ArrayList<String> options = new ArrayList<>();
        options.add("New");
        options.add("JellyLike");
        Astra.instance.settingsManager.rSetting(new Setting("Design", this, "New", options));
        Astra.instance.settingsManager.rSetting(new Setting("Sound", this, false));
        Astra.instance.settingsManager.rSetting(new Setting("GuiRed", this, 255, 0, 255, true));
        Astra.instance.settingsManager.rSetting(new Setting("GuiGreen", this, 0, 0, 255, true));
        Astra.instance.settingsManager.rSetting(new Setting("GuiBlue", this, 255, 0, 255, true));
    }

    @Override
    public void onEnable() {
        super.onEnable();

        mc.displayGuiScreen(Astra.instance.clickGUI);
        toggle();
    }
}