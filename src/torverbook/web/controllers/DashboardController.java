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
import torverbook.web.ad.AdCategory;
import torverbook.web.constants.RequestAttributes;
import torverbook.web.dao.AdDAO;

public class DashboardController extends AuthenticatedController {

	private static final long serialVersionUID = -8866040628982966855L;
	private static AdDAO adDao = AdDAO.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			super.doGet(req, resp);
			if (authenticatedUser) {
				Object adTypeParam = req.getParameter(RequestAttributes.FILTER_TYPE_ATTRIBUTE_NAME);
				Object adCategoryParam = req.getParameter(RequestAttributes.FILTER_CATEGORY_ATTRIBUTE_NAME);
				Object adPriceParam = req.getParameter(RequestAttributes.FILTER_PRICE_ATTRIBUTE_NAME);
				List<Ad> ads;

				if (adTypeParam != null && adCategoryParam != null && adPriceParam != null) {
					String adTypeFilter = (String) adTypeParam;
					String adCategoryFilter = (String) adCategoryParam;
					double adPriceFilter = Double.parseDouble((String) adPriceParam);

					if (adCategoryFilter.contentEquals(AdCategory.ANY.toString())) {
						ads = adDao.getHomepageAdsList();
					} else {
						ads = adDao.loadSearchAd(adCategoryFilter, adTypeFilter, adPriceFilter);
					}

				} else {
					ads = adDao.getHomepageAdsList();
				}

				if (ads != null && !ads.isEmpty()) {
					req.setAttribute(RequestAttributes.ADS_LIST_ATTRIBUTE_NAME, ads);
				}

				req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);
			}
		} catch (ServletException | IOException | SQLException | ParseException ex) {
			Logger.getLogger(this.getClass().getSimpleName()).severe(ex.getMessage());
		}
	}

}