package com.tdd.genericsExercises;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class BookTest {
	
	@Test
	@DisplayName("Test Book class initialises with expected attribute")
	public void test_BookClass_InitialisesWithExpectedAttribute() {
		
		Book book = new Book(1234);
		assertEquals(1234, book.getId());
	
	}

}
