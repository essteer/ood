package ood1.interfaces;

import java.util.ArrayList;

public class CalorieCounter {
	
	private ArrayList<FoodItem> lowCalorieFoods;
	
	public CalorieCounter() {
		this.lowCalorieFoods = new ArrayList<>();
	}
	
	public void addLowCalorieFood(FoodItem foodItem) {
		
		if (foodItem.getCalories() <= 500) {
			this.lowCalorieFoods.add(foodItem);
		}
	}
	
	public ArrayList<FoodItem> getAllLowCalorieFoods() {
		return this.lowCalorieFoods;
	}

}
