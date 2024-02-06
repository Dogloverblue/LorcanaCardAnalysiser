package me.lowen.imagetools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class ReplaceLightColorsWithRed extends ImageChange {

	public ReplaceLightColorsWithRed(BufferedImage inputImage) {
		super(inputImage);
	}

	
	
	@Override
	public boolean applyChanges() {
		BufferedImage subImg =copyImage(img.getSubimage(1270, 1140, 100, 105));
		for (int width = 0; width < subImg.getWidth() -1; width++) {
			for (int height = 0; height < subImg.getHeight() -1; height++) {
				Color clr = new Color(subImg.getRGB(width, height));
				if (ColorUtils.isColorLight(clr)) {
					subImg.setRGB(width, height, Color.black.getRGB());
				} else {
					subImg.setRGB(width, height, Color.white.getRGB());
				}
			}
		}
		// To get rid of an artifact in the bottom right
//		subImg.getGraphics().fillRect(90, 95, 10, 10);
		
		Graphics phics = img.getGraphics();
		phics.fillRect(1200, 1100, 200, 200);
		// Cropped by one to get right of artifacts on the right and lower side
		phics.drawImage(subImg.getSubimage(0, 0, 99, 104), 1270 - 70, 1140, Color.GREEN, null);
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
