package me.lowen.imagechanges;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import me.lowen.imagetools.ColorUtils;
import me.lowen.imagetools.ImageChange;

public class MakePowerReadable extends ImageChange {

	public MakePowerReadable() {
		super();
	}

	
	
	@Override
	public boolean applyChanges(BufferedImage img) {
		BufferedImage subImg =copyImage(img.getSubimage(1100, 1150, 85, 90));
		for (int width = 0; width < subImg.getWidth() -1; width++) {
			for (int height = 0; height < subImg.getHeight() -1; height++) {
				Color clr = new Color(subImg.getRGB(width, height));
				if (ColorUtils.isColorDark(clr)) {
					subImg.setRGB(width, height, Color.black.getRGB());
				} else {
					subImg.setRGB(width, height, Color.white.getRGB());
				}
			}
		}
		// To get rid of an artifact in the bottom right
		subImg.getGraphics().fillRect(90, 95, 10, 10);
		
		Graphics phics = img.getGraphics();
		phics.fillRect(1035, 1100, 175, 200);
		// Cropped by one to get right of artifacts on the right and lower side
		phics.drawImage(subImg.getSubimage(0, 0, 84, 89), 1100, 1150, Color.GREEN, null);
		return false;
	}
	
	public static BufferedImage copyImage(BufferedImage source){
	    BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
	    Graphics g = b.getGraphics();
	    g.drawImage(source, 0, 0, null);
	    g.dispose();
	    return b;
	}

}
