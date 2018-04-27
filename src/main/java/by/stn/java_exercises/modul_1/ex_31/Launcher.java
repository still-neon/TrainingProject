package by.stn.java_exercises.modul_1.ex_31;

import by.stn.java_exercises.modul_1.ex_19.TextNumbersSumCounter;
import by.stn.java_exercises.modul_1.ex_30.FileManager;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

/**
 * Created by EugenKrasotkin on 4/25/2018.
 */
public class Launcher {
    public static final String FILE_NAME = "text.txt";
    private static final String PATH = System.getProperty("user.dir");
    private static final String FS = System.getProperty("file.separator");
    private static final String FILE_PATH = PATH + FS + "src" + FS + "main" + FS + "resources" + FS + FILE_NAME;

    public static void main(String[] args) {
        String text = "2 How can 1 there be an 'N/A' as a billing 23 type 2 when that is a 1 required 4 decision in the contract record? Or is this 5 SO/LO's? 7";

        try {
            FileManager.create(FILE_PATH);
            FileManager.write(FILE_PATH,text);
            String data = FileManager.read(FILE_PATH);
            List<Integer> numbers = TextNumbersSumCounter.getNumbers(data);
            System.out.println("The numbers of the file are " + numbers);
            System.out.println("The sum of all numbers in the file is " + TextNumbersSumCounter.count(data));
            System.out.println("The unique numbers of the file are " + new HashSet<>(numbers));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}