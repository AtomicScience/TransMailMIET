package ru.techain.TransMail.api.email.entities;

public class LetterBuilder {

    Letter letter;

    public LetterBuilder() {
        letter = new Letter();
    }

    public LetterBuilder setToWhom(String toWhom) {
        letter.toWhom = toWhom;
        return this;
    }

    public LetterBuilder setFromWhom(String fromWhom) {
        letter.fromWhom = fromWhom;
        return this;
    }

    public LetterBuilder setToEmail(String toEmail) {
        letter.toEmail = toEmail;
        return this;
    }

    public LetterBuilder setFromEmail(String fromEmail) {
        letter.fromEmail = fromEmail;
        return this;
    }

    public LetterBuilder setPassword(String password) {
        letter.password = password;
        return this;
    }

    public LetterBuilder setSubject(String subject) {
        letter.subject = subject;
        return this;
    }

    public LetterBuilder setContent(String content) {
        letter.content = content;
        return this;
    }

    public Letter build() {
        return letter;
    }

}
