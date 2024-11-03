package ood1.arrays;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExercise {

	public static void main(String[] args) {
		ArrayList<String> shoppingBasket = new ArrayList<>();
		
		shoppingBasket.add("milk");
		shoppingBasket.add("cereals");
		shoppingBasket.add("apples");
		shoppingBasket.add("oranges");
		shoppingBasket.add("bread");
		
		System.out.println(shoppingBasket.size());
		System.out.println(shoppingBasket.get(0));
		System.out.println(shoppingBasket.get(4));
		
		shoppingBasket.remove("bread");
		System.out.println(shoppingBasket.size());
		
		shoppingBasket.remove(2);
		System.out.println(shoppingBasket.toString());
		
		shoppingBasket.add("potatoes");
		shoppingBasket.add("olive oil");
		shoppingBasket.add("chicken");
		
		Collections.sort(shoppingBasket);
		System.out.println(shoppingBasket.get(0));
		System.out.println(shoppingBasket.get(shoppingBasket.size() - 1));
		
		
		ArrayList<Integer> salaries = new ArrayList<>();
		salaries.addAll(Arrays.asList(75000, 25000, 42000, 30000, 55000, 42000, 39000));
		
		System.out.println(Collections.max(salaries));
		System.out.println(Collections.min(salaries));
		
		System.out.println(Collections.frequency(salaries, 42000));

		Collections.sort(salaries);
		System.out.println(salaries.get(salaries.size() / 2));
		
		Collections.reverse(salaries);
		System.out.println(salaries.get(0));
		System.out.println(salaries.get(salaries.size() - 1));
		
	}

}
