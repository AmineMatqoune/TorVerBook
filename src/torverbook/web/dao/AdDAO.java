package torverbook.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import torverbook.web.account.Account;
import torverbook.web.account.User;
import torverbook.web.ad.Ad;
import torverbook.web.bean.AddAdBean;
import torverbook.web.db.DBManager;

public class AdDAO {

	private static AdDAO instance = null;
	private DBManager dbManager;

	private AdDAO() {
		dbManager = DBManager.getInstance();
	}

	public List<Ad> loadMyAds(Account account) throws SQLException, ParseException {
		ResultSet result = dbManager.getMyAds(account.getUsername());
		List<Ad> tmp = fetchAd(result);
		for (int i = 0; i < tmp.size(); i++)
			tmp.get(i).setAccount(account);
		return tmp;
	}

	public List<Ad> loadSearchAd(String category, String type, double price) throws ParseException, SQLException {
		ResultSet result = dbManager.getSearchAds(category, type, price);
		return fetchAd(result);
	}

	public List<Ad> loadRCAd() throws SQLException, ParseException {
		ResultSet result = dbManager.getRCAd();
		return fetchAd(result);
	}

	public List<Ad> getHomepageAdsList() throws SQLException, ParseException {
		ResultSet result = dbManager.getHomepageAds();
		return fetchAd(result);
	}

	public boolean checkIsFavouriteAd(long adId, String currentUsername) throws SQLException {
		return dbManager.checkIsFavouriteAd(adId, currentUsername).first();
	}

	public List<Ad> loadFavouriteAds(String ownerUsername) throws SQLException, ParseException {
		ResultSet result = dbManager.getFavouriteAds(ownerUsername);
		return fetchAd(result);
	}

	private List<Ad> fetchAd(ResultSet result) throws ParseException, SQLException {
		List<Ad> myAds = new ArrayList<>();
		// creating list of Ads
		while (result.next()) {
			Ad ad = new Ad(result.getString("User"), result.getInt("ID"));
			ad.setDate(result.getString("Date"));
			ad.setDescription(result.getString("Description"));
			ad.setTitle(result.getString("Title"));
			ad.setPrice(result.getInt("Price"));
			ad.setCategory(result.getString("Course"));
			ad.setType(result.getString("Type"));
			ad.setStatus(result.getInt("isSold"));
			ad.setQuantity(result.getInt("Quantity"));
			myAds.add(ad);
		}
		return myAds;
	}

	public boolean createNewAd(Account account, AddAdBean addAdBean) throws SQLException, ParseException {
		User user = (User) account;
		Ad ad = new Ad(user.getUsername(), 0);
		ad.setDate(LocalDate.now().toString());
		ad.setDescription(addAdBean.getDescription());
		ad.setTitle(addAdBean.getTitle());
		ad.setPrice(addAdBean.getPrice());
		ad.setCategory(addAdBean.getCourse());
		ad.setType(addAdBean.getType());
		ad.setQuantity(addAdBean.getQuantity());
		ad.setStartHighlight(addAdBean.getStartHighlightToString());
		ad.setFinishHighlight(addAdBean.getEndHighlightToString());
		ad.setHighlight(addAdBean.getHighlight());
		return dbManager.addAd(ad);
	}

	public boolean addAdToFavouriteList(long id) throws SQLException {
		return dbManager.addAdToFavouriteList(id, AccountDAO.getInstance().getAccountObject().getUsername());
	}

	public boolean removeAdFromFavouriteList(long id) throws SQLException {
		return dbManager.removeAdFromFavouriteList(id, AccountDAO.getInstance().getAccountObject().getUsername());
	}

	public boolean validateAd(long id) throws SQLException {
		return dbManager.updateAdState(id);
	}

	public boolean deleteAd(long id) throws SQLException {
		return dbManager.deleteAd(id);
	}

	public boolean markAsSold(long id) throws SQLException {
		return dbManager.markAsSold(id);
	}

	public static AdDAO getInstance() {
		if (instance == null)
			instance = new AdDAO();
		return instance;
	}
}
