package by.stn.java_exercises.modul_1.ex_32_fixed;

import by.stn.java_exercises.modul_1.ex_27.RandomNumbersCollectionCreator;
import by.stn.java_exercises.modul_1.ex_30_fixed.FileManager;
import by.stn.java_exercises.modul_1.ex_30_fixed.FileWithDataCreator;

import java.io.IOException;

/**
 * Created by EugenKrasotkin on 4/25/2018.
 */
public class Launcher {
    public static final String FILE_NAME = "text.txt";
    private static final String PATH = System.getProperty("user.dir");
    private static final String FS = System.getProperty("file.separator");
    private static final String FILE_PATH = PATH + FS + "src" + FS + "main" + FS + "resources" + FS + FILE_NAME;

    public static void main(String[] args) {
        try {
            FileWithDataCreator.create(FILE_PATH, String.valueOf(RandomNumbersCollectionCreator.create(5,6)));
            System.out.println("The file data is " + FileManager.read(FILE_PATH));
            System.out.println("The file number arithmetical mean is " + ArithmeticalMeanFileNumbersCounter.count(FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}