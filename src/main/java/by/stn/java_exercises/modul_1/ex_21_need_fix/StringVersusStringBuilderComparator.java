package by.stn.java_exercises.modul_1.ex_21_need_fix;

public class StringVersusStringBuilderComparator {
    public static double getAddingTime(AdditionPerforming adder, String string, long additionsNumber) {
        return TimeInterval.getInterval(adder, string, additionsNumber);
    }

    public static void main(String[] args) {
        String string = "";//абстрактный класс, конструктор стринг, аддитионс, сложение отделить от времени
        long additions = 10000000;
        System.out.println(additions + " times adding of empty string takes " + getAddingTime(new WithStringAdder(),string, additions) + " ms with String and " +
                getAddingTime(new WithStringBuilderAdder(),string, additions) + " ms with StringBuilder");
    }
}