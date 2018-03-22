package by.stn.java_exercises.modul_1.ex_13_fixed;

import by.stn.java_exercises.modul_1.ex_11_fixed.SimpleNumberDeterminant;

import java.util.ArrayList;
import java.util.List;

public class SimpleNumbersDeterminant {
    public static ArrayList<Integer> getSimpleNumbers(int limitNumber) {
        List<Integer> simpleNumbers = new ArrayList<>();
        for (int i = 1; i <= limitNumber; i++) {
            if (SimpleNumberDeterminant.determinate(i)) {
                simpleNumbers.add(i);
            }
        }
        return (ArrayList<Integer>) simpleNumbers;
    }

    public static void main(String[] args) {
        int limitNumber = 101;
        System.out.println("All simple numbers in the interval form 1 to " + limitNumber + " are " + getSimpleNumbers(limitNumber));
    }
}