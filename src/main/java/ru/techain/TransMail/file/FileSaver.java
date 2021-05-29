package ru.techain.TransMail.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileSaver {
    public static File loadFile(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            File tempFile = File.createTempFile("file-", "-uploaded");

            byte[] bytes = file.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(tempFile));

            stream.write(bytes);
            stream.close();

            return tempFile;
        } else {
            throw new IOException("File is empty");
        }
    }
}
