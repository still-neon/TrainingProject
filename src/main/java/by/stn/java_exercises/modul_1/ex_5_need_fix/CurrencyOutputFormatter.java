package by.stn.java_exercises.modul_1.ex_5_need_fix;

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
        if (sum % BASE == 1 && sum % (BASE * BASE) != (BASE + 1))//добавить метод проверяющий что единица не входит в 11 (вторая часть условия)
            return sum + CURRENCY_DECLENSION_1;//1 return вместо 3-х
        else if ((sum % BASE > 1 && sum % BASE < LIMITER) && !(sum % (BASE * BASE) > (BASE + 1) && sum % (BASE * BASE) < (BASE + LIMITER)))//метод от 2-х до 4-х
            return sum + CURRENCY_DECLENSION_2;
        else
            return sum + CURRENCY_DECLENSION_3;
    }

    public static void main(String[] args) {
        System.out.println("У вас " + format(1121));
    }
}