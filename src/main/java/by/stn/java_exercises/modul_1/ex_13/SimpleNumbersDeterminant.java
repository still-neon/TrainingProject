package by.stn.java_exercises.modul_1.ex_13;

import by.stn.java_exercises.modul_1.ex_11.SimpleNumberDeterminant;

import java.util.ArrayList;
import java.util.List;

public class SimpleNumbersDeterminant {
    public static List<Integer> getSimpleNumbers(int maxNumber) {
        List<Integer> simpleNumbers = new ArrayList<>();
        for (int i = 1; i <= maxNumber; i++) {
            if (SimpleNumberDeterminant.determine(i)) {
                simpleNumbers.add(i);
            }
        }
        return simpleNumbers;
    }

    public static void main(String[] args) {
        int limitNumber = 101;
        System.out.println("All simple numbers in the interval form 1 to " + limitNumber + " are " + getSimpleNumbers(limitNumber));
    }
}