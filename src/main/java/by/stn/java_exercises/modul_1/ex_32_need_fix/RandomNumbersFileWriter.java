package by.stn.java_exercises.modul_1.ex_32_need_fix;

import by.stn.java_exercises.modul_1.ex_30_need_fix.FileManager;

/**
 * Created by EugenKrasotkin on 3/13/2018.
 */
public class RandomNumbersFileWriter {
    public static final String FILE_NAME = "text.txt";
    public static final String SEPARATOR = " ";
    private static final String PATH = System.getProperty("user.dir");
    private static final String FS = System.getProperty("file.separator");
    private static final String FILE_PATH = PATH + FS + "src" + FS + "main" + FS + "resources" + FS + FILE_NAME;

    public static void write(String filePath, int numbersAmount) {
        StringBuffer text = new StringBuffer();
        for (int i = 0; i < numbersAmount; i++) {
            text.append((int) (Math.random() * 15)).append(SEPARATOR);
        }
        FileManager.createFile(filePath, text.toString());
    }

    public static void main(String[] args) {
        write(FILE_PATH, 5);
        System.out.println("The collection of numbers is " + FileManager.readFile(FILE_PATH));
        System.out.println("The arithmetical mean of file numbers is " + ArithmeticalMeanFileNumbersCounter.count(FILE_PATH));
    }
}
