package by.stn.java_exercises.modul_1.ex_6_fixed;

import lombok.Getter;

/**
 * Created by EugenKrasotkin on 3/15/2018.
 */
public class DateEditor {
    @Getter
    private int day;
    @Getter
    private int month;
    @Getter
    private int year;

    public DateEditor(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void incrementDay() {
        day++;
    }

    public void incrementMonth() {
        month++;
    }

    public void incrementYear() {
        year++;
    }

    public void resetDay() {
        day = 1;
    }

    public void resetMonth() {
        month = 1;
    }
}