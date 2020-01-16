package logic.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logic.ad.Ad;
import logic.stuff.Message;
import logic.stuff.Review;

public final class User extends Account{
	
	//User's account info
	private int rank;
	private boolean isBanned;
	private int numOfViolations;
	private int money;
	
	private String birthDateString;
	
	private List<Ad> ownAd;
	List<Message> listMessage = null;
	List<User> relatedUser = null;
	List<Review> ownReview = null;
	
	//L'utente dev'essere Singleton
	public User(String name, String surname, String username, String email, String password) {
		super(name, surname, username, email, password);
		loadOwnAds();
		loadOwnReviews();
		loadRelatedUsers();
	}
	
	//methods for initialize User object
	
	private void loadOwnReviews() {}
	
	private void loadRelatedUsers() {}
	
	private void loadOwnAds() {}
	
	//methods for user's actions
	
	public void writeReview(User dest, String mex, byte rank) {}
	
	public void addAd(Ad ad) {}
	
	public void removeAd(Ad ad){}
	
	public void saveInFavoriteList(Ad ad) {}
	
	private void addRelatedUser(User u) {
		if(relatedUser == null) {
			relatedUser = new ArrayList<>();
		}
		
		relatedUser.add(u);
	}
	
	public void changeProfileSettings(String name, String surname, String address, int age, String username, String email, String pwdHash){
	}
	
	public void deleteAd(Ad ad) {}
	
	public void markAsSold(Ad ad) {}
	
	public void sendMessage(Message mex) {
	}
	
	public void sendEmail(){}
	
	public void setBirthDate(String date) {
		//yyyy-mm-dd format
		birthDateString = date;
	}
	
	public void setBirthDate(Date date) {
		birthDate = date;
		birthDateString = (date.getYear() + 1900) + "-" + (date.getMonth() + 1) + "-" + date.getDay();
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getBirthDateString() {
		return this.birthDateString;
	}
}
