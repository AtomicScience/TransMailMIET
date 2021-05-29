package ru.techain.TransMail.email;

import ru.techain.TransMail.api.email.EmailSender;
import ru.techain.TransMail.api.email.entities.Letter;

import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class EmailRepo implements EmailSender {

    @Override
    public void sendLetter(Letter letter) throws MessagingException, IOException {
        Properties props = System.getProperties();
        String host;
        String port;

        String domain = letter.fromEmail.split("@")[1];

        if (domain.startsWith("outlook")) {
            host = "smtp-mail.outlook.com";
            port = "587";
            props.put("mail.smtp.starttls.enable", "true");
        } else {
            host = "smtp." + domain;
            port = "465";
            props.put("mail.smtp.ssl.enable", "true");
        }


        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(letter.fromEmail, letter.password);

            }

        });

        session.setDebug(true);

        MimeMessage msg = new MimeMessage(session);

        msg.setSubject(letter.subject);
        msg.setFrom(letter.fromEmail);
        msg.setRecipients(Message.RecipientType.TO, letter.toEmail);

        MimeBodyPart content = new MimeBodyPart();
        content.setText(letter.content);

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(content);

        msg.setContent(multipart);
        FileOutputStream os = new FileOutputStream("file.eml");
        msg.writeTo(os);

        Transport.send(msg);

        System.out.println("Done!");
    }

}
