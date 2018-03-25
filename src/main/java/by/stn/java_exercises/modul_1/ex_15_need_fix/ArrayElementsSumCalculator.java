package by.stn.java_exercises.modul_1.ex_15_need_fix;

import java.util.Arrays;

public class ArrayElementsSumCalculator {
    private static final int MARKS[] = {2, 7, 3, 11, 3, 3, 8, 5, 10, 4};//входные параметры, упростить длинную хуйню, Arrays.asList(MARKS) один раз, indexOf сложная операция

    public static void main(String[] args) {
        System.out.println(calculate());
    }

    private static int calculate() {
        int maxMark = MARKS[0];
        int minMark = MARKS[0];
        int sum = 0;
        for (int mark : MARKS) {
            if (maxMark < mark) {
                maxMark = mark;
            }
            if (minMark > mark) {
                minMark = mark;
            }
        }
        for (int i = Math.min(Arrays.asList(MARKS).indexOf(minMark), Arrays.asList(MARKS).indexOf(maxMark)) + 1; i < Math.max(Arrays.asList(MARKS).indexOf(minMark), Arrays.asList(MARKS).indexOf(maxMark)); i++) {
            sum += MARKS[i];
        }
        return sum;
    }
}