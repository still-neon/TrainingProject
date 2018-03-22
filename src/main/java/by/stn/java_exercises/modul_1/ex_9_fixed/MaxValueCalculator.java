package by.stn.java_exercises.modul_1.ex_9_fixed;

import java.util.ArrayList;

public class MaxValueCalculator {
    public static int calculate(ArrayList<Integer> numbers) {//отделть генератор чисел
        int maxNumber = 0;
        for (int i : numbers) {
            if (i > maxNumber) {
                maxNumber = i;
            }
        }
        return maxNumber;
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = NumbersGenerator.generateNumbersList(20);
        System.out.println("The max value of numbers " + numbers + " is " + calculate(numbers));
    }
}