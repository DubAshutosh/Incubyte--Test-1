package com.java.stringcalculator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

	private StringCalculator calculator;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void initialize() {
		calculator = new StringCalculator();
	}

/// Test -1 Basic Test
	@Test
	public void emptyStringShouldReturn0() {
		assertEquals(calculator.add(""), 0);
	}

	@Test
	public void numberStringShouldReturnSameNumber() {
		assertEquals(calculator.add("1"), 1);
		assertEquals(calculator.add("3"), 3);
	}

	@Test
	public void numbersCommaDelimitedShouldBeSummed() {
		assertEquals(calculator.add("1,2"), 3);
		assertEquals(6, calculator.add("1,5"));
	}

    //Test -2 Unknown amount of numbers
	@Test
	public void handleMultipleInput() {
		assertEquals(45, calculator.add("1,2,3,4,5,6,7,8,9"));

	}

	// Test-3 Handle new Line
	@Test
	public void numbersNewlineDelimiter() {
		assertEquals(calculator.add("1\n2"), 3);
		assertEquals(calculator.add("50\n50"), 100);
	}
	//Test-4 Support Different Delimiter
	 @Test
	    public void differentDelimiter() {
	        assertEquals(calculator.add("9,8,7"), 24);
	        assertEquals(calculator.add("50\n20\n30"), 100);
	    }
     // Test-5 Negative Inputs
	    @Test
	    public void negativeInput() {
	        thrown.expect(IllegalArgumentException.class);
	        thrown.expectMessage("Negative input Not Allowed");
	        calculator.add("-10");
	        calculator.add("-7,10\n-15");
	    }
	    //test -6 value greater than 1000
	    @Test
	    public void greaterThan1000() {
	        assertEquals(calculator.add("5,10,1500"), 15);
	       
	    }
}
