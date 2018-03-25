package by.stn.java_exercises.modul_1.ex_19_need_fix;

public class WordsCounter {
    private static final String TEXT = " what a hell, is going on? I don't  understand! ";//входные параметры

    public static void main(String[] args) {
        System.out.println("This text contains " + count(TEXT) + " words");
    }

    public static int count(String txt) {
        int counter = 0;
        txt = txt.trim().toLowerCase();

        for (int i = 0; i < txt.length(); i++) {//toCharArray, методы isLetter, while больше подходит
            if (txt.charAt(i) >= 'a' && txt.charAt(i) <= 'z') {
                counter++;
                for (int n = i; n < txt.length(); n++) {
                    if (txt.charAt(n) < 'a' || txt.charAt(n) > 'z') {
                        i = n;
                        break;
                    } else if (n == txt.length() - 1) {
                        return counter;
                    }
                }
            }
        }
        return counter;
    }
}