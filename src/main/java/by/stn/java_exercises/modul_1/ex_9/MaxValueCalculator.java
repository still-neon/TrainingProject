package by.stn.java_exercises.modul_1.ex_9;

import java.util.List;

public class MaxValueCalculator {
    public static int calculate(List<Integer> numbers) {
        int maxNumber = -1;
        for (int i : numbers) {
            if (i > maxNumber) {
                maxNumber = i;
            }
        }
        return maxNumber;
    }

    public static void main(String[] args) {
        List<Integer> numbers = NumbersGenerator.generateNumbersList(20);
        System.out.println("The max value of numbers " + numbers + " is " + calculate(numbers));
    }
}