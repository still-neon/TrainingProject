package java_exercises.modul_1.ex_11;

public class SimpleNumberDeterminant {
    private static final int NUMBER = 101;

    public static void main(String[] args) {
        System.out.println("It's " + determinate(NUMBER) + " that's the number " + NUMBER + " is simple");
    }

    private static boolean determinate(int n) {
        int counter = 0;
        while (n > 0) {
            if (NUMBER % n == 0) {
                counter++;
            }
            if(counter == 2)
                break;
            n--;
        }
        return counter == 2;
    }
}