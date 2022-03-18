package me.catto.astra.module.combat;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.input.Keyboard;

import me.catto.astra.module.Category;
import me.catto.astra.module.Module;
import net.minecraft.entity.Entity;

import java.util.Iterator;


public class Aura extends Module {

    public Aura() {
        super("Aura", Keyboard.KEY_R, Category.COMBAT);
    }

    @Override
    public void onUpdate() {
        if(!this.isToggled())
            return;

        for(Iterator<Entity> entities = mc.theWorld.loadedEntityList.iterator(); entities.hasNext();) {
            Object theObject = entities.next();
            if(theObject instanceof EntityLivingBase) {
                EntityLivingBase entity = (EntityLivingBase) theObject;

                if(entity instanceof EntityPlayerSP) continue;

                if(mc.thePlayer.getDistanceToEntity(entity) <= 6.2173613F) {
                    if(entity.isEntityAlive()) {
                        mc.playerController.attackEntity(mc.thePlayer, entity);
                        mc.thePlayer.swingItem();
                        continue;
                    }
                }
            }
        }



        super.onUpdate();
    }
}
