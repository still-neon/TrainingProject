package by.stn.java_exercises.modul_1.ex_21_fixed;

/**
 * Created by EugenKrasotkin on 3/27/2018.
 */
public class TimeInterval {
    private static double startTime;

    public static double getInterval(AdditionPerforming adder) {
        startTime = System.currentTimeMillis();
        adder.add();
        return System.currentTimeMillis() - startTime;
    }
}