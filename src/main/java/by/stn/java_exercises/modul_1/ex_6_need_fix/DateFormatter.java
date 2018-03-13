package by.stn.java_exercises.modul_1.ex_6_need_fix;

/**
 * Created by EugenKrasotkin on 2/26/2018.
 */
public class DateFormatter {

    //сделать сетами на 12, 46911 сет 2 и вычислять
    //переделать алгоритм, чтобы он был более универсальный и более простой, учесть ввод невалидной даты
    //метод календарь вычислет текущую дату, метод шифт переводит на какое-то чилсо вперед
    //

    public static String format(int[] date) {
        return date[0] + "/" + date[1] + "/" + date[2];
    }

    public static void main(String[] args) {
        //System.out.println("The next day is " + format(NextDayDateCalculator.getNextDay(29, 1, 1)));
        System.out.println("The date is "+ format(NextDayDateCalculator.shift(29, 1, 1, 10)));
    }
}