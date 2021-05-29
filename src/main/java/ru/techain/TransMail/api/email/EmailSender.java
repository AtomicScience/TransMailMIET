package ru.techain.TransMail.api.email;

import ru.techain.TransMail.api.email.entities.Letter;

import javax.mail.MessagingException;
import java.io.IOException;

public interface EmailSender {

    void sendLetter(Letter letter) throws MessagingException, IOException;
}
