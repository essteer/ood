package com.fdmgroup.tddExercise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CheckoutTest {

	@Test
	void test_CalculatePrice_ReturnsDoubleZeroPointZeroWhenPassedAnEmptyBasket() {
		// Arrange
		Basket basket = new Basket();
		Checkout checkout = new Checkout();

		// Act
		double price = checkout.calculatePrice(basket);

		// Assert
		assertEquals(0, price);
	}

	@Test
	public void test_CalculatePrice_ReturnsPriceOfBookInBasket_WhenPassedBasketWithOneBook() {
		// Arrange
		Basket basket = new Basket();
		Book book = new Book(10);
		Checkout checkout = new Checkout();

		// Act
		basket.addBook(book);
		double price = checkout.calculatePrice(basket);

		// Assert
		assertEquals(10, price);
	}
	
	@Test
	public void test3() {
		// Arrange
		Basket basket = new Basket();
		Book book = new Book(10);
		Checkout checkout = new Checkout();

		// Act
		basket.addBook(book);
		basket.addBook(book);
		double price = checkout.calculatePrice(basket);

		// Assert
		assertEquals(20, price);
	}
	
	@Test
	public void test4() {
		// Arrange
		Basket basket = new Basket();
		Book book = new Book(25.99);
		Checkout checkout = new Checkout();

		// Act
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		double price = checkout.calculatePrice(basket);

		// Assert
		assertEquals(77.19, price, 0.005);
	}
	
	@Test
	public void test5() {
		// Arrange
		Basket basket = new Basket();
		Book book = new Book(25.99);
		Checkout checkout = new Checkout();

		// Act
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		double price = checkout.calculatePrice(basket);

		// Assert
		assertEquals(178.29, price, 0.005);
	}
	
	@Test
	public void test6() {
		// Arrange
		Basket basket = new Basket();
		Book book = new Book(25.99);
		Checkout checkout = new Checkout();

		// Act
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		double price = checkout.calculatePrice(basket);

		// Assert
		assertEquals(226.11, price, 0.005);
	}

}
