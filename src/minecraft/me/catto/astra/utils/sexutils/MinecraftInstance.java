package me.catto.astra.utils.sexutils;

import net.minecraft.client.Minecraft;

public class MinecraftInstance
{
    public static Minecraft mc;

    static {
        MinecraftInstance.mc = Minecraft.getMinecraft();
    }
}