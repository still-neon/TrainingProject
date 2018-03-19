package by.stn.java_exercises.modul_1.ex_6_fixed;

import lombok.Getter;

/**
 * Created by EugenKrasotkin on 3/15/2018.
 */
public class CustomDate {
    @Getter
    private int day;
    @Getter
    private int month;
    @Getter
    private int year;
    @Getter
    private MonthGroup monthGroup;
    private static final int LEAP_YEAR_DIVISOR = 4;

    public CustomDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.monthGroup = MonthGroup.of(month);
    }

    public void nextDay() {
        if (monthGroup.isNotLastDay(day, isLeapYear())) {
            day++;
        } else if (monthGroup.isLastMonth(month)) {
            resetDay();
            resetMonth();
            year++;
        } else {
            resetDay();
            month++;
        }
    }

    public boolean isLeapYear() {
        return year % LEAP_YEAR_DIVISOR == 0;
    }

    private void resetDay() {
        day = 1;
    }

    private void resetMonth() {
        month = 1;
    }
}