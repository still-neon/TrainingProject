package by.stn.java_exercises.modul_1.ex_3_fixed;

/**
 * Created by EugenKrasotkin on 2/26/2018.
 */
public class LastDigitChecker {
    private static final int DIVIDER = 10;
    private static final int DIVISION_REMAINDER = 7;
    //10 и 7 в константы

    public static boolean check(int number) {
        return number % DIVIDER == DIVISION_REMAINDER;
    }

    public static void main(String[] args) {
        System.out.println("It's " + check(778) + " that last number is 7");
    }
}