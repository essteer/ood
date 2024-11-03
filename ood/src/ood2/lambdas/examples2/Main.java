package ood2.lambdas.examples2;

import java.util.Random;
import java.util.function.IntBinaryOperator;

public class Main {

	public static void main(String[] args) {
		Greeting greeting = new HelloGreeting();

		greeting.sayHello();
		
		Greeting greeting2 = new Greeting() {
			@Override
			public void sayHello() {
				System.out.println("Hello, World 2");
			}
		};
		greeting2.sayHello();
		
		Greeting greeting3 = () -> System.out.println("Hello, World 3");
		greeting3.sayHello();
		
		Calculator calculateSum = (int x, int y) -> {
			Random randomizer = new Random();
			int randomNo = randomizer.nextInt(50);
			
			return x + y; // + randomNo;
		};
		System.out.println("Calculate Functional Interface: Sum of 4 and 5 is: " + calculateSum.calculate(4, 5));
		
		IntBinaryOperator calculateSum2 = (int x, int y) -> {
			Random randomizer = new Random();
			int randomNo = randomizer.nextInt(50);
			
			return x + y; // + randomNo;
		};
		System.out.println("IntBinaryOperator Functional Inteface: Sum of 4 and 5 is: " + calculateSum2.applyAsInt(4, 5));

	}

}
