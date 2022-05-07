package me.catto.astra.module.render;

import me.catto.astra.module.Category;
import me.catto.astra.module.Module;
import net.minecraft.block.Block;

import java.util.ArrayList;

public class Xray extends Module {

    public static boolean enabled;
    private float oldGamma;
    public ArrayList<Block> xrayBlocks = new ArrayList<Block>();

    public Xray() {
        super("Xray", 0, Category.RENDER);
    }

    @Override
    public void onEnable() {
        Xray.enabled = true;
        oldGamma = mc.gameSettings.gammaSetting;
        mc.gameSettings.gammaSetting = 100.0F;
        mc.gameSettings.ambientOcclusion = 0;
        mc.renderGlobal.loadRenderers();
    }

    @Override
    public void onDisable() {
        Xray.enabled = false;
        mc.gameSettings.gammaSetting = this.oldGamma;
        mc.gameSettings.ambientOcclusion = 1;
        mc.renderGlobal.loadRenderers();
    }

    public boolean shouldXray(Block blockid) {
        if(this.xrayBlocks.contains(blockid)) {
            return true;
        }
        return false;
    }
}
