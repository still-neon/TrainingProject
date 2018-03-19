package by.stn.java_exercises.modul_1.ex_6;

/**
 * Created by EugenKrasotkin on 2/26/2018.
 */
public class DateFormatter {
    public static String format(CustomDate dateEditor) {
        return dateEditor.getDay() + "/" + dateEditor.getMonth() + "/" + dateEditor.getYear();
    }

    public static void main(String[] args) {
        DateShifter dateShifter = new DateShifter(new CustomDate(31, 12, 2));
        dateShifter.shift(1);
        System.out.println("The date is " + format(dateShifter.getDateEditor()));
    }
}