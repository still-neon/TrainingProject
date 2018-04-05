package by.stn.java_exercises.modul_1.ex_27_need_fix;

import java.util.*;

public class UniqueNumbersCollectionCreator {
    public static Set<Integer> create(int numbersAmount) {
        Set<Integer> numbers = new HashSet<Integer>();//переделать листом, задание
        for (int i = 0; i < numbersAmount; i++) {
            numbers.add((int) (Math.random() * 15));
        }
        return (HashSet<Integer>) numbers;
    }

    public static void main(String[] args) {
        System.out.print("The collection of unique numbers is " + create(10));
    }
}