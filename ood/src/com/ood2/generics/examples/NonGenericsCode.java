//// Before Generics:
//// Needs explicit casting
//// Lacks type safety
//
//package com.ood2.generics.examples;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class NonGenericsCode {
//
//	public static void main(String[] args) {
//		List languages = new ArrayList(); // languages is a raw list / type
//		languages.add(12); // No type safety
//		languages.add("Cantonese");
//		languages.add("Japanese");
//		languages.add("French");
//		Object value = new String("Latin");
//		languages.add(value);
//		// Print languages
//		System.out.println("Languages spoken are : " + languages);
//		processLanguages(languages);
//		//num = 5;
//	}
//
//	private static void processLanguages(List data) {
//		// Explicit casting of String required 
//		String language = null;
//		// language = (String) data.get(0); // No type safety - can generate runtime exceptions
//
//		// Defensive coding required to prevent run time exceptions
//		if (data.get(0) instanceof String) { // Defensive coding
//			language = (String) data.get(0);
//		} else {
//			language = "";
//		}
//		
//		String language2 = (String) data.get(1); // Casting of String is required here
//		System.out.println("First Language is: " + language);
//		System.out.println("Second Language is: " + language2);
//	}
//}
//
//
//
