package Chapter5;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import java.lang.String;
import java.util.EmptyStackException;
import org.junit.jupiter.api.function.Executable;


public class TestConcat {
    private static final String EMPTY = "";
    private static final String NON_EMPTY = "abc";

   @Test
    public void testConcat_EmptyEmpty(){
       assertEquals(EMPTY, EMPTY.concat(""));
   }

   @Test
    public void testConcat_EmptyNonEmpty(){
       assertEquals(NON_EMPTY, EMPTY.concat(NON_EMPTY));
   }

   @Test
    public void testConcat_NonEmptyEmpty(){
       assertEquals(NON_EMPTY, NON_EMPTY.concat("") );
   }

   @Test
    public void testConcat_NonEmptyNonEmpty(){
       assertEquals("abcabc", NON_EMPTY.concat(NON_EMPTY));
   }

    @Test // This test documents that calling concat with a null argument throws an NPE
    public void testConcat_Null()
    {
        assertThrows(NullPointerException.class, new Executable()
        {
            // A lambda expression would normally be used here, but
            // they are not covered until Chapter 9.
            @Override
            public void execute() throws Throwable
            {
                NON_EMPTY.concat(null);
            }
        });
    }


}

