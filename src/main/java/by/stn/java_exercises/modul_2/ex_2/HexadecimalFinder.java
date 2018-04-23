package by.stn.java_exercises.modul_2.ex_2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by EugenKrasotkin on 4/23/2018.
 */
public class HexadecimalFinder {
    public static List<String> find(String text) {
        List<String> hexadecimals = new ArrayList<>();
        String pattern = "-?0[xX][A-Fa-f\\d]{1,5}";
        //String pattern = "0xhhhh";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        while (m.find()) {
            hexadecimals.add(text.substring(m.start(), m.end()));
        }
        return hexadecimals;
    }

    public static void main(String args[]) {
        String text = "-0x7FFF <p id=p1> 0X7AAF <p id=p1> kkkk  khg gkhjg";
        System.out.println(find(text));
    }
}
