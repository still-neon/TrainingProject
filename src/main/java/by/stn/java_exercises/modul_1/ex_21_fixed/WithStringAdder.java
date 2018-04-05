package by.stn.java_exercises.modul_1.ex_21_fixed;

/**
 * Created by EugenKrasotkin on 3/30/2018.
 */
public class WithStringAdder extends AbstractAdder implements AdditionPerforming {
    public WithStringAdder(String string, long additions) {
        super(string, additions);
    }

    @Override
    public void add() {
        String string = "";
        for (long i = 0; i < getAdditions(); i++) {
            string += getString();
        }
    }
}