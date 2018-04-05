package by.stn.java_exercises.modul_1.ex_26;

import java.util.*;

public class SufficientMarks {
    private static final int MAX_MARK = 5;
    private static final int MIN_MARK = 2;

    public static List<Integer> create(int students) {
        List<Integer> marks = new ArrayList<Integer>();
        for (int i = 0; i < students; i++) {
            marks.add((int) (Math.random() * MAX_MARK + 1));
        }
        return removeNegativeMarks(marks);
    }

    private static List<Integer> removeNegativeMarks(List<Integer> marks) {
        Set<Integer> negativeMarks = new HashSet<>();
        for (Integer mark : marks) {
            if (mark <= MIN_MARK) {
                negativeMarks.add(mark);
            }
        }

        marks.removeAll(negativeMarks);
        return marks;
    }

    public static void main(String[] args) {
        System.out.print("The list of positive marks is " + create(55));
    }
}