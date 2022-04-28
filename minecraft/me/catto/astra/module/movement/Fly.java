package me.catto.astra.module.movement;

import org.lwjgl.input.Keyboard;

import me.catto.astra.module.Category;
import me.catto.astra.module.Module;


public class Fly extends Module {
    public Fly() {
        super("Fly", Keyboard.KEY_F, Category.MOVEMENT);
    }

    public static float flySpeed = 0.1f;

    public void onDisable() {
        mc.thePlayer.capabilities.isFlying = false;
        super.onDisable();
    }

    public void onUpdate() {
        if(this.isToggled()) {
            mc.thePlayer.capabilities.isFlying = true;

            if(mc.gameSettings.keyBindJump.isPressed()) {
                mc.thePlayer.motionY += 0.2f;
            }

            if(mc.gameSettings.keyBindSneak.isPressed()) {
                mc.thePlayer.motionY -= 0.2f;
            }

            if(mc.gameSettings.keyBindForward.isPressed()) {
                mc.thePlayer.capabilities.setFlySpeed(flySpeed);
            }

            super.onDisable();
        }
    }
}
