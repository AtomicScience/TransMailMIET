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
import ru.techain.TransMail.api.email.entities.Letter;
import ru.techain.TransMail.api.email.entities.RequestLetterBuilder;
import ru.techain.TransMail.api.table.RealLotableParser;
import ru.techain.TransMail.file.FileSaver;

@RestController
public class FileUploadController {
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public @ResponseBody
	ModelAndView handleFileUpload(@RequestParam("file") MultipartFile file) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			System.out.println("Gotcha!");
			modelAndView.setViewName("letterCompose");

			File tempFile  = FileSaver.loadFile(file);
			LotTableParser parser = new RealLotableParser(new FileReader(tempFile, StandardCharsets.UTF_8));

			Letter requestLetter = new RequestLetterBuilder()
					.addPrefix("Николай, здравствуйте!")
					.addPrizes(parser.getMapPrizes())
					.addSuffix("До свидания!")
					.build();

			modelAndView.addObject("list", requestLetter.content);
			return modelAndView;
		} catch (IOException e) {
			modelAndView.setViewName("uploadError");
		}

		return modelAndView;
	}
}