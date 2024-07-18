package com.tdd.demo.genericsExercises;

public class Book implements CatalogItem {
	
	private int id;
	
	public Book(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

}
