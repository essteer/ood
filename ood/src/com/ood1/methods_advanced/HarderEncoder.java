package com.ood1.methods_advanced;

public class HarderEncoder {
	
	public static String encode(String target) {

		char[] targetArray = target.toLowerCase().toCharArray();

		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String encodedTarget = "";

		for (int i = 0; i < target.length(); i++) {

			if (alphabet.indexOf(targetArray[i]) == -1) {
				encodedTarget += targetArray[i];
				continue;
			}
			int j = alphabet.indexOf(targetArray[i]);

			if (i % 2 == 1) {
				int index = j - i + 25;
				while (index < 0) {
					index += 26;
				}
				encodedTarget += alphabet.charAt(index % 26);
			} else {
				encodedTarget += alphabet.charAt((i + j + 1) % 26);
			}
		}
		return encodedTarget;
	}

}
