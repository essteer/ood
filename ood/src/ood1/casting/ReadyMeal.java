package ood1.casting;

public class ReadyMeal implements BasketItem, FoodItem {
	
	private String cuisineType;
	private String name;
	private double price;
	private int calories;
	
	public ReadyMeal(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	
	public ReadyMeal(String cuisineType, String name, double price, int calories) {
		this.cuisineType = cuisineType;
		this.name = name;
		this.price = price;
		this.calories = calories;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public double getPrice() {
		return this.price;
	}
	
	@Override
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public int getCalories() {
		return this.calories;
	}
	
	@Override
	public void setCalories(int calories) {
		this.calories = calories;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

}
