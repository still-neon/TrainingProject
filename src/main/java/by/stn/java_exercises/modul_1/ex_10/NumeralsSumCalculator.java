package java_exercises.modul_1.ex_10;

public class NumeralsSumCalculator {
    private static final int NUMBER = 123456845;

    public static void main(String[] args) {
        System.out.println("Numerals sum of the number " + NUMBER + " is " + calculate(NUMBER));
    }

    private static int calculate(int n) {
        int sum = 0;

        while (n != 0) {
            sum = sum +  n % 10;
            n = n / 10;
        }
        return sum;
    }
}