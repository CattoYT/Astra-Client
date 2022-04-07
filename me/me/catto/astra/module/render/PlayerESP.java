package me.catto.astra.module.render;

import me.catto.astra.module.Category;
import me.catto.astra.module.Module;
import me.catto.astra.utils.esp.MobESPUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class PlayerESP extends Module {
    public PlayerESP() {
        super("PlayerESP", 0, Category.RENDER);
    }


    @Override
    public void onRender() {
        if(this.isToggled()) {
            for(Object p: mc.theWorld.loadedEntityList) {
                if(p instanceof EntityPlayer) {
                    MobESPUtils.entityESPBox((Entity)p , 0);
                }
            }
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
