package logic.controller;

import javafx.scene.control.Button;

public class SignInController {
	
	public Button registerBtn;
	public Button btnLanguage;
	
	public void register() {
		checkInfo();
		registerBtn.setText("Ti sei registrato");
	}
	
	public void changeLanguage() { //apply observer GoF
		if(btnLanguage.getText().equals("ITA"))
			btnLanguage.setText("ENG");
		else
			btnLanguage.setText("ITA");
	}
	
	private void checkInfo() {}

}
