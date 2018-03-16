package by.stn.java_exercises.modul_1.ex_32;

import by.stn.java_exercises.modul_1.ex_31.FileNumbersSearcher;

import java.util.List;

/**
 * Created by EugenKrasotkin on 3/14/2018.
 */
public class ArithmeticalMeanFileNumbersCounter {
    public static int count(String filePath) {
        List<Integer> numbersList = FileNumbersSearcher.search(filePath);
        int numbersSum = 0;
        for (int number : numbersList) {
            numbersSum += number;
        }
        return numbersSum / numbersList.size();
    }
}
