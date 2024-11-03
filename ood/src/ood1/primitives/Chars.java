package ood1.primitives;

public class Chars {

	public static void main(String[] args) {
		
		char letter = 'a';
		int code = 98;
		System.out.println(Integer.valueOf(letter));
		System.out.println((int) letter);
		System.out.println((char) code);
		System.out.println((char) 36);
		
		System.out.println('c' - 'a');
		System.out.println('z' - 'a');
		
		char char1 = 'x';
		char char2 = 'y';
		char char3 = 'z';
		
		String string1 = "z";
		String string2 = "y";
		
		System.out.println(char1 + char2 + char3);
		System.out.println(char1 + char2 + string2);
		System.out.println(char1 + string1 + char3);
		

	}

}
