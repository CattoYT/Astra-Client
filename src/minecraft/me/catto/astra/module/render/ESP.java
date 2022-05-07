package me.catto.astra.module.render;

import de.Hero.settings.Setting;
import me.catto.astra.Astra;
import me.catto.astra.module.Category;
import me.catto.astra.module.Module;
import me.catto.astra.utils.esp.ChestESPUtils;
import me.catto.astra.utils.esp.MobESPUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityChest;

public class ESP extends Module {
    public ESP() {
        super("ESP", 0 , Category.RENDER);
    }

    public void setup() {
        Astra.settingsManager.rSetting(new Setting("Players", this, false));
        Astra.settingsManager.rSetting(new Setting("Chest", this, false));
        Astra.settingsManager.rSetting(new Setting("Mobs", this, false));
        Astra.settingsManager.rSetting(new Setting("Animals", this, false));
    }

    public void onRender() {
        if(this.isToggled() && Astra.settingsManager.getSettingByName("Players").getValBoolean()) {
            for(Object e : mc.theWorld.loadedEntityList) {
                if(e instanceof EntityPlayer) {
                    MobESPUtils.entityESPBox((Entity)e, 0);
                }
            }
        }
        if(this.isToggled() && Astra.settingsManager.getSettingByName("Chest").getValBoolean()) {
                for(Object o : mc.theWorld.loadedTileEntityList) {
                    if(o instanceof TileEntityChest) {
                        ChestESPUtils.blockESPBox(((TileEntityChest)o).getPos());
                }
            }
        }
        if(this.isToggled() && Astra.settingsManager.getSettingByName("Mobs").getValBoolean()) {
            for(Object h : mc.theWorld.loadedEntityList) {
                if(h instanceof EntityMob) {
                    MobESPUtils.entityESPBox((Entity)h, 0);
                }
            }
        }
        if(this.isToggled() && Astra.settingsManager.getSettingByName("Animals").getValBoolean()) {
            for(Object f : mc.theWorld.loadedEntityList) {
                if(f instanceof EntityMob) {
                    MobESPUtils.entityESPBox((Entity)f, 0);
                }
            }
        }
    }
}
