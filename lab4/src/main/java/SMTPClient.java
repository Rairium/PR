import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SMTPClient {
    public static void main(String[] args) {
        // Mention the Recipient's email address
        String to = "petrea@egutu.md";
        // Mention the Sender's email address
        String from = "eric@egutu.md";
        // Mention the SMTP server address. Below Gmail's SMTP server is being used to send email
        String host = "DESKTOP-5V3KRLL";
        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "25");
        properties.put("mail.smtp.ssl.enable", "false");
        properties.put("mail.smtp.auth", "true");
        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("eric", "root");
            }
        });
        // Used to debug SMTP issues
        session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            message.setSubject("Tipa subject line");
            // Now set the actual message
            message.setText("");
            System.out.println("tipa vine...");
            // Send message
            Transport.send(message);
            System.out.println("WAI PETREA O VENIIT!!!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}