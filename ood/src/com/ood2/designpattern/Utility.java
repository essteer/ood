package com.ood2.designpattern;

public class Utility {
	
	private static Utility utility;
	
	private static boolean initialised = false;
	
	private Utility() {};
	
	private void init() {
		
	}
	
	public Utility getInstance() {
		if (initialised) return utility;
		utility = new Utility();
		utility.init();
		return utility;
	}
	
	public int getMaximumOfTwoNumbers(int a, int b) {
		return Math.max(a, b);
	}
	
	public int getMinimumOfTwoNumbers(int a, int b) {
		return Math.min(a, b);
	}
	
	public double getSquareRootOfNumber(double a) {
		return Math.sqrt(a);
	}
	

}
