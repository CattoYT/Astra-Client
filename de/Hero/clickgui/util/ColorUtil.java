package de.Hero.clickgui.util;

import java.awt.Color;

//Deine Imports
import me.catto.astra.Astra;

/**
 *  Made by HeroCode
 *  it's free to use
 *  but you have to credit me
 *
 *  @author HeroCode
 */
public class ColorUtil {
	
	public static Color getClickGUIColor(){
		return new Color((int) Astra.instance.settingsManager.getSettingByName("GuiRed").getValDouble(), (int)Astra.instance.settingsManager.getSettingByName("GuiGreen").getValDouble(), (int)Astra.instance.settingsManager.getSettingByName("GuiBlue").getValDouble());
	}
}
