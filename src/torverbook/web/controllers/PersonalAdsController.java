package torverbook.web.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import torverbook.web.account.Account;
import torverbook.web.ad.Ad;
import torverbook.web.constants.RequestAttributes;
import torverbook.web.dao.AdDAO;

public class PersonalAdsController extends AuthenticatedController {

	private static final long serialVersionUID = -7502812230747771542L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			super.doGet(req, resp);
			if (authenticatedUser) {
				Account account = (Account) req.getSession().getAttribute(RequestAttributes.ACCOUNT_ATTRIBUTE_NAME);
				List<Ad> ads = AdDAO.getInstance().loadMyAds(account);
				if (ads != null && !ads.isEmpty()) {
					req.setAttribute("ads-list", ads);
				}
				req.getRequestDispatcher("/personal-ads.jsp").forward(req, resp);
			}
		} catch (ServletException | IOException | SQLException | ParseException ex) {
			Logger.getLogger(this.getClass().getSimpleName()).severe(ex.getMessage());
		}	}
	
}
