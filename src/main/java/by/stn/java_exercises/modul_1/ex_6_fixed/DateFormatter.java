package by.stn.java_exercises.modul_1.ex_6_fixed;

/**
 * Created by EugenKrasotkin on 2/26/2018.
 */
public class DateFormatter {
    public static String format(CustomDate dateEditor) {
        return dateEditor.getDay() + "/" + dateEditor.getMonth() + "/" + dateEditor.getYear();
    }

    public static void main(String[] args) {
        DateShifter nextDayDateCalculator = new DateShifter(new CustomDate(30, 12, 1));
        nextDayDateCalculator.shift(1);
        System.out.println("The date is " + format(nextDayDateCalculator.getDateEditor()));
    }
}