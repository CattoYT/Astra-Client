package me.catto.astra.module.movement;

import com.google.common.eventbus.Subscribe;
import me.catto.astra.events.events.impl.SlowdownEvent;
import me.catto.astra.events.events.impl.UpdatePlayerEvent;
import me.catto.astra.module.Category;
import me.catto.astra.module.Module;
import me.catto.astra.utils.sexutils.PacketUtil;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFood;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class NoSlow extends Module {

    public NoSlow() {
        super("NoSlow", 0, Category.MOVEMENT);
    }


    @Subscribe
    public void onMotion(final UpdatePlayerEvent event) {
        if (this.mc.thePlayer.isBlocking()) {
            this.mc.playerController.syncCurrentPlayItem();
            PacketUtil.send(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, EnumFacing.DOWN));
        }
    }

}