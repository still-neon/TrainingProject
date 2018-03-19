package by.stn.java_exercises.modul_1.ex_6_fixed;

/**
 * Created by EugenKrasotkin on 3/19/2018.
 */
public class DateValidator {
    private static MonthGroup monthGroup;

    public static void validate(CustomDate dateEditor) {
        monthGroup = MonthGroup.of(dateEditor.getMonth());

        if (dateEditor.getMonth() > MonthGroup.getLAST_MONTH_INDEX() || dateEditor.getDay() > monthGroup.checkDaysNumber(dateEditor.isLeapYear())) {
            throw new IllegalStateException("The day " + dateEditor.getDay() + " or month " + dateEditor.getMonth() + " is incorrect!");
        }
    }
}