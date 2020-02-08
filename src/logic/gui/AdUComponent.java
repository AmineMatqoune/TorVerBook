package logic.gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.ad.Ad;
import logic.dao.AdDAO;
import logic.gui.popup.InfoPopup;

//AdComponent that will be shown in the homepage
public class AdUComponent extends AdComponent{
	
	private ImageView star = null;
	private Pane starPane;
	private FileInputStream input = null;
    boolean isFavourite = false;
    
	public AdUComponent(Ad ad, boolean isFavourite) {
		super(ad);
		this.isFavourite = isFavourite;
		
		try {
			starPane = new Pane();
			starPane.setPrefSize(40, 40);
			starPane.setLayoutX(520);
			starPane.setLayoutY(10);
			pane.getChildren().add(starPane);
			
			if(this.isFavourite)
				input = new FileInputStream("img/star5.PNG");
			else
				input = new FileInputStream("img/star0.PNG");
			
			Image image = new Image(input);
	        star = new ImageView(image);
	        starPane.setOnMouseClicked(event ->
	        	clickStar(ad)
            );
	        starPane.getChildren().add(star);
		} catch (FileNotFoundException e) {
			new InfoPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
		}
	}
	
	private boolean addToFavouriteList(Ad ad) throws ClassNotFoundException, SQLException {
		AdDAO dao = AdDAO.getInstance();
		return dao.addAdToFavouriteList(ad);
	}
	
	private boolean removeFromFavouriteList(Ad ad) throws ClassNotFoundException, SQLException {
		AdDAO dao = AdDAO.getInstance();
		return dao.removeAdFromFavouriteList(ad);
	}
	
	private void clickStar(Ad ad) {
		try {
			FileInputStream input2 = null;
			if(this.isFavourite && removeFromFavouriteList(ad)) 
					input2 = new FileInputStream("img/star0.png");
			else if(addToFavouriteList(ad)) 
					input2 = new FileInputStream("img/star5.png");
			
			Image image2 = new Image(input2);
			star.setImage(image2);
			this.isFavourite = !this.isFavourite;
		} catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
			new InfoPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
		}
	}
}