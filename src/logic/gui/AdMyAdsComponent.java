package logic.gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import logic.dao.AdDAO;
import logic.gui.popup.ErrorPopup;
import logic.gui.popup.InfoPopup;


public class AdMyAdsComponent extends AdComponent{
	
	private long id;
	
	public AdMyAdsComponent(String title, String description, String username, String type, int price, String category) {
		super(title, description, username, type, price, category);
		
		Pane deletePane = new Pane();
		deletePane.setPrefSize(60, 60);
		deletePane.setLayoutX(540);
		deletePane.setLayoutY(0);
		deletePane.setStyle("-fx-background-color: #f44336");
		pane.getChildren().add(deletePane);
		
		Pane markAsSold = new Pane();
		markAsSold.setPrefSize(60, 60);
		markAsSold.setLayoutX(540);
		markAsSold.setLayoutY(60);
		markAsSold.setStyle("-fx-background-color: #f44336");
		pane.getChildren().add(markAsSold);
		
		try {
			Image delete = new Image(new FileInputStream("img/delete.PNG"));
			ImageView bin = new ImageView(delete);
	        deletePane.setOnMouseClicked(event ->
	        	deleteAd()
	        );
	        deletePane.getChildren().add(bin);
	        
			Image sold = new Image(new FileInputStream("img/sold.PNG"));
			ImageView mark = new ImageView(sold);
	        markAsSold.setOnMouseClicked(event ->
	        	markAsSold()
	        );
	        markAsSold.getChildren().add(mark);     
		} catch (FileNotFoundException e) {
			new ErrorPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
		}
		
		
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	private void deleteAd() {
		try {
			if(AdDAO.getInstance().deleteAd(id)) {
				new InfoPopup("Annuncio cancellato correttamente!", (Stage)pane.getScene().getWindow());
				MyAdsScene adScene = MyAdsScene.getInstance();
				adScene.refresh();
			} else {
				new InfoPopup("Ops! Qualcosa è andato storto!", (Stage)pane.getScene().getWindow());
			}
		} catch (ClassNotFoundException | SQLException e) {
			new ErrorPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
		}
	}
	
	private void markAsSold() {
		try {
			AdDAO.getInstance().markAsSold(id);
		} catch (ClassNotFoundException | SQLException e) {
			new ErrorPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
		} 
	}
}
