package com.essteer.BookStoreMockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CatalogueTest {
	
	Catalogue catalogue;
	
	@Mock
	Book mockBook;
	
	@Mock
	ReadItemCommand mockRIC;
	
	@Mock
	WriteItemCommand mockWIC;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
		catalogue = new Catalogue(mockRIC, mockWIC);
	}
	
	@Test  // 1
	public void getAllBooks_ReturnsEmptyBookList_IfNoBooksAreInTheCatalogue() {
		
		List<Book> bookList = catalogue.getAllBooks();
		
		int expected = 0;
		int actual = bookList.size();
		
		assertEquals(expected, actual);
	}
	
	@Test  // 2
	public void getAllBooks_CallsReadAllMethodOfReadItemCommand_WhenCalled() {
		
		catalogue.getAllBooks();
		verify(mockRIC, times(1)).readAll();
	}
	
	@Test  // 3
	public void getAllBooks_ReturnsListOfBooksItReceivesFromReadAllMethodOfReadItemCommand_WhenCalled() {
		
		List<Book> expected = new ArrayList<>();
		expected.add(new Book("1234"));
		when(mockRIC.readAll()).thenReturn(expected);
		
		List<Book> actual = catalogue.getAllBooks();
		
		assertEquals(expected, actual);
	}
	
	@Test  // 4
	public void addBook_PassesBookGivenToInsertItemMethodOfWriteItemCommand_WhenCalled() {
		
		catalogue.addBook(mockBook);
		verify(mockWIC, times(1)).insertItem(mockBook);
	}
	
	@Test  // 5
	public void addBooks_PassesEachBooksToInsertItemMethodOfWriteItemCommand_WhenCalledWithListOfBooks() {
		
		List<Book> bookList = new ArrayList<>();
		bookList.add(mockBook);
		bookList.add(mockBook);
		catalogue.addBooks(bookList);
		
		verify(mockWIC, times(2)).insertItem(mockBook);
	}
	
	@Test  // 6
	public void getBook_ReturnsBookWithSameISBNValueFromGetItemMethodOfReadItemCommand_WhenCalled() {
		
		String ISBN = "1234";
		when(mockRIC.getItem(ISBN)).thenReturn(new Book(ISBN));
		
		Book book = catalogue.getBook(ISBN);
		
		assertEquals(book.getISBN(), mockRIC.getItem(ISBN).getISBN());
	}
	
	@Test  // 7
	public void deleteBook_PassesBookToDeleteItemMethodOfWriteItemCommand_WhenCalled() {
		
		catalogue.deleteBook(mockBook);
		verify(mockWIC, times(1)).deleteItem(mockBook);
	}
	
	@Test  // 8
	public void deleteAllBooks_CallsReadAllMethodOfReadItemCommand_ThenCallsDeleteItemMethodOfWriteItemCommandForEachBook_WhenCalled() {
		
		List<Book> books = new ArrayList<>();
		int n = 5;
		for (int i=1; i<=n; i++) {
			books.add(mockBook);
		}
		// this bypasses the Catalogue's own list of books
		// since that doesn't yet exist
		// when readAll is called, it simulates it by returning an artificial list of books
		// the deleteItem method is then called on each book in that artificial list
		when(mockRIC.readAll()).thenReturn(books);
		
		catalogue.deleteAllBooks();
		
		verify(mockRIC, times(1)).readAll();
		verify(mockWIC, times(n)).deleteItem(mockBook);
	}
	

}
