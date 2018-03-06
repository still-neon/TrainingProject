package java_exercises.modul_1.ex_20;

public class LastSymbolTextCreator {
    private static final String TEXT = " what a hell, 123 is going on? I 45 don't  understand 7! ";

    public static void main(String[] args) {
        System.out.print("The text created of words last letters is " + create(TEXT));
    }

    private static String create(String txt) {
        txt = txt.trim().toLowerCase();
        String lastLettersText = "";

        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) >= 'a' && txt.charAt(i) <= 'z') {
                for (int n = i; n < txt.length(); n++) {
                    if (txt.charAt(n) < 'a' || txt.charAt(n) > 'z') {
                        lastLettersText += txt.charAt(n - 1);
                        i = n;
                        break;
                    } else if (n == txt.length() - 1) {
                        return lastLettersText;
                    }
                }
            }
        }
        return lastLettersText;
    }
}