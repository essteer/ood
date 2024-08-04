package com.fdmgroup.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
* <h1>Main Class</h1>
* Comments for Main class
* <p>
* Giving proper comments in your program makes it more
* user friendly and it is assumed as a high quality code.
* 
* @author Itai
* @version 1.0
*
*/
public class Main {
	
	/**
	 * basic integer division
	 * @param x numerator
	 * @param y denominator
	 * @return 0 if y = 0, x/y otherwise
	 */
	
	static int divide(int x, int y) {
//		if (y == 0) {
//			System.out.println("Cannot divide by zero!");
//			return 0;
//		}
		return x/y;
	}
/*
 * This a comment
 * another line
 * ...	
 */
	/**
	 * @author Itai Ndoro
	 * @param x
	 * @throws MyException
	 */
	static void myOtherMethod(int x) throws MyException {
		if (x < 0) {
			throw new MyException();
		}
	}
	
	static void myMethod() {
		try (BufferedReader reader = new BufferedReader(new FileReader("myFile.txt"))) {

		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("blah");
	}
	
	static void update(int[] arr, int index, int value) {
		if (index < arr.length) {
			arr[index] = value;
		}
	}
	
	public static void main(String[] args) {
//		String name = new String("John");
//		if (name != null )
//			System.out.println("Name is: " + name.hashCode());
//		else
//			System.out.println("The name is null so we cannot calculate the hashcode");
		
//		System.out.printf("Hello \t Bobby");
//		System.out.printf("World");
		
//		System.out.println("Hello ");
//		System.out.println("World");
//		String myNewString = "MC Hammer;
//		System.out.println("This is my new string" + myNewString.hashCode());		
//		String[] stringArray = new String[5]; // Indexes 0, 1, 2, 3, 4; 5 is out of bounds
//		stringArray[5] = "oops";
//		System.out.println(divide(10, 3));
//		System.out.println(divide(10, 0));
//		int[] arr = new int[] {1,2,3};
//		update(arr, 4, 5);
		
//		myMethod();
		
//		try (Scanner sc = new Scanner(System.in)) {
//			int input = Integer.parseInt(sc.nextLine());
//			System.out.println(input);
//		} catch (NumberFormatException e) {
//			System.out.println("invalid input");
//		}
//		
		try {
			myOtherMethod(-1);
		} catch (MyException e) {
			e.printStackTrace();
		}
		System.out.println("End of the program");

	}


}
