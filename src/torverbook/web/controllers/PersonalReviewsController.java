package torverbook.web.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import torverbook.web.account.User;
import torverbook.web.constants.RequestAttributes;
import torverbook.web.dao.ReviewDAO;
import torverbook.web.review.Review;

public class PersonalReviewsController extends AuthenticatedController {

	private static final long serialVersionUID = 565120048959767406L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			super.doGet(req, resp);
			if (authenticatedUser) {
				User account = (User) req.getSession().getAttribute(RequestAttributes.ACCOUNT_ATTRIBUTE_NAME);
				Review[] reviews = ReviewDAO.getInstance().loadMyReview(account);
				req.setAttribute("reviews", reviews);
				req.getRequestDispatcher("/personal-reviews.jsp").forward(req, resp);
			}
		} catch (ServletException | IOException | SQLException | ParseException ex) {
			Logger.getLogger(this.getClass().getSimpleName()).severe(ex.getMessage());
		}
	}

}
