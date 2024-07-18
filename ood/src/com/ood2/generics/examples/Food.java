package com.ood2.generics.examples;

public class Food {
	
	private String food;
	
	public Food(String food) {
		setFood(food);
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}
	
	@Override
	public String toString() {
		return getFood();
	}
}