package by.stn.java_exercises.modul_2.ex_2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by EugenKrasotkin on 4/23/2018.
 */
public class SubStringFinder {
    public static List<String> find(String text, String regex) {
        List<String> subs = new ArrayList<>();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()) {
            subs.add(text.substring(m.start(), m.end()));
        }
        return subs;
    }

    public static void main(String args[]) {
        String text = "-0x7FFF <p id=p1> 0X7AAF <p id=p1> kkkk  khg gkhjg";
        String regex = "-?0[xX][A-Fa-f\\d]*";
        System.out.println(find(text, regex));
    }
}