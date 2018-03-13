package by.stn.java_exercises.modul_1.ex_31;

import by.stn.java_exercises.modul_1.ex_30.FileManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EugenKrasotkin on 3/13/2018.
 */
public class FileNumbersSearcher {
    public static final String FILE_NAME = "text.txt";
    private static final String PATH = System.getProperty("user.dir");
    private static final String FS = System.getProperty("file.separator");
    private static final String FILE_PATH = PATH + FS + "src" + FS + "main" + FS + "resources" + FS + FILE_NAME;

    public static ArrayList<Integer> search(String filePath) {
        List<Integer> numbersList = new ArrayList<Integer>();
        int numberStartIndex;
        int numberFinishIndex;
        String text = FileManager.readFile(filePath).toString();

        text = text.trim().toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= '0' && text.charAt(i) <= '9') {
                numberStartIndex = i;
                for (int n = i; n < text.length(); n++) {
                    if (text.charAt(n) < '0' || text.charAt(n) > '9') {
                        numberFinishIndex = n;
                        numbersList.add(Integer.valueOf(text.substring(numberStartIndex, numberFinishIndex)));
                        i = numberFinishIndex;
                        break;
                    } else if (n == text.length() - 1) {
                        numbersList.add(Integer.valueOf(text.substring(numberStartIndex, text.length())));
                        return (ArrayList<Integer>) numbersList;
                    }
                }
            }
        }
        return (ArrayList<Integer>) numbersList;
    }

    public static void main(String[] args) {
        System.out.println("In the file there are numbers " + search(FILE_PATH));
    }
}