package by.stn.java_exercises.modul_1.ex_32_fixed;

import by.stn.java_exercises.modul_1.ex_31_fixed.FileNumbersListCreator;

import java.io.IOException;
import java.util.List;

/**
 * Created by EugenKrasotkin on 3/14/2018.
*/

public class ArithmeticalMeanFileNumbersCounter {
    public static int count(String filePath) throws IOException {
        List<Integer> numbersList = FileNumbersListCreator.create(filePath);
        int numbersSum = 0;
        for (int number : numbersList) {
            numbersSum += number;
        }
        return numbersSum / numbersList.size();
    }
}
