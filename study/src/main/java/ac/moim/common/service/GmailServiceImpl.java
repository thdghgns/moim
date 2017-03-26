package ac.moim.common.service;

import java.util.List;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class GmailServiceImpl implements GmailService {

	public void send(String title, String message, List<String> toMail) throws Exception {
		String id = "elandmoim";
		String pwd = "dlfosemahdla";		 
		
		Properties p = new Properties();
		p.put("mail.smtp.user", "elandmoim@gmail.com");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");

		Authenticator auth = new SMTPAuthenticator(id, pwd);
		Session session = Session.getInstance(p, auth);
		session.setDebug(true); // 메일을 전송할 때 상세한 상황을 콘솔에 출력한다.

		MimeMessage msg = new MimeMessage(session);
		msg.setSubject(title, "UTF-8");
		InternetAddress[] addressTo = new InternetAddress[toMail.size()];
		for (int i = 0; i < toMail.size(); i++) {
			addressTo[i] = new InternetAddress(toMail.get(i));
		}

		msg.setRecipients(Message.RecipientType.TO, addressTo);
		msg.setContent(message, "text/html;charset=utf-8");

		Transport.send(msg);

	}

	private static class SMTPAuthenticator extends javax.mail.Authenticator {

		String id;
		String pwd;
		
		SMTPAuthenticator(String id, String pwd) {
			this.id = id;
			this.pwd = pwd;
		}

		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(id, pwd); 
		}
	}
}
