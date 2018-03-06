package java_exercises.modul_1.ex_9;

public class MaxValueCalculator {
    public static void main(String[] args) {
        System.out.println("\n The max value is " + calculate());
    }

    private static int calculate() {
        int max = 0;
        System.out.print("Values are: ");
        int x = (int) (Math.random() * 20);
        while (x != 0) {
            System.out.print(x + ";");
            if (x >= max)
                max = x;
            x = (int) (Math.random() * 20);
        }
        return max;
    }
}