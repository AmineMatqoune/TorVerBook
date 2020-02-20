package logic.exceptions;

public class UsernameAlreadyExistsException extends Exception {

	private static final long serialVersionUID = -2942568804539978872L;
	private static final String ERROR_MESSAGE = "Username already exists, choose a different username!";

	public UsernameAlreadyExistsException() {
		super(ERROR_MESSAGE);
	}

	public UsernameAlreadyExistsException(String username) {
		super("[" + username + "]:" + ERROR_MESSAGE);
	}

	
	
}
