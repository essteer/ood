package com.ood2.generics.examples;

import java.util.ArrayList;
import java.util.List;

public class GenericList<T> {
	
	private List<T> aList;
	
	public GenericList() {
		aList = new ArrayList<>();
	}
	
	public void add_item(T item) {
		aList.add(item);
	}
	
	public void remove_item(T item) {
		aList.remove(item);
	}

	public void print_list() {
		// System.out.print(aList);
		for(T item : aList) {
			System.out.println(item);
		}
	}
}