package by.stn.java_exercises.modul_1.ex_11_need_fix;

public class SimpleNumberDeterminant {
    public static void main(String[] args) {
        System.out.println("It's " + determinate(100) + " that's the number is simple");
    }

    private static boolean determinate(int n) {//модификация числа убрать, ошибка в алгоритме
        int counter = 0;
        while (n > 0) {
            if (100 % n == 0) {
                counter++;
            }
            if (counter == 2)
                break;
            n--;
        }
        return counter == 2;
    }
}