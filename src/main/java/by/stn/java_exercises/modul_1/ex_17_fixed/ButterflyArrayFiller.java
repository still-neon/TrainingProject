package by.stn.java_exercises.modul_1.ex_17_fixed;

import java.util.Arrays;

public class ButterflyArrayFiller {
    //входной параметр, разделение бабочки от создания, добавить условия с понятным смыслом

    private static int[][] fill(int[][] array) {
        for (int line = 0; line < array.length; line++) {
            for (int col = 0; col < array.length; col++) {
                if (isZero(line, col, array)) {
                    array[line][col] = 0;
                } else
                    array[line][col] = 1;
            }
        }
        return array;
    }

    private static boolean upToMiddle(int line, int[][] array) {
        return line < array.length / 2;
    }

    private static boolean isZero(int line, int col, int[][] array) {
        return upToMiddle(line, array) ? col < line || col >= array.length - line : col < array.length - 1 - line || col > line;
    }

    public static int[][] createArray(int size) {
        return new int[size][size];
    }

    public static void main(String[] args) {
        int[][] array = fill(createArray(5));
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
}