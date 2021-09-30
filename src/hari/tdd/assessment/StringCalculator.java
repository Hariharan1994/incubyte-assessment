package hari.tdd.assessment;

import java.util.ArrayList;
import java.util.List;

import hari.tdd.exception.CustomizeException;

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
			String delimeterInput = getDelimeterInput(inputString);
			inputString = inputString.substring(inputString.indexOf("\n") + 1, inputString.length());
			inputString = inputString.replace(delimeterInput, ",");
		}

		String[] inputArray = inputString.split("[,\n]"); // Split by both commas and newLines
		List<Integer> positiveList = getValidPositiveNumbers(inputArray);

		if (positiveList.size() == 1) {
			return getIntValue(inputString); // For single string, directly return value
		}

		int sumValue = 0;
		for (int inputNum : positiveList) { // For adding n numbers (more than 1)
			sumValue = sumValue + inputNum;
		}
		return sumValue;
	}

	/**
	 * This method is used to split the delimeterInput from input String
	 * 
	 * @param inputString
	 * @return delimeterInput
	 */
	private String getDelimeterInput(String inputString) {
		String delimeterInput = inputString.substring(2, inputString.indexOf("\n"));
		if (delimeterInput.startsWith("[")) {
			delimeterInput = delimeterInput.substring(1, delimeterInput.length());
		}
		if (delimeterInput.endsWith("]")) {
			delimeterInput = delimeterInput.substring(0, delimeterInput.length() - 1);
		}
		return delimeterInput;
	}

	/**
	 * This method is used to validate the array input and get the positive number.
	 * If negative number is available, CustomizeException will be thrown.
	 * 
	 * @param inputArray
	 * @return positiveInputList
	 */
	private List<Integer> getValidPositiveNumbers(String[] inputArray) {
		List<Integer> positiveList = new ArrayList<>();
		List<Integer> negativeList = new ArrayList<>();
		for (String inputString : inputArray) {
			int inputNum = getIntValue(inputString);
			if (inputNum < 0) {
				negativeList.add(inputNum);
			} else {
				positiveList.add((inputNum > 1000) ? 0 : inputNum); // Numbers > 1000 should be ignored,
			}
		}

		if (!negativeList.isEmpty()) {
			throw new CustomizeException(String.format("negatives not allowed - %s", negativeList));
		} else {
			return positiveList;
		}
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
