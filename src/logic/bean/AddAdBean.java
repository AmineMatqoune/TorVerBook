package logic.bean;

import java.time.LocalDate;

import javafx.scene.Scene;
import logic.ad.AdType;
import logic.exceptions.EmptyFieldException;
import logic.exceptions.ExcessiveInputLengthException;
import logic.exceptions.InvalidInputValueException;
import logic.gui.AddAdScene;
import static logic.utils.DataValidationUtils.*;

public class AddAdBean {

	private AddAdScene addAdScene;

	public AddAdBean() {
		addAdScene = AddAdScene.getInstance();
	}

	public boolean check() throws InvalidInputValueException, EmptyFieldException, ExcessiveInputLengthException {
		if (checkByMaxLength(addAdScene.getTitle(), 100) && checkByMaxLength(addAdScene.getDescription(), 300)
				&& checkNotEmpty(addAdScene.getTitle()) && checkNotEmpty(addAdScene.getDescription())) {
			checkQuantity();
			checkType();
			checkFromDate();
			checkToDate();
			return true;
		}
		return false;
	}

	private boolean checkType() throws InvalidInputValueException {
		if (addAdScene.getType().equals(AdType.SALE)) {
			checkPrice();
		}
		return true;
	}

	private void checkPrice() throws InvalidInputValueException {
		if (addAdScene.getPrice() > 255 || addAdScene.getPrice() < 0) {
			throw new InvalidInputValueException();
		}
	}

	private void checkQuantity() throws InvalidInputValueException {
		if (addAdScene.getQuantity() > 255 && addAdScene.getQuantity() < 0) {
			throw new InvalidInputValueException();
		}
	}

	private void checkFromDate() throws InvalidInputValueException {
		if (addAdScene.getFromDate().compareTo(LocalDate.now()) < 0) {
			throw new InvalidInputValueException();
		}
	}

	private void checkToDate() throws InvalidInputValueException {
		if (addAdScene.getToDate().compareTo(addAdScene.getFromDate()) < 0) {
			throw new InvalidInputValueException();
		}
	}

	// getter da addAdScene
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