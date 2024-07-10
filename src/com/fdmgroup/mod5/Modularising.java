package com.fdmgroup.mod5;

public class Modularising {
	
	public static int getPoints(String alienColour) {
		if (alienColour.equals("green")) {
			return 5;
		} else if (alienColour.equals("red")) {
			return 10;
		} else if (alienColour.equals("yellow")) {
			return 15;
		} else {
			return 0;
		}
	}
	
	public static long sumOfNumbersUpTo(int maxNum) {
		long result = 0L;
		for (int i=1; i<= maxNum; i++) {
			result += i;
		}
	    return result;
	}
	
	public static void displayTimesTable(int timesTable) {
		for (int i=1; i<13; i++) {
			System.out.println(i + " x " + timesTable + " = " + i*timesTable);
		}
	}

	public static void main(String[] args) {
		int points = getPoints("green");
		System.out.println("You've scored " + points + " points!");
		
		long total = sumOfNumbersUpTo(5);
		System.out.println(total);
		
		displayTimesTable(3);
		
	}

}
