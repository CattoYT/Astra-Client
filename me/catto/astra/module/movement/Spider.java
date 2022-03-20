package me.catto.astra.module.movement;

import me.catto.astra.module.Category;
import me.catto.astra.module.Module;
import me.catto.astra.utils.IFuckedYourCodeProbably;

public class Spider extends Module {
    public Spider() {
        super("Spider", 0, Category.MOVEMENT);
    }

    @Override
    public void onUpdate() {
        if(this.isToggled()) {
            if(IFuckedYourCodeProbably.isCollidedHorizontally()) {
                IFuckedYourCodeProbably.setMotionY(0.2);

                float var6 = 0.15f;

                if(IFuckedYourCodeProbably.getMotionX() < (double)-var6) {
                    IFuckedYourCodeProbably.setMotionX((double)-var6);
                }

                if(IFuckedYourCodeProbably.getMotionX() > (double)-var6) {
                    IFuckedYourCodeProbably.setMotionX((double)-var6);
                }

                if(IFuckedYourCodeProbably.getMotionZ() < (double)-var6) {
                    IFuckedYourCodeProbably.setMotionZ((double)-var6);
                }

                if(IFuckedYourCodeProbably.getMotionZ() > (double)-var6) {
                    IFuckedYourCodeProbably.setMotionZ((double)-var6);
                }

                IFuckedYourCodeProbably.setFallDistance(0);

                if(IFuckedYourCodeProbably.getMotionY() < 0.15D) {
                    IFuckedYourCodeProbably.setMotionY(-0.15D);
                }
            }
        }
        super.onUpdate();
    }
}
