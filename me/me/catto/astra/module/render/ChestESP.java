package me.catto.astra.module.render;

import me.catto.astra.module.Category;
import me.catto.astra.module.Module;
import me.catto.astra.utils.esp.ChestESPUtils;
import net.minecraft.tileentity.TileEntityChest;

public class ChestESP extends Module {

    public ChestESP() {
        super("ChestESP", 0, Category.RENDER);
    }

    public void onRender() {
        if(this.isToggled()) {
            for(Object o : mc.theWorld.loadedTileEntityList) {
                if(o instanceof TileEntityChest) {
                    ChestESPUtils.blockESPBox(((TileEntityChest)o).getPos());
                }
            }
        }
    }
}
