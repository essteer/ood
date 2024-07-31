package com.ood1.methods;

import java.util.Arrays;
import java.util.ArrayList;

public class MethodsWithTestCases {

	public static boolean leapYear(int year) {
		
		if (!(year % 4 == 0)) {
			return false;
		}
		if (year % 100 == 0 && !(year % 400 == 0)) {
			return false;
		}
		return true;
	}
	
	public static boolean arrayContains(String[] stringArray, String string) {
		
		for (String s : stringArray) {
			if (s.equals(string)) {
				return true;
			}
		}
		return false;
	}
	
	public static int arrayFrequency(int[] intArray, int number) {
		
		int count = 0;
		for (int i : intArray) {
			if (i == number) {
				count ++;
			}
		}
		return count;
	}
	
	public static int maxNumber(int[] intArray) {
		
		Arrays.sort(intArray);
		return intArray[intArray.length - 1];
		
	}
	
	public static int[] extractEvenArray(int[] intArray) {
		
		ArrayList<Integer> evenNums = new ArrayList<>();
		
		for (int i : intArray) {
			if (i%2 == 0) {
				evenNums.add(i);
			}
		}
		return evenNums.stream().mapToInt(i -> i).toArray();
	}
	
	public static String[] reverseStringArray(String[] rawArray) {
		
		int index = 0;
		String[] reversedArray = new String[rawArray.length];
		for (int i = rawArray.length - 1; i >= 0; i--) {
			reversedArray[index] = rawArray[i];
			index ++;
		}
		return reversedArray;
	}
	
	public static boolean isAnagram(String string1, String string2) {
		
		char[] chars1 = string1.toCharArray();
		Arrays.sort(chars1);
		char[] chars2 = string2.toCharArray();
		Arrays.sort(chars2);
		
		string1 = new String(chars1);
		string2 = new String(chars2);
		
		return string1.equals(string2);
		
	}
	
	public static double medianNumber(double[] doublesArray) {
		int length = doublesArray.length;
		
		Arrays.sort(doublesArray);
		
		if (length % 2 != 0) {
			return doublesArray[(length / 2)];
		}
		
		double mid1 = doublesArray[(length / 2) - 1];
		double mid2 = doublesArray[length / 2];
		
		return (mid1 + mid2) / 2;
		
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(leapYear(2016));
		System.out.println(leapYear(2019));
		System.out.println(leapYear(2000));
		System.out.println(leapYear(1900));
		
		int[] demoArray = {2,5,3,7,6,7,3,4,3};
		int[] result = extractEvenArray(demoArray);
		for (int i : result) {
			System.out.println(i);
		}
		
		String[] stringArray = {"three", "two", "one"};
		String[] results = reverseStringArray(stringArray);
		for (String s : results) {
			System.out.println(s);
		}
		
		System.out.println(isAnagram("olol", "lolo"));
		System.out.println(isAnagram("olol", "llo"));
		
		double[] ex1 = {1.0, 2.0, 3.0, 4.0, 5.0};
		System.out.println(medianNumber(ex1));
		
		double[] ex2 = {1.0, 2.0, 3.0, 4.0};
		System.out.println(medianNumber(ex2));
		
		double[] ex3 = {7.4, 3.9, 1.2, 9.7, 2.3};
		System.out.println(medianNumber(ex3));
		
		double[] ex4 = {7.4, 3.9, 1.2, 9.7, 2.3, 8.2};
		System.out.println(medianNumber(ex4));
		

	}

}
