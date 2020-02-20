package logic.exceptions;

public class InsufficientFundsException extends Exception {

	private static final long serialVersionUID = -3827598579664821236L;
	private static final String ERROR_MESSAGE = "Not enough funds to buy the book!";

	public InsufficientFundsException() {
		super(ERROR_MESSAGE);
	}
}
