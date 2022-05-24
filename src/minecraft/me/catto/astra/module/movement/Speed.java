package me.catto.astra.module.movement;

import de.Hero.settings.Setting;
import me.catto.astra.Astra;
import me.catto.astra.events.events.impl.MoveEvent;
import me.catto.astra.events.riseevents.packet.MoveUtil;
import me.catto.astra.module.Category;
import me.catto.astra.module.Module;
import net.minecraft.potion.Potion;
import org.lwjgl.input.Keyboard;
import net.minecraft.network.play.client.C03PacketPlayer;

import java.util.ArrayList;

public class Speed extends Module {
    public Speed() {
        super("Speed", Keyboard.KEY_X, Category.MOVEMENT);
    }


    public boolean isMoving() {
        return mc.thePlayer != null && (mc.thePlayer.movementInput.moveForward != 0F || mc.thePlayer.movementInput.moveStrafe != 0F);
    }

    public void setup() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("LowHop");
        options.add("Skate");
        Astra.settingsManager.rSetting(new Setting("Speed", this, "LowHop", options));
    }
    public void onUpdate() {
        if(this.isToggled()) {
            if(Astra.settingsManager.getSettingByName("Speed").getValString() == "LowHop") {
                if (mc.thePlayer.onGround && isMoving()) {
                    mc.thePlayer.jump();
                    MoveUtil.strafe();
                }

            else if(Astra.settingsManager.getSettingByName("Speed").getValString() == "Skate")
                if(mc.thePlayer.onGround) {
                    mc.thePlayer.motionX *= 2.0f;
                    mc.thePlayer.motionZ *= 2.0f;
                }
            }
        }
    }
}
