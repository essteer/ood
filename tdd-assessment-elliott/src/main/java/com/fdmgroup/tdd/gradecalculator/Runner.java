package com.fdmgroup.tdd.gradecalculator;

public class Runner {

	public static void main(String[] args) {
		
		// Demonstrate grade classifications spanning each of the bands
		// fail, pass, merit, distinction, and above the distinction limit
		GradeCalculator gradeCalculator = new GradeCalculator();
		for (double i = 74.5; i<101; i++) {
			String grade = gradeCalculator.getClassification(i);
			System.out.println("Grade for " + i + ": " + grade);
		}

	}

}
