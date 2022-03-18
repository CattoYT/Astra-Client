package me.catto.astra.gui;

import me.catto.astra.Astra;
import me.catto.astra.module.Module;
import me.catto.astra.utils.ColorUtils;
import me.catto.astra.utils.Wrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;

public class GuiIngameHook extends GuiIngame {


    public GuiIngameHook(Minecraft mcIn) {
        super(mcIn);
    }

    public void renderGameOverlay(float p_175180_1_) {
        super.renderGameOverlay(p_175180_1_);


        drawRect(2, 2, 100, 14, 0x80000000);
        Wrapper.fr.drawString("Astra", 4, 4, 0xD517D5);
        Wrapper.fr.drawString("FPS " + mc.getDebugFPS(), 50, 4, -1);


        renderArrayList();
    }

    private void renderArrayList(){
        int yCount = 10;
        int index = 0;
        long x = 0;
        for (Module m : Astra.instance.moduleManager.getModules()){
            m.onRender();

            if(m.isToggled()) {
                Wrapper.fr.drawString("- " + m.getName(), 5, yCount + 5, ColorUtils.rainbowEffect(index + x*2000000000L, 1.0F).getRGB());
                yCount += 10;
                index++;
                x++;
            }
        }


    }
}
