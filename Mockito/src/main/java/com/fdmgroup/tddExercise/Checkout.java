package com.fdmgroup.tddExercise;

public class Checkout {

	public double calculatePrice(Basket basket) {
		double price = 0;
		for (Book book : basket.getBooksInBasket()) {
			price += book.getPrice();
		}
		
		int discount = 0;
		discount += basket.getBooksInBasket().size()/3;
		if (basket.getBooksInBasket().size() >= 10) {
			discount += 10;
		}
		return price * (100-discount)/100.0;
	}

}
