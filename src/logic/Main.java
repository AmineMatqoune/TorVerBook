package logic;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.catalina.LifecycleException;

import javafx.application.Application;
import logic.gui.MainGui;
import torverbook.web.server.WebServer;

public class Main {

	private static String driverClass = "com.mysql.jdbc.Driver";
	private static final String WEB_SERVER_MODE_FLAG = "--server-mode";

	public static void main(String[] args) throws IOException, LifecycleException, URISyntaxException {
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			System.exit(25);
		}

		boolean webServerMode = serverMode(args);

		if (webServerMode) {
			WebServer server = new WebServer(5080);
			server.createServerEmbeddedWithXML();
		} else {
			Application.launch(MainGui.class, args);
		}
	}

	private static boolean serverMode(String[] args) {
		for (String arg : args) {
			if (arg.trim().contains(WEB_SERVER_MODE_FLAG)) {
				return true;
			}
		}
		return false;
	}
}
