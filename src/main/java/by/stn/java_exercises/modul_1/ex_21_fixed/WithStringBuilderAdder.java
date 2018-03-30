package by.stn.java_exercises.modul_1.ex_21_fixed;

/**
 * Created by EugenKrasotkin on 3/30/2018.
 */
public class WithStringBuilderAdder implements AdditionPerformig {
    @Override
    public void add(String string, long additionsNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        for (long i = 0; i < additionsNumber; i++) {
            stringBuilder.append(string);
        }
    }
}