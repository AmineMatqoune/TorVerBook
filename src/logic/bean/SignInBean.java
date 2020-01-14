package logic.bean;

import logic.account.User;

public class SignInBean {
	
	public boolean checkInfo(User user) {
		boolean expression = false;
		if((user.getName().length() > 15) || user.getName().equals(""))
			return expression;
		if((user.getSurname().length() > 15) || user.getSurname().equals(""))
			return expression;
		if((user.getUsername().length() > 20) || user.getUsername().equals(""))
			return expression;
		if((user.getEmail().length() > 30) || user.getEmail().equals(""))
			return expression;
		if((user.getPassword().length() > 30) || user.getPassword().equals(""))
			return expression;
		
		//no syntax errors found, return true
		return !expression;
	}
}
