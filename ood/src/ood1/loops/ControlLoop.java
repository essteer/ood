package ood1.loops;

public class ControlLoop {

	public static void main(String[] args) {
		
		String[] cities = {"Glasgow", "London", "Birmingham", "Cardiff", "Manchester", "Newcastle"};
		
		for (String city : cities) {
			if (city.startsWith("B")) {
				System.out.println(city + " - match");
				break;
	
			} else {
				System.out.println(city + " - doesn't match");
			}
		}
		
		int[] numbers = {6, 15, 75, 32, 89, 24, 103, 17, 5, 250, 63, 91};
		
		for (int num : numbers) {
			if (num > 100) {
				System.out.println(num);
				break;
			}
		}

	}

}
