package by.stn.java_exercises.modul_1.ex_6_fixed;

import lombok.Getter;

import static by.stn.java_exercises.modul_1.ex_6_fixed.NextDayDateCalculator.MonthGroup.*;


/**
 * Created by EugenKrasotkin on 3/6/2018.
 */
public class NextDayDateCalculator {
    @Getter
    private CustomDate dateEditor;

    public NextDayDateCalculator(CustomDate dateEditor) {
        this.dateEditor = dateEditor;
    }

    public void shift(int times) {
        validateDate();
        for (int i = 0; i < times; i++) {
            dateEditor.nextDay();
        }
    }

    private void validateDate() {
        if (dateEditor.getMonth() > LAST_MONTH_INDEX || dateEditor.getDay() > MONTHS.get(dateEditor.getMonth()).checkDaysNumber()) {
            throw new IllegalStateException("The day " + dateEditor.getDay() + " or month " + dateEditor.getMonth() + " is incorrect!");
        }
    }
}