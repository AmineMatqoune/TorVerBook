package logic.bean;

import java.text.SimpleDateFormat;

public class SignInBean {
	
	public boolean checkInfo(String name, String surname, String dd, String mm, String yyyy, String phoneNumber, String username, String email, String pwd, String pwd2) {
		
		if((name.length() > 15) || name.equals(""))
			return false;
		if((surname.length() > 15) || surname.equals(""))
			return false;
		if(dd.equals("") || mm.equals("") || yyyy.equals(""))
			return false;
		if((phoneNumber.length() > 10) || phoneNumber.equals(""))
			return false;
		if((username.length() > 20) || username.equals(""))
			return false;
		if((email.length() > 30) || username.equals(""))
			return false;
		if((pwd.length() > 30) || pwd.equals(""))
			return false;
		if((pwd2.length() > 30) || pwd2.equals(""))
			return false;
		if(!pwd.equals(pwd2))
			return false;
		
		try {
			SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
			date.setLenient(false);
			date.parse(String.valueOf(mm) + "/" + String.valueOf(dd) + "/" + String.valueOf(yyyy));
		} catch (java.text.ParseException e) {
			return false;
		}
		
		//no syntax errors found, return true
		return true;
	}
}
