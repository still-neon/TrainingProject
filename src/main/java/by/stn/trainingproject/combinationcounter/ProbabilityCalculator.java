package by.stn.trainingproject.combinationcounter;

import lombok.Setter;

public class ProbabilityCalculator {
    @Setter//сделать не статик поля
    private static int min = 60;
    @Setter
    private static int hour = 24;
    @Setter
    private static int[] multiplicity = {2, 3};
    private static final int TOTAL = hour * min;

    public static double calculate(boolean multi) {
        int counter = 0;
        double probability;

        for (int h = 0; h < hour; h++) {
            for (int m = 0; m < min; m++) {
                if (h == m | ReverseValueComparator.compare(h, m)) {
                    //System.out.println(hour + " = " + min);
                    counter++;
                }
                if (multi) {
                    if (h != 0 && (m == multiplicity[0] * h || m == multiplicity[1] * h)) {
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