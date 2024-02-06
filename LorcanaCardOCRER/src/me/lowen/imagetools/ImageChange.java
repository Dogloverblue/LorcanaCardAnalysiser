package me.lowen.imagetools;

import java.awt.image.BufferedImage;

public abstract class ImageChange {
	
	BufferedImage img;
	
	public ImageChange(BufferedImage inputImage) {
		img = inputImage;
		
	}
	
	public abstract boolean applyChanges();
	
	public BufferedImage getImage() {
		return img;
	}

}
