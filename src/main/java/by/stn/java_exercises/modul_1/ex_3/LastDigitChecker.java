package by.stn.java_exercises.modul_1.ex_3;

/**
 * Created by EugenKrasotkin on 2/26/2018.
 */
public class LastDigitChecker {
    private static final int NUMBER = 778;//10 и 7 в константы

    private static boolean check(int n) {
        return n % 10 == 7;
    }

    public static void main(String[] args) {
        System.out.println("It's " + check(NUMBER) + " that last number is 7");
    }
}