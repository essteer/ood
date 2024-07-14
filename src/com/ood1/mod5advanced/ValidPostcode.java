package com.ood1.mod5advanced;

import java.util.regex.Pattern;

public class ValidPostcode {
	
	public static boolean validPostcode(String postcode) {
		
		String REGEX = "[A-Za-z]{1,2}[0-9]{1,2}\s?[0-9][A-Za-z]{2}";

		return Pattern.matches(REGEX, postcode);
	}
}
