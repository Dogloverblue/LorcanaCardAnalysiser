package me.lowen.imagetools;

import java.awt.Color;

public class ColorUtils {

	public static boolean isColorLight(Color clr) {
		if (getColorBrightness(clr) > 180) {
			return true;
			
		}
		return false;
	}
	
	
	public static double getColorBrightness(Color color) {
		return ((0.2126 * color.getRed()) + (0.7152 * color.getGreen()) + (0.0722 * color.getBlue()));
	}

	public static boolean isColorDark(Color clr) {
		return (getColorBrightness(clr) < 100);
	}
	
	public static boolean areColorsClose(Color a, Color z, int threshold) {
	    int r = (int)a.getRed() - z.getRed(),
	    		
	        g = (int)a.getGreen() - z.getGreen(),
	        b = (int)a.getBlue() - z.getBlue();
	    
	    return (r*r + g*g + b*b) <= threshold*threshold;
	}


}
