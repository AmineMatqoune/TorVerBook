package logic.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

//questi AdComponent sono per FavouriteListScene
public class AdComponent {

	protected Pane pane;

	private String textfont;
	private Color bgColor;
	private Color textColor;
	private int thickness;
	private String adStyle;

	public static final int WIDTH = 585;
	public static final int HEIGHT = 350;
	public static final String HEADER = " Bold";
	
	public AdComponent(String title, String description, String username, String type, int price, String category) {
		String rgbBackgroundColor;
		String rgbDarkerBackgroundColor;
		System.out.println("Ho ricevuto: " + title + "\n" + description + "\n\n\n\n");

		if (bgColor == Color.GREEN) {
			rgbBackgroundColor = "-fx-background-color: #228B22";
			rgbDarkerBackgroundColor = "-fx-background-color: #1F781F";
		} else if (bgColor == Color.CYAN) {
			rgbBackgroundColor = "-fx-background-color: #A5F0EB";
			rgbDarkerBackgroundColor = "-fx-background-color: #97DED9";
		} else {
			rgbBackgroundColor = "-fx-background-color: #FFFFFF";
			rgbDarkerBackgroundColor = "-fx-background-color: #E3E3E3";
		}
		pane = new Pane();
		pane.setStyle(rgbBackgroundColor);

		pane.setPrefWidth(WIDTH);
		pane.setPrefHeight(HEIGHT);

		Label titleLabel = new Label(title);
		titleLabel.setTextFill(textColor);
		titleLabel.setAlignment(Pos.CENTER);
		titleLabel.setFont(new Font(textfont + HEADER, (thickness + 10)));
		titleLabel.setPrefWidth(WIDTH);
		titleLabel.setPrefHeight(40);
		pane.getChildren().add(titleLabel);

		Label descriptionHeader = new Label("Description");
		descriptionHeader.setTextFill(textColor);
		descriptionHeader.setFont(new Font(textfont + HEADER, (thickness + 5)));
		descriptionHeader.setLayoutX(10);
		descriptionHeader.setLayoutY(50);
		pane.getChildren().add(descriptionHeader);

		Pane descPane = new Pane();
		descPane.setStyle(rgbDarkerBackgroundColor);
		descPane.setPrefWidth(316);
		descPane.setPrefHeight(256);
		descPane.setLayoutX(10);
		descPane.setLayoutY(82);
		pane.getChildren().add(descPane);

		Label descriptionLabel = new Label(description);
		descriptionLabel.setTextFill(textColor);
		descriptionLabel.setFont(new Font(textfont, thickness));
		descriptionLabel.setStyle(adStyle);
		descriptionLabel.setPrefWidth(316);
		descriptionLabel.setPrefHeight(256);
		descriptionLabel.setAlignment(Pos.TOP_CENTER);
		descriptionLabel.setWrapText(true);
		descPane.getChildren().add(descriptionLabel);

		Label ownerUsernameLabel = new Label("By " + username);
		ownerUsernameLabel.setTextFill(textColor);
		ownerUsernameLabel.setFont(new Font(textfont + HEADER, thickness));
		ownerUsernameLabel.setStyle(adStyle);
		ownerUsernameLabel.setLayoutX(348);
		ownerUsernameLabel.setLayoutY(53);
		pane.getChildren().add(ownerUsernameLabel);

		Pane infoAdPane = new Pane();
		infoAdPane.setStyle(rgbDarkerBackgroundColor);
		infoAdPane.setPrefWidth(188);
		infoAdPane.setPrefHeight(256);
		infoAdPane.setLayoutX(347);
		infoAdPane.setLayoutY(82);
		pane.getChildren().add(infoAdPane);

		Label adTypeLabel = new Label("Ad type: " + type);
		adTypeLabel.setTextFill(textColor);
		adTypeLabel.setFont(new Font(textfont, 15));
		adTypeLabel.setLayoutX(20);
		adTypeLabel.setLayoutY(48);
		infoAdPane.getChildren().add(adTypeLabel);

		Label priceLabel = new Label("Price: " + price + " €");
		priceLabel.setTextFill(textColor);
		priceLabel.setFont(new Font(textfont, 15));
		priceLabel.setLayoutX(20);
		priceLabel.setLayoutY(93);
		infoAdPane.getChildren().add(priceLabel);

		Label categorylabel = new Label("Course:  " + category);
		categorylabel.setTextFill(textColor);
		categorylabel.setFont(new Font(textfont, 15));
		categorylabel.setLayoutX(20);
		categorylabel.setLayoutY(143);
		infoAdPane.getChildren().add(categorylabel);

		Label label10 = new Label("Send Message");
		label10.setTextFill(textColor);
		label10.setFont(new Font(textfont, thickness));
		label10.setLayoutX(35);
		label10.setLayoutY(200);
		infoAdPane.getChildren().add(label10);
	}
	
	public void setFont(String font) {
		textfont = font;
	}
	
	public void setStyle(String style){
		adStyle = style;
	}
	
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	
	public void setTextColor(Color color) {
		textColor = color;
	}
	
	public void setBackgroundColor(Color color) {
		bgColor = color;
	}
	
	public void setY(int y) {
		pane.setLayoutY(y);
	}
	
	public int getHeight() {
		return HEIGHT;
	}

	public Pane getAdComponent() {
		return pane;
	}
}