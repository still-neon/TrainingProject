package by.stn.java_exercises.modul_1.ex_32;


import java.io.IOException;
import java.util.List;

/**
 * Created by EugenKrasotkin on 3/14/2018.
*/

public class ArithmeticalMeanFileNumbersCounter {
    public static double count(List<Integer> numbers) throws IOException {
        int numbersSum = 0;
        for (int number : numbers) {
            numbersSum += number;
        }
        return (double) numbersSum / numbers.size();
    }
}
