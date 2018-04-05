package by.stn.java_exercises.modul_1.ex_28;

import java.util.*;

public class TopMarkFinder {
    public static int find(List<Integer> marksList) {
        Iterator<Integer> marksIterator = marksList.iterator();
        int maxMark = marksList.get(0);

        while (marksIterator.hasNext() && maxMark < MarksListCreator.MAX_MARK) {
            int currentMark = marksIterator.next();
            if (currentMark > maxMark) {
                maxMark = currentMark;
            }
        }
        return maxMark;
    }

    public static void main(String[] args) {
        System.out.print("The top marks is " + find(MarksListCreator.create(10)));
    }
}