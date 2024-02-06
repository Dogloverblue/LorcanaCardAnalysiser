package me.lowen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import me.lowen.imagetools.ReplaceDarkColorsWithRed3;
import me.lowen.imagetools.ReplaceLightColorsWithRed;

public class LORCMain {
	public static void main(String[] args) {
//		System.out.println(ColorUtils.getColorBrightness(Color.red));
//		System.out.println(ColorUtils.getColorBrightness(Color.green));
//		System.out.println(ColorUtils.getColorBrightness(Color.blue));
//		System.out.println(ColorUtils.getColorBrightness(Color.white));
//		System.out.println(ColorUtils.getColorBrightness(Color.black));

		File imgInputs = new File("C:\\Users\\Jacob\\Pictures\\TestJava\\inputs");
		File imgOutputs = new File("C:\\Users\\Jacob\\Pictures\\TestJava\\outputs");
		for (File imgFile : imgInputs.listFiles()) {
			System.out.println("Doing " + imgFile.getName() + "...");
			try {
				BufferedImage bi = ImageIO.read(imgFile);
				ReplaceLightColorsWithRed red = new ReplaceLightColorsWithRed(bi);
				red.applyChanges();
				ReplaceDarkColorsWithRed3 red3 = new ReplaceDarkColorsWithRed3(bi);
				red3.applyChanges();
				ImageIO.write(bi, "png", new File(imgOutputs + "\\" + imgFile.getName()));
				System.out.println("Successfully wrote " + imgFile.getName() + "!");
			} catch (IOException e) {
				System.err.println("Encountered an error for " + imgFile.getName());
				e.printStackTrace();
			}
		}
	}

}
