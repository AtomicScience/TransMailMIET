package ru.techain.TransMail.web.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.techain.TransMail.api.FullLotTableParser;
import ru.techain.TransMail.api.email.EmailSender;
import ru.techain.TransMail.api.email.entities.Letter;
import ru.techain.TransMail.api.email.entities.LetterBuilder;
import ru.techain.TransMail.api.models.FinalEmployee;
import ru.techain.TransMail.api.table.RealFullLotTableParser;
import ru.techain.TransMail.email.EmailRepo;

import javax.mail.MessagingException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

@RestController
public class ReplyRequestController {
    @RequestMapping(value="/sendReply", method= RequestMethod.POST)
    public @ResponseBody String handleSendReply(@RequestParam("email") String email,
                                                @RequestParam("password") String password) throws IOException {
        File pdfDirectory = new File("src/main/resources/static/pdf");

        FullLotTableParser parser = getTestTableParser();
        List<File> files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(pdfDirectory.listFiles())));

        List<FinalEmployee> employees = parser.getFinalEmployeesByProduct("Онлайн-подписка Сберпрайм (12 месяцев)");
        int i = 0;

        EmailSender sender = new EmailRepo();
        for (FinalEmployee e : employees) {
            LetterBuilder lb = new LetterBuilder();
            String str = String.format("Уважаемый %s, вас ожидает ваш подарок: %s",
                    e.getName() + " " + e.getPatronymic(), e.getNameProduct());
            String downStr = "Ваш Андрей Пьявкин";
            List<File> toSend = new ArrayList<>();
            for (int j = i; j-i < e.getCount(); j++) {
                lb.addAttachment(files.get(j));
            }
            i += e.getCount();
            Letter letter = lb.setFromEmail(email)
                    .setPassword(password)
                    .setSubject("Ваш подарок!")
                    .setContent(str + "\n\n" + downStr)
                    .setToEmail(e.getEmail())
                    .build();

            try {
                sender.sendLetter(letter);
            } catch (MessagingException messagingException) {
                return "Ошибка отправки сообщения: " + messagingException.getLocalizedMessage();
            }
        }

        return "Сообщения отправлены";
    }

    private FullLotTableParser getTestTableParser() throws IOException {
        FileReader ordersTable = new FileReader(new File("src/main/resources/static/mock/mock_lots.csv"), Charset.forName("CP1251")); // TODO
        FileReader employeesTable = new FileReader(new File("src/main/resources/static/mock/mock_employees.csv"), Charset.forName("CP1251")); // TODO

        return new RealFullLotTableParser(ordersTable, employeesTable);
    }

    private List<File> getPdfFiles() {
        return Arrays.asList(Objects.requireNonNull(new File("src/main/resources/static/pdf").listFiles()));
    }
}
