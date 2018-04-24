package by.stn.java_exercises.modul_1.ex_30_need_fix;

import java.io.*;

/**
 * Created by EugenKrasotkin on 3/12/2018.
 */
public class FileManager {
    private static File file;

    public static void createFile(String filePath, String text) {//вывести эксепшен на высокий уровень
        file = new File(filePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StringBuffer readFile(String filePath) {
        file = new File(filePath);
        StringBuffer fileText = new StringBuffer();
        String fileString;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while ((fileString = bufferedReader.readLine()) != null) {
                fileText.append(fileString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileText;
    }
}