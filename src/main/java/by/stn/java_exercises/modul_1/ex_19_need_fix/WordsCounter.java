package by.stn.java_exercises.modul_1.ex_19_need_fix;

public class WordsCounter {
    public static int count(String text) {
        int counter = 0;
        text = text.trim().toLowerCase();
        char[] symbols = text.toCharArray();

        for(int i = 0; i < symbols.length; i++) {
            if(isLetter(symbols[i])) {
                counter++;
                i++;//разобраться с ошибкой
                while(isLetter(symbols[i])) {
                    i++;
                }
            }
        }
        return counter;
    }

    private static boolean isLetter(char symbol) {
        return symbol >= 'a' && symbol <= 'z';
    }

    public static void main(String[] args) {
        String text = " what a hell, is going on? I dont  understand";
        System.out.println("This text contains " + count(text) + " words");
    }
}