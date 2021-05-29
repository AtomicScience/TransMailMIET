package ru.techain.TransMail.api.email.entities;

import java.io.File;
import java.util.List;

public class Letter {
    public String toWhom;
    public String fromWhom;
    public String toEmail;
    public String fromEmail;
    public String password;
    public String subject;
    public String content;

    public List<File> attachments;
}

