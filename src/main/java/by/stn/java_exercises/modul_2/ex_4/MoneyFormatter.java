package by.stn.java_exercises.modul_2.ex_4;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by EugenKrasotkin on 4/24/2018.
 */
public class MoneyFormatter {
    public static String format(double money, String language, String country) {
        Locale loc = new Locale(language, country);
        NumberFormat format = NumberFormat.getCurrencyInstance(loc);
        return format.format(money);
    }


    public static void main(String args[]) {
        double number = 153.5;
        String language = "uk";
        String country = "UA";
        System.out.println(format(number, language, country));
    }
}