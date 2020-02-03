package logic.gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.ad.Ad;
import logic.gui.popup.ErrorPopup;

public class AdComponent {

	protected Pane pane;
	protected Label backgroundPaneLabel;
	
	private String textfont;
	private Color textcolor;
	private int thickness;
	
	private static String style = "-fx-background-color: #024a00";
	
	public AdComponent(Ad ad) {
		pane = new Pane();
		
		pane.setPrefWidth(550);
		pane.setPrefHeight(350);
		
		textfont = ad.getFont();
		thickness = ad.getThickness();
		textcolor = ad.getTextColor();
		
		backgroundPaneLabel = new Label();
		backgroundPaneLabel.setPrefWidth(550);
		backgroundPaneLabel.setPrefHeight(350);
		backgroundPaneLabel.setStyle(style);
		backgroundPaneLabel.setOpacity(0.25);
        pane.getChildren().add(backgroundPaneLabel);
        
        Label label1 = new Label(ad.getTitle());
        label1.setStyle("-fx-background-color: " + ad.getRGBColor());
        label1.setTextFill(textcolor);
        label1.setFont(new Font(textfont, (thickness+5)));
        label1.setStyle(ad.getStyle());
        label1.setPrefWidth(550);
        label1.setPrefHeight(40);
        pane.getChildren().add(label1);
        
        Label label2 = new Label("Description");
        label2.setTextFill(textcolor);
        label2.setFont(new Font(textfont, 15));
        label2.setLayoutX(10);
        label2.setLayoutY(50);
        pane.getChildren().add(label2);
        
        Label label3 = new Label();
        label3.setStyle(style);
        label3.setOpacity(0.5);
        label3.setPrefWidth(316);
        label3.setPrefHeight(256);
        label3.setLayoutX(10);
        label3.setLayoutY(82);
        pane.getChildren().add(label3);
        
        Label label4 = new Label(ad.getDescription());
        label4.setTextFill(textcolor);
        label4.setFont(new Font(textfont, thickness));
        label4.setStyle(ad.getStyle());
        label4.setPrefWidth(316);
        label4.setPrefHeight(256);
        label4.setLayoutX(10);
        label4.setLayoutY(82);
        label4.setWrapText(true);
        pane.getChildren().add(label4);
        
        Label label5 = new Label(ad.getOwner().getUsername());
        label5.setTextFill(textcolor);
        label5.setFont(new Font(textfont, thickness));
        label5.setStyle(ad.getStyle());
        label5.setLayoutX(348);
        label5.setLayoutY(82);
        pane.getChildren().add(label5);
        
        Label label6 = new Label();
        label6.setStyle(style);
        label6.setOpacity(0.5);
        label6.setPrefWidth(188);
        label6.setPrefHeight(225);
        label6.setLayoutX(347);
        label6.setLayoutY(112);
        pane.getChildren().add(label6);
        
        Label label7 = new Label("Ad type: " + ad.getType());
        label7.setTextFill(textcolor);
        label7.setFont(new Font(textfont, 15));
        label7.setLayoutX(351);
        label7.setLayoutY(130);
        pane.getChildren().add(label7);
        
        Label label8 = new Label("Price: " + ad.getPrice());
        label8.setTextFill(textcolor);
        label8.setFont(new Font(textfont, 15));
        label8.setLayoutX(351);
        label8.setLayoutY(175);
        pane.getChildren().add(label8);
        
        Label label9 = new Label("Quantity:  " + ad.getQuantity());
        label9.setTextFill(textcolor);
        label9.setFont(new Font(textfont, 15));
        label9.setLayoutX(351);
        label9.setLayoutY(225);
        pane.getChildren().add(label9);
        
        Label label10 = new Label("Send Message");
        label10.setTextFill(textcolor);
        label10.setFont(new Font(textfont, thickness));
        label10.setLayoutX(387);
        label10.setLayoutY(285);
        pane.getChildren().add(label10);
        
        try {
			FileInputStream input = new FileInputStream("img/logo.png");
			Image image = new Image(input);
	        ImageView imageView = new ImageView(image);
	        imageView.setLayoutX(485);
	        imageView.setLayoutY(283);
	        pane.getChildren().add(imageView);
		} catch (FileNotFoundException e) {
			new ErrorPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
		}
    }
	
	public Pane getReviewComponent() {
		return pane;
	}
}