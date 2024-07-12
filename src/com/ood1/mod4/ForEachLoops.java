package com.ood1.mod4;

import java.util.ArrayList;

public class ForEachLoops {

	public static void main(String[] args) {
		
		String[] courses = {"UNIX", "SQL", "Java", "Python", "Web Apps"};
		for (String course : courses) {
			System.out.println("I love learning " + course);
		}
		
		
		ArrayList<String> coursesList = new ArrayList<String>();
		
		for (String course : courses) {
			coursesList.add(course);
		}
		
		for (String c : coursesList) {
			System.out.println(c);
		}
		
		
		ArrayList<Double> prices = new ArrayList<Double>();
		
		prices.add(4.50);
		prices.add(1.99);
		prices.add(9.75);
		prices.add(3.15);
		prices.add(10.25);
		double total = 0;
		
		for (double price : prices) {
			total += price;
		}
		System.out.println(total);
		
		
		double[] doubleArray = new double[5];
		int counter = 0;
		for (double p : prices) {
			doubleArray[counter] = p;
			counter += 1;
		}
		
		String numbers = "10,7,25,3,8";
		String[] splitNums = numbers.split(",");
		int totalVal = 0;
		for (String num : splitNums) {
			totalVal += Integer.valueOf(num);
		}
		System.out.println(totalVal);
		
		
		String text = "desrever neeb sah txet siht";
		char[] charArray = text.toCharArray();
		
		String result = "";
		for (char c : charArray) {
			result = c + result;
		}
		System.out.println(result);
		
		
		
		

	}

}
