import by.stn.trainingproject.combinationcounter.ReverseValueComparator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by EugenKrasotkin on 12/19/2017.
 */
public class ReverseValueComparatorTest {
    private static ReverseValueComparator reverseValueComparator;

    @Test
    public void reverse_1337h7331m() {
        Assert.assertTrue(reverseValueComparator.compare(1337,7331));
    }

    @BeforeClass
    public static void crateObject() {
        reverseValueComparator = new ReverseValueComparator();
    }
}
