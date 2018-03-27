package by.stn.java_exercises.modul_1.ex_14;

import by.stn.java_exercises.modul_1.ex_9.MaxValueCalculator;
import by.stn.java_exercises.modul_1.ex_9.NumbersGenerator;

import java.util.List;

public class MaxMarkIndexDeterminant {
    public static int determine(List<Integer> marks) {
        return marks.indexOf(MaxValueCalculator.calculate(marks));
    }

    public static void main(String[] args) {
        List<Integer> marks = NumbersGenerator.generateNumbersList(10);
        System.out.print("The first max mark index of " + marks + " is " + determine(marks));
    }
}