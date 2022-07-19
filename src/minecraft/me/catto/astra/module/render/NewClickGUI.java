package me.catto.astra.module.render;

import me.catto.astra.Astra;
import me.catto.astra.module.Category;
import me.catto.astra.module.Module;
import org.lwjgl.input.Keyboard;

public class NewClickGUI extends Module {
    public NewClickGUI() {
        super("NewClickGUI", Keyboard.KEY_RSHIFT, Category.RENDER);
    }

    @Override
    public void onEnable() {
        super.onEnable();

        mc.displayGuiScreen(Astra.instance.shitGUI);
        toggle();

    }
}
