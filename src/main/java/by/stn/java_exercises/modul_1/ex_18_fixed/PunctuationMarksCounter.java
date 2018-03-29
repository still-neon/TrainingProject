package by.stn.java_exercises.modul_1.ex_18_fixed;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PunctuationMarksCounter {
    //Set contains
    public static int count(String text, Set<Character> punctuationMarks) {
        int counter = 0;

        for (int i = 0; i < text.length(); i++)
            if (punctuationMarks.contains(text.charAt(i))) {
                counter++;
            }
        return counter;
    }

    public static void main(String[] args) {
        Set<Character> punctuationMarks = new HashSet<>(Arrays.asList('.','!','?','-',':',';','(',')','/'));
        String text = "How can there be an ‘N/A’ as a billing type when that is a required decision in the contract record? Or is this SO/LO’s? If so, there are many more than 2 of those.";
        System.out.println("In this string there are " + count(text, punctuationMarks) + " punctuation marks");
    }
}