package by.stn.java_exercises.modul_1.ex_30;

import by.stn.java_exercises.modul_1.ex_18_need_fix.PunctuationMarksCounter;
import by.stn.java_exercises.modul_1.ex_19_need_fix.WordsCounter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by EugenKrasotkin on 3/12/2018.
 */
public class FilePunctuationMarksAndWordsCounter {
    public static final String FILE_NAME = "text.txt";
    public static final String FIRST_COUNTER = " punctuation marks";
    public static final String SECOND_COUNTER = " words";
    private static final String PATH = System.getProperty("user.dir");
    private static final String FS = System.getProperty("file.separator");
    private static final String FILE_PATH = PATH + FS + "src" + FS + "main" + FS + "resources" + FS + FILE_NAME;

    public static HashMap<String, Integer> count(String filePath) {
        Map<String,Integer> countValues = new HashMap<>();
        countValues.put(FIRST_COUNTER,PunctuationMarksCounter.count(FileManager.readFile(filePath).toString()));
        countValues.put(SECOND_COUNTER,WordsCounter.count(FileManager.readFile(filePath).toString()));
        return (HashMap<String, Integer>) countValues;
    }

    public static void main(String[] args) {
        String text = "How can there be an 'N/A' as a billing type when that is a required decision in the contract record? Or is this SO/LO's?";
        FileManager.createFile(FILE_PATH, text);
        System.out.println("In the text there are " + count(FILE_PATH).get(FIRST_COUNTER) + FIRST_COUNTER + " and " + count(FILE_PATH).get(SECOND_COUNTER) + SECOND_COUNTER);
    }
}