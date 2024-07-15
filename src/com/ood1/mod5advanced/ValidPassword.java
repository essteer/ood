package com.ood1.mod5advanced;

import java.util.regex.Pattern;

public class ValidPassword {
	
	public static boolean validPassword(String password) {
		
        // A valid password should have at least 7 characters. 
		if (password.length() < 7) {
			return false;
		}
		// It should contain 3 of the following 4 characters: 
		// upper case letter, lower case letter, number, symbol.
		Pattern upperCasePattern = Pattern.compile("[A-Z]");
		Pattern lowerCasePattern = Pattern.compile("[a-z]");
		Pattern digitPattern = Pattern.compile("\\d");
		Pattern symbolPattern = Pattern.compile("[^A-z\\d\\_]");
		
		int numTypes = 0;
		if (upperCasePattern.matcher(password).find()) numTypes++;
		if (lowerCasePattern.matcher(password).find()) numTypes++;
		if (digitPattern.matcher(password).find()) numTypes++;
		if (symbolPattern.matcher(password).find()) numTypes++;
		
		return numTypes >= 3;
	}

}
