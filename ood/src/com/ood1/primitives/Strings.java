package com.ood1.primitives;

public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String message = "a message";
		System.out.println(message);
		
		String firstName = "Elliott";
		String secondName = "Steer";
		String fullName = firstName + " " + secondName;
		System.out.println(fullName);
		
		String personName = "Hal";
		System.out.println("Hello " + personName + ", would you like to learn some Java today?");
		
		String myName = "Elliott";
		System.out.println(myName.length());
		System.out.println(myName.toUpperCase());
		System.out.println(myName.charAt(0));
		System.out.println(myName.charAt(myName.length() - 1));
		
		String sentence = "this is a sentence";
		System.out.println(sentence.indexOf(" "));
		System.out.println(sentence.lastIndexOf(" "));
		System.out.println(sentence.indexOf("x"));
		System.out.println(sentence.substring(0, 4));
		System.out.println(sentence.substring(10));
		System.out.println(sentence.substring(5, 9));
		System.out.println(sentence.contains("a"));
		System.out.println(sentence.contains("x"));
		System.out.println("is " + sentence + "?");
		System.out.println("T" + sentence.substring(1));
		
		

	}

}
