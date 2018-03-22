package by.stn.java_exercises.modul_1.ex_12_need_fixed;

public class AccountNumberFormatter {
    //входные параметры, accountNumberFormatter String format(int number)
    private static final long BASE = 10;//base 10, groupsize = 3, методы дополняющий нулями до 3
    private static final int GROUP_SIZE = 3;
    private static final String SPACE_PREFIX = " ";
    private static final String ZERO_PREFIX = "0";
    private static final String DOUBLE_ZERO_PREFIX = ZERO_PREFIX + ZERO_PREFIX;

    public static String format(long number) {
        StringBuffer accountNumber = new StringBuffer();
        while (number > (BASE * BASE * BASE)) {//метод множит base * 3
            accountNumber.insert(0, complement(number % (BASE * BASE * BASE)));
            number /= (BASE * BASE * BASE);
        }
        return String.valueOf(accountNumber.insert(0,number));
    }

    private static String complement(long num) {
        String numberString = String.valueOf(num);
        if (numberString.length() == GROUP_SIZE)//цикл, допиливание до нулей
            return SPACE_PREFIX + numberString;

        return numberString.length() == GROUP_SIZE - 1 ? SPACE_PREFIX + ZERO_PREFIX + numberString : SPACE_PREFIX + DOUBLE_ZERO_PREFIX + numberString;
    }

    public static void main(String[] args) {
        long number = 2002314005;
        System.out.print("Account output of the number " + number + " is " + format(number));
    }
}