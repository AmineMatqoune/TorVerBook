package torverbook.web.server;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.catalina.Context;
import org.apache.catalina.Globals;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.scan.StandardJarScanner;

import torverbook.web.controllers.LoginController;

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
		} catch (IOException e){
			Logger.getLogger(e.getMessage());
		}
		//da Amine
		return null;		
	}
	
	public static boolean directoryExists() {
		return new File(getRootPath() + "web-content").exists();	
	}

	public void createServerEmbeddedWithCustomPath(String path) {
		try {
			Tomcat tomcat = new Tomcat();
			tomcat.setBaseDir(TMP_DIR);
			tomcat.setPort(this.port);
			Context ctx = tomcat.addWebapp(tomcat.getHost(), "", path);
			((StandardJarScanner) ctx.getJarScanner()).setScanAllDirectories(true);
			Tomcat.addServlet(ctx, "loginController", new LoginController());
			ctx.addServletMapping("/login", "loginController");
			ctx.addWelcomeFile("index.jsp");
			tomcat.start();
			tomcat.getServer().await();
		} catch (LifecycleException e) {
			Logger.getLogger(e.getMessage());
		}
	}

	public void createServerEmbedded()  {
		try {
			Tomcat tomcat = new Tomcat();
			tomcat.setBaseDir(TMP_DIR);
			tomcat.setPort(this.port);

			String webappDirLocation = getRootPath();
			Context ctx = tomcat.addWebapp(tomcat.getHost(), "", webappDirLocation + "web-content");

			((StandardJarScanner) ctx.getJarScanner()).setScanAllDirectories(true);
			((StandardJarScanner) ctx.getJarScanner()).setScanClassPath(true);
			((StandardJarScanner) ctx.getJarScanner()).setScanBootstrapClassPath(true);
			((StandardJarScanner) ctx.getJarScanner()).setScanAllFiles(true);

			Tomcat.addServlet(ctx, "loginController", new LoginController());
			ctx.addServletMapping("/login", "loginController");
			ctx.addWelcomeFile("index.jsp");
			tomcat.start();
			tomcat.getServer().await();
		} catch (LifecycleException e) {
			Logger.getLogger(e.getMessage());
		}
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
		} catch (LifecycleException e){
			Logger.getLogger(e.getMessage());
		}
	}

}
