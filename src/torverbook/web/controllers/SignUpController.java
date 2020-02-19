package torverbook.web.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import torverbook.web.account.User;
import torverbook.web.constants.RequestAttributes;
import torverbook.web.dao.AccountDAO;

public class SignUpController extends HttpServlet {

	private static final long serialVersionUID = 6496253699314593055L;
	private static final String ROOT_URL = "/";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/sign-up.jsp").forward(req, resp);
		} catch (ServletException | IOException ex) {
			Logger.getLogger(this.getClass().getSimpleName()).severe(ex.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String firstName = req.getParameter("first-name");
			String lastName = req.getParameter("last-name");
			String email = req.getParameter("email");
			String birthDate = req.getParameter("birth-date");
			String phoneNumber = req.getParameter("phone-number");

			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String passwordConfirm = req.getParameter("password-confirm");
			User user = new User(firstName, lastName, username, email, password);
			user.setBirthDate(birthDate);
			user.setPhoneNumber(phoneNumber);

			if (passwordConfirm.contentEquals(password) && user.isValid()) {
				AccountDAO.getInstance().registerUser(user);
				resp.sendRedirect(ROOT_URL + "login");
			} else {
				req.setAttribute(RequestAttributes.ERROR_MESSAGE_ATTRIBUTE_NAME, "Please insert valid data!");
				req.getRequestDispatcher("/sign-up.jsp").forward(req, resp);
			}

		} catch (IOException | SQLException | ServletException ex) {
			Logger.getLogger(this.getClass().getSimpleName()).severe(ex.getMessage());
		}
	}

}
