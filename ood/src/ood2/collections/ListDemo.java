package ood2.collections;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
	
	public static void main(String[] args) {
		
		List<String> namesList = new ArrayList<>();
		namesList.add("Audrey");
		namesList.add("John");
		namesList.add("Audrey");
		namesList.add("Steve");
		
		System.out.println(namesList);
		System.out.println(namesList.get(1));
		System.out.println(namesList.indexOf("Audrey"));
		System.out.println(namesList.lastIndexOf("Audrey"));
		
	}

}
