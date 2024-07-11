package com.fdmgroup.castingExercises;

public class Snack implements BasketItem, FoodItem {
	
	private int fatContent;
	private int sugarContent;
	private String name;
	private double price;
	private int calories;
	
	public Snack(int fatContent, int sugarContent) {
		this.fatContent = fatContent;
		this.sugarContent = sugarContent;
	}
	
	public Snack(int fatContent, int sugarContent, String name, double price, int calories) {
		this.fatContent = fatContent;
		this.sugarContent = sugarContent;
		this.name = name;
		this.price = price;
		this.calories = calories;
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

	public int getFatContent() {
		return fatContent;
	}

	public void setFatContent(int fatContent) {
		this.fatContent = fatContent;
	}

	public int getSugarContent() {
		return sugarContent;
	}

	public void setSugarContent(int sugarContent) {
		this.sugarContent = sugarContent;
	}

	public String getName() {
		return name;
	}
	
}
