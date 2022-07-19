package me.catto.astra.clickgui;

import me.catto.astra.utils.ColorUtils;
import net.minecraft.client.gui.GuiScreen;

public class Clickgui extends GuiScreen {

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

        drawRect(0, 0, width, height, ColorUtils.getAstolfoColor(-6000, 0));
        drawCenteredString(mc.fontRendererObj, "This is likely broken + WIP", width/2f, height/2f - mc.fontRendererObj.FONT_HEIGHT/2f, -1);
    }

}
