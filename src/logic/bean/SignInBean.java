package logic.bean;

import logic.account.User;

public class SignInBean {
	
	public boolean checkInfo(User user) {
		
		if((user.getName().length() > 15) || user.getName().equals(""))
			return false;
		if((user.getSurname().length() > 15) || user.getSurname().equals(""))
			return false;
		if((user.getUsername().length() > 20) || user.getUsername().equals(""))
			return false;
		if((user.getEmail().length() > 30) || user.getEmail().equals(""))
			return false;
		if((user.getPassword().length() > 30) || user.getPassword().equals(""))
			return false;
		
		//no syntax errors found, return true
		return true;
	}
}
