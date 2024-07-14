package com.ood1.mod5advanced;

public class BubbleSort {

	public static int[] sortIntArray(int[] rawArray) {

		int[] newArray = rawArray.clone();

		outer: while (true) {

			boolean swapped = false;

			for (int i = 0; i < rawArray.length - 1; ++i) {

				if (newArray[i] > newArray[i + 1]) {
					int temp = newArray[i];
					newArray[i] = newArray[i + 1];
					newArray[i + 1] = temp;
					swapped = true;
				}
				if (!swapped) {
					break outer;
				}
			}
		}
		return newArray;
	}
}
