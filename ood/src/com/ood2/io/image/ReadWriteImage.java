package com.ood2.io.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ReadWriteImage {

	public static void main(String[] args) throws IOException {

		// copy from the same folder
		File file = new File("./images/Unknown.jpg");
		BufferedImage image = ImageIO.read(file);
		ImageIO.write(image, "jpeg", new File("./images/coolmeme.jpeg"));

		/*
		 * // copy image from another folder into current folder File newFile = new
		 * File("/Users/amrinbinanan/Desktop/FOC.png"); BufferedImage img =
		 * ImageIO.read(newFile); ImageIO.write(img, "png", new
		 * File("./images/FOC.png"));
		 */

		// copy image from the internet into current folder
		BufferedImage newImage = ImageIO
				.read(new URL("https://image.api.playstation.com/vulcan/ap/rnd/202008/1020/T45iRN1bhiWcJUzST6UFGBvO.png"));
		ImageIO.write(newImage, "jpg", new File("./images/ps4game.jpg"));
		
		/*
		// change format of the picture
		File spiderman=new File("./images/spiderman.jpg");
		BufferedImage i=ImageIO.read(spiderman);
		ImageIO.write(i, "png", new File("./images/spiderman.png")); */

	}
}
