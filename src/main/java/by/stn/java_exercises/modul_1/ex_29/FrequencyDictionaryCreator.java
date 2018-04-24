package by.stn.java_exercises.modul_1.ex_29;

import by.stn.java_exercises.modul_1.ex_19.WordsCounter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyDictionaryCreator {
    public static Map<String, Integer> create(String text) {
        Map<String, Integer> frequencyDictionary = new HashMap<>();

        for (String word : createWordsList(text)) {
            frequencyDictionary.put(word, frequencyDictionary.containsKey(word) ? frequencyDictionary.get(word) + 1 : 1);
        }
        return frequencyDictionary;
    }

    private static List<String> createWordsList(String text) {
        int start;
        int finish;

        List<String> wordsList = new ArrayList<>();

        text = text.trim().toLowerCase();
        char[] symbols = text.toCharArray();

        for (int i = 0; i < symbols.length; i++) {
            if (WordsCounter.isLetter(symbols[i])) {
                start = i;
                while (WordsCounter.isLetter(symbols[i])) {
                    if (i++ == symbols.length - 1) {
                        break;
                    }
                }
                finish = i;
                wordsList.add(text.substring(start, finish));
            }
        }
        return wordsList;
    }

    public static void main(String[] args) {
        String text = "one two one";
        System.out.println("The frequency dictionary for text is " + create(text));
    }
}