import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class testClass extends Application {
	
	Label displayText;
	boolean mathError = false;
	boolean startSecondTerm = false, resultShowed = false;
	public double firstTerm = 0, secondTerm = 0, result = 0;
	String operator = "";
	
	public void addDigit(String n){
		
		if((resultShowed) || (startSecondTerm)){
			displayText.setText(n);
			resultShowed = false;
			startSecondTerm = false;
		}
		else {
			if((displayText.getText() == "0") || (displayText.getText() == "Te piacerebbe"))
				displayText.setText(n);
			else
				displayText.setText(displayText.getText() + n);	
		}
		
	}
	
	public void restart() {
		operator = "";
		firstTerm = 0;
		secondTerm = 0;
		mathError = false;
	}
	
	public void calculateResult(){
		if(operator == "ADD"){
			result = firstTerm + secondTerm;
		}else if(operator == "DIFFERENCE") {
			result = firstTerm - secondTerm;
		}else if(operator == "DIVIDE") {
			if(secondTerm == 0.0)
				mathError = true;
			else
				result = firstTerm / secondTerm;
		}else if(operator == "MULTIPLY") {
			result = firstTerm * secondTerm;
		}
		
		if(mathError)
			displayText.setText("Te piacerebbe");
		else if((result%1) == 0)
			displayText.setText(String.valueOf((int)result));
		else
			displayText.setText(String.valueOf((result * 1000)/1000));
		resultShowed = true;
		restart();
	}
	
	@Override
	public void start(Stage stage) throws Exception{
		stage.setTitle("MyFirstCalculator");
		stage.setWidth(320);
		stage.setHeight(480);
		stage.setResizable(false);

		VBox vbox = new VBox();
		
		HBox hbox0 = new HBox();
		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox();
		HBox hbox3 = new HBox();
		HBox hbox4 = new HBox();
		HBox hbox5 = new HBox();
		
		//VBox
		displayText = new Label("0");
		displayText.setStyle("-fx-background-color:#F4C47F");
		displayText.setFont(new Font("Verdana", 32));
		displayText.setTextFill(Color.web("#333333"));
		displayText.setMinWidth(295);
		displayText.setMinHeight(100);
		displayText.setAlignment(Pos.CENTER_RIGHT);
		displayText.setTextAlignment(TextAlignment.RIGHT);
		hbox0.getChildren().add(displayText);
		
		Label tmp = new Label("");
		tmp.setStyle("-fx-background-color:#F4C47F");
		tmp.setMinWidth(25);
		tmp.setMinHeight(100);
		hbox0.getChildren().add(tmp);
		
		//HBox1
		Label ACLabel = new Label("AC");
		ACLabel.setStyle("-fx-background-color:#DADADA");
		ACLabel.setFont(new Font("Verdana", 16));
		ACLabel.setMinHeight(72);
		ACLabel.setMinWidth(80);
		ACLabel.setAlignment(Pos.CENTER);
		hbox1.getChildren().add(ACLabel);
		ACLabel.setOnMouseClicked(event->{
			displayText.setText("0");
		});
		
		Label DELLabel = new Label("DEL");
		DELLabel.setStyle("-fx-background-color:#DADADA");
		DELLabel.setFont(new Font("Verdana", 16));
		DELLabel.setMinHeight(72);
		DELLabel.setMinWidth(80);
		DELLabel.setAlignment(Pos.CENTER);
		hbox1.getChildren().add(DELLabel);
		DELLabel.setOnMouseClicked(event->{
			if(displayText.getText().length() > 0)
				displayText.setText(displayText.getText().substring(0,displayText.getText().length()-1));
			
			if(displayText.getText().length() < 1)	
				displayText.setText("0");
		});
		
		Label PERCLabel = new Label("%");
		PERCLabel.setStyle("-fx-background-color:#DADADA");
		PERCLabel.setFont(new Font("Verdana", 16));
		PERCLabel.setMinHeight(72);
		PERCLabel.setMinWidth(80);
		PERCLabel.setAlignment(Pos.CENTER);
		hbox1.getChildren().add(PERCLabel);
		
		Label DIVLabel = new Label("÷");
		DIVLabel.setStyle("-fx-background-color:#DADADA");
		DIVLabel.setFont(new Font("Verdana", 16));
		DIVLabel.setMinHeight(72);
		DIVLabel.setMinWidth(80);
		DIVLabel.setAlignment(Pos.CENTER);
		hbox1.getChildren().add(DIVLabel);
		DIVLabel.setOnMouseClicked(event->{
			if(displayText.getText() != "Te piacerebbe"){
				operator = "DIVIDE";
				firstTerm = Double.valueOf(displayText.getText());
				startSecondTerm = true;
				DIVLabel.setTextFill(Color.LIGHTSKYBLUE);
				DIVLabel.setFont(new Font("Verdana", 32));
			}
		});
		
		//HBox2
		Label sevenLabel = new Label("7");
		sevenLabel.setFont(new Font("Verdana", 16));
		sevenLabel.setMinHeight(72);
		sevenLabel.setMinWidth(80);
		sevenLabel.setAlignment(Pos.CENTER);
		hbox2.getChildren().add(sevenLabel);
		sevenLabel.setOnMouseClicked(event->{
			addDigit("7");
		});
		
		Label eightLabel = new Label("8");
		eightLabel.setFont(new Font("Verdana", 16));
		eightLabel.setMinHeight(72);
		eightLabel.setMinWidth(80);
		eightLabel.setAlignment(Pos.CENTER);
		hbox2.getChildren().add(eightLabel);
		eightLabel.setOnMouseClicked(event->{
			addDigit("8");
		});
		
		Label nineLabel = new Label("9");
		nineLabel.setFont(new Font("Verdana", 16));
		nineLabel.setMinHeight(72);
		nineLabel.setMinWidth(80);
		nineLabel.setAlignment(Pos.CENTER);
		hbox2.getChildren().add(nineLabel);
		nineLabel.setOnMouseClicked(event->{
			addDigit("9");
		});
		
		Label MULLabel = new Label("X");
		MULLabel.setStyle("-fx-background-color:#DADADA");
		MULLabel.setFont(new Font("Verdana", 16));
		MULLabel.setMinHeight(72);
		MULLabel.setMinWidth(80);
		MULLabel.setAlignment(Pos.CENTER);
		hbox2.getChildren().add(MULLabel);
		MULLabel.setOnMouseClicked(event->{
			if(displayText.getText() != "Te piacerebbe"){
				operator = "MULTIPLY";
				firstTerm = Double.valueOf(displayText.getText());
				startSecondTerm = true;
				MULLabel.setTextFill(Color.LIGHTSKYBLUE);
				MULLabel.setFont(new Font("Verdana", 32));
			}
		});
		
		//HBox3
		Label fourLabel = new Label("4");
		fourLabel.setFont(new Font("Verdana", 16));
		fourLabel.setMinHeight(72);
		fourLabel.setMinWidth(80);
		fourLabel.setAlignment(Pos.CENTER);
		hbox3.getChildren().add(fourLabel);
		fourLabel.setOnMouseClicked(event->{
			addDigit("4");
		});
		
		Label fiveLabel = new Label("5");
		fiveLabel.setFont(new Font("Verdana", 16));
		fiveLabel.setMinHeight(72);
		fiveLabel.setMinWidth(80);
		fiveLabel.setAlignment(Pos.CENTER);
		hbox3.getChildren().add(fiveLabel);
		fiveLabel.setOnMouseClicked(event->{
			addDigit("5");
		});
		
		Label sixLabel = new Label("6");
		sixLabel.setFont(new Font("Verdana", 16));
		sixLabel.setMinHeight(72);
		sixLabel.setMinWidth(80);
		sixLabel.setAlignment(Pos.CENTER);
		hbox3.getChildren().add(sixLabel);
		sixLabel.setOnMouseClicked(event->{
			addDigit("6");
		});
		
		Label DIFFLabel = new Label("-");
		DIFFLabel.setStyle("-fx-background-color:#DADADA");
		DIFFLabel.setFont(new Font("Verdana", 16));
		DIFFLabel.setMinHeight(72);
		DIFFLabel.setMinWidth(80);
		DIFFLabel.setAlignment(Pos.CENTER);
		hbox3.getChildren().add(DIFFLabel);
		DIFFLabel.setOnMouseClicked(event->{
			if(displayText.getText() != "Te piacerebbe"){
				operator = "DIFFERENCE";
				firstTerm = Double.valueOf(displayText.getText());
				startSecondTerm = true;
				DIFFLabel.setTextFill(Color.LIGHTSKYBLUE);
				DIFFLabel.setFont(new Font("Verdana", 32));
			}
		});
		
		//HBox4
		Label oneLabel = new Label("1");
		oneLabel.setFont(new Font("Verdana", 16));
		oneLabel.setMinHeight(72);
		oneLabel.setMinWidth(80);
		oneLabel.setAlignment(Pos.CENTER);
		hbox4.getChildren().add(oneLabel);
		oneLabel.setOnMouseClicked(event->{
			addDigit("1");
		});
		
		Label twoLabel = new Label("2");
		twoLabel.setFont(new Font("Verdana", 16));
		twoLabel.setMinHeight(72);
		twoLabel.setMinWidth(80);
		twoLabel.setAlignment(Pos.CENTER);
		hbox4.getChildren().add(twoLabel);
		twoLabel.setOnMouseClicked(event->{
			addDigit("2");
		});
		
		Label threeLabel = new Label("3");
		threeLabel.setFont(new Font("Verdana", 16));
		threeLabel.setMinHeight(72);
		threeLabel.setMinWidth(80);
		threeLabel.setAlignment(Pos.CENTER);
		hbox4.getChildren().add(threeLabel);
		threeLabel.setOnMouseClicked(event->{
			addDigit("3");
		});
		
		Label SUMLabel = new Label("+");
		SUMLabel.setStyle("-fx-background-color:#DADADA");
		SUMLabel.setFont(new Font("Verdana", 16));
		SUMLabel.setMinHeight(72);
		SUMLabel.setMinWidth(80);
		SUMLabel.setAlignment(Pos.CENTER);
		hbox4.getChildren().add(SUMLabel);
		SUMLabel.setOnMouseClicked(event->{
			if(displayText.getText() != "Te piacerebbe"){
				operator = "ADD";
				firstTerm = Double.valueOf(displayText.getText());
				startSecondTerm = true;
				SUMLabel.setTextFill(Color.LIGHTSKYBLUE);
				SUMLabel.setFont(new Font("Verdana", 32));
			}
		});
		
		//HBox5
		Label zerozeroLabel = new Label("");
		zerozeroLabel.setFont(new Font("Verdana", 16));
		zerozeroLabel.setMinHeight(72);
		zerozeroLabel.setMinWidth(80);
		zerozeroLabel.setAlignment(Pos.CENTER);
		hbox5.getChildren().add(zerozeroLabel);
		
		Label zeroLabel = new Label("0");
		zeroLabel.setFont(new Font("Verdana", 16));
		zeroLabel.setMinHeight(72);
		zeroLabel.setMinWidth(80);
		zeroLabel.setAlignment(Pos.CENTER);
		hbox5.getChildren().add(zeroLabel);
		zeroLabel.setOnMouseClicked(event->{
			addDigit("0");
		});
		
		Label dotLabel = new Label(".");
		dotLabel.setFont(new Font("Verdana", 16));
		dotLabel.setMinHeight(72);
		dotLabel.setMinWidth(80);
		dotLabel.setAlignment(Pos.CENTER);
		hbox5.getChildren().add(dotLabel);
		dotLabel.setOnMouseClicked(event->{
			displayText.setText(displayText.getText() + ".");
		});
		
		Label EQLabel = new Label("=");
		EQLabel.setStyle("-fx-background-color:#3EB3D1");
		EQLabel.setFont(new Font("Verdana", 16));
		EQLabel.setMinHeight(72);
		EQLabel.setMinWidth(80);
		EQLabel.setAlignment(Pos.CENTER);
		hbox5.getChildren().add(EQLabel);
		EQLabel.setOnMouseClicked(event->{
			secondTerm = Double.valueOf(displayText.getText());
			calculateResult();
			DIVLabel.setTextFill(Color.BLACK);
			DIVLabel.setFont(new Font("Verdana", 16));
			DIFFLabel.setTextFill(Color.BLACK);
			DIFFLabel.setFont(new Font("Verdana", 16));
			SUMLabel.setTextFill(Color.BLACK);
			SUMLabel.setFont(new Font("Verdana", 16));
			MULLabel.setTextFill(Color.BLACK);
			MULLabel.setFont(new Font("Verdana", 16));
		});
		
		vbox.getChildren().add(hbox0);
		vbox.getChildren().add(hbox1);
		vbox.getChildren().add(hbox2);
		vbox.getChildren().add(hbox3);
		vbox.getChildren().add(hbox4);
		vbox.getChildren().add(hbox5);
		
		Scene scene = new Scene(vbox);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
