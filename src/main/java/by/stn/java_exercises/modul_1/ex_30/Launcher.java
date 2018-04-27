package by.stn.java_exercises.modul_1.ex_30;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by EugenKrasotkin on 4/25/2018.
 */
public class Launcher {
    public static final String FILE_NAME = "text.txt";
    private static final String PATH = System.getProperty("user.dir");
    private static final String FS = System.getProperty("file.separator");
    private static final String FILE_PATH = PATH + FS + "src" + FS + "main" + FS + "resources" + FS + FILE_NAME;

    public static void main(String[] args) {
        String text = "How can there be an 'N/A' as a billing type when that is a required decision in the contract record? Or is this SO/LO's?";
        Set<Character> punctuationMarks = new HashSet<>(Arrays.asList('.','!','?','-',':',';','(',')','/'));

        try {
            FileManager.create(FILE_PATH);
            FileManager.write(FILE_PATH,text);
            System.out.println("In the file there are " + WordsInFileCounter.count(FILE_PATH) + " words and " + PunctuationMarksInFileCounter.count(FILE_PATH, punctuationMarks) + " punctuation marks");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}