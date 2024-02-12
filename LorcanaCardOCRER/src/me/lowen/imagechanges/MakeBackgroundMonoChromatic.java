package me.lowen.imagechanges;

import java.awt.Color;
import java.awt.image.BufferedImage;

import me.lowen.imagetools.ColorUtils;
import me.lowen.imagetools.ImageChange;

public class MakeBackgroundMonoChromatic extends ImageChange {
	Color color;
	public MakeBackgroundMonoChromatic(Color color) {
		this.color = color;
	}

	@Override
	public boolean applyChanges(BufferedImage img) {
		BufferedImage subImg = img.getSubimage(59, 1366, 1348, 542);
		for (int x = 0; x < subImg.getWidth(); x++) {
			for (int y = 0; y < subImg.getHeight(); y++) {
				if (ColorUtils.areColorsClose(new Color(subImg.getRGB(x, y)), new Color(236, 211, 139), 50)
						|| ColorUtils.areColorsClose(new Color(subImg.getRGB(x, y)), new Color(181, 180, 119), 30)
						|| ColorUtils.areColorsClose(new Color(subImg.getRGB(x, y)), new Color(203, 176, 174), 30)
						|| ColorUtils.areColorsClose(new Color(subImg.getRGB(x, y)), new Color(226, 177, 100), 30)
						|| ColorUtils.areColorsClose(new Color(subImg.getRGB(x, y)), new Color(238, 172, 124), 30)
						|| ColorUtils.areColorsClose(new Color(subImg.getRGB(x, y)), new Color(177, 199, 189), 30)
						|| ColorUtils.areColorsClose(new Color(subImg.getRGB(x, y)), new Color(178, 171, 155), 30)) {
					subImg.setRGB(x, y, color.getRGB());
				}
			}
		}
		return false;
	}

}
