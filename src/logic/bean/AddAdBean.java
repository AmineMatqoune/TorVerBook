package logic.bean;

import java.time.LocalDate;
import javafx.scene.Scene;
import logic.ad.AdType;
import logic.gui.AddAdScene;

public class AddAdBean {

	private AddAdScene addAdScene;
	
	public AddAdBean() {
		addAdScene = AddAdScene.getInstance();
	}
	
	public boolean check() { //1 tutto okay, 0 check fallito  
		return !(addAdScene.getTitle().length() > 100 || addAdScene.getTitle().equals("") ||
				addAdScene.getDescription().length() > 300 || addAdScene.getDescription().equals("")
				|| checkType() || checkQuantity() || checkFromDate() || checkToDate());
	}
	
	private boolean checkType() {
		if(AdType.SALE.equals(addAdScene.getType())) 
			return checkPrice();
		else
			return true;
	}
	
	private boolean checkPrice() {
		return addAdScene.getPrice() > 255;
	}
	
	private boolean checkQuantity() {
		return addAdScene.getQuantity() > 255 || addAdScene.getQuantity() <= 0;
	}
	
	private boolean checkFromDate() {
		return addAdScene.getFromDate().compareTo(LocalDate.now()) < 0;
	}
	
	private boolean checkToDate() {
		return addAdScene.getToDate().compareTo(addAdScene.getFromDate()) < 0;
	}
	
	//getter da addAdScene
	public String getDescription() {
		return addAdScene.getDescription();
	}
	
	public String getTitle() {
		return addAdScene.getTitle();
	}
	
	public int getPrice() {
		return addAdScene.getPrice();
	}
	
	public String getCourse() {
		return addAdScene.selectedCollegeBox();
	}
	
	public String getType() {
		return addAdScene.getType().toString();
	}
	
	public int getQuantity() {
		return addAdScene.getQuantity();	
	}
	
	public String getStartHighlight() {
		return addAdScene.getFromDate().toString();
	}
	
	public String getFinishHighlight() {
		return addAdScene.getToDate().toString();
	}
	
	public String getHighlight() {
		return addAdScene.selectedHighlightBox();
	}
	
	public Scene getScene() {
		return addAdScene.getScene();
	}
}