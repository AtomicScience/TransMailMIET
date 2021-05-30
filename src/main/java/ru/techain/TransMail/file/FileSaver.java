package ru.techain.TransMail.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

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

    public static File saveStringToTempFile(String content) throws IOException {
        File tempFile = File.createTempFile("file-", "-uploaded");

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile)));
        writer.write(content);
        writer.close();

        return tempFile;
    }

    public static String loadStringFromTempFile(String filename) throws IOException {
        File tempFile = new File(filename);

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(tempFile)));

        StringBuilder builder = new StringBuilder();

        while(reader.ready()) {
            builder.append(reader.readLine()).append("\n");
        }

        return builder.toString();
    }
}
