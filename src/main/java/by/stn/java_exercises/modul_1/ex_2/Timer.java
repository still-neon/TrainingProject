package java_exercises.modul_1.ex_2;

class Timer {
    private final static int SECONDS_TOTAL = 3700000;
    private final static int SECONDS_IN_WEEK = 604800;
    private final static int SECONDS_IN_DAY = 86400;
    private final static int SECONDS_IN_HOUR = 3600;
    private final static int SECONDS_IN_MINUTE = 60;

    public static void main(String args[]) {
        int seconds = SECONDS_TOTAL % SECONDS_IN_MINUTE;
        int minutes = (SECONDS_TOTAL % SECONDS_IN_HOUR) / SECONDS_IN_MINUTE;
        int hours = (SECONDS_TOTAL % SECONDS_IN_DAY) / SECONDS_IN_HOUR;
        int days = (SECONDS_TOTAL % SECONDS_IN_WEEK) / SECONDS_IN_DAY;
        int weeks = SECONDS_TOTAL / SECONDS_IN_WEEK;
        System.out.println(weeks + " weeks " + days + " days " + hours + " hours " + minutes + " minutes " + seconds + " getAllSeconds ");
    }
}