package by.stn.trainingproject.combinationcounter.tests;

import by.stn.trainingproject.combinationcounter.ReverseValueComparator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by EugenKrasotkin on 12/19/2017.
 */
public class ReverseValueComparatorTester {
    private static ReverseValueComparator reverseValueComparator;

    @Test
    public void reverse_21h12m_returntrue() {
        Assert.assertEquals(reverseValueComparator.compare(21,12),true);
    }

    @BeforeClass
    public static void crateObject() {
        reverseValueComparator = new ReverseValueComparator();
    }
}
