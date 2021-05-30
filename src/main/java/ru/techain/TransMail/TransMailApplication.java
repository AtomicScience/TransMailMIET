package ru.techain.TransMail;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.techain.TransMail.api.FullLotTableParser;
import ru.techain.TransMail.api.email.entities.Letter;
import ru.techain.TransMail.api.email.entities.LetterBuilder;
import ru.techain.TransMail.api.models.FinalEmployee;
import ru.techain.TransMail.api.table.RealFullLotTableParser;
import ru.techain.TransMail.web.controllers.FileUploadController;

import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class TransMailApplication {
    public static void main(String[] args) {
		SpringApplication.run(TransMailApplication.class, args);
//		File pdfDirectory = new File("src/main/resources/static/pdf");
//
//		FullLotTableParser parser = new RealFullLotTableParser();
//		List<File> files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(pdfDirectory.listFiles())));
//
//		List<FinalEmployee> employees = parser.getFinalEmployeesByProduct("Сберпрайм");
//		int i = 0;
//		for (FinalEmployee e: employees) {
//			LetterBuilder lb = new LetterBuilder();
//			String str = String.format("Уважаемый %s, вас ожидает ваш подарок: %s",
//					e.getName() + " " + e.getPatronymic(), e.getNameProduct());
//
//			if (e.getNameProduct().equals("Онлайн-подписка Сберпрайм (12 месяцев)"))
//
//			lb.setFromEmail("ENTERYOUTEMAIL@gmail.com")
//					.setPassword("ENTERYOURPASSWORD")
//					.setSubject("Ваш подарок!")
//					.setContent()
//					.setToEmail(e.getEmail());
//
//
//		}


    }

    @Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize(DataSize.of(128, DataUnit.KILOBYTES));
		factory.setMaxRequestSize(DataSize.of(128, DataUnit.KILOBYTES));
		return factory.createMultipartConfig();
	}

	@GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}
}