package by.stn.java_exercises.modul_1.ex_21_fixed;

/**
 * Created by EugenKrasotkin on 3/30/2018.
 */
public class WithStringAdder implements AdditionPerformig {
    @Override
    public void add(String string, long additionsNumber) {
        for (long i = 0; i < additionsNumber; i++) {
            string += string;
        }
    }
}