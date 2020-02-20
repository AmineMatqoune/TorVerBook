package torverbook.web.server;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.catalina.Context;
import org.apache.catalina.Globals;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.scan.StandardJarScanner;

public class WebServer {
	private static final String WEB_CONTENT_DIR = "web-content/";
	private static final String WEB_CONFIG_XML = "web-content/WEB-INF/web.xml";
	private static final String TMP_DIR = "./tmp";
	private int port;

	public WebServer(int port) {
		this.port = port;
	}

	private static String getRootPath() {
		try {
			return new File(".").getCanonicalPath() + "/";
		} catch (IOException e) {
			Logger.getLogger(e.getMessage());
		}
		// da Amine
		return null;
	}

	public static boolean directoryExists() {
		return new File(getRootPath() + "web-content").exists();
	}

	public void createServerEmbeddedWithXML() {
		try {
			Tomcat tomcat = new Tomcat();
			tomcat.setBaseDir(TMP_DIR);
			tomcat.setPort(this.port);

			String rootWebAppDirectoryPath = getRootPath();
			Context ctx = tomcat.addWebapp(tomcat.getHost(), "", rootWebAppDirectoryPath + WEB_CONTENT_DIR);
			ctx.getServletContext().setAttribute(Globals.ALT_DD_ATTR, rootWebAppDirectoryPath + WEB_CONFIG_XML);
			((StandardJarScanner) ctx.getJarScanner()).setScanAllDirectories(true);

			tomcat.start();
			tomcat.getServer().await();
		} catch (LifecycleException e) {
			Logger.getLogger(e.getMessage());
		}
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getPort() {
		return this.port;
	}

}
