package ood2.collections;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		
		Map<String,Integer> groceries = new HashMap<>();
		groceries.put("Apples", 2);
		groceries.put("Bananas", 2);
		groceries.put("Oranges", 7);
		groceries.put("Oranges", 3);
		
		System.out.println(groceries);
		
		System.out.println(groceries.values());
		System.out.println(groceries.keySet());
	}
}
