package java_exercises.modul_1.ex_17;

import java.util.Arrays;

public class ButterflyArrayCreator {
    private static final int ARRAY_SIZE = 5;

    public static void main(String[] args) {
        int[][] arr = create();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    private static int[][] create() {
        int butterfly[][] = new int[ARRAY_SIZE][ARRAY_SIZE];

        for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = 0; j < ARRAY_SIZE; j++) {
                if (((i < ARRAY_SIZE / 2) && (j < i || j >= ARRAY_SIZE - i)) || ((i >= ARRAY_SIZE / 2) && (j < ARRAY_SIZE - 1 - i || j > i))) {
                    butterfly[i][j] = 0;
                } else
                    butterfly[i][j] = 1;
            }
        }
        return butterfly;
    }
}