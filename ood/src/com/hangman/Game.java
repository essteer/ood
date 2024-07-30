package com.hangman;

import java.util.Scanner;

public class Game {
	
	private String targetWord;
	private GuessCounter guessCounter;
	private GuessList guessList;
	private GuessState guessState;
	
	public Game() {
		// Feature 1/5: the player is given 8 guesses
		GuessCounter guessCounter = new GuessCounter(8);
		this.guessCounter = guessCounter;
		// Feature 3/5: String ArrayList to track letters guessed so far
		this.guessList = new GuessList();
		// Feature 5/5: hidden word selected at random from a pre-populated list of words
		WordGenerator wordGenerator = new WordGenerator();
		this.targetWord = wordGenerator.getRandomWord();
		// Feature 2/5: hidden word should be displayed, with a dash marking any hidden letters
		this.guessState = new GuessState(this.targetWord);
	}
	
	
	public void playGame() {
		// Print welcome message
		System.out.println("Welcome to Hangman!");
		// Initialise Scanner object to read player input
		Scanner scanner = new Scanner(System.in);
		
		// Main game loop - continues until either no guesses remain (LOSE), 
		// or player has correctly guessed all letters in target word (WIN)
		while (this.guessCounter.getRemainingGuesses() > 0) {
			
			// Feature 3/5: display a list of previously guessed letters
			if (this.guessList.isNotEmpty()) {
				// Only print out list of guessed letters after first guess made 
				System.out.println("Previously guessed letters: " + this.guessList.toString());
			}
			
			// Feature 2/5: the hidden word should be displayed, with a dash marking any hidden letters
			System.out.println("The word now looks like this: " + this.guessState.getGuessState());
			
			// Show player the number of guesses remaining
			if (this.guessCounter.getRemainingGuesses() > 1) {
				System.out.println("You have " + this.guessCounter.getRemainingGuesses() + " guesses left.");
			} else if (this.guessCounter.getRemainingGuesses() == 1) {
				System.out.println("You have only one guess left.");
			}
			
			// Get new guess from player
			System.out.print("Your guess: ");
			String guess = scanner.next().toUpperCase();
			
			// Check whether the guessed letter has already been guessed
			if (this.guessList.hasGuess(guess)) {
				// Feature 4/5: If the player guesses a previously guessed letter, 
				// display a message indicating as such and allow them to guess again.
				// Do not decrement their guesses
				System.out.println("You have already guessed that letter.");
				// Return to start of loop without changing game state
				continue;
			}
				
			// Letter has NOT been guessed before
			// Add guess to guess list
			this.guessList.addGuess(guess);
				
			// Check whether guessed letter in target word
			if (!(this.targetWord.contains(guess))) {
			    // Letter has not been guessed before and is INCORRECT
			    System.out.println("There are no " + guess + "'s in the word.");
			    
			    // Feature 1/5: the player is given 8 guesses, deducted only if
			    // the guessed letter does not exist in the hidden word
			    this.guessCounter.decrementGuesses();
					
			} else {
				// Letter has not been guessed before and is CORRECT
				System.out.println("That guess is correct.");
				// Update the game state
				this.guessState.updateGuessState(guess);
				// Check whether player has guessed all letters
				if (this.targetWord.equals(this.guessState.getGuessState())) {
					break;
				}
			}
		}
		
		// LOSE condition - all guesses used
		if (this.guessCounter.getRemainingGuesses() == 0) {
			System.out.println("You're completely hung.");
			System.out.println("The word was: " + this.targetWord);
			System.out.println("You lose.");
		}
		
		// WIN condition - player guessed all letters
		if (this.targetWord.equals(this.guessState.getGuessState())) {
			System.out.println("You guessed the word: " + this.targetWord);
			System.out.println("You win.");
		}
		
		// Close Scanner object
		scanner.close();
	}
}
