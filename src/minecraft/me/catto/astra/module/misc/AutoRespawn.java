package me.catto.astra.module.misc;

import me.catto.astra.module.Category;
import me.catto.astra.module.Module;

public class AutoRespawn extends Module {
    public AutoRespawn() {
        super("AutoRespawn", 0, Category.MISC);
    }

    @Override
    public void onUpdate() {
        if (this.isToggled()) {
            if (mc.thePlayer.isDead) {
                mc.thePlayer.respawnPlayer();
            }
        }
    }
}
