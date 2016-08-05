package samples;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.business.constants.EDDCommonConstants;

public class SampleTest {
	public static void main(String[] args)throws Exception {
		Properties properties=System.getProperties();
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		Session session=Session.getDefaultInstance(properties, null);
	MimeMessage mimeMessage=new MimeMessage(session);
	mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("susmitapanigrahi52@gmail.com"));
	mimeMessage.setSubject("cofidential info");
	
	MimeBodyPart messagePart = new MimeBodyPart();
	messagePart.setContent("Hi ", "text/html");
	
	MimeBodyPart attachpart = new MimeBodyPart();
	attachpart.attachFile(EDDCommonConstants.FILE_PATH);
	
	Multipart multipart = new MimeMultipart();
	multipart.addBodyPart(messagePart);
	multipart.addBodyPart(attachpart);	
	
	mimeMessage.setContent(multipart);
	
	Transport transport=session.getTransport("smtp");
	transport.connect("smtp.gmail.com", "susmitapanigrahi52@gmail.com", EDDCommonConstants.PASSWORD);
	transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
	System.out.println("Sent mail");
	}
}
