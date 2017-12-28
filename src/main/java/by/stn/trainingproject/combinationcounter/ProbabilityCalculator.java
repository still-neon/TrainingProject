package by.stn.trainingproject.combinationcounter;

public class ProbabilityCalculator {
    private static final int[] MULTIPLICITY = {2, 3, 4};//передавать в метод массив, если пустой, ио не считать

    public static double calculate(int hour, int min, boolean multi) {
        int total = hour * min;
        int counter = 0;
        double probability;

        for (int h = 0; h < hour; h++) {
            for (int m = 0; m < min; m++) {
                if (h == m | ReverseValueComparator.compare(h, m)) {
                    counter++;
                }
                if (multi) {
                    for (int i : MULTIPLICITY) {
                        if (h != 0 && (m == i * h || h == i * m)) {
                            counter++;
                        }
                    }
                }
            }
        }
        probability = (double) counter / total * 100;
        return probability;
    }
}