package java_exercises.modul_1.ex_3;

/**
 * Created by EugenKrasotkin on 2/26/2018.
 */
public class FinalNumberDeterminant {
    private static final int NUMBER = 778;

    private static boolean determinate(int n) {
        return n % 10 == 7;
    }

    public static void main(String[] args) {
        System.out.println("It's " + determinate(NUMBER) + " that last number is 7");
    }
}