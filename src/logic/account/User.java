package logic.account;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import logic.ad.Ad;
import logic.dao.AdDAO;
import logic.dao.ReviewDAO;
import logic.stuff.Message;
import logic.stuff.Review;

public final class User extends Account{
	
	//User's account info
	private boolean isBanned;
	private int numViolations;
	private int money;
	
	private ReviewDAO reviewDao;
	private AdDAO adDao;	
	
	private Ad[] myAdList = null;
	private Ad[] favouriteAds = null;
	private Message[] myMessageList = null;
	private User[] relatedUser = null;
	private Review[] ownReview = null;
	
	public User(String name, String surname, String username, String email, String password) throws ClassNotFoundException, SQLException, ParseException {
		super(name, surname, username, email, password);
		loadOwnAds();
		loadOwnReview();
	}
	
	//methods for initialize User object
	
	private void loadRelatedUsers() {}
	
	private void loadOwnAds() throws ClassNotFoundException, SQLException, ParseException {
		adDao = AdDAO.getInstance();
		myAdList = adDao.loadMyAds(this);
		favouriteAds =adDao.loadFavouriteAds(username);
	}
	
	private void loadOwnReview() throws ClassNotFoundException, SQLException, ParseException  {
		reviewDao = ReviewDAO.getInstance();
		ownReview = reviewDao.loadMyReview(this);
	}
	
	public int getNumOfAds() {
		return myAdList.length;
	}
	
	public Ad[] getMyAds() {
		return myAdList;
	}
	
	public Ad[] getFavouriteList() {
		return favouriteAds;
	}
	
	public Review[] getMyReviews() {
		return ownReview;
	}
	
	public void writeReview(User dest, String mex, byte rank) {}
	
	public void addAd(Ad ad) {}
	
	public void removeAd(Ad ad){}
	
	public void saveInFavoriteList(Ad ad) {}
	
	private void addRelatedUser(User u) {
		if(relatedUser == null) {
			//relatedUser = new ArrayList<>();
		}
		
		//relatedUser.add(u);
	}
	
	public void deleteAd(long id) {
		for (int i = 0; i < myAdList.length; i++) {
			if(myAdList[i].getId() == id)
				myAdList[i] = null;
		}
		
		redefineAdList(myAdList.length - 1);
	}
	
	//quando facciamo modifiche su un Ad, dobbiamo aggiornare i relativi oggetti
	private void redefineAdList(int length) {
		Ad[] newAdList = new Ad[length];
		for(int i = 0; i < length; i++)
			if(myAdList[i] != null) 
				newAdList[i] = myAdList[i];
		
		myAdList = newAdList;
	}
	
	public void markAsSold(long id) {
		//se la qunatità disponibile equivale a 1, elimina, altrimenti decrementa di 1 la quantità
		for(int i = 0; i < myAdList.length; i++)
			if(myAdList[i].getId() == id) {
				if(myAdList[i].getQuantity() == 1) { 
					deleteAd(id);
				}
				else {
					myAdList[i].setQuantity(myAdList[i].getQuantity() - 1);
				}
			}
	}
	
	public void sendMessage(Message mex) {
	}
	
	@Override
	public void setBirthDate(String date) { //yyyy-mm-dd format
		birthDateString = date;
	}
	
	@Override
	public void setBirthDate(Date date) {
		birthDate = date;
		
		Calendar cal = Calendar.getInstance(); //Some methods of the class Date are deprecated, that's why we use Calendar type
		cal.setTime(date);
		
		birthDateString = ( String.valueOf(cal.get(Calendar.YEAR)) + "-" +  String.valueOf(1 + cal.get(Calendar.MONTH)) + "-" + String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
	}
	
	@Override
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void setNumViolations(int numViolations) {
		this.numViolations = numViolations;
	}
	
	@Override
	public String getBirthDateString() {
		return birthDateString;
	}
}
