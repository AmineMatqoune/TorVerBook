package logic.exceptions;

public class InvalidInputValueException extends Exception {

	private static final long serialVersionUID = 5658685691974078234L;
	private static final String ERROR_MESSAGE = "Invalid input value provided!";
	
	public InvalidInputValueException() {
		super(ERROR_MESSAGE);
	}

	public InvalidInputValueException(String inputFieldName) {
		super("[" + inputFieldName + "]:" + ERROR_MESSAGE);
	}
}
