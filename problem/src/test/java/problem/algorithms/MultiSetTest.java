package problem.algorithms;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MultiSetTest {
    private MultiSet<String> set = new MultiSet<>();

    @Test
    public void testMultiSet() {
        set.add("test");
        set.add("test");
        set.add("test");
        set.remove("test");

        assertEquals(true, set.contains("test"));

        set.remove("test");

        assertEquals(true, set.contains("test"));

        set.remove("test");

        assertEquals(true, set.contains("test"));

    }
}
