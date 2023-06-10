package Test.TestStack;

import org.junit.Before;
import org.junit.Test;
import uy.edu.um.prog2.adt.stack.Stack;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class TestStack {
    private Stack<Integer> stack;

    @Before
    public void setUp() {
        stack = new Stack<>();
    }
    @Test
    public void testPush() {
        assertTrue(stack.isEmpty());
        stack.push(10);
        assertFalse(stack.isEmpty());
        stack.push(20);
        assertFalse(stack.isEmpty());
    }
    @Test(expected = EmptyStackException.class)
    public void testPop() {
        stack.pop();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }

    @Test
    public void testTop() {
        assertNull(stack.top());
        stack.push(10);
        assertEquals(Integer.valueOf(10), stack.top());
        stack.push(20);
        assertEquals(Integer.valueOf(20), stack.top());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(10);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testMakeEmpty() {
        stack.makeEmpty();
        assertTrue(stack.isEmpty());
        stack.push(10);
        assertFalse(stack.isEmpty());
        stack.makeEmpty();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPrint() {
        stack.print();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Print tiene que mostrar esto
        // [ 30 ] top
        // [ 20 ]
        // [ 10 ]
        stack.print();
    }
}
