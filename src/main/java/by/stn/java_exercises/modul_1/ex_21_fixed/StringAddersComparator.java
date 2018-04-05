package by.stn.java_exercises.modul_1.ex_21_fixed;

public class StringAddersComparator {
    public static double getAddingTime(AdditionPerforming adder) {
        return TimeInterval.getInterval(adder);
    }

    public static void main(String[] args) {
        String string = "";//абстрактный класс, конструктор стринг, аддитионс, сложение отделить от времени
        long additions = 10000000;
        System.out.println(additions + " times adding of empty string takes " + getAddingTime(new WithStringAdder(string, additions)) + " ms with String and " +
                getAddingTime(new WithStringBuilderAdder(string, additions)) + " ms with StringBuilder");
    }
}