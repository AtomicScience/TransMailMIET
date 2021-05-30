package ru.techain.TransMail.web.controllers;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.techain.TransMail.api.LotTableParser;
import ru.techain.TransMail.api.email.EmailSender;
import ru.techain.TransMail.api.email.entities.Letter;
import ru.techain.TransMail.api.email.entities.RequestLetterBuilder;
import ru.techain.TransMail.api.table.RealLotableParser;
import ru.techain.TransMail.email.EmailRepo;
import ru.techain.TransMail.file.FileSaver;

import javax.mail.MessagingException;

@RestController
public class RequestEmailController {
    @RequestMapping(value="/sendRequestEmail", method=RequestMethod.POST)
    public @ResponseBody
    ModelAndView handleFileUpload(@RequestParam("fromEmail") String fromEmail,
                                  @RequestParam("password") String password,
                                  @RequestParam("toEmail") String toEmail,
                                  @RequestParam("prefix") String prefix,
                                  @RequestParam("suffix") String suffix,
                                  @RequestParam("tempFileName") String tempFileName) throws IOException {
        Letter letter = new RequestLetterBuilder()
                .addPrefix(prefix)
                .addPrizes(FileSaver.loadStringFromTempFile(tempFileName))
                .addSuffix(suffix)
                .setFromEmail(fromEmail)
                .setPassword(password)
                .setToEmail(toEmail)
                .build();

        EmailSender sender = new EmailRepo();

        try {
            sender.sendLetter(letter);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        ModelAndView view = new ModelAndView();
        view.setViewName("mailSuccess");
        view.addObject("toEmail", toEmail);

        return view;
    }
}
