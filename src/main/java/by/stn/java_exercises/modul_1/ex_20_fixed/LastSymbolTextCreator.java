package by.stn.java_exercises.modul_1.ex_20_fixed;

import by.stn.java_exercises.modul_1.ex_19_fixed.WordsCounter;

import java.util.ArrayList;
import java.util.List;

public class LastSymbolTextCreator {
    //входные параметры

    public static List<Character> create(String text) {
        text = text.trim().toLowerCase();
        char[] symbols = text.toCharArray();
        List<Character> lastLetters = new ArrayList<>();

        for (int i = 0; i < symbols.length; i++) {//теже замечания
            if (WordsCounter.isLetter(symbols[i])) {
                while(WordsCounter.isLetter(symbols[i])) {
                    if(i == symbols.length - 1) {
                        i++;
                        break;
                    }
                    i++;
                }
                lastLetters.add(symbols[i-1]);
            }
        }
        return lastLetters;
    }

    public static void main(String[] args) {
        String text = " what a hell, is going on? I dont  understan d";
        System.out.print("The text created of words last letters is " + create(text));
    }
}