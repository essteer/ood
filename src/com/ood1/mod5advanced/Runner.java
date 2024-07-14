package com.ood1.mod5advanced;

public class Runner {
	
	public static void main(String[] args) {
		
		System.out.println(PrimeNumbers.primeNumbers(50));
		System.out.println();
		
		int[] intArray = {3,2,1,5,4};
		int[] sortedArray = BubbleSort.sortIntArray(intArray);
		
		for (int i : sortedArray) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println();
		
		//e.g. Argument “abcd” would return encoded String “badc”
		System.out.println(SimpleEncoder.encode("abcd"));
		//Argument “two words” would return “uvp xnsct”
		System.out.println(SimpleEncoder.encode("two words"));
		System.out.println();
		
        // "abcd” will return “bzfz”
		System.out.println(HarderEncoder.encode("abcd"));
		//For example: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa (52 x ‘a’)
		//will return: bydwfuhsjqlonmpkritgvexczabydwfuhsjqlonmpkritgvexcza
		System.out.println(HarderEncoder.encode("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		System.out.println();
		
		int[] array = {1,2,3,4,5};
		int[] rotatedArray1 = RotatingArrays.rotateArray(array, 1);
		System.out.print(RotatingArrays.toString(rotatedArray1));
		System.out.println();
		
		int[] rotatedArray2 = RotatingArrays.rotateArray(array, 6);
		System.out.print(RotatingArrays.toString(rotatedArray2));
		System.out.println();
		
		int[] rotatedArray3 = RotatingArrays.rotateArray(array, 3);
		System.out.print(RotatingArrays.toString(rotatedArray3));
		System.out.println();
		
		String[] commands1 = {"LEFT", "DOWN", "RIGHT", "DOWN", "LEFT", "DOWN", "UP"};
		System.out.println(MoonRover.roverMove(4, commands1));
		
		String[] commands2 = {"RIGHT", "UP", "DOWN", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT"};
		System.out.println(MoonRover.roverMove(5, commands2));
		
	}

}
