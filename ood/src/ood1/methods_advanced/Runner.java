package ood1.methods_advanced;

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
		
		int[] intArray2 = {5,2,3,1,4};
		int[] sortedArray2 = BubbleSort.sortIntArray(intArray2);
		for (int i : sortedArray2) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		//e.g. Argument “abcd” would return encoded String “badc”
		System.out.println("abcd should return badc -> " + SimpleEncoder.encode("abcd"));
		//Argument “two words” would return “uvp xnsct”
		System.out.println(SimpleEncoder.encode("two words"));
		System.out.println();
		
        // "abcd” will return “bzfz”
		System.out.println(HarderEncoder.encode("abcd"));
		// "ABCD” will return “bzfz”
		System.out.println("ABCD should return bzfz -> " + HarderEncoder.encode("ABCD"));
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
		System.out.println();
		
		String[] commands3 = {"DOWN","DOWN","RIGHT","RIGHT","RIGHT","RIGHT",
				"RIGHT","RIGHT","RIGHT","RIGHT","RIGHT","RIGHT",
				"RIGHT","RIGHT","RIGHT","RIGHT","DOWN","DOWN",
				"DOWN","DOWN","DOWN","DOWN","DOWN","DOWN","DOWN",
				"DOWN","DOWN","DOWN","DOWN","DOWN","LEFT","LEFT",
				"LEFT","LEFT","LEFT","LEFT","LEFT","LEFT","LEFT",
				"LEFT","LEFT","LEFT","LEFT","LEFT","LEFT","LEFT"};
		System.out.println("Should equal 156 -> " + MoonRover.roverMove(13, commands3));
		System.out.println();
		
		System.out.println(ValidPostcode.validPostcode("A12BC"));
		System.out.println(ValidPostcode.validPostcode("AB12 3CD"));
		System.out.println(ValidPostcode.validPostcode("12AB 3CD"));
		System.out.println();
		
		String validPassword = "qw43g4JFE@@32rf";
		String shortPassword = "1sS!";
		String twoTypePassword = "1231342342sdfsadfsdfas";
		String threeTypePassword = "%fO3cm-£ooo";
		
		System.out.println(ValidPassword.validPassword(validPassword));
		System.out.println(ValidPassword.validPassword(shortPassword));
		System.out.println(ValidPassword.validPassword(twoTypePassword));
		System.out.println(ValidPassword.validPassword(threeTypePassword));
		
	}

}
