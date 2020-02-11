package logic.gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import logic.dao.AdDAO;
import logic.gui.popup.InfoPopup;

//AdComponent that will be shown in the homepage
public class AdUComponent extends AdComponent{
	
	private ImageView star = null;
	private Pane starPane;
	private FileInputStream input = null;
    private boolean isFavourite = false;
    private long id;
    
	public AdUComponent(String title, String description, String username, String type, int price, String category, boolean isFavourite) {
		super(title, description, username, type, price, category);
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
	        	clickStar()
            );
	        starPane.getChildren().add(star);
		} catch (FileNotFoundException e) {
			new InfoPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
		}
	}
	
	private boolean addToFavouriteList() throws ClassNotFoundException, SQLException {
		AdDAO dao = AdDAO.getInstance();
		return dao.addAdToFavouriteList(id);
	}
	
	private boolean removeFromFavouriteList() throws ClassNotFoundException, SQLException {
		AdDAO dao = AdDAO.getInstance();
		return dao.removeAdFromFavouriteList(id);
	}
	
	public void setId(long id) {
    	this.id = id;
    }
	
	private void clickStar() {
		try {
			FileInputStream input2 = null;
			if(this.isFavourite && removeFromFavouriteList()) 
					input2 = new FileInputStream("img/star0.png");
			else if(addToFavouriteList()) 
					input2 = new FileInputStream("img/star5.png");
			
			Image image2 = new Image(input2);
			star.setImage(image2);
			this.isFavourite = !this.isFavourite;
		} catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
			new InfoPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
		}
	}
}