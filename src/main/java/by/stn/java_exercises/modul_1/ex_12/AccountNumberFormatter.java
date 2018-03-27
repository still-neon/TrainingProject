package by.stn.java_exercises.modul_1.ex_12;

public class AccountNumberFormatter {
    private static final long BASE = 10;
    private static final int GROUP_SIZE = 3;
    private static final String SPACE_PREFIX = " ";
    private static final String ZERO_PREFIX = "0";

    public static String format(long number) {
        StringBuffer accountNumber = new StringBuffer();
        long divider = dividerCalculator(BASE, GROUP_SIZE);
        while (number > divider) {
            accountNumber.insert(0, complement(number % divider));
            number /= (divider);
        }
        return String.valueOf(accountNumber.insert(0, number));
    }

    private static String complement(long num) {
        StringBuffer numberString = new StringBuffer(String.valueOf(num));

        for (int i = numberString.length(); i < GROUP_SIZE; i++) {
            numberString.insert(0, ZERO_PREFIX);
        }

        return String.valueOf(numberString.insert(0, SPACE_PREFIX));
    }

    private static long dividerCalculator(long base, int groupSize) {
        long divider = base;
        for (int i = 1; i < groupSize; i++) {
            divider *= base;
        }
        return divider;
    }

    public static void main(String[] args) {
        long number = 2002314005;
        System.out.print("Account output of the number " + number + " is " + format(number));
    }
}