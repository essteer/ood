package com.ood1.casting;

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
	
	public void removeHighCalorieFoodsFromBasket(Basket basket, int calories) {
		
		for (BasketItem item : basket.getAllItems()) {
			// NOTE: might be better to finish iterating then remove items
			// to avoid interfering with for each loop?
			if (item instanceof FoodItem) {
				FoodItem foodItem = (FoodItem) item;
				int cals = foodItem.getCalories();
				if (!(cals <= calories)) {
					basket.removeItem(item);
				}
			}
		}
	}

}
