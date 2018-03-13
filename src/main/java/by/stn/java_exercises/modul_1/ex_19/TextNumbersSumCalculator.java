package by.stn.java_exercises.modul_1.ex_19;

public class TextNumbersSumCalculator {
    private static final String TEXT = " what a hell, 123 is going on? I 45 don't  understand 7! ";

    public static void main(String[] args) {
        System.out.println("The sum of numbers this text contains is " + calculate(TEXT));
    }

    private static int calculate(String txt) {
        int numberStartIndex;
        int numberFinishIndex;
        int sum = 0;

        txt = txt.trim().toLowerCase();

        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) >= '0' && txt.charAt(i) <= '9') {
                numberStartIndex = i;
                for (int n = i; n < txt.length(); n++) {
                    if (txt.charAt(n) < '0' || txt.charAt(n) > '9') {
                        numberFinishIndex = n;
                        sum += new Integer(txt.substring(numberStartIndex, numberFinishIndex));
                        i = n;
                        break;
                    } else if (n == txt.length() - 1) {
                        return sum;
                    }
                }
            }
        }
        return sum;
    }
}