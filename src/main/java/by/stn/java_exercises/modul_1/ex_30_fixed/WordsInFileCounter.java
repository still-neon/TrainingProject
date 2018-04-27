package by.stn.java_exercises.modul_1.ex_30_fixed;

import by.stn.java_exercises.modul_1.ex_19.WordsCounter;

import java.io.IOException;

/**
 * Created by EugenKrasotkin on 3/12/2018.
 */
public class WordsInFileCounter {
    public static int count(String filePath) throws IOException {
        return WordsCounter.count(String.valueOf(FileManager.read(filePath)));
    }
}