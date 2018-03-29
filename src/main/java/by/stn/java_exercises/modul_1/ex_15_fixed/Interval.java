package by.stn.java_exercises.modul_1.ex_15_fixed;

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
}