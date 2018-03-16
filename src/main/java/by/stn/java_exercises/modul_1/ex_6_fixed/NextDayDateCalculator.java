package by.stn.java_exercises.modul_1.ex_6_fixed;

import lombok.Getter;

import java.util.*;

import static by.stn.java_exercises.modul_1.ex_6_fixed.NextDayDateCalculator.MonthGroup.*;


/**
 * Created by EugenKrasotkin on 3/6/2018.
 */
public class NextDayDateCalculator {
    private final Map<Integer, MonthGroup> MONTHS = new LinkedHashMap<Integer, MonthGroup>() {
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
    //HashMap вместо сетов, номер месяца - константа енума
    private static final int[] DAYS_IN_MONTH = {29, 28, 30, 31};
    private static final int LEAP_YEAR_INDEX = 4;
    private static final int LAST_MONTH_INDEX = 12;
    private static DateEditor dateEditor;

    public void shift(DateEditor dateEditor, int times) {
        this.dateEditor = dateEditor;
        invalidDateCheck();
        //сделать полями другого класса Date(представление в системе 3-х интов), в getNextDay передавать объект
        for (int i = 0; i < times; i++) {
            getNextDay();
        }
    }

    private void getNextDay() {
        if (lessThanLastDayCheck()) {
            dateEditor.incrementDay();
        } else if (lastMonthCheck()) {
            dateEditor.resetDay();
            dateEditor.resetMonth();
            dateEditor.incrementYear();
        } else {
            dateEditor.resetDay();
            dateEditor.incrementMonth();
        }
    }

    private void invalidDateCheck() {
        if (dateEditor.getMonth() > LAST_MONTH_INDEX || dateEditor.getDay() > MONTHS.get(dateEditor.getMonth()).checkDaysNumber()) {
            throw new IllegalStateException("The day " + dateEditor.getDay() + " or month " + dateEditor.getMonth() + " is incorrect!");
        }
    }

    private boolean lessThanLastDayCheck() {
        return dateEditor.getDay() < MONTHS.get(dateEditor.getMonth()).checkDaysNumber();
    }

    private static boolean lastMonthCheck() {
        return dateEditor.getMonth() == LAST_MONTH_INDEX;
    }

    private static boolean leapYearCheck() {
        return dateEditor.getYear() % LEAP_YEAR_INDEX == 0;
    }


    public enum MonthGroup {
        MONTH_GROUP_1(false, true, DAYS_IN_MONTH[1]),
        MONTH_GROUP_2(false, false, DAYS_IN_MONTH[2]),
        MONTH_GROUP_3(true, false, DAYS_IN_MONTH[3]);

        @Getter
        private boolean lastMonthInfluence;
        @Getter
        private boolean leapYearInfluence;
        private int days;

        MonthGroup(boolean lastMonthInfluence, boolean leapYearInfluence, int days) {
            this.lastMonthInfluence = lastMonthInfluence;
            this.leapYearInfluence = leapYearInfluence;
            this.days = days;
        }

        public int checkDaysNumber() {
            return leapYearInfluence && leapYearCheck() ? days++ : days;
        }
    }
}