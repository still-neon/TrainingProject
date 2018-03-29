package by.stn.java_exercises.modul_1.ex_21_fixed;

/**
 * Created by EugenKrasotkin on 3/27/2018.
 */
public class TimeInterval {
    private double startTime;

    public TimeInterval() {
        startTime = System.currentTimeMillis();
    }

    public double getInterval() {
        return System.currentTimeMillis() - startTime;
    }
}
