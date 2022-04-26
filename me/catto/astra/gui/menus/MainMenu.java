package me.catto.astra.gui.menus;

import me.catto.astra.Astra;
import me.catto.astra.altmanager.GuiAltManager;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;


public class MainMenu extends GuiScreen {

    public MainMenu() {

    }

    public void initGui() {

    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        mc.getTextureManager().bindTexture(new ResourceLocation("astra/Images/Mainbackground.png"));
        this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
        System.out.println("Loaded CustomTitle");
        this.drawGradientRect(0, height - 100, width, height, 0x0000000, 0xff000000);

        String[] buttons = {"Singleplayer", "Multiplayer", "Settings", "Alt Manager", "Quit" };

        int count = 0;
        for(String name : buttons) {
            float x = (width/ buttons.length) * count + (width/ buttons.length)/2f - mc.fontRendererObj.getStringWidth(name)/2f;
            float y = height - 20;

            boolean hovered = mouseX >= x && mouseY >= y && mouseX < x + mc.fontRendererObj.getStringWidth(name) && mouseY < y + mc.fontRendererObj.FONT_HEIGHT;
            this.drawCenteredString(mc.fontRendererObj, name, (width/ buttons.length) * count + (width/ buttons.length)/2f, height - 20, hovered ? 0xD517D5 : -1);
            count++;
        }



        GlStateManager.pushMatrix();
        GlStateManager.translate(width/2f, height/2f, 0);
        GlStateManager.scale(2, 2, 1);
        GlStateManager.translate(-(width/2f), -(height/2f), 0);
        this.drawCenteredString(mc.fontRendererObj, Astra.name,  width/2f, height/2f - mc.fontRendererObj.FONT_HEIGHT/2f, -1);
        GlStateManager.popMatrix();
    }

    public void mouseClicked(int mouseX, int mouseY, int button) {
        String[] buttons = {"Singleplayer", "Multiplayer", "Settings", "Alt Manager", "Quit" };


        int count = 0;
        for(String name : buttons) {
            float x = (width/ buttons.length) * count + (width/ buttons.length)/2f - mc.fontRendererObj.getStringWidth(name)/2f;
            float y = height - 20;

            if(mouseX >= x && mouseY >= y && mouseX < x + mc.fontRendererObj.getStringWidth(name) && mouseY < y + mc.fontRendererObj.FONT_HEIGHT) {
                switch(name) {
                    case "Singleplayer":
                        mc.displayGuiScreen(new GuiSelectWorld(this));
                        break;

                    case "Multiplayer":
                        mc.displayGuiScreen(new GuiMultiplayer(this));
                        break;

                    case "Settings":
                        mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
                        break;

                    case "Alt Manager":
                        mc.displayGuiScreen(new GuiAltManager());
                        break;

                    case "Quit":
                        mc.shutdown();
                        break;
                }
            }

            count++;
        }
    }

    public void onGuiClosed() {

    }

}

