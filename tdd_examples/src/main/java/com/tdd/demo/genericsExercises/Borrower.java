package com.tdd.demo.genericsExercises;

public class Borrower implements CatalogItem {

	private int id;
	
	public Borrower(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

}
