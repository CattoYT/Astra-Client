// 
// Decompiled by Procyon v0.5.36
// 

package me.catto.astra.utils.sexutils;

import me.catto.astra.events.events.impl.UpdatePlayerEvent;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.*;

import java.util.List;

public class PlayerUtil extends MinecraftInstance
{
    private static final MillisTimer verus_timer;
    
    public static Block getBlockRelativeToPlayer(final double offsetX, final double offsetY, final double offsetZ) {
        return PlayerUtil.mc.theWorld.getBlockState(new BlockPos(PlayerUtil.mc.thePlayer.posX + offsetX, PlayerUtil.mc.thePlayer.posY + offsetY, PlayerUtil.mc.thePlayer.posZ + offsetZ)).getBlock();
    }
    
    public static boolean isInsideBlock() {
        if (PlayerUtil.mc.thePlayer.ticksExisted < 5) {
            return false;
        }
        final EntityPlayerSP player = PlayerUtil.mc.thePlayer;
        final WorldClient world = PlayerUtil.mc.theWorld;
        final AxisAlignedBB bb = player.getEntityBoundingBox();
        for (int x = MathHelper.floor_double(bb.minX); x < MathHelper.floor_double(bb.maxX) + 1; ++x) {
            for (int y = MathHelper.floor_double(bb.minY); y < MathHelper.floor_double(bb.maxY) + 1; ++y) {
                for (int z = MathHelper.floor_double(bb.minZ); z < MathHelper.floor_double(bb.maxZ) + 1; ++z) {
                    final Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
                    final AxisAlignedBB boundingBox;
                    if (block != null && !(block instanceof BlockAir) && (boundingBox = block.getCollisionBoundingBox(world, new BlockPos(x, y, z), world.getBlockState(new BlockPos(x, y, z)))) != null && player.getEntityBoundingBox().intersectsWith(boundingBox)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean isMouseOver(final float yaw, final float pitch, final Entity target, final float range) {
        final float partialTicks = PlayerUtil.mc.timer.renderPartialTicks;
        final Entity entity = PlayerUtil.mc.getRenderViewEntity();
        Entity mcPointedEntity = null;
        if (entity == null || PlayerUtil.mc.theWorld == null) {
            return false;
        }
        PlayerUtil.mc.mcProfiler.startSection("pick");
        final double d0 = PlayerUtil.mc.playerController.getBlockReachDistance();
        MovingObjectPosition objectMouseOver = entity.rayTrace(d0, partialTicks);
        double d2 = d0;
        final Vec3 vec3 = entity.getPositionEyes(partialTicks);
        final boolean flag = d0 > range;
        if (objectMouseOver != null) {
            d2 = objectMouseOver.hitVec.distanceTo(vec3);
        }
        final Vec3 vec4 = PlayerUtil.mc.thePlayer.getVectorForRotation(pitch, yaw);
        final Vec3 vec5 = vec3.addVector(vec4.xCoord * d0, vec4.yCoord * d0, vec4.zCoord * d0);
        Entity pointedEntity = null;
        Vec3 vec6 = null;
        final float f = 1.0f;
        final List<Entity> list = PlayerUtil.mc.theWorld.getEntitiesInAABBexcluding(entity, entity.getEntityBoundingBox().addCoord(vec4.xCoord * d0, vec4.yCoord * d0, vec4.zCoord * d0).expand(1.0, 1.0, 1.0), (Predicate<? super Entity>)Predicates.and((Predicate)EntitySelectors.NOT_SPECTATING, Entity::canBeCollidedWith));
        double d3 = d2;
        for (final Entity entity2 : list) {
            final float f2 = entity2.getCollisionBorderSize();
            final AxisAlignedBB axisalignedbb = entity2.getEntityBoundingBox().expand(f2, f2, f2);
            final MovingObjectPosition movingobjectposition = axisalignedbb.calculateIntercept(vec3, vec5);
            if (axisalignedbb.isVecInside(vec3)) {
                if (d3 < 0.0) {
                    continue;
                }
                pointedEntity = entity2;
                vec6 = ((movingobjectposition == null) ? vec3 : movingobjectposition.hitVec);
                d3 = 0.0;
            }
            else {
                if (movingobjectposition == null) {
                    continue;
                }
                final double d4 = vec3.distanceTo(movingobjectposition.hitVec);
                if (d4 >= d3 && d3 != 0.0) {
                    continue;
                }
                pointedEntity = entity2;
                vec6 = movingobjectposition.hitVec;
                d3 = d4;
            }
        }
        if (pointedEntity != null && flag && vec3.distanceTo(vec6) > range) {
            pointedEntity = null;
            objectMouseOver = new MovingObjectPosition(MovingObjectPosition.MovingObjectType.MISS, vec6, null, new BlockPos(vec6));
        }
        if (pointedEntity != null && (d3 < d2 || objectMouseOver == null)) {
            objectMouseOver = new MovingObjectPosition(pointedEntity, vec6);
            if (pointedEntity instanceof EntityLivingBase || pointedEntity instanceof EntityItemFrame) {
                mcPointedEntity = pointedEntity;
            }
        }
        PlayerUtil.mc.mcProfiler.endSection();
        assert objectMouseOver != null;
        return mcPointedEntity == target;
    }
    
    public static boolean isHoldingSword() {
        return PlayerUtil.mc.thePlayer.ticksExisted > 3 && PlayerUtil.mc.thePlayer.getCurrentEquippedItem() != null && PlayerUtil.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword;
    }
    
    public static MovingObjectPosition getMouseOver(final float yaw, final float pitch, final float range) {
        final float partialTicks = PlayerUtil.mc.timer.renderPartialTicks;
        final Entity entity = PlayerUtil.mc.getRenderViewEntity();
        Entity mcPointedEntity = null;
        if (entity == null || PlayerUtil.mc.theWorld == null) {
            return null;
        }
        PlayerUtil.mc.mcProfiler.startSection("pick");
        final double d0 = PlayerUtil.mc.playerController.getBlockReachDistance();
        MovingObjectPosition objectMouseOver = entity.rayTrace(d0, partialTicks);
        double d2 = d0;
        final Vec3 vec3 = entity.getPositionEyes(partialTicks);
        final boolean flag = d0 > range;
        if (objectMouseOver != null) {
            d2 = objectMouseOver.hitVec.distanceTo(vec3);
        }
        final Vec3 vec4 = PlayerUtil.mc.thePlayer.getVectorForRotation(pitch, yaw);
        final Vec3 vec5 = vec3.addVector(vec4.xCoord * d0, vec4.yCoord * d0, vec4.zCoord * d0);
        Entity pointedEntity = null;
        Vec3 vec6 = null;
        final float f = 1.0f;
        final List<Entity> list = PlayerUtil.mc.theWorld.getEntitiesInAABBexcluding(entity, entity.getEntityBoundingBox().addCoord(vec4.xCoord * d0, vec4.yCoord * d0, vec4.zCoord * d0).expand(1.0, 1.0, 1.0), (Predicate<? super Entity>)Predicates.and((Predicate)EntitySelectors.NOT_SPECTATING, Entity::canBeCollidedWith));
        double d3 = d2;
        for (final Entity entity2 : list) {
            final float f2 = entity2.getCollisionBorderSize();
            final AxisAlignedBB axisalignedbb = entity2.getEntityBoundingBox().expand(f2, f2, f2);
            final MovingObjectPosition movingobjectposition = axisalignedbb.calculateIntercept(vec3, vec5);
            if (axisalignedbb.isVecInside(vec3)) {
                if (d3 < 0.0) {
                    continue;
                }
                pointedEntity = entity2;
                vec6 = ((movingobjectposition == null) ? vec3 : movingobjectposition.hitVec);
                d3 = 0.0;
            }
            else {
                if (movingobjectposition == null) {
                    continue;
                }
                final double d4 = vec3.distanceTo(movingobjectposition.hitVec);
                if (d4 >= d3 && d3 != 0.0) {
                    continue;
                }
                pointedEntity = entity2;
                vec6 = movingobjectposition.hitVec;
                d3 = d4;
            }
        }
        if (pointedEntity != null && flag && vec3.distanceTo(vec6) > range) {
            pointedEntity = null;
            objectMouseOver = new MovingObjectPosition(MovingObjectPosition.MovingObjectType.MISS, vec6, null, new BlockPos(vec6));
        }
        if (pointedEntity != null && (d3 < d2 || objectMouseOver == null)) {
            objectMouseOver = new MovingObjectPosition(pointedEntity, vec6);
            if (pointedEntity instanceof EntityLivingBase || pointedEntity instanceof EntityItemFrame) {
                mcPointedEntity = pointedEntity;
            }
        }
        PlayerUtil.mc.mcProfiler.endSection();
        assert objectMouseOver != null;
        return objectMouseOver;
    }
    
    public static void damageNormal(final float dist) {
        PacketUtil.send(new C03PacketPlayer.C04PacketPlayerPosition(PlayerUtil.mc.thePlayer.posX, PlayerUtil.mc.thePlayer.posY + dist, PlayerUtil.mc.thePlayer.posZ, false));
        PacketUtil.send(new C03PacketPlayer.C04PacketPlayerPosition(PlayerUtil.mc.thePlayer.posX, PlayerUtil.mc.thePlayer.posY, PlayerUtil.mc.thePlayer.posZ, false));
        PacketUtil.send(new C03PacketPlayer.C04PacketPlayerPosition(PlayerUtil.mc.thePlayer.posX, PlayerUtil.mc.thePlayer.posY, PlayerUtil.mc.thePlayer.posZ, true));
    }
    
    public static int damageEdit(final UpdatePlayerEvent e, final float dist, final int progress) {
        switch (progress) {
            case 0: {
                e.onGround = false;
                e.y = PlayerUtil.mc.thePlayer.posY + dist;
                return progress + 1;
            }
            case 1: {
                e.onGround = false;
                return progress + 1;
            }
            case 2: {
                e.onGround = true;
                return progress + 1;
            }
            default: {
                return progress;
            }
        }
    }
    
    public static boolean isOnSameTeam(final EntityLivingBase entity) {
        if (entity.getTeam() != null && PlayerUtil.mc.thePlayer.getTeam() != null) {
            final char c1 = entity.getDisplayName().getFormattedText().charAt(1);
            final char c2 = PlayerUtil.mc.thePlayer.getDisplayName().getFormattedText().charAt(1);
            return c1 == c2;
        }
        return false;
    }
    
    public static boolean damageVerus(final UpdatePlayerEvent e, final int jumps, final int[] progress) {
        if (progress[0] <= jumps) {
            e.onGround = false;
            if (PlayerUtil.verus_timer.hasTicksPassed(12.0f)) {
                if (progress[0] < jumps) {
                    PlayerUtil.mc.thePlayer.jump();
                }
                final int n = 0;
                ++progress[n];
                PlayerUtil.verus_timer.reset();
            }
        }
        return progress[0] > jumps;
    }
    
    static {
        verus_timer = new MillisTimer();
    }
}
