package java_exercises.modul_1.ex_8;

public class FactorialCalculator {
    private static final int NUMBER = 15;

    public static void main(String[] args) {
        System.out.println("The factorial of " + NUMBER + " is " + calculate());
    }

    private static int calculate() {
        int fact = 1;
        for(int i = 1; i <= NUMBER; i++) {
            fact *= i;
        }
        return fact;
    }
}