package by.stn.java_exercises.modul_1.ex_15_fixed;

import by.stn.java_exercises.modul_1.ex_9.MinMaxValueCalculator;
import by.stn.java_exercises.modul_1.ex_9.NumbersGenerator;

import java.util.*;

public class MinMaxIntervalFinder {
    //упростить длинную хуйню, Arrays.asList(MARKS) один раз, indexOf сложная операция
    public static int find(List<Integer> numbers) {
        int maxNumber = MinMaxValueCalculator.calculateMax(numbers);
        int minNumber = MinMaxValueCalculator.calculateMin(numbers);//добавить метод min в классе MaxValueCalc
        int sum = 0;

        Interval interval = getInterval(getEntryIndices(minNumber, numbers), getEntryIndices(maxNumber, numbers));

        for (int i = interval.getMinIndex() + 1; i < interval.getMaxIndex(); i++) {
            sum += numbers.get(i);
        }
        return sum;
    }

    private static List<Integer> getEntryIndices(int number, List<Integer> numbers) {
        List<Integer> indices = new ArrayList<>();//сортировать список методом sort
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == number) {
                indices.add(i);
            }
        }
        Collections.sort(indices);
        return indices;
    }

    private static Interval getInterval(List<Integer> number1Indices, List<Integer> number2Indices) {
        return getIndicesDifference(getFirstIndex(number1Indices), getLastIndex(number2Indices)) >=
                getIndicesDifference(getFirstIndex(number2Indices), getLastIndex(number1Indices)) ?
                new Interval(getFirstIndex(number1Indices), getLastIndex(number2Indices)) :
                new Interval(getFirstIndex(number2Indices), getLastIndex(number1Indices));
    }

    private static int getIndicesDifference(int index1, int index2) {//класс интервал, возвращать только два индекса
        return Math.abs(index1 - index2);//модуль Math
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