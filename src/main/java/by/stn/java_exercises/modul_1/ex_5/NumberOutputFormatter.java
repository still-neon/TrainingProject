package by.stn.java_exercises.modul_1.ex_5;

/**
 * Created by EugenKrasotkin on 2/26/2018.
 */
public class NumberOutputFormatter {
    private static final int SUM_OF_MONEY = 127;//входной параметр, константа base = 10, 11=base+1, 5 - константа, константы для рублей

    public static String format(int sum) {
        if (sum % 10 == 1 && sum % 100 != 11)
            return sum + " рубль";
        else if ((sum % 10 > 1 && sum % 10 < 5) && !(sum % 100 > 11 && sum % 100 < 15))
            return sum + " рубля";
        else
            return sum + " рублей";
    }

    public static void main(String[] args) {
        System.out.println("У вас " + format(SUM_OF_MONEY));
    }
}