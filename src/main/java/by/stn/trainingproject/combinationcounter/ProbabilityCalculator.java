package by.stn.trainingproject.combinationcounter;

public class ProbabilityCalculator {
    private static final int MIN = 24;
    private static final int HOUR = 60;
    private static final int TOTAL = HOUR * MIN;
    private static final int[] MULTIPLICITY = {2, 3};

    public static double calculate(boolean multi) {
        int counter = 0;
        double probability;

        for (int hour = 0; hour < HOUR; hour++) {
            for (int min = 0; min < MIN; min++) {
                if (hour == min | ReverseValueComparator.compare(hour, min)) {
                    //System.out.println(hour + " = " + min);
                    counter++;
                }
                if (multi) {
                    if (hour != 0 && (min == MULTIPLICITY[0] * hour || min == MULTIPLICITY[1] * hour)) {
                        //System.out.println(hour + " = " + min);
                        counter++;
                    }
                }
            }
        }
        probability = (double) counter / TOTAL * 100;
        return probability;
    }
}