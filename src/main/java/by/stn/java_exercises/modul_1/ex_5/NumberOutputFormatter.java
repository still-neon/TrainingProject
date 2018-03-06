package java_exercises.modul_1.ex_5;

/**
 * Created by EugenKrasotkin on 2/26/2018.
 */
public class NumberOutputFormatter {
    private static final int SUMM_OF_MONEY = 127;

    private static String format(int summ) {
        if (summ % 10 == 1 && summ % 100 != 11)
            return summ + " рубль";
        else if (summ % 10 > 1 && summ % 10 < 5 && !(summ % 100 > 11 && summ % 100 < 15))
            return summ + " рубля";
        else
            return summ + " рублей";
    }

    public static void main(String[] args) {
        System.out.println("У вас " + format(SUMM_OF_MONEY));
    }
}