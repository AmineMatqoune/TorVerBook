package logic.gui;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import logic.stuff.Review;

public class ReviewComponent {
	
	protected Pane pane;
	protected Label backgroundPaneLabel;
	
	private static String TEXT_FONT = "Arial";
	
	public ReviewComponent(Review review) {
		pane = new Pane();
		
		pane.setPrefWidth(550);
		pane.setPrefHeight(150);
		
		backgroundPaneLabel = new Label();
		backgroundPaneLabel.setPrefWidth(550);
		backgroundPaneLabel.setPrefHeight(150);
		backgroundPaneLabel.setStyle("-fx-background-color: #024a00");
		backgroundPaneLabel.setOpacity(0.25);
        pane.getChildren().add(backgroundPaneLabel);
        
        Label label1 = new Label("Review by: " + review.getWriter().getUsername());
        label1.setFont(new Font(TEXT_FONT, 24));
        label1.setLayoutX(10);
        label1.setLayoutY(10);
        pane.getChildren().add(label1);
        
        Label label2 = new Label();
        label2.setPrefWidth(420);
        label2.setPrefHeight(100);
        label2.setLayoutX(10);
        label2.setLayoutY(38);
        label2.setStyle("-fx-background-color: #024a00");
        label2.setOpacity(0.5);
        pane.getChildren().add(label2);
        
        Label textLabel = new Label(review.getText());
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
        label3.setStyle("-fx-background-color: #024a00");
        label3.setOpacity(0.5);
        pane.getChildren().add(label3);
        
        Label label4 = new Label("Valutazione");
        label4.setLayoutX(451);
        label4.setLayoutY(45);
        pane.getChildren().add(label4);
        
        Label label5 = new Label(review.getRank());
        label5.setLayoutX(474);
        label5.setLayoutY(69);
        pane.getChildren().add(label5);
	}
	
	public Pane getReviewComponent() {
		return pane;
	}
}
