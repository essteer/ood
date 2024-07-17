package com.tdd.demo.comparisonsExercises;

import java.util.ArrayList;
import java.util.TreeSet;

public class Runner {

	public static void main(String[] args) {
		
		Book book1 = new Book("Learn Java", 45678, 19.99, 500, 4.3);
		Book book2 = new Book("Learn UNIX", 65432, 17.5, 650, 3.9);
		Book book3 = new Book("Learn SQL", 87956, 9.75, 220, 4.4);
		Book book4 = new Book("Learn Agile", 35367, 25.5, 500, 4.4);
		Book book5 = new Book("Learn React", 55676, 28.75, 490, 4.8);
		Book book6 = new Book("Learn JavaScript", 34343, 14.99, 300, 4.4);
		Book book7 = new Book("Learn Python", 65767, 27.25, 500, 4.1);
		
		ArrayList<Book> bookArray = new ArrayList<>();
		bookArray.add(book1);
		bookArray.add(book2);
		bookArray.add(book3);
		bookArray.add(book4);
		bookArray.add(book5);
		bookArray.add(book6);
		bookArray.add(book7);
		
		bookArray.sort(Book.NAME_COMPARATOR);
		for (Book book : bookArray) {
		    System.out.println(book);
		}
		
		System.out.println();
		bookArray.sort(Book.PAGE_COMPARATOR);
		for (Book book : bookArray) {
		    System.out.println(book);
		}
		
		System.out.println();
		bookArray.sort(Book.PAGE_ISBN_COMPARATOR);
		for (Book book : bookArray) {
		    System.out.println(book);
		}
		
		System.out.println();
		bookArray.sort(Book.PRICE_COMPARATOR);
		for (Book book : bookArray) {
		    System.out.println(book);
		}
		
		System.out.println();
		bookArray.sort(Book.RATING_PRICE_COMPARATOR);
		for (Book book : bookArray) {
		    System.out.println(book);
		}
		
		TreeSet<Book> bookTreeSet = new TreeSet<Book>(new BookRatingPriceComparator());
		bookTreeSet.add(book1);
		bookTreeSet.add(book2);
		bookTreeSet.add(book3);
		bookTreeSet.add(book4);
		bookTreeSet.add(book5);
		bookTreeSet.add(book6);
		bookTreeSet.add(book7);
		
		System.out.println();
		System.out.println("TreeSet comparator");
		for (Book book : bookTreeSet) {
		    System.out.println(book);
		}
		

	}

}
