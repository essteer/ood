package com.ood1.hangman;

public class GuessCounter {
	// Class to hold the number of guesses
	// that remain available for the player
	private int remainingGuesses;
	
	public GuessCounter(int initialNumberOfGuesses) {
		// Initialises the counter with the specified number of guesses
		this.remainingGuesses = initialNumberOfGuesses;
	}
	
	public int getRemainingGuesses() {
		// Returns the current number of guesses remaining
		return this.remainingGuesses;
	}
	
	public void decrementGuesses() {
		// Decrements the number of guesses remaining by 1
		if (this.remainingGuesses > 0) {
			this.remainingGuesses --;
		}
	}
}
