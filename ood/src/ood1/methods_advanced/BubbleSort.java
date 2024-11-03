package ood1.methods_advanced;

public class BubbleSort {

	public static int[] sortIntArray(int[] rawArray) {

		int[] newArray = rawArray.clone();

		outer: while (true) {

			boolean swapped = false;

			for (int i = 0; i < rawArray.length - 1; ++i) {
				
				if (
						// A > 0 but B <= 0
						newArray[i] > 0 && newArray[i+1] <= 0 ||
						// A >= 0 but B < 0
						newArray[i] >= 0 && newArray[i+1] < 0 ||
						// A < 0 && B < 0 but A > B
						(newArray[i] <= 0 && newArray[i+1] <= 0 && newArray[i] < newArray[i+1]) ||
						// A > 0 && B > 0 but A > B
						newArray[i] > newArray[i + 1]
				) {

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
