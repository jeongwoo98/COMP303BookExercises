package Chapter5;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class TestMin {
    @Test
    public void testMin_SamePositive(){
        assertEquals(3, Math.min(3,3));
    }

    @Test
    public void testtMin_SameNegative(){
        assertEquals(-3, Math.min(-3,-3));
    }

    @Test
    public void testMin_FirstGreater(){
        assertEquals(3,Math.min(4,3));
    }

    @Test
    public void testMin_SecondGreater(){
        assertEquals(3, Math.min(3,4));
    }
}
