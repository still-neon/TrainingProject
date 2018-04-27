package by.stn.java_exercises.modul_1.ex_31_fixed;

import by.stn.java_exercises.modul_1.ex_19.TextNumbersSumCounter;
import by.stn.java_exercises.modul_1.ex_30_fixed.FileManager;

import java.io.IOException;
import java.util.List;

/**
 * Created by EugenKrasotkin on 3/13/2018.
 */
public class FileNumbersListCreator {
    public static List<Integer> create(String filePath) throws IOException {
        return TextNumbersSumCounter.getNumbers(String.valueOf(FileManager.read(filePath)));
    }
}