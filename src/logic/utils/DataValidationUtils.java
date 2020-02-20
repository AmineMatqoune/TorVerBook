package logic.utils;

import logic.exceptions.EmptyFieldException;
import logic.exceptions.ExcessiveInputLengthException;

public class DataValidationUtils {

	private DataValidationUtils() {
	}

	public static boolean checkByMaxLength(String input, int maxLength) throws ExcessiveInputLengthException {
		if (input.length() > maxLength) {
			throw new ExcessiveInputLengthException();
		}
		return true;
	}
	
	public static boolean checkNotEmpty(String input) throws EmptyFieldException {
		if(input.isEmpty()) {
			throw new EmptyFieldException();
		}
		return true;
	}

}
