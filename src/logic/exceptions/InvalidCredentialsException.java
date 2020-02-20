package logic.exceptions;

public class InvalidCredentialsException extends Exception {

	private static final long serialVersionUID = 5067379144745418614L;
	private static final String ERROR_MESSAGE = "Incorrect username or password!";

	public InvalidCredentialsException() {
		super(ERROR_MESSAGE);
	}
}
