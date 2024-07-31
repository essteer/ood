package com.ood1.casting;

import java.util.ArrayList;

public class Basket {
	
	private ArrayList<BasketItem> basketItems;
	
	public Basket() {
		this.basketItems = new ArrayList<>();
	}
	
	public void addItem(BasketItem basketItem) {
		this.basketItems.add(basketItem);
	}
	
	public void removeItem(BasketItem basketItem) {
		this.basketItems.remove(basketItem);
	}
	
	public ArrayList<BasketItem> getAllItems() {
		return this.basketItems;
	}

}
