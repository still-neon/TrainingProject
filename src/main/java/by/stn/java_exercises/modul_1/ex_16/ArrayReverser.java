package by.stn.java_exercises.modul_1.ex_16;

import java.util.Arrays;

public class ArrayReverser {
    public static int[] createRandomArray(int maxValue) {
        int randomArray[] = new int[(int) (Math.random() * maxValue)];

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (int) (Math.random() * maxValue);
        }
        return randomArray;
    }

    private static int[] reverse(int[] arr) {
        int temp;
        for (int i = 0; i < (arr.length / 2); i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] array = createRandomArray(10);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(reverse(array)));
    }
}