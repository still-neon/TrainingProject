package by.stn.java_exercises.modul_1.ex_30;

import java.io.*;

/**
 * Created by EugenKrasotkin on 3/12/2018.
 */
public class FileManager {
    private static File file;

    public static void create(String filePath) throws IOException {
        file = new File(filePath);
        file.createNewFile();
    }

    public static void write(String filePath, String text) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        bufferedWriter.write(text);
        bufferedWriter.close();
    }

    public static String read(String filePath) throws IOException {
        StringBuffer fileText = new StringBuffer();
        String fileString;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        while ((fileString = bufferedReader.readLine()) != null) {
            fileText.append(fileString);
        }
        bufferedReader.close();
        return fileText.toString();
    }
}