package hangman;

import java.util.ArrayList;
import java.util.Collections;

public class GuessList {
	// Class to keep track of letters
	// the player has already guessed
	
	private ArrayList<String> guessedLetters;
	
	public GuessList() {
		// Initialise a new empty array to store guesses
		this.guessedLetters = new ArrayList<>();
	}
	
	public void addGuess(String guess) {
		// Ensure guess is stored in upper case
		guess = guess.toUpperCase();
		// Add guess to list
		this.guessedLetters.add(guess);
	}
	
	public boolean hasGuess(String guess) {
		// Return raw list of guessed letters
		return this.guessedLetters.contains(guess);
	}
	
	public boolean isNotEmpty() {
		// Confirm whether this.guessedLetters contains guesses
		return this.guessedLetters.size() > 0;
	}
	
	private void sortGuesses() {
		// Sort guesses alphabetically
		Collections.sort(this.guessedLetters);
	}
	
	@Override
	public String toString() {
		// Sort guesses alphabetically
		sortGuesses();
		// Create string of guessed letters separated by spaces
		String output = "";
		for (String letter : this.guessedLetters) {
			output += letter;
		}
		return output;
	}
}
