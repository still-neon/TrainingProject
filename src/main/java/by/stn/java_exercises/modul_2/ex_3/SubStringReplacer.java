package by.stn.java_exercises.modul_2.ex_3;

/**
 * Created by EugenKrasotkin on 4/24/2018.
 */
public class SubStringReplacer {
    public static void main(String args[]) {
        String text = "-0x7FFF <p id=p1> 0X7AAF <p id=p1> kkkk  khg gkhjg";
        String regex = "<p\\s[a-zA-Z]*=[a-zA-Z0-9]*>";
        String replacement = "<p>";
        System.out.println(text.replaceAll(regex, replacement));
    }
}