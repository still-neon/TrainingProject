package by.stn.java_exercises.modul_1.ex_15_need_fix;

import lombok.Getter;

/**
 * Created by EugenKrasotkin on 3/27/2018.
 */
public class Interval {
    @Getter
    private int minIndex;
    @Getter
    private int maxIndex;

    public Interval(int index1, int index2) {
        minIndex = Math.min(index1, index2);
        maxIndex = Math.max(index1, index2);
    }

    public int size() {
        return maxIndex - minIndex;
    }

    public static Interval max(Interval interval1, Interval interval2) {
        return interval1.size() >= interval2.size() ? interval1 : interval2;
    }
}