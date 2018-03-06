package by.stn.java_exercises.modul_1.ex_4;

/**
 * Created by EugenKrasotkin on 2/26/2018.
 */
public class HoleBlocker {
    private static final int RECTANGLE_SIZE_A = 10;
    private static final int RECTANGLE_SIZE_B = 20;
    private static final int CIRCLE_RADIUS = 40;

    private static boolean attemptBlock(int sizeA, int sizeB, int radius) {//выисление диагонали и вычисление диаметра в отдельные методы
        return Math.sqrt((sizeA * sizeA + sizeB * sizeB)) <= radius * 2;
    }

    public static void main(String[] args) {
        System.out.println("It's " + attemptBlock(RECTANGLE_SIZE_A, RECTANGLE_SIZE_B, CIRCLE_RADIUS) + " that circle can cover rectangle");
    }
}
