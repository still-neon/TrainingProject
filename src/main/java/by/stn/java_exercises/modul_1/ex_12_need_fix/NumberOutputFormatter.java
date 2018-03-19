package by.stn.java_exercises.modul_1.ex_12_need_fix;

public class NumberOutputFormatter {
    private static final long NUMBER = 2002314005;//входные параметры, accountNumberFormatter String format(int number)
    private static final long MULTIPLIER = 1000;//base 10, groupsize = 3, методы дополняющий нулями до 3
    private static long tempNumber = NUMBER;
    private static String outputValue;

    private static void output() {
        for (long n = NUMBER; n > 0; n /= MULTIPLIER) {
            format();
            System.out.print(outputValue);
        }
    }

    private static void format() {
        long factor = 1;
        long num = tempNumber;
        while (num >= MULTIPLIER) {
            num /= MULTIPLIER;
            factor *= MULTIPLIER;
        }
        outputValue = tempNumber / factor + " ";

        if (tempNumber < NUMBER) {
            if ((tempNumber / factor) / 100 < 1 && (tempNumber / factor) / 10 > 1)
                outputValue = "0" + outputValue;
            else if ((tempNumber / factor) / 10 < 1)
                outputValue = "00" + outputValue;
        }
        tempNumber %= factor;
    }

    public static void main(String[] args) {
        System.out.print("Account output of the tempNumber " + tempNumber + " is ");
        output();
    }
}