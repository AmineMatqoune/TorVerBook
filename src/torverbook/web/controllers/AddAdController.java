package torverbook.web.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import torverbook.web.account.Account;
import torverbook.web.bean.AddAdBean;
import torverbook.web.constants.RequestAttributes;
import torverbook.web.dao.AdDAO;

public class AddAdController extends AuthenticatedController {

	private static final long serialVersionUID = -8576925470099521928L;
	private static AdDAO adDao = AdDAO.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			super.doGet(req, resp);
			if (authenticatedUser) {
				req.getRequestDispatcher("/add-ad.jsp").forward(req, resp);
			}
		} catch (ServletException | IOException ex) {
			Logger.getLogger(this.getClass().getSimpleName()).severe(ex.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			if (authenticatedUser) {
				AddAdBean newAd = mapRequestParamToObj(req);
				Account account = (Account) req.getSession().getAttribute(RequestAttributes.ACCOUNT_ATTRIBUTE_NAME);
				if (newAd.isValid()) {
					adDao.createNewAd(account, newAd);
				}else {
					req.setAttribute(RequestAttributes.ERROR_MESSAGE_ATTRIBUTE_NAME, "Please insert valid data!");
				}
			}
			req.getRequestDispatcher("/add-ad.jsp").forward(req, resp);
		} catch (ServletException | IOException | SQLException | ParseException ex) {
			Logger.getLogger(this.getClass().getSimpleName()).severe(ex.getMessage());
		}

	}

	private AddAdBean mapRequestParamToObj(HttpServletRequest req) {
		String title = req.getParameter(RequestAttributes.AD_TITLE_ATTRIBUTE_NAME);
		String description = req.getParameter(RequestAttributes.AD_DESCRITPION_ATTRIBUTE_NAME);
		int price = Integer.parseInt(req.getParameter(RequestAttributes.AD_PRICE_ATTRIBUTE_NAME));
		int quantity = Integer.parseInt(req.getParameter(RequestAttributes.AD_QUANTITY_ATTRIBUTE_NAME));
		String category = req.getParameter(RequestAttributes.AD_CATEGORY_ATTRIBUTE_NAME);
		String type = req.getParameter(RequestAttributes.AD_TYPE_ATTRIBUTE_NAME);
		String highlight = req.getParameter(RequestAttributes.AD_HIGHLIGHT_ATTRIBUTE_NAME);
		String highlightFromDate = req.getParameter(RequestAttributes.AD_HIGHLIGHT_FROM_DATE_ATTRIBUTE_NAME);
		String highlightToDate = req.getParameter(RequestAttributes.AD_HIGHLIGHT_TO_DATE_ATTRIBUTE_NAME);
		AddAdBean newAdBean = new AddAdBean(title, description, price, quantity, category, type);
		newAdBean.setHighlight(highlight);
		newAdBean.setStartHighlight(LocalDate.parse(highlightFromDate));
		newAdBean.setEndHighlightDate(LocalDate.parse(highlightToDate));
		return newAdBean;

	}

}
