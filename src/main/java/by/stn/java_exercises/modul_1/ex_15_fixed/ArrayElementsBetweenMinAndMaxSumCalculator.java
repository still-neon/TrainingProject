package by.stn.java_exercises.modul_1.ex_15_fixed;

import by.stn.java_exercises.modul_1.ex_9.MaxValueCalculator;
import by.stn.java_exercises.modul_1.ex_9.NumbersGenerator;

import java.util.*;

public class ArrayElementsBetweenMinAndMaxSumCalculator {
    //входные параметры, упростить длинную хуйню, Arrays.asList(MARKS) один раз, indexOf сложная операция
    public static int calculate(List<Integer> numbers) {
        int maxNumber = MaxValueCalculator.calculate(numbers);
        int minNumber = numbers.get(0);
        int sum = 0;

        for (int number : numbers) {
            if (minNumber > number) {
                minNumber = number;
            }
        }

        for (int elementIndex : getElementsIndices(getNumberIndices(minNumber, numbers), getNumberIndices(maxNumber, numbers))) {
            sum += numbers.get(elementIndex);
        }
        return sum;
    }

    private static List<Integer> getNumberIndices(int number, List<Integer> numbers) {
        Set<Integer> indices = new TreeSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == number) {
                indices.add(i);
            }
        }
        return new ArrayList<>(indices);
    }

    private static List<Integer> getElementsIndices(List<Integer> number1Indices, List<Integer> number2Indices) {
        return getIndicesDifference(getFirstIndex(number1Indices), getLastIndex(number2Indices)) >=
                getIndicesDifference(getFirstIndex(number2Indices), getLastIndex(number1Indices)) ?
                getIndexes(getFirstIndex(number1Indices), getLastIndex(number2Indices)) :
                getIndexes(getFirstIndex(number2Indices), getLastIndex(number1Indices));
    }

    private static int getIndicesDifference(int index1, int index2) {
        return Math.max(index1, index2) - Math.min(index1, index2);
    }

    private static List<Integer> getIndexes(int index1, int index2) {
        List<Integer> elementsIndexes = new ArrayList<>();
        for (int i = Math.min(index1, index2) + 1; i < Math.max(index1, index2); i++) {
            elementsIndexes.add(i);
        }
        return elementsIndexes;
    }

    private static int getLastIndex(List<Integer> indexes) {
        return indexes.get(indexes.size() - 1);
    }

    private static int getFirstIndex(List<Integer> indexes) {
        return indexes.get(0);
    }

    public static void main(String[] args) {
        List<Integer> numbers = NumbersGenerator.generateNumbersList(5);
        System.out.print("The sum of elements between min and max of " + numbers + " is " + calculate(numbers));
    }
}