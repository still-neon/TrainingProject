package by.stn.java_exercises.modul_1.ex_6_fixed;

/**
 * Created by EugenKrasotkin on 2/26/2018.
 */
public class DateFormatter {

    //сделать сетами на 12, 4 6 9 11 сет 2 и вычислять
    //переделать алгоритм, чтобы он был более универсальный и более простой, учесть ввод невалидной даты
    //метод календарь вычислет текущую дату, метод шифт переводит на какое-то чилсо вперед


    public static String format(DateEditor dateEditor) {
        return dateEditor.getDay() + "/" + dateEditor.getMonth() + "/" + dateEditor.getYear();
    }

    public static void main(String[] args) {
        DateEditor dateEditor = new DateEditor(30,13,1);
        new NextDayDateCalculator().shift(dateEditor, 1);
        System.out.println("The date is "+ format(dateEditor));
    }
}