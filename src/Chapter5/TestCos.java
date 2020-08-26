package Chapter5;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestCos
{
    private static final double ZERO = 0.0;
    private static final double QUARTER = Math.PI/2.0;
    private static final double HALF = Math.PI;
    private static final double THREE_QUARTERS = Math.PI * 1.5;

    @Test
    public void testCos_NaN()
    {
        assertEquals(Double.NaN, Math.cos(Double.NaN));
    }

    @Test
    public void testCos_Infinity()
    {
        assertEquals(Double.NaN, Math.cos(Double.POSITIVE_INFINITY));
    }

    @Test
    public void testCos_Zero()
    {
        assertEquals(1.0, Math.cos(ZERO), Math.ulp(1.0));
    }

    @Test
    public void testCos_Quarter()
    {
        assertEquals(0.0, Math.cos(QUARTER), Math.ulp(0.0));
    }

    @Test
    public void testCos_Half()
    {
        assertEquals(-1.0, Math.cos(HALF), Math.ulp(-1.0));
    }

    @Test
    public void testCos_ThreeQuaters()
    {
        assertEquals(0.0, Math.cos(THREE_QUARTERS), Math.ulp(0.0));
    }
}

//raise your awareness of the challenges of unit testing when floating-point values are involved