package com.ood2.collections;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.Set;
import java.util.TreeSet;

public class Runner {
	
	public static Set<String> getSetOfNames(String... firstNames) {
		// Returns a set of names received as input
		Set<String> nameSet = new HashSet<>();
		for (String name : firstNames) {
			nameSet.add(name);
		}
		return nameSet;
	}
	
	public static HashMap<String,Color> getColor() {
		// Returns HashMap that can be used to choose one of 
		// 13 predefined colours in the java.awt.Color class
		HashMap<String,Color> colorMap = new HashMap<>();
		colorMap.put("black", Color.BLACK);
		colorMap.put("blue", Color.BLUE);
		colorMap.put("cyan", Color.CYAN);
		colorMap.put("darkGray", Color.DARK_GRAY);
		colorMap.put("gray", Color.GRAY);
		colorMap.put("green", Color.GREEN);
		colorMap.put("lightGray", Color.LIGHT_GRAY);
		colorMap.put("magenta", Color.MAGENTA);
		colorMap.put("orange", Color.ORANGE);
		colorMap.put("pink", Color.PINK);
		colorMap.put("red", Color.RED);
		colorMap.put("white", Color.WHITE);
		colorMap.put("yellow", Color.YELLOW);
	
		return colorMap;
	}
	
	public static Map<Character,Integer> getCountOfLetters(String inputString) {
		
		Map<Character,Integer> letterMap = new HashMap<>();
		
		for (int i=0; i<inputString.length(); i++) {
			String REGEX = "[A-Za-z]";
			char c = inputString.charAt(i);
			// Cast char to String
			if (Pattern.matches(REGEX, "" + c)) {
				letterMap.put(c, letterMap.getOrDefault(c, 0) + 1);
			}
		}
		return letterMap;
	}
	
	public static int countDuplicateWords(String sentence) {
		
		String[] sentenceWords = sentence.toLowerCase().split(" ");
		ArrayList<String> wordList = new ArrayList<>();
		Set<String> wordSet = new HashSet<>();
		
		for (String word : sentenceWords) {
			String cleanWord = word.replaceAll("[^A-Za-z]", "");
			System.out.println("word: " + word + ", cleanWord: " + cleanWord);
			
			if (wordList.contains(cleanWord)) {
				wordSet.add(cleanWord);
			} else {
				wordList.add(cleanWord);
			}
		}
		return wordSet.size();
	}
	
	public static LinkedList<Object> reverseLinkedList(LinkedList<Object> linkedList) {
		
		ArrayList<Object> tempList = new ArrayList<>();
		for (Object obj : linkedList) {
			tempList.add(obj);
		}
		
		LinkedList<Object> reversedLinkedList = new LinkedList<>();
		for (int i = tempList.size() - 1; i >= 0; i--) {
			reversedLinkedList.add(tempList.get(i));
		}
		return reversedLinkedList;
	}
	
	public static TreeSet<String> getTokenisedTreeSet(String userInput) {
		
		String[] tokenisedInput = userInput.split(" ");
		TreeSet<String> treeSet = new TreeSet<>();
		
		for (String token : tokenisedInput) {
			treeSet.add(token);
		}
		return treeSet;
		
	}
	

	public static void main(String[] args) {
		// 1)	Write a method that takes a variable argument of 
		// multiple first names and eliminates duplicates by storing them in a Set. 
		// It should return the Set.
		System.out.println(getSetOfNames("Adam", "Bethan", "Chris", "Bethan"));
		// 2)	Write a method, which returns a HashMap that can be used for choosing 
		// one of the 13 predefined colors in class java.awt.Color. 
		// The names of the colors should be used as keys, 
		// and the predefined java.awt.Color objects should be used as values. 
		HashMap<String,Color> colorHashMap = getColor();
		Color green = colorHashMap.get("green");
		System.out.println(green);
		// 3)	Write a method to count the number of occurrences of each letter in a string. 
		// For example, the string "HELLO THERE" contains two Hs, three Es, two Ls, 
		// one O, one T and one R. 
		// It should return an object that contains the results 
		// – what kind of class is best suited for this?
		System.out.println(getCountOfLetters("HELLO THERE"));
		// 4)	Write a method that returns the number of duplicate words in a sentence. 
		// Treat uppercase and lowercase letters the same. 
		// Ignore punctuation. For example, “The the THE dog is brown BrOwN.” 
		// Would return 2 as the words ‘the’ and ‘brown’ are both duplicated.
		System.out.println(countDuplicateWords("The the THE dog is brown BrOwN."));
		// 5)	Write a method that takes in a LinkedList and returns a LinkedList object 
		// containing a copy of the first list, but in reverse order.
		LinkedList<Object> linkList = new LinkedList<>();
		linkList.add(1);
		linkList.add(2);
		linkList.add(3);
		linkList.add(4);
		linkList.add(5);
		System.out.println(reverseLinkedList(linkList));
		LinkedList<Object> linkList2 = new LinkedList<>();
		linkList2.add("A");
		linkList2.add("B");
		linkList2.add("C");
		linkList2.add("D");
		linkList2.add("E");
		System.out.println(reverseLinkedList(linkList2));
		// 6)	Write a method that uses a String method split to tokenize 
		// a line of text input by the user and places each token in a TreeSet. 
		// It should return the TreeSet. To tokenize a line of text means to split up a line into its individual words.
		// Note: Printing the TreeSet should output the elements ascending sorted order.
		System.out.println(getTokenisedTreeSet("This is a sentence and the sentence contains duplicates"));

		
	}

}
