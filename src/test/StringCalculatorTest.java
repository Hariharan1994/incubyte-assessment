package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import hari.tdd.assessment.StringCalculator;

/**
 * This is used to execute the JUNIT.
 * 
 * @author HARIHARAN MANI
 * @since 30-09-2021
 */
public class StringCalculatorTest {

	private StringCalculator stringCalculator;

	@Before
	public void initialize() {
		stringCalculator = new StringCalculator();
	}

	// TASK 1
	@Test
	public void testEmptyString() {
		assertEquals(stringCalculator.add(""), 0);
	}

	@Test
	public void testSingleNumber() {
		assertEquals(stringCalculator.add("10"), 10);
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(stringCalculator.add("10,20"), 30);
	}

	// TASK 2
	@Test
	public void testMoreNumbers() {
		assertEquals(stringCalculator.add("10,20,30,40"), 100);
	}

}
