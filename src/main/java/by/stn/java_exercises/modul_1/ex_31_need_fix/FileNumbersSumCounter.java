package by.stn.java_exercises.modul_1.ex_31_need_fix;

/**
 * Created by EugenKrasotkin on 3/13/2018.
 */
public class FileNumbersSumCounter {
    public static final String FILE_NAME = "text.txt";
    private static final String PATH = System.getProperty("user.dir");
    private static final String FS = System.getProperty("file.separator");
    private static final String FILE_PATH = PATH + FS + "src" + FS + "main" + FS + "resources" + FS + FILE_NAME;

    public static int count(String filePath) {
        int sum = 0;
        for (int number : FileNumbersSearcher.search(filePath)) {
            sum += number;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("The sum of all numbers in the file is " + count(FILE_PATH));
    }
}
