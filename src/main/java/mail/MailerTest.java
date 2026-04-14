package mail;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class MailerTest {

    public static void main(String[] args) throws MessagingException {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "10.53.123.23"); //CAB-VSP-MBX5045.sigma.sbrf.ru, 9 CAB-VSP-MBX5045.sigma.sbrf.ru
        prop.put("mail.smtp.port", "25");
        prop.put("mail.smtp.ssl.trust", "10.53.123.23");

        final String username = "SIGMA\\SBT-SA-BPS00001";
        final String password = "dataspaceRBACp4";

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("SBT-SA-BPS00001@sigma.sbrf.ru"));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse("eskov.a.v@sberbank.ru"));
        message.setSubject("Mail Subject");

        String msg = "This is my first email using JavaMailer";

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }
}
