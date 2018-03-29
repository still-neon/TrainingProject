package by.stn.java_exercises.modul_1.ex_19;

public class WordsCounter {
    public static int count(String text) {
        int counter = 0;
        text = text.trim().toLowerCase();
        char[] symbols = text.toCharArray();

        for (int i = 0; i < symbols.length; i++) {
            if (isLetter(symbols[i])) {
                counter++;
                while (isLetter(symbols[i])) {
                    if(i == symbols.length - 1)
                        break;
                    i++;
                }
            }
        }
        return counter;
    }

    public static boolean isLetter(char symbol) {
        return symbol >= 'a' && symbol <= 'z';
    }

    public static void main(String[] args) {
        String text = " what a hell, is going on? I dont  understan d";
        System.out.println("This text contains " + count(text) + " words");
    }
}