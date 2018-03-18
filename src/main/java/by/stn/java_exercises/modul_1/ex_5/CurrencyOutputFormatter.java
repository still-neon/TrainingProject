package by.stn.java_exercises.modul_1.ex_5;

/**
 * Created by EugenKrasotkin on 2/26/2018.
 */
public class CurrencyOutputFormatter {
    private static final int BASE = 10;
    private static final int LIMITER = 5;
    private static final String CURRENCY_DECLENSION_1 = " рубль";
    private static final String CURRENCY_DECLENSION_2 = " рубля";
    private static final String CURRENCY_DECLENSION_3 = " рублей";

    public static String format(int sum) {
        String declension = CURRENCY_DECLENSION_3;
        if (endsWith1(sum) && doesNotEndWith11(sum))
            declension = CURRENCY_DECLENSION_1;
        else if (endsWithFrom2To4(sum) && doesNotEndWithFrom12To14(sum))
            declension = CURRENCY_DECLENSION_2;
        return sum + declension;
    }

    private static boolean endsWith1(int sum) {
        return sum % BASE == 1;
    }

    private static boolean doesNotEndWith11(int sum) {
        return sum % (BASE * BASE) != (BASE + 1);
    }

    private static boolean endsWithFrom2To4(int sum) {
        return sum % BASE > 1 && sum % BASE < LIMITER;
    }

    private static boolean doesNotEndWithFrom12To14(int sum) {
        return sum % (BASE * BASE) < (BASE + 2) || sum % (BASE * BASE) > (BASE + LIMITER);
    }

    public static void main(String[] args) {
        System.out.println("У вас " + format(1121));
    }
}