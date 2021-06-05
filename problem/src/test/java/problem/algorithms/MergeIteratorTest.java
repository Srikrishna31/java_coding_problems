package problem.algorithms;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MergeIteratorTest {
    @Test
    public void testMergeIterator() {
        var mergeIterator = new MergeIterator(
                Arrays.asList(
                    Arrays.asList(21).iterator(),
                    Arrays.asList(0).iterator(),
                    Arrays.asList(3).iterator())
                );

        mergeIterator.next();
        mergeIterator.next();
        mergeIterator.next();

        assertEquals(false, mergeIterator.hasNext());
    }
}
