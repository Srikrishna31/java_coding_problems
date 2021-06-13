package problem.algorithms;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DropBallDownStairsTest {
    private DropBallDownStairs implementation = new DropBallDownStairs();

    @Test
    public void testWithHeight4andBlacklist2() {
        int[] blacklist = {2};
        var res = implementation.solve(4, blacklist);

        int expected = 2;

        assertEquals(expected, res);
    }

    @Test
    public void testWithHeight5AndBlacklist0() {
        int [] blacklist = {0};

        var res = implementation.solve(5, blacklist);

        int expected = 0;

        assertEquals(expected, res);
    }

    @Test
    public void testWithHeight4AndNoBlacklists() {
        int [] blacklist = {};

        var res = implementation.solve(4, blacklist);

        int expected = 5;

        assertEquals(expected, res);
    }
}
