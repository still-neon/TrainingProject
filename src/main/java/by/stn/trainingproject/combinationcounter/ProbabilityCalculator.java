package by.stn.trainingproject.combinationcounter;

public class ProbabilityCalculator {
    //передавать в метод массив, если пустой, ио не считать

    public static double calculate(int hour, int min, int... MULTIPLICITY) {
        int total = hour * min;
        int counter = 0;
        double probability;

        counter = countWithNoMultiplicity(hour, min, counter);

        if (MULTIPLICITY != null) {
            counter += countWithMultiplicity(hour, min, counter, MULTIPLICITY);
        }

        probability = (double) counter / total * 100;
        return probability;
    }

    public static int countWithNoMultiplicity(int hour, int min, int counter) {
        for (int h = 0; h < hour; h++) {
            for (int m = 0; m < min; m++) {
                if (h == m || ReverseValueComparator.compare(h, m)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static int countWithMultiplicity(int hour, int min, int counter, int[] MULTIPLICITY) {
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