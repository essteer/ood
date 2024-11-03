package ood1.conditionals;

public class Conditionals {
	
	public static void main(String[] args) {
		
		String alienColour = "blue";
		if (alienColour.equals("green")) {
			System.out.println("5 points!");
		} else if (alienColour.equals("red")) {
			System.out.println("10 points!");
		} else if (alienColour.equals("yellow")) {
			System.out.println("15 points!");
		} else {
			System.out.println("invalid colour");
		}
		
		int age = 33;
		if (age < 2) {
			System.out.println("baby");
		} else if (age < 4) {
			System.out.println("toddler");
		} else if (age < 13) {
			System.out.println("child");
		} else if (age < 20) {
			System.out.println("teenager");
		} else if (age < 65) {
			System.out.println("adult");
		} else if (age >= 65) {
			System.out.println("pensioner");
		}
		
		int salary = 44444;
		if (salary > 150000) {
			System.out.println("45%");
		} else if (salary > 50000) {
			System.out.println("40%");
		} else if (salary > 12500) {
			System.out.println("20%");
		} else {
			System.out.println("0%");
		}
		
		
		
		
		
		
	}

}
