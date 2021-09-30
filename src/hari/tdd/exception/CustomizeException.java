package hari.tdd.exception;

/**
 * This is a user-defined Exception Class
 * 
 * @author HARIHARAN MANI
 * @since 30-09-2021
 */
public class CustomizeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String customErrorMessage;

	public CustomizeException(String errorMessage) {
		this.customErrorMessage = errorMessage;
	}

	public String getCustomErrorMessage() {
		return this.customErrorMessage;
	}

}