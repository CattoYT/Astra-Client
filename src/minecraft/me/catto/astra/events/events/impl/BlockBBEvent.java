// 
// Decompiled by Procyon v0.5.36
// 

package me.catto.astra.events.events.impl;

import me.catto.astra.events.events.Event;
import net.minecraft.block.Block;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;

public class BlockBBEvent extends Event
{
    public BlockPos pos;
    public Block block;
    public AxisAlignedBB blockBB;
    
    public BlockBBEvent(final BlockPos pos, final Block block, final AxisAlignedBB blockBB) {
        this.pos = pos;
        this.block = block;
        this.blockBB = blockBB;
    }
}
