package logic.utils;

import javax.mail.*;
import javax.mail.internet.*;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.gui.popup.InfoPopup;

import java.util.*;

public class SendMail {
	private Pane infoPane;
	
	private String recipient;
	private String mittente = "torverbook.info@libero.it";
	
	public SendMail(String recipient, Pane pane) {
		infoPane = pane;
		this.recipient = recipient;
	}
	
	public void sendReportingEmail(String text) throws AddressException {		 
	    Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.user", mittente);
	    props.put("mail.smtp.host", "smtp.libero.it");
	    props.put("mail.smtp.port", 465);
	 
	    // commentare la riga seguente per non usare SSL
	    props.put("mail.smtp.starttls.enable","true");
	    props.put("mail.smtp.socketFactory.port", 465);
	 
	    // commentare la riga seguente per non usare SSL
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.checkserveridentity");
	    props.put("mail.smtp.socketFactory.fallback", "false");
	 
	    Session session = Session.getInstance(props, null);
	    session.setDebug(true);
	 
	    // Creazione delle BodyParts del messaggio
	    MimeBodyPart messageBodyPart1 = new MimeBodyPart();
	 
	    try{
	      // COSTRUZIONE DEL MESSAGGIO
	      Multipart multipart = new MimeMultipart();
	      MimeMessage msg = new MimeMessage(session);
	 
	      // header del messaggio
	      msg.setSubject("TorVerBook - InfoMail");
	      msg.setSentDate(new Date());
	      msg.setFrom(new InternetAddress(mittente));
	 
	      // destinatario
	      msg.addRecipient(Message.RecipientType.TO,
	      new InternetAddress(recipient));
	 
	      // corpo del messaggio
	      messageBodyPart1.setText(text);
	      multipart.addBodyPart(messageBodyPart1);
	
	      // inserimento delle parti nel messaggio
	      msg.setContent(multipart);
	 
	      Transport transport = session.getTransport("smtps"); //("smtp") per non usare SSL
	      transport.connect("smtp.libero.it", mittente, "torverbook2020");
	      transport.sendMessage(msg, msg.getAllRecipients());
	      transport.close();
	 
	    }catch(MessagingException e) {
	    	new InfoPopup("Impossible to send Report email!", (Stage) infoPane.getScene().getWindow());
	    }
	}
}
