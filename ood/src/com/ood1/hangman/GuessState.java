package com.ood1.hangman;

public class GuessState {
	
	// Once set, the target word never changes
	private final String targetWord;
	private String guessState;
	
	public GuessState(String word) {
		
		this.targetWord = word;
		// The initial state contains as many dashes
		// as there are letters in the target word
		String initialState = "";
		for (int i=0; i < word.length(); i++) {
			initialState += "-";
		}
		this.guessState = initialState;
	}
	
	
	public String getGuessState() {
		// Return current state of hidden word
		return this.guessState;
	}
	
	
	public void updateGuessState(String guessedLetter) {
		
		String currentGuessState = this.getGuessState();
		String newGuessState = "";
		
		for (int i = 0; i < this.targetWord.length(); i++) {
			// Cast guessedLetter from String to char
			char guessChar = guessedLetter.charAt(0);
			// If target word letter matches guessed letter
			if (this.targetWord.charAt(i) == guessChar) {
				// reveal correctly guessed letter
				newGuessState += guessedLetter;
			} else {
				// otherwise leave guess state unchanged at that position
				newGuessState += currentGuessState.charAt(i);
			}
		// Update guessState with new letters revealed
		this.guessState = newGuessState;
		}
		
	}

}
