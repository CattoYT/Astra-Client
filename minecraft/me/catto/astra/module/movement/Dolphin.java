package me.catto.astra.module.movement;

import me.catto.astra.module.Category;
import me.catto.astra.module.Module;

public class Dolphin extends Module {
    public Dolphin() {
        super("Dolphin", 0, Category.MOVEMENT);
    }

    @Override
    public void onUpdate() {
        if(this.isToggled()) {
            if(mc.thePlayer.isInWater()) {
                mc.thePlayer.motionY += 0.04;
            }
        }
    }
}
