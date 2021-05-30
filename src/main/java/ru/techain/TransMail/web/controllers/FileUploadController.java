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
			modelAndView.setViewName("letterCompose");

			File tempFile  = FileSaver.loadFile(file);
			System.out.println(FileSaver.loadStringFromTempFile(tempFile.getAbsolutePath()));
			LotTableParser parser = new RealLotableParser(new FileReader(tempFile, Charset.forName("CP1251")));

			Letter requestLetter = new RequestLetterBuilder()
					.addPrizes(parser.getMapPrizes())
					.build();

			File listTempFile = FileSaver.saveStringToTempFile(requestLetter.content);

			modelAndView.addObject("list", requestLetter.content.replace("\n", "<br/>"));
			modelAndView.addObject("listTempFile", listTempFile.getAbsolutePath());
			return modelAndView;
		} catch (IOException e) {
			modelAndView.setViewName("uploadError");
		}

		return modelAndView;
	}
}