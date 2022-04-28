package me.catto.astra.module.movement;

import me.catto.astra.module.Category;
import me.catto.astra.module.Module;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;


public class NoSlow extends Module {
    public NoSlow() {
        super("NoSlow", 0, Category.MOVEMENT);
    }
}