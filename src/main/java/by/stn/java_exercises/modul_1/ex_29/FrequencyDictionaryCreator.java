package by.stn.java_exercises.modul_1.ex_29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyDictionaryCreator {
    public static HashMap<String, Integer> create(String text) {
        Map<String, Integer> frequencyDictionary = new HashMap<String, Integer>();

        for (String word : createWordsList(text))
            if (!frequencyDictionary.containsKey(word)) {
                frequencyDictionary.put(word, 1);
            } else {
                frequencyDictionary.put(word, frequencyDictionary.get(word) + 1);
            }
        return (HashMap<String, Integer>) frequencyDictionary;
    }

    private static ArrayList<String> createWordsList(String text) {
        List<String> wordsList = new ArrayList<String>();
        int wordStartIndex;
        int wordFinishIndex;

        text = text.trim().toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
                wordStartIndex = i;
                for (int n = i; n < text.length(); n++) {
                    if (text.charAt(n) < 'a' || text.charAt(n) > 'z') {
                        wordFinishIndex = n;
                        wordsList.add(text.substring(wordStartIndex, wordFinishIndex));
                        i = wordFinishIndex;
                        break;
                    } else if (n == text.length() - 1) {
                        wordsList.add(text.substring(wordStartIndex, text.length()));
                        return (ArrayList<String>) wordsList;
                    }
                }
            }
        }
        return (ArrayList<String>) wordsList;
    }

    public static void main(String[] args) {
        String text = "one two one";
        System.out.println("The frequency dictionary for text '" + text + "' is " + create(text));
    }
}