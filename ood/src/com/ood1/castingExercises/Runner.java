package com.ood1.castingExercises;

import java.util.ArrayList;

public class Runner {

	public static void main(String[] args) {
		
		Toy toy1 = new Toy(3, 8, "slinky", 4.99);
		Laptop laptop1 = new Laptop(1000.0, 1024, 2048, "dell", 399.99);
		Snack snack1 = new Snack(5, 5, "choco", 20.0, 450);
		Snack snack2 = new Snack(10, 10, "burger", 20.0, 900);
		ReadyMeal readyMeal1 = new ReadyMeal("british", "pie", 50, 320);
		ReadyMeal readyMeal2 = new ReadyMeal("german", "strudel", 13, 670);
		
		Basket basket = new Basket();
		CalorieCounter calorieCounter = new CalorieCounter();
		
		basket.addItem(toy1);
		basket.addItem(laptop1);
		basket.addItem(snack1);
		basket.addItem(snack2);
		basket.addItem(readyMeal1);
		basket.addItem(readyMeal2);
		
		ArrayList<BasketItem> basketItems = basket.getAllItems();
		
		for (BasketItem item : basketItems) {
			System.out.println(item.getName());
		}
		
		basket.removeItem(readyMeal2);
		
		for (BasketItem item : basketItems) {
			System.out.println(item.getName());
		}
		
		calorieCounter.addLowCalorieFood(snack1);
		calorieCounter.addLowCalorieFood(snack2);
		calorieCounter.addLowCalorieFood(readyMeal1);
		calorieCounter.addLowCalorieFood(readyMeal2);
		
		ArrayList<FoodItem> lowCalFoods = calorieCounter.getAllLowCalorieFoods();
		
		for (FoodItem item : lowCalFoods) {
			System.out.println(item.getCalories());
		}
		
		// Downcasting exercise
		ArrayList<FoodItem> lowCalorieFoods = calorieCounter.getAllLowCalorieFoods();
		
		for (FoodItem item : lowCalorieFoods) {
			
			if (item instanceof Snack) {
				Snack aSnack = (Snack) item;
				System.out.println("name=" + aSnack.getName() + ", price=" + aSnack.getPrice());
				System.out.println("fatContent=" + aSnack.getFatContent() + ", sugarContent=" + aSnack.getSugarContent());
				System.out.println();
			}
			
			if (item instanceof ReadyMeal) {
				ReadyMeal aReadyMeal = (ReadyMeal) item;
				System.out.println("name=" + aReadyMeal.getName() + ", price=" + aReadyMeal.getPrice());
				System.out.println("cuisineType=" + aReadyMeal.getCuisineType());
				System.out.println();
			}
		}
		
		calorieCounter.removeHighCalorieFoodsFromBasket(basket, 500);
		ArrayList<BasketItem> basketItems3 = basket.getAllItems();
		
		for (BasketItem item : basketItems3) {
			
			System.out.println(item.getName());
			if (item instanceof FoodItem) {
				FoodItem food = (FoodItem) item;
				System.out.println(food.getCalories());
				System.out.println();
			}
		}
		

	}

}
