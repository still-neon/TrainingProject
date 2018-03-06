package java_exercises.modul_1.ex_18;

public class PunctuationMarksCounter {
    private static final String STRING = "How can there be an ‘N/A’ as a billing type when that is a required decision in the contract record? Or is this SO/LO’s? If so, there are many more than 2 of those.";
    private static final String PUNCTUATION_MARKS = ".,!?-:;()";

    public static void main(String[] args) {
        System.out.println("In this string there are " + count() + " punctuation marks");
    }

    private static int count() {
        int counter = 0;

        for (int i = 0; i < STRING.length(); i++)
            if (PUNCTUATION_MARKS.indexOf(STRING.charAt(i)) != -1) {
                counter++;
            }
        return counter;
    }
}