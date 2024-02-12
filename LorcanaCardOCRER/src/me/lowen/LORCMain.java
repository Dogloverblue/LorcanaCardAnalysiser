package me.lowen;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;

import javax.imageio.ImageIO;

import me.lowen.imagechanges.MakeBackgroundMonoChromatic;
import me.lowen.imagechanges.MakePowerReadable;
import me.lowen.imagechanges.MakeToughnessReadable;
import me.lowen.imagetools.ColorUtils;
import me.lowen.imagetools.ImageChange;

public class LORCMain {
	public static void main(String[] args) {

		File imgInputs = new File("/home/jacob/Pictures/RFB-Images-p1");
		File imgOutputs = new File("/home/jacob/Pictures/LOCROutputs");
		
		
		ArrayDeque<ImageChange> changes = new ArrayDeque<>();
		changes.add(new MakeToughnessReadable());
		changes.add(new MakePowerReadable());
		changes.add(new MakeBackgroundMonoChromatic(new Color(236, 211, 139)));
		for (File imgFile : imgInputs.listFiles()) {
			System.out.println("Doing " + imgFile.getName() + "...");
			try {
				BufferedImage img = ImageIO.read(imgFile);
				for (ImageChange change: changes) {
					
					change.applyChanges(img);
					ImageIO.write(img, "png", new File(imgOutputs + File.separator + imgFile.getName()));
				}
				System.out.println("Successfully wrote " + imgFile.getName() + "!");
			} catch (IOException e) {
				System.err.println("Failed at " + imgFile.getName());
			}

		}
	}

}
