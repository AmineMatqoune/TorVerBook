package logic.gui;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.ad.AdCategory;
import logic.controller.AddAdController;
import logic.highlight.HighlightType;

public class AddAdScene extends DashBoardScene{
	
	private AddAdController addController = new AddAdController();
	
	private static AddAdScene instance = null;
	
	private TextField adTitleField;
	private TextArea adTextArea;
	private RadioButton saleRadioButton;
	private RadioButton exchangeRadioButton;
	private TextField price1Field;
	private TextField price2Field;
	private TextField quantityField;
	private ChoiceBox <AdCategory> collegeBox;
	private ChoiceBox <HighlightType> highlightBox;
	private DatePicker fromDate;
	private DatePicker toDate;
	private Button addButton;  
	
	private ToggleGroup radioGroup;
	
	private static String textFont = "Arial";
	
	private AddAdScene() {
		super();
		
		addAdLabel.setTextFill(Color.YELLOW);
		
		Label label1 = new Label("Ad Title");
		label1.setLayoutX(30);
		label1.setLayoutY(30);
		label1.setFont(new Font(textFont, 24));
		centralPane.getChildren().add(label1);
		
		adTitleField = new TextField();
		adTitleField.setPromptText("max 100 chars");
		adTitleField.setLayoutX(30);
		adTitleField.setLayoutY(70);
		adTitleField.setPrefHeight(25);
		adTitleField.setPrefWidth(528);
		centralPane.getChildren().add(adTitleField);
		
		Label label2 = new Label("Ad Description");
		label2.setLayoutX(30);
		label2.setLayoutY(110);
		label2.setFont(new Font(textFont, 24));
		centralPane.getChildren().add(label2);
		
		adTextArea = new TextArea();
		adTextArea.setPromptText("max 300 chars");
		adTextArea.setLayoutX(30);
		adTextArea.setLayoutY(150);
		adTextArea.setPrefHeight(140);
		adTextArea.setPrefWidth(528);
		centralPane.getChildren().add(adTextArea);
		
		saleRadioButton = new RadioButton();
		saleRadioButton.setLayoutX(30);
		saleRadioButton.setLayoutY(313);
		saleRadioButton.setText("Single Price");
		saleRadioButton.setFont(new Font(textFont, 24));
		centralPane.getChildren().add(saleRadioButton);
		
		exchangeRadioButton = new RadioButton();
		exchangeRadioButton.setLayoutX(30);
		exchangeRadioButton.setLayoutY(355);
		exchangeRadioButton.setText("Exchange");
		exchangeRadioButton.setFont(new Font(textFont, 24));
		centralPane.getChildren().add(exchangeRadioButton);
		
		radioGroup = new ToggleGroup();

		saleRadioButton.setToggleGroup(radioGroup);
		exchangeRadioButton.setToggleGroup(radioGroup);
		
		price1Field = new TextField();
		price1Field.setPromptText("10");
		price1Field.setLayoutX(208);
		price1Field.setLayoutY(316);
		price1Field.setPrefHeight(25);
		price1Field.setPrefWidth(37);
		centralPane.getChildren().add(price1Field);
		
		Label label3 = new Label(",");
		label3.setLayoutX(247);
		label3.setLayoutY(314);
		label3.setFont(new Font(textFont, 24));
		centralPane.getChildren().add(label3);
		
		price2Field = new TextField();
		price2Field.setPromptText("00");
		price2Field.setLayoutX(258);
		price2Field.setLayoutY(316);
		price2Field.setPrefHeight(25);
		price2Field.setPrefWidth(37);
		centralPane.getChildren().add(price2Field);
		
		Label label4 = new Label("€");
		label4.setLayoutX(303);
		label4.setLayoutY(314);
		label4.setFont(new Font(textFont, 24));
		centralPane.getChildren().add(label4);
		
		Label label5 = new Label("Quantity");
		label5.setLayoutX(365);
		label5.setLayoutY(313);
		label5.setFont(new Font(textFont, 24));
		centralPane.getChildren().add(label5);
		
		quantityField = new TextField();
		quantityField.setPromptText("00");
		quantityField.setLayoutX(464);
		quantityField.setLayoutY(313);
		quantityField.setPrefHeight(25);
		quantityField.setPrefWidth(94);
		centralPane.getChildren().add(quantityField);
		
		Label label6 = new Label("College Course");
		label6.setLayoutX(30);
		label6.setLayoutY(401);
		label6.setFont(new Font(textFont, 24));
		centralPane.getChildren().add(label6);
		
		collegeBox = new ChoiceBox <AdCategory> ();
		collegeBox.setLayoutX(221);
		collegeBox.setLayoutY(406);
		collegeBox.setPrefHeight(25);
		collegeBox.setPrefWidth(161);
		collegeBox.getItems().setAll(AdCategory.values());
		centralPane.getChildren().add(collegeBox);
		
		Label label7 = new Label("Highlight Option");
		label7.setLayoutX(30);
		label7.setLayoutY(439);
		label7.setFont(new Font(textFont, 24));
		centralPane.getChildren().add(label7);
		
		highlightBox = new ChoiceBox <HighlightType> ();
		highlightBox.setLayoutX(221);
		highlightBox.setLayoutY(444);
		highlightBox.setPrefHeight(25);
		highlightBox.setPrefWidth(161);
		highlightBox.getItems().setAll(HighlightType.values());
		centralPane.getChildren().add(highlightBox);
		
		Label label8 = new Label("From");
		label8.setLayoutX(30);
		label8.setLayoutY(479);
		label8.setFont(new Font(textFont, 24));
		centralPane.getChildren().add(label8);
		
		fromDate = new DatePicker();
		fromDate.setLayoutX(104);
		fromDate.setLayoutY(484);
		fromDate.setPromptText("Today");
		centralPane.getChildren().add(fromDate);
		
		Label label9 = new Label("To");
		label9.setLayoutX(333);
		label9.setLayoutY(479);
		label9.setFont(new Font(textFont, 24));
		centralPane.getChildren().add(label9);
		
		toDate = new DatePicker();
		toDate.setLayoutX(376);
		toDate.setLayoutY(484);
		toDate.setPromptText("Forever");
		centralPane.getChildren().add(toDate);
		
		addButton = new Button();
		addButton.setText("Add Ad");
		addButton.setFont(new Font(textFont, 24));
		addButton.setLayoutX(258);
		addButton.setLayoutY(526);
		addButton.setPrefHeight(51);
		addButton.setPrefWidth(127);
		addButton.setOnMouseClicked(event ->
			addAd()
	    );
		centralPane.getChildren().add(addButton);
	}
	
	private void addAd() {
		if(addController.addAd()) {
			
		}
	}
	
	//////////////////////
	public String getTitle() {
		return adTitleField.getText();
	}
	
	public String getDescription() {
		return adTitleField.getText();
	}
	
	/*public void getAdType() {
		radioGroup.is
	}*/
	///////////////////////

	public static AddAdScene getInstance() {
		if(AddAdScene.instance == null) {
			AddAdScene.instance = new AddAdScene();
		}
		return instance;
	}
}