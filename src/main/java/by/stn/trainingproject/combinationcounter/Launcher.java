package by.stn.trainingproject.combinationcounter;

public class Launcher {
    private static final boolean enableMultiplicity = true;
    private static double probability;

    public static void main(String[] args) {
        probability = ProbabilityCalculator.calculate(enableMultiplicity);
        System.out.println("Probability = " + String.format("%.2f", probability) + "%");
    }
}