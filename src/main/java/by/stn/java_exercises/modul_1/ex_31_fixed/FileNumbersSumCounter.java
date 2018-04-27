package by.stn.java_exercises.modul_1.ex_31_fixed;

import by.stn.java_exercises.modul_1.ex_19.TextNumbersSumCounter;
import by.stn.java_exercises.modul_1.ex_30_fixed.FileManager;

import java.io.IOException;

/**
 * Created by EugenKrasotkin on 3/13/2018.
 */
public class FileNumbersSumCounter {
    public static int count(String filePath) throws IOException {
        return TextNumbersSumCounter.count(String.valueOf(FileManager.read(filePath)));
    }
}