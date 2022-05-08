package me.catto.astra.module.combat;

import de.Hero.settings.Setting;
import me.catto.astra.Astra;
import me.catto.astra.utils.sexutils.EntityManager;
import me.catto.astra.utils.sexutils.PacketUtil;
import me.catto.astra.utils.sexutils.PlayerUtil;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.C02PacketUseEntity;
import org.lwjgl.input.Keyboard;

import me.catto.astra.module.Category;
import me.catto.astra.module.Module;
import net.minecraft.entity.Entity;

import java.util.Iterator;
import java.util.List;


public class Aura extends Module {
    public Aura() {
        super("Aura", Keyboard.KEY_R, Category.COMBAT);
    }

    public static EntityLivingBase target;
    private int targetIndex;

    private void updateTarget() {
        List<EntityLivingBase> entities = this.getTargets();
        target = entities.size() > 0 ? (EntityLivingBase) entities.get(0) : null;
    }

    public void setup() {
        Astra.settingsManager.rSetting(new Setting("KeepSprint", this, true));

    }
    @Override
    public void onUpdate() {
        if (!this.isToggled())

            return;

        for (Iterator<Entity> entities = mc.theWorld.loadedEntityList.iterator(); entities.hasNext(); ) {
            Object theObject = entities.next();
            EntityLivingBase entity = null;
            if (theObject instanceof EntityLivingBase) {
                entity = (EntityLivingBase) theObject;

                if (entity instanceof EntityPlayerSP) continue;

                if (mc.thePlayer.getDistanceToEntity(entity) <= 6.2173613F) {
                    if (entity.isEntityAlive()) {
                        PacketUtil.send(new C02PacketUseEntity(entity, C02PacketUseEntity.Action.ATTACK));
                        mc.playerController.attackEntity(mc.thePlayer, entity);
                        mc.thePlayer.swingItem();

                        continue;
                    }
                }
            }


        }


        super.onUpdate();
    }

    private List<EntityLivingBase> getTargets() {
        List entities = (List) this.mc.theWorld.loadedEntityList.stream().filter((entity) -> {
            return entity instanceof EntityLivingBase;
        }).map((entity) -> {
            return (EntityLivingBase) entity;
        }).filter((entity) -> {
            if (entity instanceof EntityPlayer && !EntityManager.Targets.PLAYERS.on) {
                return false;
            } else if (!(entity instanceof EntityPlayer) && !EntityManager.Targets.MOBS.on) {
                return false;
            } else if (entity.isInvisible() && !EntityManager.Targets.INVISIBLE.on) {
                return false;
            } else if (PlayerUtil.isOnSameTeam(entity) && !EntityManager.Targets.TEAMS.on) {
                return false;
            } else if (entity.isDead && !EntityManager.Targets.DEAD.on) {
                return false;
            } else if (entity.deathTime != 0 && !EntityManager.Targets.DEAD.on) {
                return false;
            } else if (entity.ticksExisted < 2) {
                return false;
            } else {
                if (entity instanceof EntityPlayer) {
                    EntityPlayer player = (EntityPlayer) entity;
                    Iterator var3 = EntityManager.FriendManager.friends.iterator();

                    while (var3.hasNext()) {
                        String name = (String) var3.next();
                        if (name.equalsIgnoreCase(player.getName())) {
                            return false;
                        }
                    }
                }

                return this.mc.thePlayer != entity;
            }
        });
        return entities;
    }
}
