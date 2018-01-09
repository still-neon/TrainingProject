package by.stn.trainingproject.combinationcounter;

public class ProbabilityCalculator {
        public static double calculate(int hour, int min, int... MULTIPLICITY) {
        int total = hour * min;
        double probability;

        int counter = noMulti(hour, min, 0);

        if (MULTIPLICITY != null && MULTIPLICITY.length > 0) {
            counter += withMulti(hour, min, counter, MULTIPLICITY);
        }

        probability = (double) counter / total * 100;
        return probability;
    }

    private static int noMulti(int hour, int min, int counter) {
        for (int h = 0; h < hour; h++) {
            for (int m = 0; m < min; m++) {
                if (h == m || ReverseValueComparator.compare(h, m)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private static int withMulti(int hour, int min, int counter, int[] MULTIPLICITY) {
        for (int h = 0; h < hour; h++) {
            for (int m = 0; m < min; m++) {
                for (int i : MULTIPLICITY) {
                    if (h != 0 && (m == i * h || h == i * m)) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
}