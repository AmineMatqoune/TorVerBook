package torverbook.web.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import torverbook.web.account.Account;
import torverbook.web.account.User;
import torverbook.web.constants.RequestAttributes;
import torverbook.web.dao.AccountDAO;

public class SettingsController extends AuthenticatedController {

	private static final long serialVersionUID = 1824973637829886223L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			super.doGet(req, resp);
			if (authenticatedUser) {
				req.getRequestDispatcher("/settings.jsp").forward(req, resp);
			}
		} catch (ServletException | IOException ex) {
			Logger.getLogger(this.getClass().getSimpleName()).severe(ex.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			if (authenticatedUser) {
				Account originalAccount = (Account) req.getSession()
						.getAttribute(RequestAttributes.ACCOUNT_ATTRIBUTE_NAME);
				String originalUsername = originalAccount.getUsername();
				Account modifiedAccount = mapRequestParamToAccountObj(req);

				if (modifiedAccount.isValid()) {
					boolean updated = AccountDAO.getInstance().updateAccountInfo(originalUsername, modifiedAccount);
					if (updated) {
						req.getSession().setAttribute(RequestAttributes.ACCOUNT_ATTRIBUTE_NAME, modifiedAccount);
					}

				} else {
					req.setAttribute(RequestAttributes.ERROR_MESSAGE_ATTRIBUTE_NAME, "Please insert valid data!");
				}
			}
			req.getRequestDispatcher("/settings.jsp").forward(req, resp);
		} catch (ServletException | IOException | SQLException ex) {
			Logger.getLogger(this.getClass().getSimpleName()).severe(ex.getMessage());
		}
	}

	private Account mapRequestParamToAccountObj(HttpServletRequest req) {
		String username = req.getParameter(RequestAttributes.USERNAME_ATTRIBUTE_NAME);
		String password = req.getParameter(RequestAttributes.PW_ATTRIBUTE_NAME);
		String firstName = req.getParameter(RequestAttributes.FIRSTNAME_ATTRIBUTE_NAME);
		String lastName = req.getParameter(RequestAttributes.LASTNAME_ATTRIBUTE_NAME);
		String birthdate = req.getParameter(RequestAttributes.BIRTHDATE_ATTRIBUTE_NAME);
		String email = req.getParameter(RequestAttributes.EMAIL_ATTRIBUTE_NAME);
		String phoneNumber = req.getParameter(RequestAttributes.PHONENUMBER_ATTRIBUTE_NAME);

		Account account = new User(firstName, lastName, username, email, password);
		account.setBirthDate(birthdate);
		account.setPhoneNumber(phoneNumber);

		return account;
	}

}
