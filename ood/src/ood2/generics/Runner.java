package ood2.generics;

public class Runner {

	public static void main(String[] args) {

//		Book<Integer> book1 = new Book<>(1234);
//		Book<Integer> book2 = new Book<>(2345);
//
//		Catalog<Book<Integer>> bookCatalog = new Catalog<>();
//
//		bookCatalog.addItem(book1);
//		bookCatalog.addItem(book2);
//
//		System.out.println(bookCatalog.findItem(1234));
//
//		Borrower<Double> borrower1 = new Borrower<>(1.01);
//		Borrower<Double> borrower2 = new Borrower<>(2.02);
//
//		Catalog<Borrower<Double>> borrowerCatalog = new Catalog<>();
//
//		borrowerCatalog.addItem(borrower1);
//		borrowerCatalog.addItem(borrower2);
//
//		System.out.println(borrowerCatalog.findItem(2.02));
		
		Catalog<Book, Integer> bookCatalog = new Catalog<>();
		Catalog<Borrower, Integer> borrowerCatalog = new Catalog<>();

		Book book1 = new Book();
		book1.setId(1);
		bookCatalog.addItem(book1);

		Borrower borrower1 = new Borrower();
		borrower1.setId(101);
		borrowerCatalog.addItem(borrower1);

		System.out.println("Book with ID 1: " + bookCatalog.findItem(1));
		System.out.println("Borrower with ID 101: " + borrowerCatalog.findItem(101));

	}
}
