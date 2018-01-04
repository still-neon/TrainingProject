package by.stn.trainingproject.combinationcounter;

public class Launcher {
    private static final int MIN = 60;
    private static final int HOUR = 24;
    private static final int[] MULTIPLICITY = {2, 3};

    public static void main(String[] args) {
        double probability = ProbabilityCalculator.calculate(HOUR, MIN);
        System.out.println("Probability = " + String.format("%.2f", probability) + "%");
    }
}