package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
// for importing in sts shortcut is ctrl+shift+o
import org.junit.jupiter.api.Test;

import com.revature.exceptions.WeHateSevenException;

public class CalculatorTest {

	private static Calculator calc;
	
	/*
	 * JUnit 5 annotations
	 * 	- @BeforeAll
	 * 	- @BeforeEach
	 * 	- @AfterAll
	 * 	- @AfterEach
	 * 
	 * 	- @Test
	 * 	- @Ignore
	 * 	- @Order
	 */
	
	@BeforeAll
	public static void setUp() {
		calc = new Calculator();
	}
	
	@AfterAll
	public static void tearDown() {
		//tearing down behavior
	}
	
	@Test
	public void addOneAndTwo() {
		double expected = 3;
		double actual = calc.add(1, 2);
		assertEquals(expected, actual, "Adding one and two should be 3");
	}
	
	@Test
	public void addFourAndFive() {
		double expected = 9;
		double actual = calc.add(4, 5);
		assertEquals(expected, actual, "Adding four and five should be 9");
	}
	
	@Test
	public void weHateSeven() {
		assertThrows(WeHateSevenException.class, () -> calc.add(4,3));
	}
	
}
