package com.fdmgroup.mod4;

public class WhileLoops {

	public static void main(String[] args) {
		
//		int i = 1;
//		while (i < 1000001) {
//			System.out.println(i);
//			i++;
//		}
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		char[] letters = alphabet.toCharArray();
		
		int i = 0;
		while (i < 26) {
			System.out.println(letters[i]);
			i++;
		}
		
		int a = 0;
		int b = 1;
		
		while (a <= 1000) {
			System.out.println(a);
			int temp = a;
			a += b;
			b = temp;
		}

	}

}
