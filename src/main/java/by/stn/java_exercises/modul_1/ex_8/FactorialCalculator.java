package by.stn.java_exercises.modul_1.ex_8;

public class FactorialCalculator {
    public static void main(String[] args) {
        System.out.println("The factorial of number is: " + calculate(15));
    }

    public static long calculate(long number) {
        long fact = 1;
        for (long i = 1; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }
}