package by.stn.java_exercises.modul_1.ex_28;

import java.util.*;

public class TopMarkFinder {
    public static int find(List<Integer> marksList) {
        ListIterator marksListIterator = marksList.listIterator();
        int maxMark = marksList.get(0);
        int currentMark;

        while (marksListIterator.hasNext()) {
            currentMark = (Integer) marksListIterator.next();
            if (currentMark > maxMark) {
                maxMark = currentMark;
            }
        }
        return maxMark;
    }

    public static void main(String[] args) {
        System.out.print("The top marks is " + find(MarksListCreator.create(3)));
    }
}