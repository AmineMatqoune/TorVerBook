package logic.bean;

import logic.account.User;
import logic.gui.SignUpScene;

public class SignUpBean {
	
	int c = 5;
	private SignUpScene signUpScene = null;
	
	public SignUpBean() {
		c = 8;
		signUpScene = SignUpScene.getInstance();
	}
	
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
		
		//crea metodo per far ricevere al signupController "birthdate"
	}
	
	public void printC() {
		System.out.println(c);
	}
	
	public String getName() {
		return signUpScene.getName();
	}
	
	public String getSurname() {
		return signUpScene.getSurname();
	}
	
	public String getDay() {
		return signUpScene.getDay();
	}
	
	public String getMonth() {
		return signUpScene.getMonth();
	}
	
	public String getYear() {
		return signUpScene.getYear();
	}
	
	public String getUsername() {
		return signUpScene.getUsername();
	}
	
	public String getPhoneNumber() {
		return signUpScene.getPhoneNumber();
	}
	
	public String getEmail() {
		return signUpScene.getEmail();
	}
	
	public String getPassword() {
		System.out.println("Ao damme la pwd : ");
		return "aa";
		//return signUpScene.getPwd();
	}
	
	public String getConfirmPassword() {
		System.out.println("Ao damme la conf pwd");
		return "aa";
		//return signUpScene.getConfirmPwd();
	}

}
