package Chapter5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StringTester
{
    /**
     * Checks that we can call any parameterless method of class String on an
     * empty string without raising an exception.
     */
    public static void main(String[] args)
    {
        for( Method method : String.class.getDeclaredMethods() )
        {
            if( method.getParameterCount() == 0 )
            {
                try
                {
                    method.invoke("");
                }
                catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
                {
                    System.out.println("No, we cannot.");
                    System.exit(0);
                }
            }
        }
        System.out.println("Yes, we can!");
    }
}