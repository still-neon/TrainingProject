package by.stn.java_exercises.modul_1.ex_28;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EugenKrasotkin on 3/12/2018.
 */
public class MarksListCreator {
    public static final int MAX_MARK = 5;

    public static List<Integer> create(int students) {
        List<Integer> marks = new ArrayList<Integer>();
        for (int i = 0; i < students; i++) {
            marks.add((int) (Math.random() * MAX_MARK + 1));
        }
        return marks;
    }
}