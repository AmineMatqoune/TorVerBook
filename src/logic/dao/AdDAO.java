package logic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import logic.account.User;
import logic.ad.Ad;
import logic.bean.AdBean;
import logic.bean.AddAdBean;
import logic.db.DBManager;
import logic.highlight.Highlight;

public class AdDAO {

	private static AdDAO instance = null;
	private DBManager dbManager;
	private HighlightDAO highlightDao;
	
	private int count = 0;
	
	private AdDAO() throws SQLException {
		dbManager = DBManager.getInstance();
		highlightDao = new HighlightDAO();
	}
	
	public Ad[] loadMyAds(User user) throws SQLException, ParseException {
		ResultSet result = dbManager.getMyAds(user.getUsername());
		Ad[] tmp = fetchAd(result);
		
		//bind tra Ad e User 
		if(tmp != null)
			for(int i = 0; i < tmp.length; i++)
				tmp[i].setMyUserObj(user);
		return tmp;
	}
	
	public Ad[] loadSearchAd(String category, String type, double price) throws ParseException, SQLException {
		ResultSet result = dbManager.getSearchAds(category, type, price);
		return fetchAd(result);
	}
	
	
	public Ad[] loadRCAd() throws SQLException, ParseException {
		ResultSet result = dbManager.getRCAd();
		return fetchAd(result);
	}
	
	public Ad[] getHomepageAdsList() throws SQLException, ParseException {
		ResultSet result = dbManager.getHomepageAds();
		return fetchAd(result);		
	}

	public boolean checkIsFavouriteAd(long adId, String currentUsername) throws SQLException {
		return dbManager.checkIsFavouriteAd(adId, currentUsername).first();
	}
	
	public Ad[] loadFavouriteAds(String ownerUsername) throws SQLException, ParseException {
		ResultSet result = dbManager.getFavouriteAds(ownerUsername);	
		return fetchAd(result);
	}
	
	private Ad[] fetchAd(ResultSet result) throws ParseException, SQLException {
		Ad[] myAds = null;
		//creating list of Ads
		if((count = getNumOfRows(result)) > 0) {
			myAds = new Ad[count];
			int i = 0;
			
			while(result.next()) {
				myAds[i] = new Ad(result.getString("User"), result.getInt("ID"));
				myAds[i].setDate(result.getString("Date"));
				myAds[i].setDescription(result.getString("Description"));
				myAds[i].setTitle(result.getString("Title"));
				myAds[i].setPrice(result.getInt("Price"));
				myAds[i].setCategory(result.getString("Course"));
				myAds[i].setType(result.getString("Type"));
				myAds[i].setStatus(result.getInt("isSold"));
				myAds[i].setQuantity(result.getInt("Quantity"));
				myAds[i].setStartHighlight(result.getString("StartHighlight"));
				myAds[i].setFinishHighlight(result.getString("FinishHighlight"));
				
				Highlight highlight = null;			
				//for each Ad, we first create the relative Highlight entity object, and then we get() it
				switch(result.getString("Highlight")) {
				case "SUPER":
					highlightDao.createHighlightObject("SUPER");
					highlight = highlightDao.getHighlightObject();
					break;
				case "MEDIUM":
					highlightDao.createHighlightObject("MEDIUM");
					highlight = highlightDao.getHighlightObject();
					break;
				default:
					highlightDao.createHighlightObject("BASE");
					highlight = highlightDao.getHighlightObject();
				}
					
				myAds[i].setHighlight(highlight);
				i++; 
			}
		}
		return myAds;
	}
	
	private int getNumOfRows(ResultSet result) throws SQLException { //count how many rows do we have
		count = 0;
		result.beforeFirst();
		
		while(result.next())
			count++;
		
		//repositioning of the index at line 0 (before the first row)
		result.beforeFirst();
		return count;
	}
	
	
	public boolean createNewAd() throws SQLException, ParseException {
		AddAdBean addAdBean = new AddAdBean();
		User user = (User) AccountDAO.getInstance().getAccountObject();
		//we create a temporary Ad object (ID = 0), once we added it to bd, we can update his real ID
		Ad ad = new Ad(user.getUsername(), 0);
		ad.setDate(LocalDate.now().toString());
		ad.setDescription(addAdBean.getDescription());
		ad.setTitle(addAdBean.getTitle());
		ad.setPrice(addAdBean.getPrice());
		ad.setCategory(addAdBean.getCourse());
		ad.setType(addAdBean.getType());
		ad.setQuantity(addAdBean.getQuantity());
		ad.setStartHighlight(addAdBean.getStartHighlight());
		ad.setFinishHighlight(addAdBean.getFinishHighlight());
		ad.setHighlight(addAdBean.getHighlight());
		
		if(user.addAd(ad)) {                                   //se l'inserimento nell'oggetto user va a buon fine, ultimiamo aggiungendolo al bd
			dbManager.addAd(ad, user.getMoney());
			return true;
		}
		return false;
	}
	
	public boolean addAdToFavouriteList(AdBean bean) throws SQLException, ParseException {
		if(dbManager.addAdToFavouriteList(bean.getId(), AccountDAO.getInstance().getAccountObject().getUsername())) {
			User user = (User) AccountDAO.getInstance().getAccountObject();
			user.saveInFavoriteList(createAd(bean));
			return true;
		}
		return false;
	}
	
	private Ad createAd(AdBean bean) throws ParseException {
		Ad ad = new Ad(bean.getUsername(), bean.getId());
		ad.setDate(bean.getDate());
		ad.setDescription(bean.getDescription());
		ad.setTitle(bean.getTitle());
		ad.setPrice(bean.getPrice());
		ad.setCategory(bean.getCategory());
		ad.setType(bean.getAdType());
		ad.setQuantity(bean.getQuantity());
		ad.setStartHighlight(bean.getStartHighDate());
		ad.setFinishHighlight(bean.getFinishHighDate());
		ad.setHighlight(bean.getHighlight());
		return ad;
	}
	
	public boolean removeAdFromFavouriteList(AdBean bean) throws  SQLException, ParseException {
		if(dbManager.removeAdFromFavouriteList(bean.getId(), AccountDAO.getInstance().getAccountObject().getUsername())) {
			User user = (User) AccountDAO.getInstance().getAccountObject();
			user.removeFromFavoriteList(createAd(bean));
			return true;
		}
		return false;
	}
	
	public boolean validateAdRC(long id) throws SQLException {
		return dbManager.updateAdState(id);
	}
	
	public boolean deleteAdRC(long id) throws SQLException {
		return dbManager.deleteAd(id);
	}
	
	public boolean deleteAd(long id) throws SQLException {
		User user = (User) AccountDAO.getInstance().getAccountObject();
		user.removeAd(id);
		return dbManager.deleteAd(id);
	}
	
	public boolean markAsSold(long id) throws SQLException {
		User user = (User) AccountDAO.getInstance().getAccountObject();
		if(user.markAsSold(id))
			return dbManager.markAsSold(id);
		else
			return dbManager.deleteAd(id);
	}
	
	public static AdDAO getInstance() throws SQLException {
		if (instance == null)
			instance = new AdDAO();
		return instance;
	}
}
