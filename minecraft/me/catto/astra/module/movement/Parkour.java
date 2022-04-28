package me.catto.astra.module.movement;

import me.catto.astra.module.Category;
import me.catto.astra.module.Module;
import net.minecraft.entity.Entity;
import org.lwjgl.input.Keyboard;

public class Parkour extends Module {
    public Parkour() {
        super("Parkour", Keyboard.KEY_O, Category.MOVEMENT);
    }

    public void onUpdate() {
        if(this.isToggled()) {
            if(mc.thePlayer.onGround && !mc.thePlayer.isSneaking() && !this.mc.gameSettings.keyBindSneak.pressed &&
                    this.mc.theWorld.getCollidingBoundingBoxes((Entity)mc.thePlayer, mc.thePlayer.getEntityBoundingBox().offset(0.0D, -0.5D, 0.0D).expand(-0.001D, 0.0D, -0.001D)).isEmpty())
                mc.thePlayer.jump();
        }
    }
}
