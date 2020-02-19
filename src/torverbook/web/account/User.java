package torverbook.web.account;

import java.util.Calendar;
import java.util.Date;

public final class User extends Account {

	private static final long serialVersionUID = -659562787377003669L;

	// User's account info
	private boolean isBanned = false;
	private int numViolations;
	private int money;


	public User(String name, String surname, String username, String email, String password) {
		super(name, surname, username, email, password);
	}


	@Override
	public void setBirthDate(String date) { // yyyy-mm-dd format
		birthDateString = date;
	}

	@Override
	public void setBirthDate(Date date) {
		birthDate = date;

		Calendar cal = Calendar.getInstance(); // Some methods of the class Date are deprecated, that's why we use
												// Calendar type
		cal.setTime(date);
		birthDateString = String.valueOf(
				cal.get(Calendar.YEAR) + "-" + (1 + cal.get(Calendar.MONTH)) + "-" + cal.get(Calendar.DAY_OF_MONTH));
	}

	@Override
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setStatus(int isBanned) {
		if (isBanned == 1)
			this.isBanned = true;
		else
			this.isBanned = false;
	}

	public boolean isBanned() {
		return this.isBanned;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void setNumViolations(int numViolations) {
		this.numViolations = numViolations;
	}

	public int getNumViolations() {
		return this.numViolations;
	}

	public int getMoney() {
		return money;
	}

	@Override
	public String getBirthDateString() {
		return birthDateString;
	}
}
