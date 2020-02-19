package torverbook.web.bean;

import java.text.SimpleDateFormat;

import torverbook.web.account.User;

public class SignUpBean {

	public boolean checkInfo(User user) {
		boolean expression = false;
		
		if ((user.getName().length() > 15) || user.getName().equals(""))
			return expression;
		if ((user.getSurname().length() > 15) || user.getSurname().equals(""))
			return expression;
		if ((user.getUsername().length() > 20) || user.getUsername().equals(""))
			return expression;
		if ((user.getEmail().length() > 30) || user.getEmail().equals(""))
			return expression;
		if ((user.getPassword().length() > 30) || user.getPassword().equals(""))
			return expression;

			// user inputs are correct, check if birthDate is a valid date, if so, set
			// user's birthdate
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			dateFormat.setLenient(false);

		// no syntax errors found, return true
		return !expression;

		// crea metodo per far ricevere al signupController "birthdate"
	}

}
