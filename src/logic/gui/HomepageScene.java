package logic.gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.ad.AdCategory;
import logic.ad.AdType;
import logic.controller.HomepageController;
import logic.gui.popup.ErrorPopup;

public class HomepageScene extends DashBoardScene{
	
	private static HomepageScene instance = null;
	private HomepageController hpController = new HomepageController();
	
	private ChoiceBox <AdCategory> categoryBox;
	private ChoiceBox <AdType> typeBox;
	private Slider slider;
	
	private static final String FONT = "Arial";
	
	private HomepageScene() {
		super();
		
		homepageLabel.setTextFill(Color.YELLOW);
		this.setCentralPaneFullSize(true);
		this.setCentralPaneBackground(true);
		
		Pane searchPane = new Pane();
		searchPane.setPrefSize(600, 100);
		searchPane.setStyle("-fx-background-color: #024a00");
		centralPane.getChildren().add(searchPane);
		
		Label categoryLabel = new Label("Category");
		categoryLabel.setTextFill(Color.WHITE);
		categoryLabel.setFont(new Font(FONT, 16));
		categoryLabel.setLayoutX(25);
		categoryLabel.setLayoutY(25);
		searchPane.getChildren().add(categoryLabel);
		
		categoryBox = new ChoiceBox <> ();
		categoryBox.setValue(AdCategory.UNKNOWN);
		categoryBox.setLayoutX(25);
		categoryBox.setLayoutY(50);
		categoryBox.setPrefWidth(150);
		categoryBox.getItems().setAll(AdCategory.values());
		searchPane.getChildren().add(categoryBox);
		
		Label typeLabel = new Label("Type");
		typeLabel.setTextFill(Color.WHITE);
		typeLabel.setFont(new Font(FONT, 16));
		typeLabel.setLayoutX(200);
		typeLabel.setLayoutY(25);
		searchPane.getChildren().add(typeLabel);
		
		typeBox = new ChoiceBox <> ();
		typeBox.setValue(AdType.SALE);
		typeBox.setLayoutX(200);
		typeBox.setLayoutY(50);
		typeBox.setPrefWidth(150);
		typeBox.getItems().setAll(AdType.values());
		searchPane.getChildren().add(typeBox);
		
		Label priceLabel = new Label("Max price: ");
		priceLabel.setTextFill(Color.WHITE);
		priceLabel.setFont(new Font(FONT, 16));
		priceLabel.setLayoutX(375);
		priceLabel.setLayoutY(25);
		searchPane.getChildren().add(priceLabel);
		
		slider = new Slider();
		slider.setLayoutX(375);
		slider.setLayoutY(50);
		slider.setMax(100);
		slider.setMin(1);
		slider.setValue(50);
		searchPane.getChildren().add(slider);
		
		Label label1 = new Label("1");
		label1.setTextFill(Color.WHITE);
		label1.setLayoutX(372);
		label1.setLayoutY(65);
		searchPane.getChildren().add(label1);
		
		Label label100 = new Label("100");
		label100.setTextFill(Color.WHITE);
		label100.setLayoutX(505);
		label100.setLayoutY(65);
		searchPane.getChildren().add(label100);
		
		Pane imagePane = new Pane();
		imagePane.setPrefSize(50, 50);
		imagePane.setLayoutX(530);
		imagePane.setLayoutY(25);
		imagePane.setOnMouseReleased(event -> search());
		searchPane.getChildren().add(imagePane);
		
		try {
			FileInputStream input = new FileInputStream("img/search.png");
			Image image = new Image(input);
			ImageView imageView = new ImageView(image);
	        imagePane.getChildren().add(imageView);
		} catch (FileNotFoundException e) {
			new ErrorPopup(e.getMessage(), (Stage)centralPane.getScene().getWindow());
		}
		
		Pane componentPane = new Pane();
		componentPane.setPrefSize(600, 500);
		componentPane.setLayoutY(100);
		centralPane.getChildren().add(componentPane);
		
		hpController.attachAdsTo(componentPane);
	}
	
	private void search() {
		hpController.searchList(categoryBox.getValue().toString(), typeBox.getValue().toString(), slider.getValue());
	}

	public static HomepageScene getInstance() {
		if(instance == null) 
			instance = new HomepageScene();
		return instance;
	}
}