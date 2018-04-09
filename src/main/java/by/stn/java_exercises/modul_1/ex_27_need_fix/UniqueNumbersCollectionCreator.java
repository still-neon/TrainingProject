package by.stn.java_exercises.modul_1.ex_27_need_fix;

import java.util.*;

public class UniqueNumbersCollectionCreator {
    public static List<Integer> create(int numbersAmount) {
        List<Integer> numbers = new ArrayList<>();//переделать листом, задание
        for (int i = 0; i < numbersAmount; i++) {
            numbers.add((int) (Math.random() * 15));
        }
        return numbers;
    }

    public static void main(String[] args) {
        System.out.print("The collection of unique numbers is " + create(10));
    }
}