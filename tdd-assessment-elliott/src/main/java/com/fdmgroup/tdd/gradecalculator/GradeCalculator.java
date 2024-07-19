package com.fdmgroup.tdd.gradecalculator;

public class GradeCalculator implements GradeCalculatorService {
	
	private double passThreshold;
	private double meritThreshold;
	private double distinctionThreshold;
	private double validMarkLimit;
	
	public GradeCalculator() {
		this.passThreshold = 75.0;
		this.meritThreshold = 80.0;
		this.distinctionThreshold = 90.0;
		this.validMarkLimit = 100.0;
	}
	
	@Override
	public String getClassification(double mark) {
		if (mark < this.passThreshold) {
			return "fail";
		}
		
		if (mark >= this.passThreshold && mark < this.meritThreshold) {
			return "pass";
		}
		
		if (mark >= this.meritThreshold && mark < this.distinctionThreshold) {
			return "merit";
		}
		
		if (mark >= this.distinctionThreshold && mark <= this.validMarkLimit) {
			return "distinction";
		}
		// No return value specified for case where mark exceeds 100.0
		return null;
	}
	
}
