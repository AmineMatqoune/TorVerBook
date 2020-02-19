package logic.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import javafx.stage.Stage;

import logic.bean.AddAdBean;
import logic.dao.AdDAO;
import logic.gui.AddAdScene;
import logic.gui.popup.ErrorPopup;

public class AddAdController {

	public int addAd() { // return 0 if syntax control fails, 1 if user haven't enough money, 2 if all is
							// okay, 3 fatal error (SQL or Parse) Exception

		AddAdBean adBean = new AddAdBean();
		try {
			if (!adBean.check())
				return 0;

			AdDAO adDAO = AdDAO.getInstance();
			if (!adDAO.createNewAd())
				return 1;
		} catch (SQLException | ParseException e) {
			new ErrorPopup(e.getMessage(), (Stage) AddAdScene.getInstance().getScene().getWindow());
			return 3;
		}
		return 2;
	}

	public LocalDate getTodayDate() {
		return LocalDate.now();
	}
}
