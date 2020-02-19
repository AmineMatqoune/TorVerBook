package logic.controller;

import java.sql.SQLException;
import java.text.ParseException;
import javafx.stage.Stage;
import logic.dao.AccountDAO;
import logic.gui.Homepage;
import logic.gui.LogInScene;
import logic.gui.popup.ErrorPopup;
import logic.gui.popup.InfoPopup;

public class LogInController {

	private GUIController guiController = GUIController.getInstance();
	private AccountDAO accountDao = AccountDAO.getInstance();

	public boolean checkLogin(String username, String password) {
		try {
			// if log-in is successful, create user object and load homepage
			if (accountDao.logIn(username, password)) {
				return true;
			} else {
				if(accountDao.getErrorMessage().equals("USER_BANNED"))
					new InfoPopup("Account bannato!", (Stage) LogInScene.getInstance().getScene().getWindow());
				// Notify log-in error
				return false;
			}
		} catch (SQLException | ParseException e) {
			new ErrorPopup(e.getMessage(), (Stage) LogInScene.getInstance().getScene().getWindow());
		}
		return false;
	}

	public void loadSignUp() {
		guiController.setSignUpScene((Stage) LogInScene.getInstance().getScene().getWindow());
	}

	/* metodo per caricare l'homepage per lo user/ruleChecker
	*  applicazione del GoF Factory Method, più precisamente:
	*  il vero oggetto homepage da instanziare si sa solo a runtime, 
	*  in base al risultato si sa se si è loggato un utente o un rulechecker;
	*  in entrambi i casi, è necessario presentare un messaggio di benvenuto.
	*/
	public void loadHomepage() {
		Homepage home = guiController.loadNextHomepage(accountDao.getAccountType(), (Stage) LogInScene.getInstance().getScene().getWindow());
		home.salut();
	}
}
