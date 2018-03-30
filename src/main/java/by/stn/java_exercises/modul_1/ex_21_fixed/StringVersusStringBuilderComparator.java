package by.stn.java_exercises.modul_1.ex_21_fixed;

public class StringVersusStringBuilderComparator {
    public static double getAddingTime(AdditionPerformig adder, String string, long additionsNumber) {
        return TimeInterval.getInterval(adder, string, additionsNumber);
    }

    public static void main(String[] args) {
        String string = "";
        long additions = 10000000;
        System.out.println(additions + " times adding of empty string takes " + getAddingTime(new WithStringAdder(),string, additions) + " ms with String and " +
                getAddingTime(new WithStringBuilderAdder(),string, additions) + " ms with StringBuilder");
    }
}