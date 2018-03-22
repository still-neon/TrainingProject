package by.stn.java_exercises.modul_1.ex_10;

public class NumeralsSumCalculator {
    public static int calculate(int number) {
        int  sum = 0;

        while (number != 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int number = 123456845;
        System.out.println("Numerals sum of the number " + number + " is " + calculate(number));
    }
}