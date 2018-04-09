package by.stn.java_exercises.modul_1.ex_27_fixed;

import java.util.*;

public class RandomNumbersCollectionCreator {
    public static List<Integer> create(int numbersAmount, int max) {
        List<Integer> numbers = new ArrayList<>();//переделать листом, задание
        for (int i = 0; i < numbersAmount; i++) {
            numbers.add((int) (Math.random() * max));
        }
        return numbers;
    }

    public static void main(String[] args) {
        System.out.print("The collection of unique numbers is " + DuplicateRemover.remove(create(20, 10)));
    }
}