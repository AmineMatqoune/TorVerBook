package logic.controller;

import java.sql.SQLException;
import java.text.ParseException;

import javafx.stage.Stage;
import logic.account.Account;
import logic.account.AccountType;
import logic.account.RuleChecker;
import logic.account.User;
import logic.bean.SettingsBean;
import logic.dao.AccountDAO;
import logic.gui.SettingScene;
import logic.gui.popup.ErrorPopup;

public class SettingController {

	private AccountDAO accountDao = AccountDAO.getInstance();

	public boolean applyChanges() {
		SettingsBean settingsBean = SettingScene.getInstance().getSettingsBean();
		
		try {
			// controllo dei dati
			Account tempAccount;
			if (accountDao.getAccountType() == AccountType.RULE_CHECKER) {
				tempAccount = new RuleChecker(settingsBean.getAccountName(), settingsBean.getAccountSurname(),
						settingsBean.getAccountUsername(), settingsBean.getAccountEmail(),
						settingsBean.getAccountPassword());
			} 
			else {
				tempAccount = new User(settingsBean.getAccountName(), settingsBean.getAccountSurname(),
						settingsBean.getAccountUsername(), settingsBean.getAccountEmail(),
						settingsBean.getAccountPassword());
			}
			tempAccount.setBirthDate(settingsBean.getAccountBirthdate());
			tempAccount.setPhoneNumber(settingsBean.getAccountPhoneNumber());
			
			if (!settingsBean.checkInfo(tempAccount))
				return false;

			// aggiorno database
			accountDao.updateAccountInfo(tempAccount);
		} catch (SQLException | ParseException e) {
			new ErrorPopup(e.getMessage(), (Stage) SettingScene.getInstance().getScene().getWindow());
		}
		return true;
	}
}
