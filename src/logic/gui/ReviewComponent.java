package logic.gui;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import logic.bean.ReviewBean;

public class ReviewComponent {
	
	protected Pane pane;
	protected Label backgroundPaneLabel;
	protected int height = 150;
	protected int width = 550;
	
	private static String textFont = "Arial";
	private static String bgColor = "-fx-background-color: #024a00";
	
	public ReviewComponent(ReviewBean bean) {
		pane = new Pane();
		
		pane.setPrefWidth(550);
		pane.setPrefHeight(150);
		
		backgroundPaneLabel = new Label();
		backgroundPaneLabel.setPrefWidth(550);
		backgroundPaneLabel.setPrefHeight(150);
		backgroundPaneLabel.setStyle(bgColor);
		backgroundPaneLabel.setOpacity(0.25);
        pane.getChildren().add(backgroundPaneLabel);
        
        Label label1 = new Label("Review by: " + bean.getWriter());
        label1.setFont(new Font(textFont, 24));
        label1.setLayoutX(10);
        label1.setLayoutY(10);
        pane.getChildren().add(label1);
        
        Label label2 = new Label();
        label2.setPrefWidth(420);
        label2.setPrefHeight(100);
        label2.setLayoutX(10);
        label2.setLayoutY(38);
        label2.setStyle(bgColor);
        label2.setOpacity(0.5);
        pane.getChildren().add(label2);
        
        Label textLabel = new Label(bean.getText());
        textLabel.setWrapText(true);
        textLabel.setPrefWidth(420);
        textLabel.setPrefHeight(100);
        textLabel.setLayoutX(10);
        textLabel.setLayoutY(38);
        pane.getChildren().add(textLabel);
        
        Label label3 = new Label();
        label3.setPrefWidth(100);
        label3.setPrefHeight(100);
        label3.setLayoutX(440);
        label3.setLayoutY(38);
        label3.setStyle(bgColor);
        label3.setOpacity(0.5);
        pane.getChildren().add(label3);
        
        Label label4 = new Label("Valutazione");
        label4.setLayoutX(451);
        label4.setLayoutY(45);
        pane.getChildren().add(label4);
        
        Label label5 = new Label(bean.getRank());
        label5.setLayoutX(474);
        label5.setLayoutY(69);
        pane.getChildren().add(label5);
	}
	
	public int getHeight() {
		return height;
	}
	
	public Pane getReviewComponent() {
		return pane;
	}
}
