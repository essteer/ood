package ood1.methods_advanced;

public class SimpleEncoder {

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
				encodedTarget += alphabet.charAt((j + 25) % 26);
			} else {
				encodedTarget += alphabet.charAt((j + 1) % 26);
			}
		}
		return encodedTarget;
	}

}
