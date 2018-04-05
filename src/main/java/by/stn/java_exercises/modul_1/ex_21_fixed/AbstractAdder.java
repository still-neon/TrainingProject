package by.stn.java_exercises.modul_1.ex_21_fixed;

import lombok.Getter;

/**
 * Created by EugenKrasotkin on 4/3/2018.
 */
public class AbstractAdder {
    @Getter
    private String string;
    @Getter
    private long additions;

    public AbstractAdder(String string, long additions) {
        this.string = string;
        this.additions = additions;
    }
}