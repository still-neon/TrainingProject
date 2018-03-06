package java_exercises.modul_1.ex_7;

public class CapacityChecker {
    private static final double A_SIZE = 1;
    private static final double B_SIZE = 0.1;
    private static final double C_SIZE = 2;
    private static final double D_SIZE = 1;
    private static final double E_SIZE = 2;
    private static final double F_SIZE = 1;

    public static void main(String[] args) {
        System.out.println("It's " + check(A_SIZE, B_SIZE, C_SIZE, D_SIZE, E_SIZE, F_SIZE) + " that figures are fit");
    }

    private static boolean check(double a, double b, double c, double d, double e, double f) {
        a = Math.max(a, b);
        b = Math.min(a, b);
        c = Math.max(c, d);
        d = Math.min(c, d);
        e = Math.max(e, f);
        f = Math.min(e, f);

        if ((a + d <= e && Math.max(b, c) <= f) || (a + c <= e && Math.max(b, d) <= f))
            return true;
        else if ((a + d <= f && Math.max(b, c) <= e) || (a + c <= f && Math.max(b, d) <= e))
            return true;
        else if ((b + d <= f && Math.max(a, c) <= e) || (b + c <= f && Math.max(a, d) <= e))
            return true;
        else if ((b + d <= e && Math.max(a, c) <= f) || (b + c <= e && Math.max(a, d) <= f))
            return true;
        else
            return false;
    }
}