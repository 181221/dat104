package no.hvl.dat104.app;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.Properties;

public class MailUtil {
    public static void setUpMail(HttpServletRequest request) {
        String til = request.getParameter("til");
        String msg = request.getParameter("msg");
        String subject = request.getParameter("subject");
        Mail mail = new Mail(til, msg, subject);
        setUpProps(mail, request);
    }
    private static void setUpProps(Mail mail, HttpServletRequest req) {
        String host = "smtp.gmail.com";
        // Creating Properties object
        Properties props = new Properties();
        // Defining properties
        props.put("mail.smtp.host", host);
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.user", Mail.getFRAMAIL());
        props.put("mail.password", Mail.getPASSORD());
        props.put("mail.port", "465");

        sendMail(mail, props, req);
    }
    private static void sendMail(Mail mail, Properties props, HttpServletRequest req) {
        String host = "smtp.gmail.com";
        // Authorized the Session object.
        Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Mail.getFRAMAIL(), Mail.getPASSORD());
            }
        });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(mailSession);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(Mail.getFRAMAIL()));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(mail.getTil()));
            // Set Subject: header field
            message.setSubject(mail.getSubject());
            // Now set the actual message
            message.setText(mail.getMsg());
            // Send message
            javax.mail.Transport.send(message);
            mail.setResult("Your mail sent successfully....");
            req.getSession().setAttribute("result", mail.getResult());
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
    }
}
