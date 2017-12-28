package by.stn.trainingproject.combinationcounter;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by EugenKrasotkin on 12/19/2017.
 */
public class ProbabilityCalculatorTest {
    private static ProbabilityCalculator probabilityCalculator;

    @Test
    public void checkMultiplicity() {
        assertTrue("Enabled multiplicity should increase the probability", probabilityCalculator.calculate(24, 60, false) < probabilityCalculator.calculate(24, 60, true));
    }

    @Test
    public void checkReverseArguments() {
        //написать метод отлавливающий косяки
        assertTrue("Reversed values should make the same result",
                (probabilityCalculator.calculate(24, 60, true) == probabilityCalculator.calculate(60, 24, true)) &&
                        (probabilityCalculator.calculate(24, 60, false) == probabilityCalculator.calculate(60, 24, false)));
    }

    @BeforeClass
    public static void crateObject() {
        probabilityCalculator = new ProbabilityCalculator();
    }
}