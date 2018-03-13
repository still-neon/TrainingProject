package by.stn.java_exercises.modul_1.ex_2;

class TimeFormatter {
    private final static int SECONDS_IN_MINUTE = 60;
    private final static int MINUTES_IN_HOUR = 60;
    private final static int SECONDS_IN_HOUR = SECONDS_IN_MINUTE * MINUTES_IN_HOUR;
    private final static int HOURS_IN_DAY = 24;
    private final static int SECONDS_IN_DAY = SECONDS_IN_HOUR * HOURS_IN_DAY;
    private final static int DAYS_IN_WEEK = 7;
    private final static int SECONDS_IN_WEEK = SECONDS_IN_DAY * DAYS_IN_WEEK;

    public static String format(int secondsTotal) {
        int seconds = secondsTotal % SECONDS_IN_MINUTE;
        int minutes = (secondsTotal % SECONDS_IN_HOUR) / SECONDS_IN_MINUTE;
        int hours = (secondsTotal % SECONDS_IN_DAY) / SECONDS_IN_HOUR;
        int days = (secondsTotal % SECONDS_IN_WEEK) / SECONDS_IN_DAY;
        int weeks = secondsTotal / SECONDS_IN_WEEK;
        return secondsTotal + " seconds = " + weeks + " weeks " + days + " days " + hours + " hours " + minutes + " minutes " + seconds + " seconds ";
    }

    public static void main(String args[]) {
        System.out.println(format(3721000));
    }
}