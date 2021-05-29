package ru.techain.TransMail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TransMailApplication {
    public static void main(String[] args) {
		SpringApplication.run(TransMailApplication.class, args);
//        Letter letter = new LetterBuilder().addAttachment(new File("C:\\Users\\HASEE\\Desktop\\sample.pdf"))
//                .addAttachment(new File("C:\\Users\\HASEE\\Desktop\\sample1.pdf"))
//                .setContent("Test")
//                .setFromEmail(EmailConsts.PODSATAVA007_YANDEX)
//                .setPassword(EmailConsts.PODSATAVA007_YANDEX_PASSWORD)
//                .setToEmail(EmailConsts.VERRIGOOFF_GMAIL)
//                .setSubject("Test for attachments")
//                .build();
//        try {
//            new EmailRepo().sendLetter(letter);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}