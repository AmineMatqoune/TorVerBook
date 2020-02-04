package logic.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.ad.Ad;

public class AdComponent {

	protected Pane pane;

	private String textfont;
	private Color bgColor;
	private Color textcolor;
	private int thickness;

	public static final int width = 585;
	public static final int height = 350;

	public AdComponent(Ad ad) {
		textfont = ad.getFont();
		thickness = ad.getThickness();
		textcolor = ad.getTextColor();
		bgColor = ad.getBackgroundColor();
		String rgbBackgroundColor;
		String rgbDarkerBackgroundColor;

		if (bgColor == Color.GREEN) {
			rgbBackgroundColor = "-fx-background-color: #228B22";
			rgbDarkerBackgroundColor = "-fx-background-color: #1F781F";
		} else if (bgColor == Color.YELLOW) {
			rgbBackgroundColor = "-fx-background-color: #F7E178";
			rgbDarkerBackgroundColor = "-fx-background-color: #EDD45C";
		} else {
			rgbBackgroundColor = "-fx-background-color: #FFFFFF";
			rgbDarkerBackgroundColor = "-fx-background-color: #E3E3E3";
		}
		pane = new Pane();
		pane.setStyle(rgbBackgroundColor);

		pane.setPrefWidth(width);
		pane.setPrefHeight(height);

		Label titleLabel = new Label(ad.getTitle());
		titleLabel.setTextFill(textcolor);
		titleLabel.setAlignment(Pos.CENTER);
		titleLabel.setFont(new Font(textfont + " Bold", thickness + 10));
		titleLabel.setPrefWidth(width);
		titleLabel.setPrefHeight(40);
		pane.getChildren().add(titleLabel);

		Label descriptionHeader = new Label("Description");
		descriptionHeader.setTextFill(textcolor);
		descriptionHeader.setFont(new Font(textfont + " Bold", thickness + 5));
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

		Label descriptionLabel = new Label(ad.getDescription());
		descriptionLabel.setTextFill(textcolor);
		descriptionLabel.setFont(new Font(textfont, thickness));
		descriptionLabel.setStyle(ad.getStyle());
		descriptionLabel.setPrefWidth(316);
		descriptionLabel.setPrefHeight(256);
		descriptionLabel.setAlignment(Pos.TOP_CENTER);
		descriptionLabel.setWrapText(true);
		descPane.getChildren().add(descriptionLabel);

		Label ownerUsernameLabel = new Label("By " + ad.getOwnerUsername());
		ownerUsernameLabel.setTextFill(textcolor);
		ownerUsernameLabel.setFont(new Font(textfont + " Bold", thickness));
		ownerUsernameLabel.setStyle(ad.getStyle());
		ownerUsernameLabel.setLayoutX(348);
		ownerUsernameLabel.setLayoutY(50);
		pane.getChildren().add(ownerUsernameLabel);

		Pane infoAdPane = new Pane();
		infoAdPane.setStyle(rgbDarkerBackgroundColor);
		infoAdPane.setPrefWidth(188);
		infoAdPane.setPrefHeight(256);
		infoAdPane.setLayoutX(347);
		infoAdPane.setLayoutY(82);
		pane.getChildren().add(infoAdPane);

		Label adTypeLabel = new Label("Ad type: " + ad.getType());
		adTypeLabel.setTextFill(textcolor);
		adTypeLabel.setFont(new Font(textfont, 15));
		adTypeLabel.setLayoutX(351);
		adTypeLabel.setLayoutY(130);
		pane.getChildren().add(adTypeLabel);

		Label priceLabel = new Label("Price: " + ad.getPrice() + " €");
		priceLabel.setTextFill(textcolor);
		priceLabel.setFont(new Font(textfont, 15));
		priceLabel.setLayoutX(351);
		priceLabel.setLayoutY(175);
		pane.getChildren().add(priceLabel);

		Label quantityLabel = new Label("Quantity:  " + ad.getQuantity());
		quantityLabel.setTextFill(textcolor);
		quantityLabel.setFont(new Font(textfont, 15));
		quantityLabel.setLayoutX(351);
		quantityLabel.setLayoutY(225);
		pane.getChildren().add(quantityLabel);

		Label label10 = new Label("Send Message");
		label10.setTextFill(textcolor);
		label10.setFont(new Font(textfont, thickness));
		label10.setLayoutX(387);
		label10.setLayoutY(285);
		pane.getChildren().add(label10);
	}

	public void setY(int y) {
		pane.setLayoutY(y);
	}

	public Pane getAdPane() {
		return pane;
	}
}