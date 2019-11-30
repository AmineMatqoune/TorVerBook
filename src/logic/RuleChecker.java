package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public final class RuleChecker extends Account{
	
	private List<Ad> listAd = null;
	private List<Review> listReview = null;
	
	//Rule Checker's info
	private int salary;
	private Date workStartTime;
	private Date finishStartTime;
	private int numConvalidatedAds;
	
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
