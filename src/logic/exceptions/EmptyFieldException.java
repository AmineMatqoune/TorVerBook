package logic.exceptions;

public class EmptyFieldException extends Exception {

	private static final long serialVersionUID = 5658685691974078234L;
	private static final String ERROR_MESSAGE = "Empty input field value!";

	public EmptyFieldException() {
		super(ERROR_MESSAGE);
	}

	public EmptyFieldException(String inputFieldName) {
		super("[" + inputFieldName + "]:" + ERROR_MESSAGE);
	}

}
