package ood2.io.io;

import java.util.Scanner;

public class UserApp {

	public static void main(String[] args) {
		UserProfile userProfile=new UserProfile();
		userProfile.write("Have a good day!");
		userProfile.read();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Key in your content >> ");
		String content = scanner.nextLine();
		userProfile.write(content);
		userProfile.read();

		scanner.close();

	}
	
	// research and add image (2 hours)
	// read image from abs folder(images folder-->./images)
	// write images to this folder
	// source folder -->srcimage(./srcimage)
	
	//destination folder --> images(./images)
	// blob -->datatype for image

}
