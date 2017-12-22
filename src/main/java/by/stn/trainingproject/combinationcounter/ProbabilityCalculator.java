package by.stn.trainingproject.combinationcounter;

import lombok.Setter;

public class ProbabilityCalculator {
    private static int[] multiplicity = {2, 3};


    public static double calculate(int hour, int min, boolean multi) {
        int total = hour * min;
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
        probability = (double) counter / total * 100;
        return probability;
    }
}