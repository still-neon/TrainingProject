package by.stn.java_exercises.modul_1.ex_6_fixed;

import lombok.Getter;

/**
 * Created by EugenKrasotkin on 3/6/2018.
 */
public class DayShifter {
    @Getter
    private CustomDate dateEditor;

    public DayShifter(CustomDate dateEditor) {
        this.dateEditor = dateEditor;
    }

    public void shift(int times) {
        DateValidator.validate(dateEditor);
        for (int i = 0; i < times; i++) {
            dateEditor.nextDay();
        }
    }
}