package com.tdd.comparisonsExercises;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;


public class BookTest {
	
	private Book book1;
	private Book book2;
	private Book book3;
	private Book book4;
	private Book book5;
	private Book book6;
	private Book book7;
	private List<Book> books;
	
	@BeforeAll
	void initAll() {
		this.book1 = new Book("Learn Java", 45678, 19.99, 500, 4.3);
		this.book2 = new Book("Learn UNIX", 65432, 17.5, 650, 3.9);
		this.book3 = new Book("Learn SQL", 87956, 9.75, 220, 4.4);
		this.book4 = new Book("Learn Agile", 35367, 25.5, 500, 4.4);
		this.book5 = new Book("Learn React", 55676, 28.75, 490, 4.8);
		this.book6 = new Book("Learn JavaScript", 34343, 14.99, 300, 4.4);
		this.book7 = new Book("Learn Python", 65767, 27.25, 500, 4.1);
		this.books = new ArrayList<>();
	}
	
	@BeforeEach
	void initEach() {
		this.books = new ArrayList<>();
	}
	
	@Test
	@DisplayName("Test Book class initialises with expected attributes")
	public void test_BookClass_InitialisesWithExpectedAttributes() {
		
		String title = "Title";
		int isbn = 1234;
		double price = 9.99;
		int numberOfPages = 100;
		double rating = 4.5;
		Book book = new Book(title, isbn, price, numberOfPages, rating);

		assertEquals(title, book.getTitle());
		assertEquals(isbn, book.getISBN());
		assertEquals(price, book.getPrice());
		assertEquals(numberOfPages, book.getNumberOfPages());
		assertEquals(rating, book.getRating());
	}
	
	@Test
	@DisplayName("Test PAGE_COMPARATOR sorts books by ascending number of pages")
	public void test_BookClass_PageComparator_SortsByAscendingNumberOfPages() {
		
		books.add(book2);
		books.add(book3);
		books.add(book4);
		
		books.sort(Book.PAGE_COMPARATOR);
		
		assertEquals(book3, books.get(0));
		assertEquals(book4, books.get(1));
		assertEquals(book2, books.get(2));
	}
	
	@Test
	@DisplayName("Test PAGE_COMPARATOR sorts books with equal numberOfPages by ISBN")
	public void test_BookClass_PageComparator_SecondarySortsByISBNIfNumberOfPagesIsEqual() {
		
		books.add(book1);
		books.add(book4);
		books.add(book7);
		
		books.sort(Book.PAGE_COMPARATOR);
		
		assertEquals(book4, books.get(0));
		assertEquals(book1, books.get(1));
		assertEquals(book7, books.get(2));
	}
	
	@Test
	@DisplayName("Test NAME_COMPARATOR sorts books by name alphabetically")
	public void test_BookClass_NameComparator_SortsByNameAlphabetically() {
		
		books.add(book3);
		books.add(book4);
		books.add(book5);
		
		books.sort(Book.NAME_COMPARATOR);
		
		assertEquals(book4, books.get(0));
		assertEquals(book5, books.get(1));
		assertEquals(book3, books.get(2));
	}
	
	@Test
	@DisplayName("Test PRICE_COMPARATOR sorts books in descending price order")
	public void test_BookClass_PriceComparator_SortsByPriceInDescendingOrder() {
		
		books.add(book2);
		books.add(book4);
		books.add(book6);
		
		books.sort(Book.PRICE_COMPARATOR);
		
		assertEquals(book4, books.get(0));
		assertEquals(book2, books.get(1));
		assertEquals(book6, books.get(2));
	}
	
	@Test
	@DisplayName("Test PAGE_ISBN_COMPARATOR sorts books in ascending page then descending ISBN order")
	public void test_BookClass_PageISBNComparator_SortsByAscendingPageThenDescendingISBN() {
		
		books.add(book1);
		books.add(book4);
		books.add(book7);
		
		books.sort(Book.PAGE_ISBN_COMPARATOR);
		
		assertEquals(book7, books.get(0));
		assertEquals(book1, books.get(1));
		assertEquals(book4, books.get(2));
	}
	
	@Test
	@DisplayName("Test RATING_PRICE_COMPARATOR sorts books in descending rating then ascending price order")
	public void test_BookClass_RatingPriceComparator_SortsByDescendingRatingThenAscendingPrice() {
		
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
		
		books.sort(Book.RATING_PRICE_COMPARATOR);
		
		assertEquals(book5, books.get(0));
		assertEquals(book3, books.get(1));
		assertEquals(book4, books.get(2));
		assertEquals(book2, books.get(3));
	}

}
