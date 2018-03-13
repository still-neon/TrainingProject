package by.stn.java_exercises.modul_1.ex_4;

/**
 * Created by EugenKrasotkin on 2/26/2018.
 */
public class HoleBlocker {
    public static boolean attemptBlock(double sizeA, double sizeB, double radius) {
        return calculateDiagonal(sizeA, sizeB) <= calculateDiameter(radius);
    }

    private static double calculateDiameter(double r) {
        return r * 2;
    }

    private static double calculateDiagonal(double sA, double sB) {
        return Math.sqrt(sA * sA + sB * sB);
    }

    public static void main(String[] args) {
        System.out.println("It's " + attemptBlock(10, 20, 40) + " that circle can cover rectangle");
    }
}