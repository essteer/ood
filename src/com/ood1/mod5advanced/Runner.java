package com.ood1.mod5advanced;

public class Runner {
	
	public static void main(String[] args) {
		
		PrimeNumbers primeNums = new PrimeNumbers();
		System.out.println(primeNums.primeNumbers(50));
		
		BubbleSort bubbleSort = new BubbleSort();
		int[] intArray = {3,2,1,5,4};
		int[] sortedArray = bubbleSort.sortIntArray(intArray);
		
		for (int i : sortedArray) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		SimpleEncoder simpleEncoder = new SimpleEncoder();
		//e.g. Argument “abcd” would return encoded String “badc”
		System.out.println(simpleEncoder.encode("abcd"));
		//Argument “two words” would return “uvp xnsct”
		System.out.println(simpleEncoder.encode("two words"));
		
		HarderEncoder harderEncoder = new HarderEncoder();
        // "abcd” will return “bzfz”
		System.out.println(harderEncoder.encode("abcd"));
		//For example: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa (52 x ‘a’)
		//will return: bydwfuhsjqlonmpkritgvexczabydwfuhsjqlonmpkritgvexcza
		System.out.println(harderEncoder.encode("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		
		
		
		
	}

}
