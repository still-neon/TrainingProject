package by.stn.java_exercises.modul_1.ex_31;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by EugenKrasotkin on 3/13/2018.
 */
public class FileNumbersSetCreator {
    public static final String FILE_NAME = "text.txt";
    private static final String PATH = System.getProperty("user.dir");
    private static final String FS = System.getProperty("file.separator");
    private static final String FILE_PATH = PATH + FS + "src" + FS + "main" + FS + "resources" + FS + FILE_NAME;

    public static HashSet<Integer> create(String filePath) {
        Set<Integer> numbers = new HashSet<Integer>();
        for (int number : FileNumbersSearcher.search(filePath)) {
            numbers.add(number);
        }
        return (HashSet<Integer>) numbers;
    }

    public static void main(String[] args) {
        System.out.print("The set of numbers of the file is " + create(FILE_PATH));
    }
}