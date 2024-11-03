package ood2.generics.examples;

import java.util.ArrayList;

public class GenericsCode {

	public static void main(String[] args) {
		// ArrayList<String> languages = new ArrayList<>(Arrays.asList("Italian", "Greek", "Cantonese"));
		ArrayList<String> languages = new ArrayList<>();

		// ArrayList<String> languages = new ArrayList<>(Arrays.asList("Italian", "Greek", "Cantonese"));
		
		// languages.add(23); // Type safety will not allow this
		languages.add("Latin");
		languages.add("English");
		languages.add("Swedish");
		languages.add("French");
		processLanguages(languages);
		
		// ArrayList<int> ints = new ArrayList<>(); - won't work with primitives		
		ArrayList<Integer> ints = new ArrayList<>();
		// ints.add("Somestring");
		ints.add(8); // Autoboxing number 8
		ints.add(15);
		int number = ints.get(0); // Unboxing number 8
		System.out.println("Number is : " + number);
	}

	private static void processLanguages(ArrayList<String> data) {
		String language = data.get(0); // Casting no longer needed
		System.out.println("Language is: " + language);
	}

}
