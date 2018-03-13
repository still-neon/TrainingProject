package by.stn.java_exercises.modul_1.ex_3;

/**
 * Created by EugenKrasotkin on 2/26/2018.
 */
public class LastDigitChecker {
    private static final int BASE = 10;
    private static final int TARGET_DIGIT = 7;

    public static boolean check(int number, int targetDigit) {
        return number % BASE == targetDigit;
    }

    public static void main(String[] args) {
        System.out.println("It's " + check(778,TARGET_DIGIT) + " that last number is 7");
    }
}