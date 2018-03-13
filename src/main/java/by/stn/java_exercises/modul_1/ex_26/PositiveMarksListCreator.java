package by.stn.java_exercises.modul_1.ex_26;

import java.util.*;

public class PositiveMarksListCreator {
    private static final int MAX_MARK = 5;
    private static final int MIN_MARK = 2;

    public static ArrayList<Integer> create(int sudentsNumber) {
        List<Integer> marks = new ArrayList<Integer>();
        for (int i = 0; i < sudentsNumber; i++) {
            marks.add((int) (Math.random() * MAX_MARK + 1));
        }
        return removeNegativeMarks(marks);
    }

    private static ArrayList<Integer> removeNegativeMarks(List<Integer> marks) {
        ArrayList<Integer> negativeMarks = new ArrayList<Integer>();
        for (Integer mark : marks) {
            if (mark <= MIN_MARK) {
                negativeMarks.add(mark);
            }
        }

        marks.removeAll(negativeMarks);
        return (ArrayList) marks;
    }

    public static void main(String[] args) {
        System.out.print("The list of positive marks is " + create(55));
    }
}