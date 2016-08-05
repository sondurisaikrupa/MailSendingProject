package email.utility;

import java.io.File;
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

public class EmailUtility {
	
	public static void sendMailWithAttachment() throws Exception{
		System.out.println(EDDCommonConstants.PROCESSING_SENDING_MAIL);
		Properties properties=System.getProperties();
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		
		Session session=Session.getDefaultInstance(properties, null);
		
		MimeMessage mimeMessage = new MimeMessage(session);

		mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("baase.srinivas@gmail.com"));
		mimeMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("mpgc922@gmail.com"));
		mimeMessage.setSubject("Confidential Information");
		
		Multipart multipart = new MimeMultipart();
		
		MimeBodyPart messagePart = new MimeBodyPart();
		messagePart.setContent("Please find the attachment.", "text/html");
		multipart.addBodyPart(messagePart);
		
		MimeBodyPart attachmentPart = new MimeBodyPart();
		attachmentPart.attachFile(new File(EDDCommonConstants.FILE_PATH));
		multipart.addBodyPart(attachmentPart);
		
		mimeMessage.setContent(multipart);
		
		Transport transport=session.getTransport("smtp");
		transport.connect("smtp.gmail.com", "bashasrinivas96@gmail.com", "unitedamerica");
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		System.out.println(EDDCommonConstants.PROCESSED_SENDING_MAIL);
		transport.close();
		
	}
	
}
