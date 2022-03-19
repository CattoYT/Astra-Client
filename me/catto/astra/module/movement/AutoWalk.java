package me.catto.astra.module.movement;

import me.catto.astra.module.Category;
import me.catto.astra.module.Module;

public class AutoWalk extends Module {
    public AutoWalk() {
        super("AutoWalk", 0, Category.MOVEMENT);
    }

    @Override
    public void onUpdate() {
        if (isToggled()) {
            mc.gameSettings.keyBindForward.pressed = true;
        }
    }

    @Override
    public void onDisable() {
        if (isToggled()) {
            mc.gameSettings.keyBindForward.pressed = false;
            super.onDisable();
        }
    }
}
