package Test.QueueTest;

import org.junit.Before;
import org.junit.Test;
import uy.edu.um.prog2.adt.Queue.Queue;

import static org.junit.Assert.*;

public class QueueTest {
    private Queue<Integer> queue;

    @Before
    public void setUp() {
        queue = new Queue<>();
    }

    @Test
    public void testEnqueue() {
        assertTrue(queue.isEmpty());
        queue.enqueue(10);
        assertFalse(queue.isEmpty());
        queue.enqueue(20);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testDequeue() {
        assertNull(queue.dequeue());

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        assertEquals(Integer.valueOf(10), queue.dequeue());
        assertEquals(Integer.valueOf(20), queue.dequeue());
        assertEquals(Integer.valueOf(30), queue.dequeue());
        assertNull(queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(10);
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testPrint() {
        queue.print();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.print();
    }
}
