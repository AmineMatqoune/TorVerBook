package torverbook.web.controllers;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonalReviewsController extends AuthenticatedController {

	private static final long serialVersionUID = 565120048959767406L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			super.doGet(req, resp);
			if (authenticatedUser) {
				req.getRequestDispatcher("/personal-reviews.jsp").forward(req, resp);
			}
		} catch (ServletException | IOException ex) {
			Logger.getLogger(this.getClass().getSimpleName()).severe(ex.getMessage());
		}
	}

}
