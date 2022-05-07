package me.catto.astra.module.player;

import me.catto.astra.module.Category;
import me.catto.astra.module.Module;

public class FastPlace extends Module {
    public FastPlace() {
        super("FastPlace", 0, Category.PLAYER);
    }

    @Override
    public void onUpdate() {
        if (this.isToggled()) {
            mc.rightClickDelayTimer = 0;
        }

    }
}
