package me.catto.astra.module.movement;

import me.catto.astra.module.Category;
import me.catto.astra.module.Module;


public class BunnyHop extends Module {
    public BunnyHop() {
        super("BunnyHop", 0, Category.MOVEMENT);
    }

    @Override

    public void onUpdate() {
        if(this.isToggled()) {
            if (mc.thePlayer.onGround) {
                mc.thePlayer.jump();
            }
        }
    }
}