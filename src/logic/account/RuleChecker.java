package logic.account;

import java.time.LocalDate;
import java.util.List;

import logic.ad.Ad;
import logic.review.Review;

public final class RuleChecker extends Account {

	private List<Ad> listAd = null;
	private List<Review> listReview = null;

	// Rule Checker's info
	private int salary;
	private LocalDate workStartTime;
	private LocalDate workFinishTime;
	private int numConvalidatedAds;

	// methods for RuleChecker's actions

	public RuleChecker(String name, String surname, String username, String email, String pwdHash) {
		super(name, surname, username, email, pwdHash);
		loadOwnInfo();
	}

	public void loadOwnInfo() {

	}

	public void convalidateAd(Ad ad) {

	}

	public void banAd(Ad ad) {

	}

	public void banUser(User u) {
		
	}

	public List<Ad> getListAd() {
		return listAd;
	}

	public void setListAd(List<Ad> listAd) {
		this.listAd = listAd;
	}

	public List<Review> getListReview() {
		return listReview;
	}

	public void setListReview(List<Review> listReview) {
		this.listReview = listReview;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public LocalDate getWorkStartTime() {
		return workStartTime;
	}

	public void setWorkStartTime(LocalDate workStartTime) {
		this.workStartTime = workStartTime;
	}

	public LocalDate getFinishStartTime() {
		return workFinishTime;
	}

	public void setworkFinishTime(LocalDate workFinishTime) {
		this.workFinishTime = workFinishTime;
	}

	public int getNumConvalidatedAds() {
		return numConvalidatedAds;
	}

	public void setNumConvalidatedAds(int numConvalidatedAds) {
		this.numConvalidatedAds = numConvalidatedAds;
	}
}
