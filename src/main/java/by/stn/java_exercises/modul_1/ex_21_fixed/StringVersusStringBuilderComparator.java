package by.stn.java_exercises.modul_1.ex_21_fixed;

public class StringVersusStringBuilderComparator {
    //входные параметры
    private static final String STRING = "";

    private static double getStringAddingTime(String string, long additionsNumber) {
        TimeInterval timeInterval = new TimeInterval();
        //отделение времени от операции, возможно другой класс
        for (long i = 0; i < additionsNumber; i++) {
            string += string;
        }
        return timeInterval.getInterval();
    }

    private static double getStringBuilderAddingTime(StringBuilder string, long additionsNumber) {
        TimeInterval timeInterval = new TimeInterval();
        for (long i = 0; i < additionsNumber; i++) {
            string.append(string);
        }
        return timeInterval.getInterval();
    }

    public static void main(String[] args) {
        long additionsNumber = 10000000;
        System.out.println(additionsNumber + " times adding of empty string takes " + getStringAddingTime(STRING, additionsNumber) + " ms with String and " +
                getStringBuilderAddingTime(new StringBuilder(STRING), additionsNumber) + " ms with StringBuilder");
    }
}