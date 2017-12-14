package by.stn.trainingproject.combinationcounter;

public class ReverseValueComparator {
    public static boolean compare(int h, int m) {
        int counter = 0;
        int minReversed = m;
        int minTmp = m;

        while (minReversed != 0) {
            minReversed /= 10;
            counter++;
        }

        for (int i = 0; i < counter; counter--) {
            minReversed += minTmp % 10 * (int) Math.pow(10, counter - 1);
            minTmp /= 10;
        }
        if (m < 10) minReversed *= 10;
        return h == minReversed;
    }
}