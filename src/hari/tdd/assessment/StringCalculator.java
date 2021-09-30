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
	 * their sum. (For example “” or “1” or “1,2” as inputs)
	 * 
	 * @param inputString
	 * @return sumValue
	 */
	public int add(String inputString) {
		if (inputString.isEmpty()) {
			return 0; // For an empty string it will return 0.
		}

		if (inputString.startsWith("//")) {
			String delimeterInput = inputString.substring(2, inputString.indexOf("\n"));
			inputString = inputString.substring(inputString.indexOf("\n") + 1, inputString.length());
			inputString = inputString.replace(delimeterInput, ",");
		}

		String[] inputArray = inputString.split("[,\n]"); // Split by both commas and newLines

		if (inputArray.length == 1) {
			return getIntValue(inputString); // For single string, directly return value
		}

		int sumValue = 0;
		for (String inputNum : inputArray) { // For adding n numbers (more than 1)
			sumValue = sumValue + getIntValue(inputNum);
		}
		return sumValue;
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
