package by.stn.java_exercises.modul_2.ex_4;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by EugenKrasotkin on 4/24/2018.
 */
public class MoneyFormatter {
    public static String format(double number, String language, String country) {
        Locale loc = new Locale(language, country);
        NumberFormat rubFormat = NumberFormat.getCurrencyInstance(loc);
        return rubFormat.format(number);
    }


    public static void main(String args[]) {
        double number = 153.5;
        String language = "uk";
        String country = "UA";
        System.out.println(format(number, language, country));
    }
}