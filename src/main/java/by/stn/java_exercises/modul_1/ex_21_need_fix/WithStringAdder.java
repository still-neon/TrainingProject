package by.stn.java_exercises.modul_1.ex_21_need_fix;

/**
 * Created by EugenKrasotkin on 3/30/2018.
 */
public class WithStringAdder implements AdditionPerforming {

    @Override
    public void add(String string, long additions) {
        for (long i = 0; i < additions; i++) {
            string += string;
        }
    }
}