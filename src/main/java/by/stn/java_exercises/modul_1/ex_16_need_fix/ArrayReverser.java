package by.stn.java_exercises.modul_1.ex_16_need_fix;

import java.util.Arrays;

public class ArrayReverser {
    public static void main(String[] args) {
        int[] array = createRandomArray();
        System.out.println(Arrays.toString(array));

        System.out.println(Arrays.toString(reverse(array)));
    }

    private static int[] createRandomArray() {
        int randomArray[] = new int[(int) (Math.random() * 10)];//входной параметр

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (int) (Math.random() * 10);
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
}