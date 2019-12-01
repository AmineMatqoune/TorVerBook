package logic.account;

import java.util.ArrayList;
import java.util.List;

import logic.Message;
import logic.Review;
import logic.ad.Ad;

public final class User extends Account{
	
	//User's account info
	private int numAds;
	private int rank;
	
	private List<Ad> listOfAd;
	List<Message> listOfMessage = null;
	List<User> listOfRelatedUser = null;
	List<Review> listOfReview = null;
	
	public User(String name, String surname, String address, int age, String username, String email, String pwdHash) {
		super(name, surname, address, age, username, email, pwdHash);
		loadOwnAds();
		loadOwnReviews();
		loadRelatedUsers();
	}
	
	//methods for init User object
	
	private void loadOwnReviews() {}
	
	private void loadRelatedUsers() {}
	
	private void loadOwnAds() {}
	
	//methods for user's actions
	
	public void writeReview(User dest, String mex, byte rank) {}
	
	public void addAd(Ad ad) {}
	
	public void addToFavoriteList(Ad ad) {}
	
	private void addRelatedUser(User u) {
		if(listOfRelatedUser == null) {
			listOfRelatedUser = new ArrayList<>();
		}
		
		listOfRelatedUser.add(u);
	}
	
	public void deleteAd(Ad ad) {}
	
	public void markAsSold(Ad ad) {}
	
	public void sendMessage(String mex, User dest) {
		Message m = new Message(mex, dest);
		m.send();
		this.addRelatedUser(dest);
	}
}
