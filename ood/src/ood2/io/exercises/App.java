package ood2.io.exercises;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		/**
		 * Question 1
		 */
		IOExercise io = new IOExercise();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your new line: ");
		String content = sc.nextLine();
		io.write(content);
		io.read();
		sc.close();
		
		/**
		 * Question 2 and 3
		 */

		System.out.println("Please enter your name: ");
		Scanner input1 = new Scanner(System.in);
		String userName = input1.nextLine();
		input1.close();

		System.out.println("Please enter your email: ");
		Scanner input2 = new Scanner(System.in);
		String userEmail = input2.nextLine();
		input2.close();

		System.out.println("Please enter your address: ");
		Scanner input3 = new Scanner(System.in);
		String userAddress = input3.nextLine();
		input3.close();

		// String[] userRegistration = {userName, userEmail, userAddress};
		IOExercise2and3 registerUser = new IOExercise2and3();
		registerUser.write(userName + ", " + userEmail + ", " + userAddress);

		System.out.println();
		registerUser.read();

	}

}
