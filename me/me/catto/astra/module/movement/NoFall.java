package me.catto.astra.module.movement;

import me.catto.astra.module.Category;
import me.catto.astra.module.Module;
import net.minecraft.network.play.client.C03PacketPlayer;
import org.lwjgl.input.Keyboard;

public class NoFall extends Module {
    public NoFall() {
        super("NoFall", Keyboard.KEY_N, Category.MOVEMENT);
    }

    public void onUpdate() {
        if(this.isToggled()) {
            if(mc.thePlayer.fallDistance > 2f) {
                mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
            }
            super.onUpdate();
        }
    }
}
