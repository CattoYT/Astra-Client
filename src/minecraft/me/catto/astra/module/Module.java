package me.catto.astra.module;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;

public class Module {

    protected Minecraft mc = Minecraft.getMinecraft();
    private String name;
    private int key;
    private boolean toggled;
    private Category category;

    public Module(String nm, int k, Category c) {
        name = nm;
        key = k;
        category = c;
        toggled = false;
        setup();
    }

    public Minecraft getMc() {
        return mc;
    }

    public void toggle() {
        toggled = !toggled;
        if(toggled) {
            onEnable();
        }else {
            onDisable();
        }
    }

    public void onEnable() {}
    public void onDisable() {}
    public void onUpdate() {}
    public void onRender() {}
    public void setup() {}

    public void setMc(Minecraft mc) {
        this.mc = mc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    protected EntityPlayerSP player(){
        return mc.thePlayer;
    }
    protected PlayerControllerMP playerController(){
        return mc.playerController;
    }
    protected WorldClient world(){
        return mc.theWorld;
    }




}
