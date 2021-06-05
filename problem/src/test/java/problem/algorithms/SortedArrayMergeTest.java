package problem.algorithms;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SortedArrayMergeTest {

    @Test
    public void TestProblem() {
        int[] a = { 1, 10, 25, 31, 33, 50 };
        int[] b = { 2, 4, 32, 64 };

        var actual = SortedArrayMerge.solve(a, b);
        int[] expected = {1, 2, 4, 10, 25, 31, 32, 33, 50, 64};

        assertEquals(expected, actual);
    }
}
