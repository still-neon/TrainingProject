package by.stn.java_exercises.modul_1.ex_11_fixed;

public class SimpleNumberDeterminant {
    private static final int DIVIDERS_NUMBER = 2;
    public static boolean determinate(int number) {//добавить константу вместо 2
        int counter = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                counter++;
            }
        }
        return counter <= DIVIDERS_NUMBER;
    }

    public static void main(String[] args) {
        int number = 4;
        System.out.println("It's " + determinate(number) + " that's the number " + number + " is simple");
    }
}