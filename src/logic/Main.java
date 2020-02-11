package logic;

import javafx.application.Application;
import logic.gui.MainGui;

public class Main {
	
	private static String driverClass = "com.mysql.jdbc.Driver";
	
	public static void main(String[] args) {
		try {
			Class.forName(driverClass);	
		} catch (ClassNotFoundException e) {
			System.exit(25);
		}
		Application.launch(MainGui.class, args);
	}
}
