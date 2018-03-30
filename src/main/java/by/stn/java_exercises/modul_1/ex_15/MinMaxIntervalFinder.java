package by.stn.java_exercises.modul_1.ex_15;

import by.stn.java_exercises.modul_1.ex_9.MinMaxValueCalculator;
import by.stn.java_exercises.modul_1.ex_9.NumbersGenerator;

import java.util.*;

public class MinMaxIntervalFinder {
    public static int find(List<Integer> numbers) {
        int max = MinMaxValueCalculator.calculateMax(numbers);
        int min = MinMaxValueCalculator.calculateMin(numbers);
        int sum = 0;


        Interval interval = getInterval(getIndices(numbers, min), getIndices(numbers, max));

        for (int i = interval.getMinIndex() + 1; i < interval.getMaxIndex(); i++) {
            sum += numbers.get(i);
        }
        return sum;
    }

    private static List<Integer> getIndices(List<Integer> numbers, int number) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == number) {
                indices.add(i);
            }
        }
        return indices;
    }

    private static Interval getInterval(List<Integer> number1Indices, List<Integer> number2Indices) {
        Interval interval1 = new Interval(getFirstIndex(number1Indices), getLastIndex(number2Indices));
        Interval interval2 = new Interval(getFirstIndex(number2Indices), getLastIndex(number1Indices));
        return Interval.max(interval1, interval2);
    }

    private static int getLastIndex(List<Integer> indexes) {
        return indexes.get(indexes.size() - 1);
    }

    private static int getFirstIndex(List<Integer> indexes) {
        return indexes.get(0);
    }

    public static void main(String[] args) {
        List<Integer> numbers = NumbersGenerator.generateNumbersList(8);
        System.out.print("The sum of elements between min and max of " + numbers + " is " + find(numbers));
    }
}