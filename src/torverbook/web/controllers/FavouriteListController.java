package torverbook.web.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import torverbook.web.ad.Ad;
import torverbook.web.constants.RequestAttributes;
import torverbook.web.dao.AdDAO;

public class FavouriteListController extends AuthenticatedController {

	private static final long serialVersionUID = -4203738735443040247L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			super.doGet(req, resp);
			if (authenticatedUser) {
				String username = (String) req.getSession().getAttribute(RequestAttributes.USERNAME_ATTRIBUTE_NAME);
				List<Ad> ads = AdDAO.getInstance().loadFavouriteAds(username);
				if (!ads.isEmpty()) {
					req.setAttribute(RequestAttributes.ADS_LIST_ATTRIBUTE_NAME, ads);
				}
				req.getRequestDispatcher("/favourite-list.jsp").forward(req, resp);
			}
		} catch (ServletException | IOException | SQLException | ParseException ex) {
			Logger.getLogger(this.getClass().getSimpleName()).severe(ex.getMessage());
		}
	}

}
