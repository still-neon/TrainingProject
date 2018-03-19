package by.stn.java_exercises.modul_1.ex_6_fixed;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eugen Fasenda on 18.03.2018.
 */
public enum MonthGroup {
    MONTH_GROUP_1(true, 28),
    MONTH_GROUP_2(false, 30),
    MONTH_GROUP_3(false, 31);

    private static final Map<Integer, MonthGroup> MONTHS = new HashMap<Integer, MonthGroup>() {
        {
            put(1, MONTH_GROUP_3);
            put(2, MONTH_GROUP_1);
            put(3, MONTH_GROUP_3);
            put(4, MONTH_GROUP_2);
            put(5, MONTH_GROUP_3);
            put(6, MONTH_GROUP_2);
            put(7, MONTH_GROUP_3);
            put(8, MONTH_GROUP_3);
            put(9, MONTH_GROUP_2);
            put(10, MONTH_GROUP_3);
            put(11, MONTH_GROUP_2);
            put(12, MONTH_GROUP_3);
        }
    };
    @Getter
    private static final int LAST_MONTH_INDEX = MONTHS.size();
    @Getter
    private boolean modifiedByLeapYear;
    @Getter
    private int days;

    MonthGroup(boolean leapYearInfluence, int days) {
        this.modifiedByLeapYear = leapYearInfluence;
        this.days = days;
    }

    public int checkDaysNumber(boolean isLeapYear) {
        return isLeapYear && isModifiedByLeapYear() ? days + 1 : days;
    }

    public boolean isNotLastDay(int day, boolean isLeapYear) {
        return day < checkDaysNumber(isLeapYear);
    }

    public boolean isLastMonth(int month) {
        return month == LAST_MONTH_INDEX;
    }

    public static MonthGroup of(int month) {
        return MONTHS.get(month);
    }
}