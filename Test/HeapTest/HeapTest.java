package Test.HeapTest;

import org.junit.Test;
import uy.edu.um.prog2.adt.heap.Heap;
import uy.edu.um.prog2.adt.heap.MyHeap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HeapTest {

    @Test
    public void testMaxHeap() {
        Heap<Integer> maxHeap = new Heap<>(true);
        maxHeap.add(5);
        maxHeap.add(10);
        maxHeap.add(7);
        maxHeap.add(3);

        assertEquals(4, maxHeap.size());
        assertEquals(Integer.valueOf(10), maxHeap.delete());
        assertEquals(Integer.valueOf(7), maxHeap.delete());
        assertEquals(Integer.valueOf(5), maxHeap.delete());
        assertEquals(Integer.valueOf(3), maxHeap.delete());
        assertEquals(0, maxHeap.size());
        assertNull(maxHeap.delete());
    }

    @Test
    public void testminHeap() {
        MyHeap<Integer> minHeap = new Heap<>(false);

        minHeap.add(5);
        minHeap.add(10);
        minHeap.add(7);
        minHeap.add(3);

        assertEquals(4, minHeap.size());
        assertEquals(Integer.valueOf(10), minHeap.delete());
        assertEquals(Integer.valueOf(7), minHeap.delete());
        assertEquals(Integer.valueOf(5), minHeap.delete());
        assertEquals(Integer.valueOf(3), minHeap.delete());
        assertEquals(0, minHeap.size());
        assertNull(minHeap.delete());
    }
}

