// 
// Decompiled by Procyon v0.5.36
// 

package me.catto.astra.utils.sexutils;

import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.Team;

import java.util.ArrayList;

public class EntityManager extends MinecraftInstance
{
    public static boolean isTarget(final Entity ent, final boolean antibot) {
        if (antibot && isEntityBot(ent)) {
            return false;
        }
        if (ent == EntityManager.mc.thePlayer || ent instanceof EntityArmorStand) {
            return false;
        }
        if (ent instanceof EntityLivingBase && ((EntityLivingBase)ent).getHealth() <= 0.0f && !Targets.DEAD.on) {
            return false;
        }
        if (ent instanceof EntityLivingBase) {
            final Team lol = ((EntityLivingBase)ent).getTeam();
            final Team lel = EntityManager.mc.thePlayer.getTeam();
            if (lol != null && lel != null && lol.isSameTeam(lel)) {
                return Targets.TEAMS.on;
            }
        }
        if (isMob(ent) || isAnimal(ent)) {
            return Targets.MOBS.on;
        }
        if (ent instanceof EntityPlayer) {
            return Targets.PLAYERS.on;
        }
        return ent.isInvisible() && Targets.INVISIBLE.on;
    }
    
    public static boolean isAnimal(final Entity ent) {
        return ent instanceof EntitySheep || ent instanceof EntityCow || ent instanceof EntityPig || ent instanceof EntityChicken || ent instanceof EntityRabbit || ent instanceof EntityHorse || ent instanceof EntityBat;
    }
    
    public static boolean isMob(final Entity ent) {
        return ent instanceof EntityZombie || ent instanceof EntitySkeleton || ent instanceof EntityVillager || ent instanceof EntitySlime || ent instanceof EntityCreeper || ent instanceof EntityEnderman || ent instanceof EntityEndermite || ent instanceof EntitySpider || ent instanceof EntityWitch || ent instanceof EntityWither || ent instanceof EntityBlaze;
    }
    
    private static boolean isEntityBot(final Entity entity) {
        return entity.getDisplayName().getUnformattedTextForChat().toLowerCase().equals("§8npc §8| §8shop") || entity.getDisplayName().getUnformattedText().toLowerCase().equals("§8npc §8| §8upgrades");
    }
    
    private static boolean isOnTab(final Entity entity) {
        for (final NetworkPlayerInfo info : EntityManager.mc.getNetHandler().getPlayerInfoMap()) {
            if (info.getGameProfile().getName().equals(entity.getDisplayName().getFormattedText())) {
                return true;
            }
        }
        return false;
    }
    
    public enum Targets
    {
        MOBS("Mobs", false), 
        PLAYERS("Players", true), 
        INVISIBLE("Invisible", true), 
        DEAD("Dead", false), 
        TEAMS("Teams", true);
        
        public String displayName;
        public boolean on;
        
        private Targets(final String displayName, final boolean on) {
            this.displayName = displayName;
            this.on = on;
        }
    }
    
    public static class FriendManager
    {
        public static ArrayList<String> friends;
        
        public static void addFriend(final String name) {
            FriendManager.friends.add(name);
        }
        
        public static void removeFriend(final String name) {
            FriendManager.friends.remove(name);
        }
        
        public static boolean isFriend(final String name) {
            return FriendManager.friends.contains(name);
        }
        
        public static boolean isFriend(final Entity entity) {
            return isFriend(entity.getName());
        }
        
        static {
            FriendManager.friends = new ArrayList<String>();
        }
    }
    
    public static class TargetManager
    {
        public static ArrayList<String> targets;
        
        public static void addTarget(final String name) {
            TargetManager.targets.add(name);
        }
        
        public static void removeTarget(final String name) {
            TargetManager.targets.remove(name);
        }
        
        public static boolean isTarget(final String name) {
            return TargetManager.targets.contains(name);
        }
        
        public static boolean isTarget(final Entity entity) {
            return isTarget(entity.getName());
        }
        
        static {
            TargetManager.targets = new ArrayList<String>();
        }
    }
}
