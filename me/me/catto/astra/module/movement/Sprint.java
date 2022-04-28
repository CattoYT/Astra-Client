package me.catto.astra.module.movement;

import org.lwjgl.input.Keyboard;

import me.catto.astra.module.Category;
import me.catto.astra.module.Module;


public class Sprint extends Module {

    public Sprint() {
        super("Sprint", Keyboard.KEY_Z, Category.MOVEMENT);
    }

    @Override
    public void onUpdate() {
        if(this.isToggled()) {
            mc.thePlayer.setSprinting(true);
        }
        else{
            mc.thePlayer.setSprinting(false);
        }
    }
}
