package logic.bean;

import static logic.utils.DataValidationUtils.checkByMaxLength;
import static logic.utils.DataValidationUtils.checkNotEmpty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.stage.Stage;
import logic.account.User;
import logic.exceptions.EmptyFieldException;
import logic.exceptions.ExcessiveInputLengthException;
import logic.gui.SignUpScene;
import logic.gui.popup.ErrorPopup;

public class SignUpBean {

	private SignUpScene signUpScene;

	private Date date;

	public SignUpBean() {
		signUpScene = SignUpScene.getInstance();
	}

	public boolean checkInfo(User user) throws EmptyFieldException, ExcessiveInputLengthException {
		if (checkByMaxLength(user.getName(), 15) && checkNotEmpty(user.getName())
				&& checkByMaxLength(user.getSurname(), 15) && checkNotEmpty(user.getSurname())
				&& checkByMaxLength(user.getUsername(), 20) && checkNotEmpty(user.getUsername())
				&& checkByMaxLength(user.getEmail(), 30) && checkNotEmpty(user.getEmail())
				&& checkByMaxLength(user.getPassword(), 30) && checkNotEmpty(user.getPassword())) {
			try {
				// user inputs are correct, check if birthDate is a valid date, if so, set
				// user's birthdate
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				dateFormat.setLenient(false);
				date = dateFormat.parse(getYear() + "-" + getMonth() + "-" + getDay());
			} catch (ParseException e) {
				new ErrorPopup(e.getMessage(), (Stage) signUpScene.getScene().getWindow());
				return false;
			}
			return true;
		}

		return false;

		// crea metodo per far ricevere al signupController "birthdate"
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
