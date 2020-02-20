package logic.controller;

import java.sql.SQLException;
import java.text.ParseException;

import javafx.stage.Stage;
import logic.account.User;
import logic.bean.SignUpBean;
import logic.dao.AccountDAO;
import logic.exceptions.EmptyFieldException;
import logic.exceptions.ExcessiveInputLengthException;
import logic.exceptions.UsernameAlreadyExistsException;
import logic.gui.SignUpScene;
import logic.gui.popup.ErrorPopup;
import logic.gui.popup.InfoPopup;

public class SignUpController {

	private SignUpScene signUpScene;
	private AccountDAO userDAO = AccountDAO.getInstance();

	public boolean signUp() {
		SignUpBean signUpBean = new SignUpBean();

		// check if user's inputs are correct, if so, proceed with the sign-up
		try {
			if (signUpBean.getPassword().equals(signUpBean.getConfirmPassword())) {

				// if password fields are same, proceed creating a temporary user object and
				// check information consistency
				User user = new User(signUpBean.getName(), signUpBean.getSurname(), signUpBean.getUsername(),
						signUpBean.getEmail(), signUpBean.getPassword());
				user.setPhoneNumber(signUpBean.getPhoneNumber());

				if (signUpBean.checkInfo(user)) {
					// if date doesn't throwed any ParseException, it means that user inserted a
					// valid date, so we can finally sign-up the new user
					user.setBirthDate(signUpBean.getYear() + "-" + signUpBean.getMonth() + "-" + signUpBean.getDay());
					userDAO.registerUser(user);

					// return to log-in page
					loadLogIn();
				} else // if user's inputs are wrong, signUp will not proceed
					return false;
			} else // passwords don't match
				return false;
		} catch (SQLException | ParseException e) {
			signUpScene = SignUpScene.getInstance();
			new ErrorPopup(e.getMessage(), (Stage) signUpScene.getScene().getWindow());
			return false;
		} catch (EmptyFieldException | UsernameAlreadyExistsException | ExcessiveInputLengthException e) {
			signUpScene = SignUpScene.getInstance();
			new InfoPopup(e.getMessage(), (Stage) signUpScene.getScene().getWindow());
		}
		return true;
	}

	private void loadLogIn() {
		signUpScene = SignUpScene.getInstance();
		GUIController gui = GUIController.getInstance();

		gui.setLogInScene((Stage) signUpScene.getScene().getWindow());
	}
}
