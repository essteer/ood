package com.essteer.BookStoreTDD;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Test;

public class CheckoutTest {
	
	@Test
	public void test_CalculatePrice_ReturnsDoubleZeroPointZeroWhenPassedAnEmptyBasket() {
		
		Basket basket = new Basket();
		Checkout checkout = new Checkout();
		
		double expected = 0.0;
		double actual = checkout.calculatePrice(basket);
		double epsilon = 0.0001;
		
		assertTrue(Math.abs(expected - actual) <= epsilon);
	}
	
	@Test 
	void test_CalculatePrice_ReturnsPriceOfBookInBasket_WhenPassedBasketWithOneBook() {
		
		Basket basket = new Basket();
		Checkout checkout = new Checkout();
		int numBooks = 1;
		for (int i=1; i<=numBooks; i++) {
			Book book = new Book(25.99, 1111L);
			basket.addBook(book);
		}
		double expected = 25.99;
		double actual = checkout.calculatePrice(basket);
		double epsilon = 0.0001;
		
		assertTrue(Math.abs(expected - actual) <= epsilon);
	}
	
	@Test
	void test_CalculatePrice_ReturnsPriceOfBooksInBasketMinusFivePercent_WhenPassedBasketWithTwoDifferentBooks() {
		
		Basket basket = new Basket();
		Checkout checkout = new Checkout();
		int numBooks = 2;
		long baseISBN = 1111L;
		for (int i=1; i<=numBooks; i++) {
			Book book = new Book(25.99, baseISBN * i);
			basket.addBook(book);
		}
		
		double discountForUniqueBooks = 0.05;
		double expected = (25.99 * 2) * (1 - discountForUniqueBooks);
		double actual = checkout.calculatePrice(basket);
		double epsilon = 0.0001;
		
		assertTrue(Math.abs(expected - actual) <= epsilon);
	}
	
	@Test
	void test_CalculatePrice_ReturnsPriceOfBooksInBasketMinusSixPercent_WhenPassedBasketWithThreeDifferentBooks() {
		
		Basket basket = new Basket();
		Checkout checkout = new Checkout();
		int numBooks = 3;
		long baseISBN = 1111L;
		for (int i=1; i<=numBooks; i++) {
			Book book = new Book(25.99, baseISBN * i);
			basket.addBook(book);
		}
		
		double discountForUniqueBooks = 0.05;
		double discountForThreeBooks = 0.01;
		double expected = (25.99 * 3) * (1 - discountForThreeBooks - discountForUniqueBooks);
		double actual = checkout.calculatePrice(basket);
		double epsilon = 0.001;
		
		assertTrue(Math.abs(expected - actual) <= epsilon);
	}
	
	@Test
	void test_CalculatePrice_ReturnsPriceOfBooksInBasketMinusTwoPercent_WhenPassedBasketWithSevenUniqueBooks() {
		
		Basket basket = new Basket();
		Checkout checkout = new Checkout();
		int numBooks = 7;
		long baseISBN = 1111L;
		for (int i=1; i<=numBooks; i++) {
			Book book = new Book(25.99, baseISBN * i);
			basket.addBook(book);
		}
		
		double discountForUniqueBooks = 0.05;
		double discountForThreeBooks = 0.01 * 2;
		double expected = (25.99 * 7) * (1 - discountForThreeBooks - discountForUniqueBooks);
		double actual = checkout.calculatePrice(basket);
		double epsilon = 0.001;
		
		assertTrue(Math.abs(expected - actual) <= epsilon);
	}
	
	@Test
	void test_CalculatePrice_ReturnsPriceOfBooksInBasketMinusEighteenPercent_WhenPassedBasketWithTenUniqueBooks() {
		
		Basket basket = new Basket();
		Checkout checkout = new Checkout();
		int numBooks = 10;
		long baseISBN = 1111L;
		for (int i=1; i<=numBooks; i++) {
			Book book = new Book(25.99, baseISBN * i);
			basket.addBook(book);
		}
		
		double expected = (25.99 * 10) * 0.82;
		double actual = checkout.calculatePrice(basket);
		double epsilon = 0.001;
		
		assertTrue(Math.abs(expected - actual) <= epsilon);
	}
	
	@Test
	void test_CalculatePrice_ReturnsPriceOfBooksMinusSixPercent_WhenPassedBasketWithThreeUniqueBooks() {
		
		Basket basket = new Basket();
		Checkout checkout = new Checkout();
		int numBooks = 3;
		long baseISBN = 1111L;
		for (int i=1; i<=numBooks; i++) {
			Book book = new Book(25.99, baseISBN * i);
			basket.addBook(book);
		}
		
		double expected = (25.99 * 3) * 0.94;
		double actual = checkout.calculatePrice(basket);
		double epsilon = 0.001;
		
		assertTrue(Math.abs(expected - actual) <= epsilon);
	}
	
	@Test
	void test_CalculatePrice_ReturnsPriceOfBooksMinusFiftyPercent_WhenPassedBasketWithTwoIdenticalBooks() {
		
		Basket basket = new Basket();
		Checkout checkout = new Checkout();
		int numBooks = 2;
		long baseISBN = 1111L;
		for (int i=1; i<=numBooks; i++) {
			Book book = new Book(25.99, baseISBN);
			basket.addBook(book);
		}
		
		double expected = (25.99 * 2) * 0.5;
		double actual = checkout.calculatePrice(basket);
		double epsilon = 0.001;
		
		assertTrue(Math.abs(expected - actual) <= epsilon);
	}

}
