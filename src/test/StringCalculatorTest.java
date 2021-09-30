package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import hari.tdd.assessment.StringCalculator;
import hari.tdd.exception.CustomizeException;

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

	// TASK 2 - Allow the Add method to handle an unknown amount of numbers
	@Test
	public void testMoreNumbers() {
		assertEquals(stringCalculator.add("10,20,30,40"), 100);
	}

	// TASK 3 - Allow the new lines between numbers (instead of commas)
	@Test
	public void testNumbersWithNewLines() {
		assertEquals(stringCalculator.add("10,20\n30,40"), 100);
	}

	// TASK 4 - Support different delimiters “//[delimiter]\n[numbers…]”
	@Test
	public void testDifferentDelimiters() {
		assertEquals(stringCalculator.add("//;\n1;2"), 3); // where the default delimiter is ‘;’
		assertEquals(stringCalculator.add("//#\n1#2"), 3);

		assertEquals(stringCalculator.add("//#$\n1#$2#$3"), 6);

		assertEquals(stringCalculator.add("//-$^$-\n1-$^$-2-$^$-3"), 6);
	}

	// TASK 5 - Calling Add with a negative number will throw an exception
	@Test(expected = CustomizeException.class)
	public void testNegativeNumbers() {
		stringCalculator.add("10,-20,30,-40");
	}

}
