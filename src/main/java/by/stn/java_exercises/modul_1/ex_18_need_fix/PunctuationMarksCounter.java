package by.stn.java_exercises.modul_1.ex_18_need_fix;

import java.util.Arrays;
import java.util.List;

public class PunctuationMarksCounter {
    //Set contains

    public static int count(String text, char marks) {
        List<Character> punctuationMarks = Arrays.asList(marks);

        int counter = 0;

        for (int i = 0; i < text.length(); i++)
            if (punctuationMarks.contains(text.charAt(i))) {
                counter++;
            }
        return counter;
    }

    public static void main(String[] args) {
        // сделать Set char marks = {'.','!','?','-',':',';','(',')','/'};
        String text = "How can there be an ‘N/A’ as a billing type when that is a required decision in the contract record? Or is this SO/LO’s? If so, there are many more than 2 of those.";
        //System.out.println("In this string there are " + count(text, marks) + " punctuation marks");
    }
}