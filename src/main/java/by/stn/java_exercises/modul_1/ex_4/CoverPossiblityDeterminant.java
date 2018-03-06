package java_exercises.modul_1.ex_4;

/**
 * Created by EugenKrasotkin on 2/26/2018.
 */
public class CoverPossiblityDeterminant {
    private static final int RECTANGLE_SIZE_A = 10;
    private static final int RECTANGLE_SIZE_B = 20;
    private static final int CIRCLE_RADIUS = 40;

    private static boolean determinate(int sizeA, int sizeB, int radius) {
        return Math.sqrt((sizeA * sizeA + sizeB * sizeB)) <= radius * 2;
    }

    public static void main(String[] args) {
        System.out.println("It's " + determinate(RECTANGLE_SIZE_A, RECTANGLE_SIZE_B, CIRCLE_RADIUS) + " that circle can cover rectangle");
    }
}
