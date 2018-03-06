package java_exercises.modul_1.ex_15;

import java.util.Arrays;

public class ArrayElementsSumCalculator {
    private static final Integer MARKS[] = {2, 7, 3, 11, 3, 3, 8, 5, 10, 4};

    public static void main(String[] args) {
        System.out.println(calculate());
    }

    private static int calculate() {
        int maxMark = MARKS[0];
        int minMark = MARKS[0];
        int sum = 0;
        for (int m : MARKS) {
            if (maxMark < m) {
                maxMark = m;
            }
            if (minMark > m) {
                minMark = m;
            }
        }
        for (int i = Math.min(Arrays.asList(MARKS).indexOf(minMark), Arrays.asList(MARKS).indexOf(maxMark)) + 1; i < Math.max(Arrays.asList(MARKS).indexOf(minMark), Arrays.asList(MARKS).indexOf(maxMark)); i++) {
            sum += MARKS[i];
        }
        return sum;
    }
}