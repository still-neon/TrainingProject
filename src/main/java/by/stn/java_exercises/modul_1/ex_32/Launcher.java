package by.stn.java_exercises.modul_1.ex_32;

import by.stn.java_exercises.modul_1.ex_19.TextNumbersSumCounter;
import by.stn.java_exercises.modul_1.ex_27.RandomNumbersCollectionCreator;
import by.stn.java_exercises.modul_1.ex_30.FileManager;

import java.io.IOException;
import java.util.List;

/**
 * Created by EugenKrasotkin on 4/25/2018.
 */
public class Launcher {
	public static final String FILE_NAME = "data_sets/text.txt";
    private static final String PATH = System.getProperty("user.dir");
    private static final String FS = System.getProperty("file.separator");
    private static final String FILE_PATH = PATH + FS + "src" + FS + "main" + FS + "resources" + FS + FILE_NAME;

    public static void main(String[] args) {
        try {
            FileManager.create(FILE_PATH);
            FileManager.write(FILE_PATH,String.valueOf(RandomNumbersCollectionCreator.create(5,26)));
            System.out.println("The file data is " + FileManager.read(FILE_PATH));
            List<Integer> numbers = TextNumbersSumCounter.getNumbers(String.valueOf(FileManager.read(FILE_PATH)));
            System.out.println("The file number arithmetical mean is " + ArithmeticalMeanFileNumbersCounter.count(numbers));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}