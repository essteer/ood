package com.ood2.streams.class_content;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
			
		Integer[] scores = new Integer[] {90, 39, 29, 21, 23, 60};
		
		Stream<Integer> scoresStream = Arrays.stream(scores);

		// Method 1 - using Optional<Integer> and Comparator
		Comparator<Integer> scoreComparator = (score1, score2) -> score1 - score2;
		Optional<Integer> highestScore = scoresStream.max(scoreComparator);
 		System.out.println("Highest Score is : " + highestScore.get());
	
 		// Method 2 - using OptionalInt and ToIntFunction
		 scoresStream = Arrays.stream(scores);
 		 ToIntFunction<Integer> getScore = score -> { return score; };
		 // OptionalInt highScore = Arrays.stream(scores).mapToInt(getScore).max();		
		 OptionalInt highScore = scoresStream.mapToInt(getScore).max();		
 		 System.out.println("Highest Score is : " + highScore.getAsInt());
		
		List<String> shoppingList = new ArrayList<>();
		shoppingList.add("eggs");
//		shoppingList.add("bread");
//		shoppingList.add("pinapples");
//		shoppingList.add("apples");
//		shoppingList.add("milk");
//		shoppingList.add("pasta");
//		
//		Stream<String> shoppingListStream = shoppingList.stream();
//		
//		Stream<String> lettersStream = Stream.of("a", "b", "c");
//		
//		System.out.println(shoppingListStream); // Print stream?
//		shoppingListStream.forEach(x -> System.out.println(x)); // Print stream
//		shoppingListStream = shoppingList.stream();
//		shoppingListStream = shoppingList.stream();
//		shoppingListStream.sorted().forEach(item -> System.out.println(item));
//		
//		Make uppercase:
//			shoppingListStream.sorted()
//						  .map(item -> item.toUpperCase())
//						  .forEach(item -> System.out.println(item));
//		
//		Filter:
//			shoppingList.stream()
//						.sorted()
//						.map(item -> item.toUpperCase())
//						.filter(item -> item.startsWith("P"))
//						.forEach(item -> System.out.println(item));

//		Without shoppingListStream:
//		shoppingList.stream()
//					.sorted()
//					.map(item -> item.toUpperCase())
//					.filter(item -> item.startsWith("P"))
//					.forEach(item -> System.out.println(item));
			
	}
}