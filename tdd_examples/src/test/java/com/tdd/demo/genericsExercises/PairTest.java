package com.tdd.demo.genericsExercises;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class PairTest {

	@Test
	@DisplayName("Test Pair class initialises with two type parameters")
	public void test_PairClass_InitialisesWithTwoTypeParameters() {
		
		Pair<String> pair = new Pair<>("elementOne", "elementTwo");
		assertEquals("elementOne", pair.getFirstElement());
		assertEquals("elementTwo", pair.getSecondElement());
	
	}
	
	@Test
	@DisplayName("Test Pair class elements can be set")
	public void test_PairClass_ElementsCanBeSetToNewValues() {
		
		Pair<String> pair = new Pair<>("elementOne", "elementTwo");
		pair.setFirstElement("newElementOne");
		pair.setSecondElement("newElementTwo");
		assertEquals("newElementOne", pair.getFirstElement());
		assertEquals("newElementTwo", pair.getSecondElement());
		
	}
	
}
