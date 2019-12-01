package logic.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logic.Review;
import logic.ad.Ad;


public final class RuleChecker extends Account{
	
	private List<Ad> listAd = null;
	private List<Review> listReview = null;
	
	//Rule Checker's info
	private int salary;
	private Date workStartTime;
	private Date finishStartTime;
	private int numConvalidatedAds;
	
	//methods for RuleChecker's actions
	
	public RuleChecker(String name, String surname, String address, int age, String username, String email, String pwdHash) {
		super(name, surname, address, age, username, email, pwdHash);
		loadOwnInfo();
		loadAds();
	}
	
	public void loadAds() {
		if(listAd == null)
			listAd = new ArrayList<>();
		//...
	}
	
	public void loadReviews() {
		if(listReview == null)
			listReview = new ArrayList<>();
	}

	public void loadOwnInfo() {
	}
	
	public void convalidateAd(Ad ad) {
	}
	
	public void banAd(Ad ad) {
	}
	
	public void banUser(User u) {
	}
	
}
