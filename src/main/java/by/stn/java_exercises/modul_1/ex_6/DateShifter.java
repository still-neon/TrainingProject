package by.stn.java_exercises.modul_1.ex_6;

import lombok.Getter;

/**
 * Created by EugenKrasotkin on 3/6/2018.
 */
public class DateShifter {
    @Getter
    private CustomDate dateEditor;

    public DateShifter(CustomDate dateEditor) {
        this.dateEditor = dateEditor;
    }

    public void shift(int times) {
        for (int i = 0; i < times; i++) {
            dateEditor.nextDay();
        }
    }
}