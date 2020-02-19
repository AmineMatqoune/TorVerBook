package torverbook.web.account;

import java.time.LocalDate;

public final class RuleChecker extends Account {

	private static final long serialVersionUID = -8295309304224914053L;


	// Rule Checker's info
	private int salary;
	private LocalDate workStartTime;
	private LocalDate workFinishTime;
	private int numConvalidatedAds;

	// methods for RuleChecker's actions

	public RuleChecker(String name, String surname, String username, String email, String pwdHash) {
		super(name, surname, username, email, pwdHash);
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
