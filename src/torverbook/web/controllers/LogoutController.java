package torverbook.web.controllers;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import torverbook.web.constants.RequestAttributes;
import torverbook.web.constants.UrlRoutes;

public class LogoutController extends AuthenticatedController {

	private static final long serialVersionUID = 7297019851798320933L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			super.doGet(req, resp);
			if (authenticatedUser) {
				req.getSession().removeAttribute(RequestAttributes.ACCOUNT_ATTRIBUTE_NAME);
				req.getSession().removeAttribute(RequestAttributes.USERNAME_ATTRIBUTE_NAME);
				req.getSession().removeAttribute(RequestAttributes.AUTHENTICATED_ATTRIBUTE_NAME);
			}
			resp.sendRedirect(UrlRoutes.LOGIN_FULL_URL);
		} catch (ServletException | IOException ex) {
			Logger.getLogger(this.getClass().getSimpleName()).severe(ex.getMessage());
		}
	}

}
