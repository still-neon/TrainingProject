package by.stn.trainingproject.combinationcounter;

public class ProbabilityCalculator {
    private static final int MIN = 60;
    private static final int HOUR = 24;
    private static final int[] MULTIPLICITY = {2, 3};

    public static void calculate(boolean withMultiplicity) {
        int total = HOUR * MIN;
        int counter = 0;

        for (int h = 0; h < HOUR; h++) {
            for (int m = 0; m < MIN; m++) {
                if (h == m || ReverseValueComparator.compare(h, m)) {
                    //System.out.println(h + " = " + m);
                    counter++;
                }
                if (withMultiplicity == true) {
                    if (h != 0 && (m == MULTIPLICITY[0] * h || m == MULTIPLICITY[1] * h)) {
                        //System.out.println(h + " = " + m);
                        counter++;
                    }
                }
            }
        }
       System.out.println("Probability = " + String.format("%.2f",(double) counter / total * 100) + "%");
    }
}