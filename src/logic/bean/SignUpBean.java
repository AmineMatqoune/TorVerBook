package logic.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.stage.Stage;
import logic.account.User;
import logic.gui.SignUpScene;
import logic.gui.popup.ErrorPopup;

public class SignUpBean {
	
	private SignUpScene signUpScene;
	
	private Date date;
	
	public SignUpBean() {
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
		
		try {
			//user inputs are correct, check if birthDate is a valid date, if so, set user's birthdate			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			dateFormat.setLenient(false);
			date = dateFormat.parse(getYear() + "-" + getMonth() + "-" + getDay());
		} catch (ParseException e) {
			new ErrorPopup(e.getMessage(), (Stage)signUpScene.getScene().getWindow());
			return expression;
		}
		
		//no syntax errors found, return true
		return !expression;
		
		//crea metodo per far ricevere al signupController "birthdate"
	}
	
	public String getName() {
		return signUpScene.getName();
	}
	
	public Date getBirthDate() {
		return date;
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
		return signUpScene.getPwd();
	}
	
	public String getConfirmPassword() {
		return signUpScene.getConfirmPwd();
	}

}
