package logic.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;

import org.eclipse.jdt.core.compiler.InvalidInputException;

import javafx.stage.Stage;

import logic.bean.AddAdBean;
import logic.dao.AdDAO;
import logic.exceptions.EmptyFieldException;
import logic.exceptions.ExcessiveInputLengthException;
import logic.exceptions.InsufficientFundsException;
import logic.exceptions.InvalidInputValueException;
import logic.gui.AddAdScene;
import logic.gui.LogInScene;
import logic.gui.popup.ErrorPopup;
import logic.gui.popup.InfoPopup;

public class AddAdController {

	public int addAd() { // return 0 if syntax control fails, 1 if user haven't enough money, 2 if all is
							// okay, 3 fatal error (SQL or Parse) Exception

		AddAdBean adBean = new AddAdBean();
		try {
			if (!adBean.check()) {
				throw new InvalidInputException();
			}

			AdDAO adDAO = AdDAO.getInstance();
			if (!adDAO.createNewAd())
				return 1;
		} catch (SQLException | ParseException e) {
			new ErrorPopup(e.getMessage(), (Stage) AddAdScene.getInstance().getScene().getWindow());
			return 3;
		}catch(InvalidInputValueException | EmptyFieldException
				| ExcessiveInputLengthException | InvalidInputException | InsufficientFundsException e) {
			new InfoPopup(e.getMessage(), (Stage) LogInScene.getInstance().getScene().getWindow());
		}
		return 2;
	}

	public LocalDate getTodayDate() {
		return LocalDate.now();
	}
}
