package by.stn.java_exercises.modul_1.ex_9;

import java.util.List;

public class MinMaxValueCalculator {
    public static int calculateMax(List<Integer> numbers) {
        int maxNumber = -1;
        for (int number : numbers) {
            if (number > maxNumber) {
                maxNumber = number;
            }
        }
        return maxNumber;
    }

    public static int calculateMin(List<Integer> numbers) {
        int minNumber = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number < minNumber) {
                minNumber = number;
            }
        }
        return minNumber;
    }

    public static void main(String[] args) {
        List<Integer> numbers = NumbersGenerator.generateNumbersList(20);//пакет Util, class RNG генераторы массивов и чего угодно
        System.out.println("The max value of numbers " + numbers + " is " + calculateMax(numbers));
    }
}