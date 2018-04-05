package by.stn.java_exercises.modul_1.ex_21;

/**
 * Created by EugenKrasotkin on 3/30/2018.
 */
public class WithStringBuilderAdder extends AbstractAdder implements AdditionPerforming {

    public WithStringBuilderAdder(String string, long additions) {
        super(string, additions);
    }

    @Override
    public void add() {
        StringBuilder stringBuilder = new StringBuilder(getString());
        for (long i = 0; i < getAdditions(); i++) {
            stringBuilder.append(getString());
        }
    }
}