package by.stn.java_exercises.modul_1.ex_6;

import java.util.Arrays;

/**
 * Created by EugenKrasotkin on 2/26/2018.
 */
public class DateFormatter {
    private static int dayValue = 1;//входные параметры
    private static int monthValue = 1;
    private static int yearValue = 1;
    private static final int INITIAL_VALUE = 1;
    private static final Integer[] MONTH_WITH_31_DAYS = {1, 3, 5, 7, 8, 10, 12};//сделать сетами на 12, 46911 сет 2 и вычислять
    private static final Integer[] MONTH_WITH_30_DAYS = {4, 6, 9, 11};//переделать алгоритм, чтобы он был более универсальный и более простой, учесть ввод невалидной даты
    //метод календарь вычислет текущую дату, метод шифт переводит на какое-то чилсо вперед
    //
    private static final int MONTH_WITH_28_29_DAYS = 2;
    private static final int DAYS_IN_MONTH_28 = 28;
    private static final int DAYS_IN_MONTH_29 = 29;
    private static final int DAYS_IN_MONTH_30 = 30;
    private static final int DAYS_IN_MONTH_31 = 31;
    private static final int BISSEXTILE_YEAR_INDEX = 4;
    private static final int MONTHS_IN_YEAR = 12;


    private static String calculate() {
        if (dayValue < DAYS_IN_MONTH_28) {
            dayValue++;
            return dayValue + "/" + monthValue + "/" + yearValue;
        }

        switch (countDaysInMonth()) {
            case DAYS_IN_MONTH_28:
                changeDate(DAYS_IN_MONTH_28);
                break;
            case DAYS_IN_MONTH_29:
                changeDate(DAYS_IN_MONTH_29);
                break;
            case DAYS_IN_MONTH_30:
                changeDate(DAYS_IN_MONTH_30);
                break;
            case DAYS_IN_MONTH_31:
                changeDate(DAYS_IN_MONTH_31);
                break;
        }
        return dayValue + "/" + monthValue + "/" + yearValue;
    }

    private static int countDaysInMonth() {
        if (monthValue == MONTH_WITH_28_29_DAYS && yearValue % BISSEXTILE_YEAR_INDEX != 0)
            return DAYS_IN_MONTH_28;
        if (Arrays.asList(MONTH_WITH_30_DAYS).contains(monthValue))
            return DAYS_IN_MONTH_30;
        if (Arrays.asList(MONTH_WITH_31_DAYS).contains(monthValue))
            return DAYS_IN_MONTH_31;
        else
            return DAYS_IN_MONTH_29;
    }

    private static void changeDate(int days) {
        if (dayValue == days) {
            dayValue = INITIAL_VALUE;
            monthValue++;
        } else {
            dayValue++;
        }
        if (monthValue > MONTHS_IN_YEAR) {
            monthValue = INITIAL_VALUE;
            yearValue++;
        }
    }

    public static void main(String[] args) {
        System.out.println("The next day is " + calculate());
    }
}