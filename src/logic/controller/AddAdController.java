package logic.controller;

import logic.bean.AddAdBean;

public class AddAdController {
	
	private AddAdBean adBean;

	public boolean addAd() {
		adBean = new AddAdBean();
		// prima di aggiungere l'ad viene fatto un controllo 
		// per vedere la correttezza nei campi
		
		
		return true;
	}
}