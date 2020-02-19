package logic.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.bean.AdBean;

//questi AdComponent sono per FavouriteListScene
public class AdComponent {

	protected Pane pane;
    protected long id;
	private String textfont;
	private int thickness;
	private String adStyle;
	protected Label ownerUsernameLabel;
	protected Label sendMex;
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 380;
	public static final String HEADER = " Bold";

	public AdComponent(AdBean adBean) {
		id = adBean.getId();
		textfont = adBean.getFont();
		thickness = adBean.getThickness();
		
		String rgbBackgroundColor;
		String rgbDarkerBackgroundColor;
		
		if (adBean.getBackgroundColor() == Color.GREEN) {
			rgbBackgroundColor = "-fx-background-color: #228B22";
			rgbDarkerBackgroundColor = "-fx-background-color: #1F781F";
		} else if (adBean.getBackgroundColor() == Color.CYAN) {
			rgbBackgroundColor = "-fx-background-color: #A5F0EB";
			rgbDarkerBackgroundColor = "-fx-background-color: #97DED9";
		} else {
			rgbBackgroundColor = "-fx-background-color: #FFFFFF";
			rgbDarkerBackgroundColor = "-fx-background-color: #E3E3E3";
		}
		pane = new Pane();
		pane.setStyle(rgbBackgroundColor);
		pane.setPrefWidth(WIDTH);
		pane.setPadding(new Insets(0,0,50,0));
		
		Label titleLabel = new Label(adBean.getTitle());
		titleLabel.setTextFill(adBean.getTextColor());
		titleLabel.setAlignment(Pos.CENTER);
		titleLabel.setFont(new Font(textfont + HEADER, (thickness + 10)));
		titleLabel.setPrefWidth(WIDTH);
		titleLabel.setPrefHeight(40);
		titleLabel.setPadding(new Insets(20,0,0,0));
		pane.getChildren().add(titleLabel);

		Label descriptionHeader = new Label("Description");
		descriptionHeader.setTextFill(adBean.getTextColor());
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

		Label descriptionLabel = new Label(adBean.getDescription());
		descriptionLabel.setTextFill(adBean.getTextColor());
		descriptionLabel.setFont(new Font(textfont, thickness));
		descriptionLabel.setStyle(adStyle);
		descriptionLabel.setPrefWidth(316);
		descriptionLabel.setPrefHeight(256);
		descriptionLabel.setAlignment(Pos.TOP_CENTER);
		descriptionLabel.setWrapText(true);
		descriptionLabel.setPadding(new Insets(20));
		descPane.getChildren().add(descriptionLabel);

		ownerUsernameLabel = new Label("By " + adBean.getUsername());
		ownerUsernameLabel.setTextFill(adBean.getTextColor());
		ownerUsernameLabel.setFont(new Font(textfont + HEADER, thickness));
		ownerUsernameLabel.setStyle(adStyle);
		ownerUsernameLabel.setLayoutX(348);
		ownerUsernameLabel.setLayoutY(53);
		ownerUsernameLabel.setCursor(Cursor.HAND);
		pane.getChildren().add(ownerUsernameLabel);

		Pane infoAdPane = new Pane();
		infoAdPane.setStyle(rgbDarkerBackgroundColor);
		infoAdPane.setPrefWidth(188);
		infoAdPane.setPrefHeight(256);
		infoAdPane.setLayoutX(347);
		infoAdPane.setLayoutY(82);
		pane.getChildren().add(infoAdPane);

		Label adTypeLabel = new Label("Ad type: " + adBean.getAdType());
		adTypeLabel.setTextFill(adBean.getTextColor());
		adTypeLabel.setFont(new Font(textfont, 15));
		adTypeLabel.setLayoutX(20);
		adTypeLabel.setLayoutY(48);
		infoAdPane.getChildren().add(adTypeLabel);

		Label priceLabel = new Label("Price: " + adBean.getPrice() + " €");
		priceLabel.setTextFill(adBean.getTextColor());
		priceLabel.setFont(new Font(textfont, 15));
		priceLabel.setLayoutX(20);
		priceLabel.setLayoutY(93);
		infoAdPane.getChildren().add(priceLabel);

		Label categorylabel = new Label("Course:  " + adBean.getCategory());
		categorylabel.setTextFill(adBean.getTextColor());
		categorylabel.setFont(new Font(textfont, 15));
		categorylabel.setLayoutX(20);
		categorylabel.setLayoutY(143);
		infoAdPane.getChildren().add(categorylabel);

		sendMex = new Label("Send Message");
		sendMex.setTextFill(adBean.getTextColor());
		sendMex.setFont(new Font(textfont + HEADER, thickness));
		sendMex.setLayoutX(35);
		sendMex.setLayoutY(200);
		sendMex.setCursor(Cursor.HAND);
		sendMex.setPadding(new Insets(5));
		
		infoAdPane.getChildren().add(sendMex);
	}

	public void setY(int y) {
		pane.setLayoutY(y);
	}

	public int getHeight() {
		return (int) pane.getHeight();
	}

	public Pane getAdComponent() {
		return pane;
	}
}