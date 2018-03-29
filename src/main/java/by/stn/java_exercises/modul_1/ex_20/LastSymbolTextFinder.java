package by.stn.java_exercises.modul_1.ex_20;

import by.stn.java_exercises.modul_1.ex_19.WordsCounter;

import java.util.ArrayList;
import java.util.List;

public class LastSymbolTextFinder {
    public static List<Character> find(String text) {
        text = text.trim().toLowerCase();
        char[] symbols = text.toCharArray();
        List<Character> lastLetters = new ArrayList<>();

        for (int i = 0; i < symbols.length; i++) {
            if (WordsCounter.isLetter(symbols[i])) {
                while(WordsCounter.isLetter(symbols[i])) {
                    if(i++ == symbols.length - 1) {
                        break;
                    }
                }
                lastLetters.add(symbols[i-1]);
            }
        }
        return lastLetters;
    }

    public static void main(String[] args) {
        String text = " what a hell, is going on? I dont  understan d";
        System.out.print("The text created of words last letters is " + find(text));
    }
}