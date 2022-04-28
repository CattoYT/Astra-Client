package me.catto.astra.module.movement;

import me.catto.astra.module.Category;
import me.catto.astra.module.Module;
import org.lwjgl.input.Keyboard;

public class Speed extends Module {
    public Speed() {
        super("Speed", Keyboard.KEY_X, Category.MOVEMENT);
    }

    public void onUpdate() {
        if(this.isToggled()) {
            if(mc.thePlayer.onGround) {
                mc.thePlayer.motionX *= 2.0f;
                mc.thePlayer.motionZ *= 2.0f;
            }
        }
    }
}
