package ru.techain.TransMail.api.email;

import ru.techain.TransMail.api.email.entities.Letter;

public interface EmailSender {

    public void sendLetter(Letter letter);
}
