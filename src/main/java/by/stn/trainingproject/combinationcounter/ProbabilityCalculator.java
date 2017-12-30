package by.stn.trainingproject.combinationcounter;

public class ProbabilityCalculator {
    //передавать в метод массив, если пустой, ио не считать

    public static double calculate(int hour, int min, int... MULTIPLICITY) {
        int total = hour * min;
        int counter = 0;
        double probability;

        for (int h = 0; h < hour; h++) {
            for (int m = 0; m < min; m++) {
                if (h == m | ReverseValueComparator.compare(h, m)) {
                    counter++;
                }
                if (MULTIPLICITY!=null) {//проверка до цикла
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