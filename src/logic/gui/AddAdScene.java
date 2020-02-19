package logic.gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import logic.ad.AdCategory;
import logic.ad.AdType;
import logic.controller.AddAdController;
import logic.gui.popup.ErrorPopup;
import logic.gui.popup.InfoPopup;
import logic.highlight.HighlightType;

public class AddAdScene extends DashBoardScene {

	private AddAdController addAdController = new AddAdController();
	private static AddAdScene instance = null;

	private TextField adTitleField;
	private TextArea adTextArea;
	private RadioButton saleRadioButton;
	private RadioButton exchangeRadioButton;
	private TextField price1Field;
	private TextField quantityField;
	private ChoiceBox<AdCategory> collegeBox;
	private ChoiceBox<HighlightType> highlightBox;
	private DatePicker fromDate;
	private DatePicker toDate;
	private Button addButton;

	private ToggleGroup radioGroup;

	private static String textFont = "Arial";

	private AddAdScene() {
		super();

		addAdLabel.setTextFill(Color.YELLOW);
		this.setCentralPaneBackground(true);
		this.setCentralPaneFullSize(true);

		Label label1 = new Label("Ad Title");
		label1.setLayoutX(30);
		label1.setLayoutY(15);
		label1.setFont(new Font(textFont, 24));
		centralPane.getChildren().add(label1);

		adTitleField = new TextField();
		adTitleField.setPromptText("max 100 chars");
		adTitleField.setLayoutX(30);
		adTitleField.setLayoutY(55);
		adTitleField.setPrefHeight(25);
		adTitleField.setPrefWidth(528);
		centralPane.getChildren().add(adTitleField);

		Label label2 = new Label("Ad Description");
		label2.setLayoutX(30);
		label2.setLayoutY(95);
		label2.setFont(new Font(textFont, 24));
		centralPane.getChildren().add(label2);

		adTextArea = new TextArea();
		adTextArea.setPromptText("max 300 chars");
		adTextArea.setLayoutX(30);
		adTextArea.setLayoutY(135);
		adTextArea.setPrefHeight(140);
		adTextArea.setPrefWidth(528);
		centralPane.getChildren().add(adTextArea);

		saleRadioButton = new RadioButton();
		saleRadioButton.setLayoutX(30);
		saleRadioButton.setLayoutY(298);
		saleRadioButton.setText("Single Price");
		saleRadioButton.setFont(new Font(textFont, 24));
		saleRadioButton.setSelected(true);
		centralPane.getChildren().add(saleRadioButton);

		exchangeRadioButton = new RadioButton();
		exchangeRadioButton.setLayoutX(30);
		exchangeRadioButton.setLayoutY(340);
		exchangeRadioButton.setText("Exchange");
		exchangeRadioButton.setFont(new Font(textFont, 24));
		centralPane.getChildren().add(exchangeRadioButton);

		radioGroup = new ToggleGroup();

		saleRadioButton.setToggleGroup(radioGroup);
		exchangeRadioButton.setToggleGroup(radioGroup);

		price1Field = new TextField();
		price1Field.setAlignment(Pos.CENTER_RIGHT);
		price1Field.setPromptText("10");
		price1Field.setLayoutX(208);
		price1Field.setLayoutY(301);
		price1Field.setPrefHeight(25);
		price1Field.setPrefWidth(80);
		centralPane.getChildren().add(price1Field);

		Label label4 = new Label("€");
		label4.setLayoutX(290);
		label4.setLayoutY(299);
		label4.setFont(new Font(textFont, 24));
		centralPane.getChildren().add(label4);

		Label label5 = new Label("Quantity");
		label5.setLayoutX(365);
		label5.setLayoutY(298);
		label5.setFont(new Font(textFont, 24));
		centralPane.getChildren().add(label5);

		quantityField = new TextField();
		quantityField.setPromptText("1");
		quantityField.setLayoutX(464);
		quantityField.setLayoutY(298);
		quantityField.setPrefHeight(25);
		quantityField.setPrefWidth(94);
		centralPane.getChildren().add(quantityField);

		Label label6 = new Label("College Course");
		label6.setLayoutX(30);
		label6.setLayoutY(386);
		label6.setFont(new Font(textFont, 24));
		centralPane.getChildren().add(label6);

		collegeBox = new ChoiceBox<>();
		collegeBox.setValue(AdCategory.ANY);
		collegeBox.setLayoutX(221);
		collegeBox.setLayoutY(390);
		collegeBox.setPrefHeight(25);
		collegeBox.setPrefWidth(161);
		collegeBox.getItems().setAll(AdCategory.values());
		centralPane.getChildren().add(collegeBox);

		Label label7 = new Label("Highlight Option");
		label7.setLayoutX(30);
		label7.setLayoutY(424);
		label7.setFont(new Font(textFont, 24));
		centralPane.getChildren().add(label7);

		highlightBox = new ChoiceBox<>();
		highlightBox.setValue(HighlightType.BASE);
		highlightBox.setLayoutX(221);
		highlightBox.setLayoutY(429);
		highlightBox.setPrefHeight(25);
		highlightBox.setPrefWidth(161);
		highlightBox.getItems().setAll(HighlightType.values());
		centralPane.getChildren().add(highlightBox);

		try {
			FileInputStream input = new FileInputStream("img/information.png");
			Image image = new Image(input);
			ImageView imageView = new ImageView(image);
			imageView.setLayoutX(394);
			imageView.setLayoutY(427);
			centralPane.getChildren().add(imageView);
		} catch (FileNotFoundException e) {
			new ErrorPopup(e.getMessage(), (Stage) centralPane.getScene().getWindow());
		}

		Label infoLabel = new Label();
		infoLabel.setPrefSize(30, 30);
		infoLabel.setLayoutX(394);
		infoLabel.setLayoutY(427);
		infoLabel.setOnMouseClicked(
				event -> new InfoPopup("Highlight Price Per Day:\n1) BASE - 0\n2) MEDIUM - 1\n3) SUPER - 2",
						(Stage) centralPane.getScene().getWindow()));
		centralPane.getChildren().add(infoLabel);

		Label label8 = new Label("From");
		label8.setLayoutX(30);
		label8.setLayoutY(464);
		label8.setFont(new Font(textFont, 24));
		centralPane.getChildren().add(label8);

		fromDate = new DatePicker();
		fromDate.setValue(addAdController.getTodayDate());
		fromDate.setLayoutX(104);
		fromDate.setLayoutY(469);
		centralPane.getChildren().add(fromDate);

		Label label9 = new Label("To");
		label9.setLayoutX(333);
		label9.setLayoutY(464);
		label9.setFont(new Font(textFont, 24));
		centralPane.getChildren().add(label9);

		toDate = new DatePicker();
		toDate.setValue(addAdController.getTodayDate());
		toDate.setLayoutX(376);
		toDate.setLayoutY(469);
		centralPane.getChildren().add(toDate);

		addButton = new Button();
		addButton.setText("Add Ad");
		addButton.setFont(new Font(textFont, 24));
		addButton.setLayoutX(258);
		addButton.setLayoutY(511);
		addButton.setPrefHeight(51);
		addButton.setPrefWidth(127);
		addButton.setOnMouseClicked(event -> addAd());
		centralPane.getChildren().add(addButton);
	}

	private void addAd() {
		int result = addAdController.addAd();
		if(result == 0) 
			new InfoPopup("Qualcosa è andato storto, verifica di aver inserito correttamente tutte le informazioni e di avere credito a sufficienza", (Stage) scene.getWindow());
		else if (result == 1)
			new InfoPopup("Non hai abbastanza credito per poter usufruire dell'highlight fino al " + getToDate() + ". Prova a cambiare le date o abbassare il livello di highlight!", (Stage) scene.getWindow());
		else if (result == 2) {
			new InfoPopup("La tua richiesta di inserimento è stata inviata!\nAttendere la conferma dei nostri moderatori, dopodichè l'annuncio sarà visibile sulla bacheca" , (Stage)scene.getWindow());
			guiController.setHomepageScene((Stage) scene.getWindow());
		}			
	}

	// getter()
	public String getTitle() {
		return adTitleField.getText();
	}

	public String getDescription() {
		return adTextArea.getText();
	}

	public int getPrice() {
		int intPrice;

		if (radioGroup.getSelectedToggle().equals(saleRadioButton)) { // se saleRadioButton è premuto, ritorna il prezzo
			if (price1Field.getText().equals(""))
				intPrice = Integer.parseInt(price1Field.getPromptText());
			else
				intPrice = Integer.parseInt(price1Field.getText());
			return intPrice;
		} else
			return 0; // se exchangeRadioButton è premuto, ritorna 0
	}

	public AdType getType() {
		if (radioGroup.getSelectedToggle().equals(saleRadioButton))
			return AdType.SALE;
		else
			return AdType.EXCHANGE;
	}

	public int getQuantity() {
		if (quantityField.getText().equals(""))
			return Integer.parseInt(quantityField.getPromptText());
		return Integer.parseInt(quantityField.getText());
	}

	public String selectedCollegeBox() {
		return collegeBox.getValue().toString();

	}

	public String selectedHighlightBox() {
		return highlightBox.getValue().toString();
	}

	public DatePicker getFromDateObj() {
		return fromDate;
	}

	public LocalDate getFromDate() {
		return fromDate.getValue();
	}

	public LocalDate getToDate() {
		return toDate.getValue();
	}

	public static AddAdScene getInstance() {
		if (AddAdScene.instance == null)
			AddAdScene.instance = new AddAdScene();
		return instance;
	}
}