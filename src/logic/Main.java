package logic;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.catalina.LifecycleException;

import javafx.application.Application;
import logic.gui.MainGui;
import torverbook.web.server.WebServer;

public class Main {
	
	private static String driverClass = "com.mysql.jdbc.Driver";
	
	public static void main(String[] args) throws IOException, LifecycleException, URISyntaxException {
		try {
			Class.forName(driverClass);	
		} catch (ClassNotFoundException e) {
			System.exit(25);
		}
		
		WebServer server = new WebServer(6090);
		server.createServerEmbeddedWithXML();
//		Application.launch(MainGui.class, args);
	}
}
