package com.ood2.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		
		
//		Set<Person> friendSet = new TreeSet<>(new FriendComparator());
////		Set<Person> friendSet = new HashSet<>();
//		Person amber = new Person("Amber", true);
//		Person amber2 = new Person("Amber", true);
//		Person linette = new Person("Linette", true);
//		
//		friendSet.add(amber);
//		friendSet.add(amber2);
//		friendSet.add(linette);
//		
//		System.out.println(friendSet);
		
		// for native types, no need to specify compare method
		Set<String> names = new TreeSet<>();
		names.add("Barbara");
		names.add("Jackie");
		names.add("Abby");
		names.add("Zack");
		names.add("Zack");
		
		System.out.println(names);

	}

}
