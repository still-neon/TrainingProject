package by.stn.trainingproject.combinationcounter;

public class ReverseValueComparator {
    private static final int TEN = 10;
    public static boolean compare(int h, int m) {
        int counter = 0;
        int minReversed = m;
        int minTmp = m;

        while (minReversed != 0) {
            minReversed /= TEN;
            counter++;
        }

        for (int i = 0; i < counter; counter--) {
            minReversed += minTmp % TEN * (int) Math.pow(TEN, counter - 1);
            minTmp /= TEN;
        }
        if (m < TEN) minReversed *= TEN;
        return h == minReversed;
    }
}