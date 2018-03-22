package by.stn.java_exercises.modul_1.ex_9_fixed;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EugenKrasotkin on 3/20/2018.
 */
public class NumbersGenerator {
    public static ArrayList<Integer> generateNumbersList(int limitNumber) {
        List<Integer> numbers = new ArrayList<>();
        while (!numbers.contains(0)) {
            numbers.add((int) (Math.random() * limitNumber));
        }
        return (ArrayList<Integer>) numbers;
    }
}