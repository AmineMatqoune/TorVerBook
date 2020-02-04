package logic.bean;

import logic.gui.AddAdScene;

public class AddAdBean {

	private AddAdScene addAdScene;
	
	public AddAdBean() {
		addAdScene = AddAdScene.getInstance();
	}
	
	public boolean check() {
		if(addAdScene.getTitle().length() > 100 || addAdScene.getTitle().equals("")) 
			return false;
		if(addAdScene.getDescription().length() > 300 || addAdScene.getDescription().equals("")) 
			return false;
		return true;
	}
}