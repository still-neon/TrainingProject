package by.stn.java_exercises.modul_1.ex_21;

public class StringAddersComparator {
    public static double getAddingTime(AdditionPerforming adder) {
        return TimeInterval.getInterval(adder);
    }

    public static void main(String[] args) {
        String string = "a";
        long additions = 10000;
        System.out.println(additions + " times adding of empty string takes " + getAddingTime(new WithStringAdder(string, additions)) + " ms with String and " +
                getAddingTime(new WithStringBuilderAdder(string, additions)) + " ms with StringBuilder");
    }
}