package logic.gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.ParseException;

import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.bean.AdBean;
import logic.dao.AdDAO;
import logic.gui.popup.InfoPopup;

//AdComponent that will be shown in the homepage
public class AdUComponent extends AdComponent{
	
	private ImageView star = null;
	private FileInputStream input = null;
    private boolean isFavourite;
    
	public AdUComponent(AdBean adBean) {
		super(adBean);
		
		ownerUsernameLabel.setUnderline(true);
		sendMex.setUnderline(true);
		
		try {
			Pane starPane = new Pane();
			starPane.setPrefSize(40, 40);
			starPane.setLayoutX(520);
			starPane.setLayoutY(10);
			pane.getChildren().add(starPane);
			isFavourite = adBean.getFavourite();
			
			if(isFavourite)
				input = new FileInputStream("img/star5.PNG");
			else
				input = new FileInputStream("img/star0.PNG");
			
			Image image = new Image(input);
	        star = new ImageView(image);
	        starPane.setOnMouseClicked(event ->
	        	clickStar(adBean)
            );
	        star.setCursor(Cursor.HAND);
	        starPane.getChildren().add(star);
		} catch (FileNotFoundException e) {
			new InfoPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
		}
	}
	
	private boolean addToFavouriteList(AdBean adBean) throws SQLException {
		AdDAO dao = AdDAO.getInstance();
		try {
			return dao.addAdToFavouriteList(adBean);
		} catch (ParseException e) {
			new InfoPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
			return false;
		}
	}
	
	private boolean removeFromFavouriteList(AdBean adBean) throws SQLException {
		AdDAO dao = AdDAO.getInstance();
		try {
			return dao.removeAdFromFavouriteList(adBean);
		} catch (ParseException e) {
			new InfoPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
			return false;
		}
	}
	
	private void clickStar(AdBean adBean) {
		try {
			FileInputStream input2 = null;
			if(this.isFavourite && removeFromFavouriteList(adBean)) 
					input2 = new FileInputStream("img/star0.png");
			else if(addToFavouriteList(adBean)) 
					input2 = new FileInputStream("img/star5.png");

			Image image2 = new Image(input2);
			star.setImage(image2);
			this.isFavourite = !this.isFavourite;
		} catch (SQLException | FileNotFoundException e) {
			new InfoPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
		}
	}
}