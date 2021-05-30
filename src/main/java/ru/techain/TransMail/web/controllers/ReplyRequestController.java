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
import ru.techain.TransMail.file.FileSaver;

import javax.mail.MessagingException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

@RestController
public class ReplyRequestController {
    @RequestMapping(value = "/sendReply", method = RequestMethod.POST)
    public @ResponseBody
    String handleSendReply(@RequestParam("email") String email,
                           @RequestParam("password") String password,
                           @RequestParam("fileOrder")MultipartFile fileOrder,
                           @RequestParam("employeeInformation")MultipartFile employeeInformation) throws IOException {
       // FullLotTableParser parser = getTestTableParser();
        FullLotTableParser parser = new RealFullLotTableParser(new FileReader(FileSaver.loadFile(fileOrder), Charset.forName("CP1251")),
                new FileReader(FileSaver.loadFile(employeeInformation), Charset.forName("CP1251")));
        EmailSender sender = new EmailRepo();

        replyForSberbank(parser.getFinalEmployeesByProduct("Онлайн-подписка Сберпрайм (12 месяцев)"), email, password);

        List<FinalEmployee> iviEmployees = parser.getFinalEmployeesByProduct("Онлайн-подписка ivi.ru (12 месяцев)");
        List<FinalEmployee> litresEmployees = parser.getFinalEmployeesByProduct("1000 рублей на Литрес");
        List<FinalEmployee> dozhdEmployees = parser.getFinalEmployeesByProduct("Онлайн-подписка Дождь (12 месяцев)");

        List<Letter> iviLet = createLetters(iviEmployees, "iviGasjfkAgwklAsdj\n" +
                "ivibaskkdhAqaqqhkKa\n" +
                "iviXcvaaFdsfadsgjlOp\n" +
                "iviSdfksadvLksdfwers\n" +
                "iviJfdxnvaaqerospaxz", email, password);

        List<Letter> litersLet = createLetters(litresEmployees, "litresKikolfadsfczx\n" +
                "litresJsdaflqXzcASD", email, password);

        List<Letter> dozhdLet = createLetters(dozhdEmployees, "dozhdSopolasfksadfMxz",
                email, password);

        for (Letter each : iviLet) {
            try {
                sender.sendLetter(each);
            } catch (MessagingException ex) {
                ex.printStackTrace();
            }
        }
        for (Letter each : litersLet) {
            try {
                sender.sendLetter(each);
            } catch (MessagingException ex) {
                ex.printStackTrace();
            }
        }
        for (Letter each : dozhdLet) {
            try {
                sender.sendLetter(each);
            } catch (MessagingException ex) {
                ex.printStackTrace();
            }
        }

        return "success";
    }

    private FullLotTableParser getTestTableParser() throws IOException {
        FileReader ordersTable = new FileReader(new File("src/main/resources/static/mock/mock_lots.csv"), Charset.forName("CP1251")); // TODO
        FileReader employeesTable = new FileReader(new File("src/main/resources/static/mock/mock_employees.csv"), Charset.forName("CP1251")); // TODO

        return new RealFullLotTableParser(ordersTable, employeesTable);
    }

    private List<File> getPdfFiles() {
        return Arrays.asList(Objects.requireNonNull(new File("src/main/resources/static/pdf").listFiles()));
    }

    private void replyForSberbank(List<FinalEmployee> employees, String email, String password) {
        File pdfDirectory = new File("src/main/resources/static/pdf");
        List<File> files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(pdfDirectory.listFiles())));

        int i = 0;

        EmailSender sender = new EmailRepo();
        for (FinalEmployee e : employees) {
            LetterBuilder lb = new LetterBuilder();
            String str = String.format("Уважаемый %s, вас ожидает ваш подарок: %s",
                    e.getName() + " " + e.getPatronymic(), e.getNameProduct());
            String downStr = "Ваш Андрей Пьявкин";
            List<File> toSend = new ArrayList<>();
            for (int j = i; j - i < e.getCount(); j++) {
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
            } catch (MessagingException | IOException messagingException) {

            }
        }
    }


    static public List<Letter> createLetters(List<FinalEmployee> em, String codes, String fromEmail, String password) {
        int i = 0;
        List<Letter> toRet = new ArrayList<>();
        List<String> codess = Arrays.asList(codes.split("\n"));
        for (FinalEmployee e : em) {
            LetterBuilder lb = new LetterBuilder();
            String str = String.format("Уважаемый %s, вас ожидает ваш подарок: %s",
                    e.getName() + " " + e.getPatronymic(), e.getNameProduct());
            String downStr = "Ваш Андрей Пьявкин";
            StringBuilder content = new StringBuilder().append("\n");
            for (int j = i; j - i < e.getCount(); j++) {
                content.append(codess.get(j)).append("\n");
            }
            i += e.getCount();
            Letter letter = lb.setFromEmail(fromEmail)
                    .setPassword(password)
                    .setSubject("Ваш подарок!")
                    .setContent(str + "\n" + content.toString() + "\n" + downStr)
                    .setToEmail(e.getEmail())
                    .build();
            toRet.add(letter);
        }
        return toRet;
    }
}
