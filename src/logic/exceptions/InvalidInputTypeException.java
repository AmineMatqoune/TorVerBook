package logic.exceptions;

public class InvalidInputTypeException extends Exception {

	private static final long serialVersionUID = 5658685691974078234L;
	private static final String ERROR_MESSAGE = "Invalid input type provided!";
	
	public InvalidInputTypeException() {
		super(ERROR_MESSAGE);
	}

	public InvalidInputTypeException(String inputFieldName) {
		super("[" + inputFieldName + "]:" + ERROR_MESSAGE);
	}
}
