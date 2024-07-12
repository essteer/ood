package com.ood1.mod1;

public class Wrappers {
	
	public static void main(String[] args) {
		
		String number1 = "5";
		String number2 = "3";
		int num1 = Integer.parseInt(number1);
		int num2 = Integer.parseInt(number2);
		System.out.println(num1 + num2);
		
		String number3 = "5.3";
		String number4 = "3.2";
		double num3 = Double.parseDouble(number3);
		double num4 = Double.parseDouble(number4);
		System.out.println(num3 + num4);
		
		String string1 = "abc11";
		String string2 = "9xyz";
		String string3 = "abc7xyz";
		
		int int1 = Integer.valueOf(string1.replaceAll("[^0-9]", ""));
		int int2 = Integer.valueOf(string2.replaceAll("[^0-9]", ""));
		int int3 = Integer.valueOf(string3.replaceAll("[^0-9]", ""));
		System.out.println(int1 + int2 + int3);
		
		
	}

}
