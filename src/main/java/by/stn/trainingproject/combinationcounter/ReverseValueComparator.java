package by.stn.trainingproject.combinationcounter;

public class ReverseValueComparator {
    public static boolean compare(int h, int m) {
        String hour = String.valueOf(h);
        String min = String.valueOf(m);
        String minReversed = "";

        if (h > 0 && h < 10) {
            hour = "0" + String.valueOf(h);
        }
        if (m > 0 && m < 10) {
            min = "0" + String.valueOf(m);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min);
        sb = sb.reverse();

        for (int i = 0; i < sb.length(); i++) {
            minReversed += sb.charAt(i);
        }

        if (hour.equals(minReversed)) {
            //System.out.println(hour + " = " + min);
            return true;
        }
        return false;
    }
}