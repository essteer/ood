//package com.ood2.json;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class Client {
//
//	public static void main(String[] args) {
//
//		File booksFile = new File("./src/main/resources/books.json");
//		Book[] booksArray = readFromJSONFile(booksFile);
//		for (Book book : booksArray) {
//			System.out.println("Title=" + book.getTitle() + ",Author=" + book.getAuthor() + ",ISBN=" + book.getIsbn());
//		}
//		
//		List<Book> booksList = Arrays.asList(booksArray);
//		System.out.println();
//		File sortedBooksFile = new File("./src/main/resources/sorted-books.json");
//		writeToJSONFileInAlphabeticalOrder(sortedBooksFile, booksList);
//		System.out.println();
//		File sortedISBNFile = new File("./src/main/resources/sorted-isbn.json");
//		writeToJSONFileInISBNOrder(sortedISBNFile, booksList);
//	}
//
//	public static Book[] readFromJSONFile(File file) {
//		ObjectMapper mapper = new ObjectMapper();
//		
//		Book[] booksArray = null;
//		try {
//			booksArray = mapper.readValue(file, Book[].class);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return booksArray;
//	}
//	
//	public static void writeToJSONFileInAlphabeticalOrder(File file, List<Book> books) {
//		Collections.sort(books);
//		
//		for (Book book : books) {
//			System.out.println("Title=" + book.getTitle() + ",Author=" + book.getAuthor() + ",ISBN=" + book.getIsbn());
//		}
//		
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			mapper.writeValue(file, books);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void writeToJSONFileInISBNOrder(File file, List<Book> books) {
//		Collections.sort(books, new BookISBNComparator());
//		
//		for (Book book : books) {
//			System.out.println("Title=" + book.getTitle() + ",Author=" + book.getAuthor() + ",ISBN=" + book.getIsbn());
//		}
//		
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			mapper.writeValue(file, books);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//}
