package logic.bean;

import java.time.LocalDate;

import logic.ad.AdType;
import logic.gui.AddAdScene;

public class AddAdBean {

	private AddAdScene addAdScene;
	
	public AddAdBean() {
		addAdScene = AddAdScene.getInstance();
	}
	
	public boolean check() {
		if(addAdScene.getTitle().length() > 100 || addAdScene.getTitle().equals("")) 
			return false;
		else if(addAdScene.getDescription().length() > 300 || addAdScene.getDescription().equals("")) 
			return false;
		else if(!checkType()) 
			return false;
		else if(!checkQuantity()) 
			return false;
		else if(!checkSelectedCourse())
			return false;
		else if(!checkHighlight())
			return false;
		else if(!checkFromDate())
			return false;
		else if(!checkToDate())
			return false;
		return true;
	}
	
	private boolean checkPrice() {
		try {
			if(addAdScene.getPrice() > 255 || addAdScene.getPrice() == -1) {
				return false;
			}
		} catch(NumberFormatException | NullPointerException e) {
			return false;
		}
		return true;
	}
	
	private boolean checkType() {
		try {
			if(addAdScene.getType() == null) {
				return false;
			}
			else if(AdType.SALE.equals(addAdScene.getType())) {
				return checkPrice();
			}
		} catch(NullPointerException e) {
			return false;
		}
		return true;
	}
	
	private boolean checkQuantity() {
		try {
			if(addAdScene.getQuantity() > 255 || addAdScene.getQuantity() <= 0) {
				return false;
			}
		} catch(NumberFormatException | NullPointerException e) {
			return false;
		}
		return true;
	}
	
	private boolean checkSelectedCourse() {
		try {
			if(addAdScene.selectedCollegeBox() == null)
				return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}
	
	private boolean checkHighlight() {
		try {
			if(addAdScene.selectedHighlightBox() == null)
				return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}
	
	private boolean checkFromDate() {
		try {
			if(addAdScene.getFromDate().compareTo(LocalDate.now()) < 0)
				return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}
	
	private boolean checkToDate() {
		try {
			if(addAdScene.getToDate().compareTo(addAdScene.getFromDate()) <= 0)
				return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}
	
	////////////get da addAdScene
	public String getDescriprion() {
		return addAdScene.getDescription();
	}
	
	public String getTitle() {
		return addAdScene.getTitle();
	}
	
	public double getPrice() throws NumberFormatException, NullPointerException {
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
	///////////////////////////////////////
}