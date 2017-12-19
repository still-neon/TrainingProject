package by.stn.trainingproject.combinationcounter.tests;

import by.stn.trainingproject.combinationcounter.ProbabilityCalculator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by EugenKrasotkin on 12/19/2017.
 */
public class ProbabilityCalculatorTest {
    private static ProbabilityCalculator probabilityCalculator;

    @Test
    public void checkMultiplicity() {
        probabilityCalculator.setHour(24);
        probabilityCalculator.setMin(60);
        assertTrue("Enabled multiplicity should increase the probability", probabilityCalculator.calculate(false)
                < probabilityCalculator.calculate(true));
    }

    @Test
    public void checkReverseArguments() {
        //написать метод отлавливающий косяки
    }

    @Test
    public void calculate_24h60m_WithMultiplicity() {
        probabilityCalculator.setHour(24);
        probabilityCalculator.setMin(60);
        assertEquals(probabilityCalculator.calculate(true), 5.486111111111111, 0);
    }

    @Test
    public void calculate_24h60m_NoMultiplicity() {
        probabilityCalculator.setHour(24);
        probabilityCalculator.setMin(60);
        assertEquals(probabilityCalculator.calculate(false), 2.569444444444444, 0);
    }

    @Test
    public void calculate_60h24m_WithMultiplicity() {
        probabilityCalculator.setHour(60);
        probabilityCalculator.setMin(24);
        assertEquals(probabilityCalculator.calculate(true), 5.486111111111111, 0);
    }

    @Test
    public void calculate_60h24m_NoMultiplicity() {
        probabilityCalculator.setHour(60);
        probabilityCalculator.setMin(24);
        assertEquals(probabilityCalculator.calculate(false), 2.569444444444444, 0);
    }

    @BeforeClass
    public static void crateObject() {
        probabilityCalculator = new ProbabilityCalculator();
    }
}
