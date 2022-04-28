package me.catto.astra.module.misc;

import me.catto.astra.module.Category;
import me.catto.astra.module.Module;
import me.catto.astra.events.event.EventListener;
import me.catto.astra.events.event.MotionEvent;


public final class ResetVL extends Module {

    private int jumped;
    private double y;

    public ResetVL() {
        super("ResetVL", 0, Category.EXPLOIT);
    }

    private final EventListener<MotionEvent> onMotion = e -> {
        if(mc.thePlayer.onGround) {
            if(jumped <= 25) {
                mc.thePlayer.motionY = 0.11;
                jumped++;
            }
        }
        if(jumped <= 25) {
            mc.thePlayer.posY = y;
            mc.timer.timerSpeed = 2.25f;
        }else{
            mc.timer.timerSpeed = 1;
            toggle();
        }
    };

    @Override
    public void onEnable() {
        System.out.println("ResetVL Enabled");
        jumped = 0;
        y = mc.thePlayer.posY;
        super.onEnable();
    }
}
