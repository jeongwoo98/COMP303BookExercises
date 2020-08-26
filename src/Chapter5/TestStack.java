package Chapter5;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class TestStack {
    Stack<String> myStack = new Stack<>();

    @BeforeEach
    public void setUp(){
        myStack.clear();
    }

    @Test
    public void pushEmpty(){
        String test = "foo";
        assertSame(test, myStack.push(test));
        assertSame(test, myStack.peek());
    }

    @Test
    public void pushNon_Empty(){
        myStack.push("foo");
        String test = "fooo";
        assertSame(test, myStack.push(test));
        assertSame(test,myStack.peek());
    }

    @Test
    public void popEmpty(){
        try{
            myStack.pop();
            fail();
        }
        catch(EmptyStackException e){}
        //assertTrue(myStack.isEmpty());
    }

    @Test
    public void popNonEmpty(){
        String test = "foo";
        myStack.push(test);
        assertSame(test ,myStack.pop());
        assertTrue(myStack.isEmpty());
    }

    @Test
    public void pushNull(){
        assertNull(myStack.push(null));
        assertNull(myStack.peek());

    }









}
