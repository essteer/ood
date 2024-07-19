package com.tdd.genericsExercises;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class BorrowerTest {
	
	@Test
	@DisplayName("Test Borrower class initialises with expected attribute")
	public void test_BorrowerClass_InitialisesWithExpectedAttribute() {
		
		Borrower borrower = new Borrower(1234);
		assertEquals(1234, borrower.getId());
	
	}

}
