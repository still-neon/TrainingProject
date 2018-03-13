package by.stn.java_exercises.modul_1.ex_6_fixed;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by EugenKrasotkin on 3/6/2018.
 */
public class NextDayDateCalculator {
    private static final Set<Integer> MONTHS_WITH_31_DAYS = new HashSet<Integer>(Arrays.asList(1, 3, 5, 7, 8, 10));
    private static final Set<Integer> MONTHS_WITH_30_DAYS = new HashSet<Integer>(Arrays.asList(4, 6, 9, 11));
    private static final Set<Integer> MONTH_WITH_28_29_DAYS = new HashSet<Integer>(Arrays.asList(2));
    private static final Set<Integer> LAST_MONTH = new HashSet<Integer>(Arrays.asList(12));
    private static final int[] DAYS_IN_MONTH = {28, 29, 30, 31};
    private static final int BISSEXTILE_YEAR_INDEX = 4;
    private static final int INITIAL_VALUE = 1;
    private static MonthGroup monthGroup;

    public static int[] calculate(int day, int month, int year) {
        int[] date = null;

        monthGroup = MonthGroup.defineMonthGroup(day, month);

        switch (monthGroup) {
            case MONTH_GROUP_1:
                if (checkYear(year)) {
                    monthGroup.days = DAYS_IN_MONTH[1];
                }
                date = changeDate(monthGroup, day, month, year);
                break;
            case MONTH_GROUP_2:
                date = changeDate(monthGroup, day, month, year);
                break;
            case MONTH_GROUP_3:
                date = changeDate(monthGroup, day, month, year);
                break;
            case MONTH_GROUP_4:
                date = changeDate(monthGroup, day, month, year);
                break;
        }
        return date;
    }

    private static int[] changeDate(MonthGroup st, int d, int m, int y) {
        if (d < st.days) {
            d++;
        } else if (st == MonthGroup.MONTH_GROUP_4) {
            d = m = INITIAL_VALUE;
            y++;
        } else {
            d = INITIAL_VALUE;
            m++;
        }
        return new int[]{d, m, y};
    }

    private static boolean checkYear(int y) {
        return y % BISSEXTILE_YEAR_INDEX == 0;
    }

    public static int[] shift(int day, int month, int year, int times) {
        int[] date = {day, month, year};
        for (int i = 0; i < times; i++) {
            date = calculate(date[0], date[1], date[2]);
        }
        return date;
    }

    private enum MonthGroup {
        MONTH_GROUP_1(MONTH_WITH_28_29_DAYS, DAYS_IN_MONTH[0]),
        MONTH_GROUP_2(MONTHS_WITH_30_DAYS, DAYS_IN_MONTH[2]),
        MONTH_GROUP_3(MONTHS_WITH_31_DAYS, DAYS_IN_MONTH[3]),
        MONTH_GROUP_4(LAST_MONTH, DAYS_IN_MONTH[3]);

        private Set<Integer> months;
        private int days;

        MonthGroup(Set<Integer> months, int days) {
            this.months = months;
            this.days = days;
        }

        public static MonthGroup defineMonthGroup(int day, int month) {
            for (MonthGroup val : MonthGroup.values()) {
                if (val.months.contains(month) && day <= val.days) {
                    return val;
                }
            }
            throw new IllegalStateException("The day " + day + " or month " + month + " is incorrect!");
        }
    }
}