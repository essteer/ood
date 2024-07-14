package com.ood1.mod5advanced;

public class RotatingArrays {
	
	public static int[] rotateArray(int[] array, int rotations) {
		
		int[] rotatedArray = new int[array.length];
		
		for (int i=0; i<array.length; i++) {
			
			rotatedArray[(i + rotations) %array.length] = array[i];
		}
		
		return rotatedArray;
	}
	
	public static String toString(int[] array) {
		
		String result = "[";
		
		for (int i=0; i<array.length; i++) {
			result += array[i];
			if (i < array.length - 1) {
				result += ",";
			}
		}
		result += "]";
		
		return result;
	}
	
}
