package com.fdmgroup.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Caleb Keung
 * my main class for file io discussions
 */
public class Main {
	
	public static boolean nameContainsLettersOnly(String nameToValidate) {
		// some code here to validate that the name contains letters only
		//if (some code)
			return true;
		//else
		//	return false;
	}
	
	public static void main(String[] args) {
		
		// Self documenting code example:
		String traineeName = new String("John");
		// User requirement #2, validate name
		if (nameContainsLettersOnly(traineeName)) {
			// Do something when name is valid
			System.out.println("Name is valid");
		} else {
			// Code to do something if name is not valid
			System.out.println("Name is not valid");
		}
		
		/* This is the beginning of a comment
		 * This is another line
		 * Another line .. */
		
		File file = new File("myFile.txt");
		FileReader reader;
		BufferedReader in;
		try {
			reader = new FileReader(file);
			in 	= new BufferedReader(reader); 
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BufferedReader in2;
		try {
			in2 = new BufferedReader(new FileReader(new File("myFile2.txt")));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		try (BufferedReader br = new BufferedReader(new FileReader("resources/myFile.txt"))) {
//			System.out.println(br.readLine());
//			System.out.println(br.readLine());
//			System.out.println(br.readLine());
//			
//			String line;
//			List<String> strings = new ArrayList<>();
//			while ((line = br.readLine()) != null) {
//				System.out.println(line);
//				strings.add(line);
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println("file not found");
//		} catch (IOException e) {
//			
//		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("myFile.txt", true))) {
			bw.write("hello world\n");
//			bw.flush();
		} catch (IOException e) {
			
		}
	}

}
