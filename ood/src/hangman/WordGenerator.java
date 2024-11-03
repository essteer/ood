package hangman;

import java.util.Random;

public class WordGenerator {
	// Class to provide a new random word
	// at the start of each game
	private final String randomWord;
	
	public WordGenerator() {
		// Selects a random word from a pre-populated list of words
		
		// Array of words to randomly select from
		String[] words = {
				"APPLE", "BEACH", "CATAPULT", "DINOSAUR", "ELEPHANT", 
				"FISH", "GARAGE", "HOTEL", "INDIGO", "JUXTAPOSE", "KESTREL",
				"LUNATIC", "MONOPOLY", "NASCENT", "OCTOPUS", "PORTION", 
				"QUEST", "ROBOTICS", "SUPERIMPOSE", "TRAFFIC", "UNICORN", 
				"VEST", "WATERSHED", "XYLOPHONE", "YESTERDAY", "ZEST"
		};
		// Get number of words in array
		int numberOfWords = words.length;
		// Pick random number between 0 and number of words in array
		Random random = new Random();
		int randomNumber = random.nextInt(numberOfWords);
		// Get word at random index
		this.randomWord = words[randomNumber];
	}
	
	public String getRandomWord() {
		// Returns the randomly selected word
		return this.randomWord;
	}
}
