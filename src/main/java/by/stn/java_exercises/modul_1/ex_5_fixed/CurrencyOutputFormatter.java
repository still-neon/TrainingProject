package by.stn.java_exercises.modul_1.ex_5_fixed;

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
        if (endsWithDigit1Check(sum) && doesNotEndWithNumberFrom11To14Check(sum))//добавить метод проверяющий что единица не входит в 11 (вторая часть условия)
            declension = CURRENCY_DECLENSION_1;//1 return вместо 3-х
        else if (endsWithDigitFrom2To4Check(sum) && doesNotEndWithNumberFrom11To14Check(sum))//метод от 2-х до 4-х
            declension = CURRENCY_DECLENSION_2;
        return sum + declension;
    }

    private static boolean endsWithDigit1Check(int sum) {
        return sum % BASE == 1;
    }

    private static boolean endsWithDigitFrom2To4Check(int sum) {
        return sum % BASE > 1 && sum % BASE < LIMITER;
    }

    private static boolean doesNotEndWithNumberFrom11To14Check(int sum) {
        return sum % (BASE * BASE) < (BASE + 1) || sum % (BASE * BASE) > (BASE + LIMITER);
    }


    public static void main(String[] args) {
        System.out.println("У вас " + format(1121));
    }
}