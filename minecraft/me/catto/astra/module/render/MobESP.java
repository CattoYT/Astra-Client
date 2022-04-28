package me.catto.astra.module.render;

import me.catto.astra.module.Category;
import me.catto.astra.module.Module;
import me.catto.astra.utils.esp.MobESPUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;

public class MobESP extends Module {
    public MobESP() {
        super("MobESP", 0, Category.RENDER);
    }


    @Override
    public void onRender() {
        if (this.isToggled()) {
            for(Object m: mc.theWorld.loadedEntityList) {
                if(m instanceof EntityMob) {
                    MobESPUtils.entityESPBox((Entity)m, 0);
                }
            }
        }
    }
}
