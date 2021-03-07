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
}
