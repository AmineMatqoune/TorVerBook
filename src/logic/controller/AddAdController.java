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

	public boolean addAd() {
		
		AddAdBean adBean = new AddAdBean();
		try {
			if(!adBean.check())
				return false;
			
			AdDAO adDAO = AdDAO.getInstance();
			return adDAO.createNewAd();
		} catch (SQLException | ParseException e) {
			new ErrorPopup(e.getMessage(), (Stage) AddAdScene.getInstance().getScene().getWindow());
		}
		return false;
	}
	
	public LocalDate getTodayDate() {
		return LocalDate.now();
	}
}
