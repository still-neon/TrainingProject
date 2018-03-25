package by.stn.java_exercises.modul_1.ex_14_need_fix;

import java.util.Arrays;

public class MaxMarkIndexDeterminant {
    private static final int MARKS[] = {5, 7, 3, 9, 11, 1, 8, 5, 8, 4, 1, 15, 5, 8};//входные параметры, -1,

    public static void main(String[] args) {
        System.out.print(determinate());
    }

    private static int determinate() {
        int maxMark = MARKS[0];
        for (int m : MARKS) {
            if (maxMark < m) {
                maxMark = m;
            }
        }
        return Arrays.asList(MARKS).indexOf(maxMark);
    }
}