package by.stn.java_exercises.modul_1.ex_30_fixed;

import by.stn.java_exercises.modul_1.ex_18.PunctuationMarksCounter;

import java.io.IOException;
import java.util.Set;

/**
 * Created by EugenKrasotkin on 4/25/2018.
 */
public class PunctuationMarksInFileCounter {
    public static int count(String filePath, Set<Character> punctuationMarks) throws IOException {
        return PunctuationMarksCounter.count(filePath, punctuationMarks);
    }
}