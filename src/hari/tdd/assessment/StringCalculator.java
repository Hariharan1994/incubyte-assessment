package hari.tdd.assessment;

/**
 * This is a simple StringCalculator for TDD KATA exercise
 * 
 * @author HARIHARAN MANI
 * @since 30-09-2021
 */
public class StringCalculator {

	/**
	 * This method can take up to two numbers, separated by commas, and will return
	 * their sum. (For example �� or �1� or �1,2� as inputs)
	 * 
	 * @param inputString
	 * @return sumValue
	 */
	public int add(String inputString) {
		if (inputString.isEmpty()) {
			return 0; // For an empty string it will return 0.
		}

		String[] inputArray = inputString.split(",");

		if (inputArray.length == 1) {
			return getIntValue(inputString); // For single string, directly return value
		}

		return getIntValue(inputArray[0]) + getIntValue(inputArray[1]); // For 2 numbers, sum its value
	}

	/**
	 * This method is used to convert String Number input into Integer
	 * 
	 * @param inputString
	 * @return integerValue
	 */
	private int getIntValue(String inputString) {
		return Integer.parseInt(inputString);
	}
}