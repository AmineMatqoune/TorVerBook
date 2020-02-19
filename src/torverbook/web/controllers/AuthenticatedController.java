package torverbook.web.controllers;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import torverbook.web.constants.RequestAttributes;
import torverbook.web.constants.UrlRoutes;

public abstract class AuthenticatedController extends HttpServlet {

	private static final long serialVersionUID = 5581862144136872629L;
	protected static boolean authenticatedUser = false;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Object authenticated = req.getSession().getAttribute(RequestAttributes.AUTHENTICATED_ATTRIBUTE_NAME);
			boolean parsedToBooleanAuthenticated = authenticated == null ? Boolean.FALSE : (boolean) authenticated;
			if (!parsedToBooleanAuthenticated) {
				resp.sendRedirect(UrlRoutes.LOGIN_FULL_URL);
				setAuthenticatedFlag(false);
			}else {
				setAuthenticatedFlag(true);
			}
		} catch (IOException ex) {
			Logger.getLogger("Authenticated-Controller").severe(ex.getMessage());
		}
	}
	
	private static final void setAuthenticatedFlag(boolean authenticated) {
		authenticatedUser = authenticated;
	}
}
