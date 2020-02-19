package torverbook.web.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import torverbook.web.account.Account;
import torverbook.web.constants.RequestAttributes;
import torverbook.web.constants.UrlRoutes;
import torverbook.web.dao.AccountDAO;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1338475680890203166L;
	private static AccountDAO accountDao = AccountDAO.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Object authenticated = req.getSession().getAttribute(RequestAttributes.AUTHENTICATED_ATTRIBUTE_NAME);
			boolean parsedToBooleanAuthenticated = authenticated == null ? Boolean.FALSE : (boolean) authenticated;
			if (parsedToBooleanAuthenticated) {
				resp.sendRedirect(UrlRoutes.DASHBOARD_FULL_URL);
				return;
			}

			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		} catch (ServletException | IOException ex) {
			Logger.getLogger(this.getClass().getSimpleName()).severe(ex.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter(RequestAttributes.USERNAME_ATTRIBUTE_NAME);
		String password = req.getParameter(RequestAttributes.PW_ATTRIBUTE_NAME);

		if (username.isEmpty() || password.isEmpty()) {
			req.setAttribute("errorMessage", "Please insert username and password");
			doGet(req, resp);
			return;
		}

		try {
			Account account = accountDao.logIn(username, password);
			if (account != null) {
				req.getSession().setAttribute(RequestAttributes.AUTHENTICATED_ATTRIBUTE_NAME, true);
				req.getSession().setAttribute(RequestAttributes.ACCOUNT_ATTRIBUTE_NAME, account);
				resp.sendRedirect(UrlRoutes.DASHBOARD_FULL_URL);
			} else {
				req.setAttribute("errorMessage", "Wrong Credentials");
				doGet(req, resp);
			}
		} catch (IOException | SQLException ex) {
			Logger.getLogger(this.getClass().getSimpleName()).severe(ex.getMessage());
		}
	}
}
