package com.fdmgroup.tdd.gradecalculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class GradeCalculatorTest {
	
	GradeCalculator gradeCalculator;
	
	double markAtPassThreshold = 75.0;
	double markBelowPassThreshold = this.markAtPassThreshold - 0.01;
	
	double markAtMeritThreshold = 80.0;
	double markBelowMeritThreshold = this.markAtMeritThreshold - 0.01;
	
	double markAtDistinctionThreshold = 90.0;
	double markBelowDistinctionThreshold = this.markAtDistinctionThreshold - 0.01;
	
	double markAtValidLimit = 100.0;
	double markAboveValidLimit = this.markAtValidLimit + 0.01;
	
	@BeforeEach
	void init() {
		this.gradeCalculator = new GradeCalculator();
	}
	
	@Test
	@DisplayName("getClassification() can be called on implementation class")
	public void test_getClassificationMethodDoesNotThrowExceptionForGradeCalculator_WhenCalled() {
		double genericTestNumber = 50.0;
		assertDoesNotThrow(() -> gradeCalculator.getClassification(genericTestNumber));
	}
	
	@Test
	@DisplayName("getClassification() returns 'fail' for marks below pass threshold")
	public void test_getClassificationMethodReturnsFail_WhenCalledWithMarkBelowPassThreshold() {
		assertEquals("fail", gradeCalculator.getClassification(markBelowPassThreshold));
	}
	
	@Test
	@DisplayName("getClassification() does not return 'fail' for marks at pass threshold")
	public void test_getClassificationMethodDoesNotReturnFail_WhenCalledWithMarkAtPassThreshold() {
		assertNotEquals("fail", gradeCalculator.getClassification(this.markAtPassThreshold));
	}
	
	@Test
	@DisplayName("getClassification() does not return 'fail' for marks above pass threshold")
	public void test_getClassificationMethodDoesNotReturnFail_WhenCalledWithMarkAbovePassThreshold() {
		assertNotEquals("fail", gradeCalculator.getClassification(this.markAtMeritThreshold));
	}
	
	@Test
	@DisplayName("getClassification() returns 'pass' for marks at pass threshold")
	public void test_getClassificationMethodReturnsPass_WhenCalledWithMarkAtPassThreshold() {
		assertEquals("pass", gradeCalculator.getClassification(this.markAtPassThreshold));
	}
	
	@Test
	@DisplayName("getClassification() returns 'pass' for marks between pass and merit thresholds")
	public void test_getClassificationMethodReturnsPass_WhenCalledWithMarkBetweenPassAndMeritThresholds() {
		assertEquals("pass", gradeCalculator.getClassification(this.markBelowMeritThreshold));
	}
	
	@Test
	@DisplayName("getClassification() returns 'merit' for marks at merit threshold")
	public void test_getClassificationMethodReturnsMerit_WhenCalledWithMarkAtMeritThreshold() {
		assertEquals("merit", gradeCalculator.getClassification(this.markAtMeritThreshold));
	}
	
	@Test
	@DisplayName("getClassification() returns 'merit' for marks between merit and distinction thresholds")
	public void test_getClassificationMethodReturnsMerit_WhenCalledWithMarkBetweenMeritAndDistinctionThresholds() {
		assertEquals("merit", gradeCalculator.getClassification(this.markBelowDistinctionThreshold));
	}
	
	@Test
	@DisplayName("getClassification() returns 'distinction' for marks at distinction threshold")
	public void test_getClassificationMethodReturnsDistinction_WhenCalledWithMarkAtDistinctionThreshold() {
		assertEquals("distinction", gradeCalculator.getClassification(this.markAtDistinctionThreshold));
	}
	
	@Test
	@DisplayName("getClassification() returns 'distinction' for marks between distinction threshold and valid limit (inclusive)")
	public void test_getClassificationMethodReturnsDistinction_WhenCalledWithMarkBetweenDistinctionThresholdAndValidLimit() {
		assertEquals("distinction", gradeCalculator.getClassification(this.markAtValidLimit));
	}
	
	@Test
	@DisplayName("getClassification() returns null for marks above valid limit")
	public void test_getClassificationMethodReturnsNull_WhenCalledWithMarkAboveValidLimit() {
		assertNull(gradeCalculator.getClassification(this.markAboveValidLimit));
	}

}
