package logic.controller;

import java.sql.SQLException;

import logic.bean.AddAdBean;
import logic.dao.AdDAO;

public class AddAdController {
	
	private AddAdBean adBean;

	public boolean addAd() {
		adBean = new AddAdBean();
		
		if(!adBean.check())
			return false;
		
		try {
			AdDAO adDAO = AdDAO.getInstance();
			adDAO.addNewAd();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
}