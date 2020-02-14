package logic.gui.rc;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SettingsRCScene extends RCHomepage{

	private static SettingsRCScene instance = null;
	
	private static final String WORK_IN_PROGRESS = "WORK IN PROGRESS";
	
	private TextField usernameField;
	private TextField nameField;
	private TextField surnameField;
	private TextField dayField;
	private TextField monthField;
	private TextField yearField;
	private TextField phoneNumberField;
	private PasswordField pwd1Field;
	private PasswordField pwd2Field;
	private TextField salaryField;
	private TextField workStartDayField;
	private TextField workStartMonthField;
	private TextField workStartYearField;
	private TextField workFinishDayField;
	private TextField workFinishMonthField;
	private TextField workFinishYearField;
	
	private SettingsRCScene() {
		super();
		
		infoSettingsLabel.setTextFill(Color.YELLOW);
		
		Label label1 = new Label("Username");
		label1.setFont(new Font(fontText, 24));
		label1.setLayoutX(350);
		label1.setLayoutY(190);
		pane.getChildren().add(label1);
		
		usernameField = new TextField(WORK_IN_PROGRESS);
		usernameField.setPrefSize(450, 25);
		usernameField.setLayoutX(540);
		usernameField.setLayoutY(190);
		pane.getChildren().add(usernameField);
		
		Label label2 = new Label("Name");
		label2.setFont(new Font(fontText, 24));
		label2.setLayoutX(350);
		label2.setLayoutY(250);
		pane.getChildren().add(label2);
		
		nameField = new TextField(WORK_IN_PROGRESS);
		nameField.setPrefSize(450, 25);
		nameField.setLayoutX(540);
		nameField.setLayoutY(250);
		pane.getChildren().add(nameField);
		
		Label label3 = new Label("Surame");
		label3.setFont(new Font(fontText, 24));
		label3.setLayoutX(350);
		label3.setLayoutY(310);
		pane.getChildren().add(label3);
		
		surnameField = new TextField(WORK_IN_PROGRESS);
		surnameField.setPrefSize(450, 25);
		surnameField.setLayoutX(540);
		surnameField.setLayoutY(310);
		pane.getChildren().add(surnameField);
		
		Label label4 = new Label("Birthdate");
		label4.setFont(new Font(fontText, 24));
		label4.setLayoutX(350);
		label4.setLayoutY(370);
		pane.getChildren().add(label4);
		
		dayField = new TextField();
		dayField.setPrefSize(100, 25);
		dayField.setLayoutX(540);
		dayField.setLayoutY(370);
		pane.getChildren().add(dayField);
		
		Label label10 = new Label("/");
		label10.setFont(new Font(fontText, 24));
		label10.setLayoutX(652);
		label10.setLayoutY(370);
		pane.getChildren().add(label10);
		
		monthField = new TextField();
		monthField.setPrefSize(100, 25);
		monthField.setLayoutX(670);
		monthField.setLayoutY(370);
		pane.getChildren().add(monthField);
		
		Label label11 = new Label("/");
		label11.setFont(new Font(fontText, 24));
		label11.setLayoutX(783);
		label11.setLayoutY(370);
		pane.getChildren().add(label11);
		
		yearField = new TextField();
		yearField.setPrefSize(190, 25);
		yearField.setLayoutX(800);
		yearField.setLayoutY(370);
		pane.getChildren().add(yearField);
		
		Label label5 = new Label("Phone Number");
		label5.setFont(new Font(fontText, 24));
		label5.setLayoutX(350);
		label5.setLayoutY(430);
		pane.getChildren().add(label5);
		
		phoneNumberField = new TextField(WORK_IN_PROGRESS);
		phoneNumberField.setPrefSize(450, 25);
		phoneNumberField.setLayoutX(540);
		phoneNumberField.setLayoutY(430);
		pane.getChildren().add(phoneNumberField);
		
		Label label6 = new Label("Password");
		label6.setFont(new Font(fontText, 24));
		label6.setLayoutX(350);
		label6.setLayoutY(490);
		pane.getChildren().add(label6);
		
		pwd1Field = new PasswordField();
		pwd1Field.setPrefSize(450, 25);
		pwd1Field.setLayoutX(540);
		pwd1Field.setLayoutY(490);
		pane.getChildren().add(pwd1Field);
		
		Label label7 = new Label("Password");
		label7.setFont(new Font(fontText, 24));
		label7.setLayoutX(350);
		label7.setLayoutY(550);
		pane.getChildren().add(label7);
		
		pwd2Field = new PasswordField();
		pwd2Field.setPrefSize(450, 25);
		pwd2Field.setLayoutX(540);
		pwd2Field.setLayoutY(550);
		pane.getChildren().add(pwd2Field);
		
		Label label8 = new Label("Salary*");
		label8.setFont(new Font(fontText, 24));
		label8.setLayoutX(350);
		label8.setLayoutY(610);
		pane.getChildren().add(label8);
		
		salaryField = new TextField(WORK_IN_PROGRESS);
		salaryField.setPrefSize(450, 25);
		salaryField.setLayoutX(540);
		salaryField.setLayoutY(610);
		salaryField.setEditable(false);
		pane.getChildren().add(salaryField);
		
		Label label9 = new Label("Contract Time*");
		label9.setFont(new Font(fontText, 24));
		label9.setLayoutX(350);
		label9.setLayoutY(670);
		pane.getChildren().add(label9);
		
		Label label12 = new Label("Since");
		label12.setFont(new Font(fontText, 14));
		label12.setLayoutX(540);
		label12.setLayoutY(674);
		pane.getChildren().add(label12);
		
		workStartDayField = new TextField();
		workStartDayField.setPrefSize(36, 25);
		workStartDayField.setLayoutX(590);
		workStartDayField.setLayoutY(670);
		workStartDayField.setEditable(false);
		pane.getChildren().add(workStartDayField);
		
		Label label13 = new Label("/");
		label13.setFont(new Font(fontText, 24));
		label13.setLayoutX(630);
		label13.setLayoutY(668);
		pane.getChildren().add(label13);
		
		workStartMonthField = new TextField();
		workStartMonthField.setPrefSize(36, 25);
		workStartMonthField.setLayoutX(641);
		workStartMonthField.setLayoutY(670);
		workStartMonthField.setEditable(false);
		pane.getChildren().add(workStartMonthField);
		
		Label label14 = new Label("/");
		label14.setFont(new Font(fontText, 24));
		label14.setLayoutX(681);
		label14.setLayoutY(668);
		pane.getChildren().add(label14);
		
		workStartYearField = new TextField();
		workStartYearField.setPrefSize(59, 25);
		workStartYearField.setLayoutX(693);
		workStartYearField.setLayoutY(670);
		workStartYearField.setEditable(false);
		pane.getChildren().add(workStartYearField);
		
		Label label15 = new Label("To");
		label15.setFont(new Font(fontText, 14));
		label15.setLayoutX(792);
		label15.setLayoutY(674);
		pane.getChildren().add(label15);
		
		workFinishDayField = new TextField();
		workFinishDayField.setPrefSize(36, 25);
		workFinishDayField.setLayoutX(828);
		workFinishDayField.setLayoutY(670);
		workFinishDayField.setEditable(false);
		pane.getChildren().add(workFinishDayField);
		
		Label label16 = new Label("/");
		label16.setFont(new Font(fontText, 24));
		label16.setLayoutX(868);
		label16.setLayoutY(668);
		pane.getChildren().add(label16);
		
		workFinishMonthField = new TextField();
		workFinishMonthField.setPrefSize(36, 25);
		workFinishMonthField.setLayoutX(878);
		workFinishMonthField.setLayoutY(670);
		workFinishMonthField.setEditable(false);
		pane.getChildren().add(workFinishMonthField);
		
		Label label17 = new Label("/");
		label17.setFont(new Font(fontText, 24));
		label17.setLayoutX(920);
		label17.setLayoutY(668);
		pane.getChildren().add(label17);
		
		workFinishYearField = new TextField();
		workFinishYearField.setPrefSize(59, 25);
		workFinishYearField.setLayoutX(931);
		workFinishYearField.setLayoutY(670);
		workFinishYearField.setEditable(false);
		pane.getChildren().add(workFinishYearField);
		
		Label label19 = new Label("* Not editable");
		label19.setFont(new Font(fontText, 12));
		label19.setLayoutX(350);
		label19.setLayoutY(719);
		pane.getChildren().add(label19);
		
		Button saveButton = new Button("SAVE");	
		saveButton.setFont(new Font(fontText, 27));
		saveButton.setPrefSize(136, 65);
		saveButton.setLayoutX(1027);
		saveButton.setLayoutY(638);
		pane.getChildren().add(saveButton);
	}
	
	public static SettingsRCScene getInstance() {
		if(instance == null) {
			instance = new SettingsRCScene();
		}
		return instance;
	}
}