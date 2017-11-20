package by.stn.trainingproject.counter.swing;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eugenkrasotkin on 11/16/2017.
 */
public class SymbolsCounter {

    public static Map<Character, Integer> count (String userInput) {
        char[] charsInput = userInput.toCharArray();
        Map<Character, Integer> symbols = new HashMap<Character, Integer>();
        for (char ch : charsInput) {
            if (ch >= 'a' && ch <= 'z') {
                if (!symbols.containsKey(ch)) {
                    symbols.put(ch, 1);
                } else {
                    symbols.put(ch, symbols.get(ch) + 1);
                }
            }
        }
        return symbols;
    }
}