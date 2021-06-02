package problem;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProblemTest {

    private Problem problem = new Problem();

    @Test
    public void TestProblem() {
        var actual = problem.solve();

        assertEquals(true, actual);
    }
}
