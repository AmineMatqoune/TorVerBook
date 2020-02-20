package logic.exceptions;

public class ExcessiveInputLengthException extends Exception {

	private static final long serialVersionUID = -5576280670518976201L;
	private static final String ERROR_MESSAGE = "Provided input exceeds the maximum input size!";

	public ExcessiveInputLengthException() {
		super(ERROR_MESSAGE);
	}

	public ExcessiveInputLengthException(String inputFieldName) {
		super("[" + inputFieldName + "]:" + ERROR_MESSAGE);
	}

	public ExcessiveInputLengthException(String inputFieldName, int maxInputSize) {
		super("[" + inputFieldName + "]:" + ERROR_MESSAGE + "(Max Input Size:" + maxInputSize + ")");
	}
}
