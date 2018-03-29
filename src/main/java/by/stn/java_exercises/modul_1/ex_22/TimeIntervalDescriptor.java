package by.stn.java_exercises.modul_1.ex_22;

public class TimeIntervalDescriptor implements Comparable<TimeIntervalDescriptor> {
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int SECONDS_IN_HOUR = 3600;
    private int seconds;
    private int minutes;
    private int hours;

    public TimeIntervalDescriptor(int secondsTotal) {
        hours = secondsTotal / SECONDS_IN_HOUR;
        minutes = (secondsTotal % SECONDS_IN_HOUR) / SECONDS_IN_MINUTE;
        seconds = secondsTotal % SECONDS_IN_MINUTE;
    }

    public TimeIntervalDescriptor(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getAllSeconds() {
        return hours * SECONDS_IN_HOUR + minutes * SECONDS_IN_MINUTE + seconds;
    }

    @Override
    public int compareTo(TimeIntervalDescriptor timeIntervalDescriptor) {
        if (getAllSeconds() == timeIntervalDescriptor.getAllSeconds())
            return 0;
        else
            return getAllSeconds() > timeIntervalDescriptor.getAllSeconds() ? 1 : -1;
    }

    public String outputTimeInterval() {
        return hours + " hours " + minutes + " minutes " + seconds + " seconds";
    }

    public static void main(String[] args) {
        TimeIntervalDescriptor timeIntervalDescriptor1 = new TimeIntervalDescriptor(36000);
        TimeIntervalDescriptor timeIntervalDescriptor2 = new TimeIntervalDescriptor(10, 0, 0);

        System.out.println(timeIntervalDescriptor1.compareTo(timeIntervalDescriptor2));
        System.out.println("TimeInterval interval of the first object is " + timeIntervalDescriptor1.outputTimeInterval() + " of the second object is " + timeIntervalDescriptor2.outputTimeInterval());
    }
}