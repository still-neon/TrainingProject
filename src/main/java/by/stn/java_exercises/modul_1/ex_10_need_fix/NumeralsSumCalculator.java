package by.stn.java_exercises.modul_1.ex_10_need_fix;

public class NumeralsSumCalculator {
    public static void main(String[] args) {
        System.out.println("Numerals sum of the number is " + calculate(123456845));
    }

    private static int calculate(int n) {//локальная переменная, не модифицировать число
        int sum = 0;

        while (n != 0) {
            sum = sum +  n % 10;
            n = n / 10;
        }
        return sum;
    }
}