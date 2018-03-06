package java_exercises.modul_1.ex_21;

public class StringVersusStringBuilderComparator {
    private static final long ADDITION_NUMBER = 10000000;
    private static final String STRING = "";

    public static void main(String[] args) {
        System.out.println(ADDITION_NUMBER + " times adding of empty string takes " + calculateStringAddingTime(STRING) + " ms with String and " + calculateStringBuilderAddingTime(new StringBuilder(STRING)) + " ms with StringBuilder");
    }

    private static double calculateStringAddingTime(String str) {
        double startTime = System.currentTimeMillis();
        for (long i = 0; i < ADDITION_NUMBER; i++) {
            str += str;
        }
        return System.currentTimeMillis() - startTime;
    }

    private static double calculateStringBuilderAddingTime(StringBuilder str) {
        double startTime = System.currentTimeMillis();
        for (long i = 0; i < ADDITION_NUMBER; i++) {
            str.append(str);
        }
        return System.currentTimeMillis() - startTime;
    }
}